package aplicacion.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import aplicacion.model.Empleado;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EmpleadoDAO {

    private Conexion conexion;

    private static final String SQL_SELECT = "SELECT id_empleado, documento, nombre, tel_fijo, tel_movil, direccion, correo, fecha_nacimiento, administrador, usuario, contra, cargo, fecha_ingreso, sueldo FROM empleado";
    private static final String SQL_SEARCH = "SELECT id_empleado, documento, nombre, tel_fijo, tel_movil, direccion, correo, fecha_nacimiento, administrador, usuario, contra, cargo, fecha_ingreso, sueldo FROM empleado WHERE documento = ?";
    private static final String SQL_INSERT = "INSERT INTO empleado(documento, nombre, tel_fijo, tel_movil, direccion, correo, fecha_nacimiento, administrador, usuario, contra, cargo, fecha_ingreso, sueldo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE empleado SET documento = ?, nombre = ?, tel_fijo = ?, tel_movil = ?, direccion = ?, correo = ?, fecha_nacimiento = ?, administrador = ?, usuario = ?, contra = ?, cargo = ?, fecha_ingreso = ?, sueldo = ? WHERE id_empleado = ?";
    private static final String SQL_DELETE = "DELETE FROM empleado WHERE id_empleado = ?";

    public EmpleadoDAO() {
        conexion = new Conexion();
    }

    public List<Empleado> select() {
        List<Empleado> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Empleado empleado = null;

        SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");

        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idEmpleado = rs.getInt("id_empleado");
                String documento = rs.getString("documento");
                String nombre = rs.getString("nombre");
                String telFijo = rs.getString("tel_fijo");
                String telMovil = rs.getString("tel_movil");
                String direccion = rs.getString("direccion");
                String correo = rs.getString("correo");
                Date fechaNacimiento = formato.parse(rs.getString("fecha_nacimiento"));
                boolean admin = rs.getInt("administrador") == 1 ? true : false;
                String userName = rs.getString("usuario");
                String password = rs.getString("contra");
                String cargo = rs.getString("cargo");
                Date fechaIngreso = formato.parse(rs.getString("fecha_ingreso"));
                double sueldo = rs.getDouble("sueldo");

                empleado = new Empleado(idEmpleado, admin, userName, password, cargo, fechaIngreso, sueldo, documento, nombre, telFijo, telMovil, direccion, correo, fechaNacimiento);
                lista.add(empleado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error al seleccionar desde la base de datos");
        } catch (ParseException ex) {
            ex.printStackTrace(System.err);
            System.out.println("Error al pasar fechas");
        } finally {
            try {
                conexion.close(rs);
                conexion.close(stmt);
                conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Error al cerrar conexiones");
            }
        }

        return lista;
    }

    public boolean search(Empleado e) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareCall(SQL_SEARCH);
            stmt.setString(1, e.getDocumento());
            rs = stmt.executeQuery();
            while (rs.next()) {
                e.setIdEmpleado(rs.getInt("id_empleado"));
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            System.out.println("Error al buscar en la base de datos");
        } finally {
            try {
                conexion.close(rs);
                conexion.close(stmt);
                conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
                System.out.println("Error al cerrar la conexión");
            }
        }
        return false;
    }

    public int insert(Empleado empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");

        int registros = 0;

        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, empleado.getDocumento());
            stmt.setString(2, empleado.getNombre());
            stmt.setString(3, empleado.getTelFijo());
            stmt.setString(4, empleado.getTelMovil());
            stmt.setString(5, empleado.getDireccion());
            stmt.setString(6, empleado.getCorreo());
            stmt.setString(7, formato.format(empleado.getFechaNacimiento()));
            stmt.setInt(8, empleado.isAdmin() ? 1 : 0);
            stmt.setString(9, empleado.getUserName());
            stmt.setString(10, empleado.getPassword());
            stmt.setString(11, empleado.getCargo());
            stmt.setString(12, formato.format(empleado.getFechaIngreso()));
            stmt.setDouble(13, empleado.getSueldo());

            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error al insertar a la base de datos");
        } finally {
            try {
                conexion.close(stmt);
                conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                System.out.println("Error al cerrar conexiones");
            }
        }

        return registros;
    }

    public int update(Empleado empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");

        int registros = 0;

        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, empleado.getDocumento());
            stmt.setString(2, empleado.getNombre());
            stmt.setString(3, empleado.getTelFijo());
            stmt.setString(4, empleado.getTelMovil());
            stmt.setString(5, empleado.getDireccion());
            stmt.setString(6, empleado.getCorreo());
            stmt.setString(7, formato.format(empleado.getFechaNacimiento()));
            stmt.setInt(8, empleado.isAdmin() ? 1 : 0);
            stmt.setString(9, empleado.getUserName());
            stmt.setString(10, empleado.getPassword());
            stmt.setString(11, empleado.getCargo());
            stmt.setString(12, formato.format(empleado.getFechaIngreso()));
            stmt.setDouble(13, empleado.getSueldo());
            stmt.setInt(14, empleado.getIdEmpleado());

            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error al actualizar a la base de datos");
        } finally {
            try {
                conexion.close(stmt);
                conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Error al cerrar conexiones");
            }
        }

        return registros;
    }

    public int delete(Empleado empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, empleado.getIdEmpleado());

            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error al borrar a la base de datos");
        } finally {
            try {
                conexion.close(stmt);
                conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                System.out.println("Error al cerrar conexiones");
            }
        }

        return registros;
    }
}
