package aplicacion.bd;

import aplicacion.model.negocio.Producto;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;

public class ProductoDAO {
    private Conexion conexion;
    
    private static final String SQL_SELECT = "SELECT id_producto, codigo, nombre, caracteristicas, tipo_prod, sub_tipo_1, sub_tipo_2, sub_tipo_3, disponibilidad, foto, cantidad, valor FROM producto";
    private static final String SQL_SEARCH = "SELECT id_producto, codigo, nombre, caracteristicas, tipo_prod, sub_tipo_1, sub_tipo_2, sub_tipo_3, disponibilidad, foto, cantidad, valor FROM producto WHERE codigo = ?";
    private static final String SQL_INSERT = "INSERT INTO producto(codigo, nombre, caracteristicas, tipo_prod, sub_tipo_1, sub_tipo_2, sub_tipo_3, disponibilidad, foto, cantidad, valor) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE producto SET codigo = ?, nombre = ?, caracteristicas = ?, tipo_prod = ?, sub_tipo_1 = ?, sub_tipo_2 = ?, sub_tipo_3 = ?, disponibilidad = ?, foto = ?, cantidad = ?, valor = ? WHERE id_producto = ?";
    private static final String SQL_DELETE = "DELETE FROM producto WHERE id_producto = ?";
    
    public ProductoDAO(){
        conexion = new Conexion();
    }
    
    public List<Producto> select(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Producto> lista = new ArrayList<>();
        Producto producto = null;
        
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()){
                int idProd = rs.getInt("id_producto");
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String autor = rs.getString("autor");
                String caract = rs.getString("caracteristicas");
                String tipoProd = rs.getString("tipo_prod");
                String subTipo1 = rs.getString("sub_tipo_1");
                String subTipo2 = rs.getString("sub_tipo_2");
                String subTipo3 = rs.getString("sub_tipo_3");
                String disp = rs.getString("disponibilidad");
                
                Blob blob = rs.getBlob("foto"); // Se lee el objeto en forma de bytes desde la base de datos
                byte[] data = blob.getBytes(1, (int) blob.length()); // Se guardan los bytes del objeto en un arreglo de bytes
                BufferedImage imagen = ImageIO.read(new ByteArrayInputStream(data)); // Se lee la imagen a partir del arreglo de bytes
                Image foto = SwingFXUtils.toFXImage(imagen, null); // Se convierte la imagen de java.awt.image.BufferedImage a javafx.scene.image.Image, ya que es lo que se recibe en el constructor
                blob.free(); //Se libera el blob para liberar el espacio en memoria
                
                int cant = rs.getInt("cantidad");
                double precio = rs.getDouble("precio");
                
                producto = new Producto(idProd, codigo, nombre, autor, caract, tipoProd, subTipo1, subTipo2, subTipo3, disp, foto, cant, precio);
                lista.add(producto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            System.out.println("Error al conectar a la base de datos");
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
            System.out.println("Error al leer imagen de la base de datos");
        } finally {
            try {
                conexion.close(rs);
                conexion.close(stmt);
                conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
                System.out.println("Error al cerrar conexiones");
            }
        }
        return lista;
    }
    
    public boolean search(Producto producto){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SEARCH);
            stmt.setString(1, producto.getCodigo());
            rs = stmt.executeQuery();
            while(rs.next()){
                producto.setIdProd(rs.getInt("id_producto"));
                return true;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            System.out.println("Error al conectar a la base de datos");
        } finally {
            try {
                conexion.close(rs);
                conexion.close(stmt);
                conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
                System.out.println("Error al cerrar conexiones");
            }
        }
        
        return false;
    }
    
    public int insert(Producto producto){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        File archivo = new File(producto.getFoto().getUrl()); //Se crea un archivo con la dirección de la imagen dentro del disco
        FileInputStream fis = null; //Se crea el InputStream que se va a usar para enviar el archivo a la base de datos
        
        int registros = 0;
        
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            
            stmt.setString(1, producto.getCodigo());
            stmt.setString(2, producto.getNombre());
            stmt.setString(3, producto.getCaract());
            stmt.setString(4, producto.getTipoProd());
            stmt.setString(5, producto.getSubTipo1());
            stmt.setString(6, producto.getSubTipo2());
            stmt.setString(7, producto.getSubTipo3());
            stmt.setString(8, producto.getDisp());
            
            fis = new FileInputStream(archivo); //Se crea un FileInputStram a partir del archivo
            stmt.setBinaryStream(9, fis, (int)archivo.length()); //Se pasa la imagen en forma de bytes para almacenarla en la base de datos
            
            stmt.setInt(10, producto.getCant());
            stmt.setDouble(11, producto.getValor());
            
            registros = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            System.out.println("Error al conectar a la base de datos");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.err);
            System.out.println("Error al leer información del archivo");
        } finally {
            try {
                fis.close();
                conexion.close(stmt);
                conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
                System.out.println("Error al cerrar conexiones");
            } catch (IOException ex) {
                ex.printStackTrace(System.err);
                System.out.println("Error al cerrar conexión del archivo");
            }
        }
        
        return registros;
    }
    
    public int update(Producto producto){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        File archivo = new File(producto.getFoto().getUrl()); //Se crea un archivo con la dirección de la imagen dentro del disco
        FileInputStream fis = null; //Se crea el InputStream que se va a usar para enviar el archivo a la base de datos
        
        int registros = 0;
        
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, producto.getCodigo());
            stmt.setString(2, producto.getNombre());
            stmt.setString(3, producto.getCaract());
            stmt.setString(4, producto.getTipoProd());
            stmt.setString(5, producto.getSubTipo1());
            stmt.setString(6, producto.getSubTipo2());
            stmt.setString(7, producto.getSubTipo3());
            stmt.setString(8, producto.getDisp());
            
            fis = new FileInputStream(archivo); //Se crea un FileInputStram a partir del archivo
            stmt.setBinaryStream(9, fis, (int)archivo.length()); //Se pasa la imagen en forma de bytes para almacenarla en la base de datos
            
            stmt.setInt(10, producto.getCant());
            stmt.setDouble(11, producto.getValor());
            
            registros = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            System.out.println("Error al conectar a la base de datos");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.err);
            System.out.println("Error al leer el archivo");
        } finally {
            try {
                fis.close();
                conexion.close(stmt);
                conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
                System.out.println("Error al cerrar conexiones");
            } catch (IOException ex) {
                ex.printStackTrace(System.err);
                System.out.println("Error al cerrar conexión de FileInputStream");
            }
        }
        
        return registros;
    }
    
    public int delete(Producto producto){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        int registros = 0;
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            
            stmt.setInt(1, producto.getIdProd());
            
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            System.out.println("Error al conectar con la base de datos");
        } finally {
            try {
                conexion.close(stmt);
                conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
                System.out.println("Error al cerrar conexiones");
            }
        }
        
        return registros;
    }
}
