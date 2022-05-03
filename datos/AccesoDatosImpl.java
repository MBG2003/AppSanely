package aplicacion.datos;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import aplicacion.model.*;

public class AccesoDatosImpl implements IAccesoDatos {

    public static final String RUTA_LISTA_EMPLEADOS = "listaEmpleados.txt";
    public static final String RUTA_LISTA_CLIENTES = "listaClientes.txt";
    public static final String RUTA_LISTA_PRODUCTOS = "listaProductos.txt";

    @Override
    public boolean existe(String ruta) {
        var archivo = new File(ruta);
        return archivo.exists();
    }

    @Override
    public void crear(String ruta) {
        var archivo = new File(ruta);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error al crear el archivo");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error al crear el archivo");
        }
    }

    @Override
    public void escribir(String ruta, String contenido, boolean anexar) {
        File archivo = new File(ruta);
        try {
            BufferedWriter salida = new BufferedWriter(new FileWriter(archivo, anexar));
            salida.write(contenido);
            salida.newLine();
            salida.close();
            System.out.println("Se ha escrito al archivo: " + ruta);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error al escribir en el archivo");
        }
    }

    @Override
    public List listar(String ruta) {
        List lista = new ArrayList();
        var archivo = new File(ruta);
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();

            while (lectura != null) {
                System.out.println("entrada = " + entrada);
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error al leer el archivo");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error al leer el archivo");
        }

        return lista;
    }

    @Override
    public void borrarArchivo(String ruta) {
        File archivo = new File(ruta);
        if (archivo.exists()) {
            archivo.delete();
            System.out.println("Se ha borrado el archivo: " + ruta);
        }
    }
    
    @Override
    public void actualizarInfo(String ruta, List lista, String buscar) {
        borrarArchivo(ruta);
        crear(ruta);
        
        for (int i = 0; i < lista.size(); i++) {
            escribir(ruta, lista.get(i).toString(), true);
        }
    }

    @Override
    public void cargarDatos(String ruta) {
        File archivo = new File(ruta);
        int id = 1;
        SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = entrada.readLine();
            while (linea != null) {
                if (ruta.equals(RUTA_LISTA_CLIENTES)) {
                    Cliente c = new Cliente();

                    c.setDocumento(linea.split(", ")[1]);
                    c.setNombre(linea.split(", ")[2]);
                    c.setTelFijo(linea.split(", ")[3]);
                    c.setTelMovil(linea.split(", ")[4]);
                    c.setDireccion(linea.split(", ")[5]);
                    c.setCorreo(linea.split(", ")[6]);
                    c.setFechaNacimiento(formato.parse(linea.split(", ")[7]));
                    c.setPais(linea.split(", ")[8]);

                    Principal.listaClientes.add(c);
                }

                if (ruta.equals(RUTA_LISTA_EMPLEADOS)) {
                    Empleado e = new Empleado();

                    e.setAdmin(Boolean.valueOf(linea.split(", ")[1]));
                    e.setUserName(linea.split(", ")[2]);
                    e.setPassword(linea.split(", ")[3]);
                    e.setDocumento(linea.split(", ")[4]);
                    e.setNombre(linea.split(", ")[5]);
                    e.setTelFijo(linea.split(", ")[6]);
                    e.setTelMovil(linea.split(", ")[7]);
                    e.setDireccion(linea.split(", ")[8]);
                    e.setCorreo(linea.split(", ")[9]);
                    e.setFechaNacimiento(formato.parse(linea.split(", ")[10]));
                    e.setCargo(linea.split(", ")[11]);
                    e.setFechaIngreso(formato.parse(linea.split(", ")[12]));
                    e.setSueldo(Double.parseDouble(linea.split(", ")[13]));

                    Principal.listaEmpleados.add(e);
                }

                linea = entrada.readLine();
                id++;
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error al cargar los datos del archivo");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error al cargar los datos del archivo");
        } catch (ParseException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error al cargar los datos del archivo");
        }
    }
}
