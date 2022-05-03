package aplicacion.model;

import aplicacion.bd.*;
import aplicacion.model.negocio.*;
import java.util.*;
import aplicacion.datos.*;

public class Principal {

    private IAccesoDatos datos;
    private EmpleadoDAO empleadoDao;
    private ProductoDAO productoDao;

    public static List<Producto> listaProductos = new ArrayList<>();
    public static List<Muneco> listaMunecos = new ArrayList<>();
    public static List<Cliente> listaClientes = new ArrayList<>();
    public static List<Empleado> listaEmpleados = new ArrayList<>();
    public static List<Proveedor> listaProveedores = new ArrayList<>();
    public static List<Convenio> listaConvenios = new ArrayList<>();

    public Principal() {
        this.datos = new AccesoDatosImpl();
        this.empleadoDao = new EmpleadoDAO();
        this.productoDao = new ProductoDAO();
    }

    //--------------------------------------------MÉTODOS PARA AGREGAR OBJETOS A LAS LISTAS--------------------------------------//
    public boolean agregarCliente(Cliente c) {

        if (buscarCliente(c) == -1) {
            listaClientes.add(c);
            datos.escribir("listaClientes.txt", c.toString(), true);
            return true;
        }

        return false;
    }

    public boolean agregarEmpelado(Empleado e) {
        if(!empleadoDao.search(e)) {
            empleadoDao.insert(e);
            return true;
        }
        return false;
    }

    public boolean agregarProducto(Producto p) {
        if(!productoDao.search(p)) {
            productoDao.insert(p);
            return true;
        }
        return false;
    }

    //------------------------------------------MÉTODOS PARA ACTULIZAR OBJETOS DE LAS LISTAS--------------------------------------//
    public boolean actualizarCliente(Cliente c) {
        int pos = buscarCliente(c);

        if (pos != -1) {
            listaClientes.set(pos, c);
            datos.actualizarInfo(AccesoDatosImpl.RUTA_LISTA_CLIENTES, listaClientes, c.getDocumento());
            return true;
        }

        return false;
    }

    public boolean actualizarEmpleado(Empleado e) {
        if(empleadoDao.search(e)){
            empleadoDao.update(e);
            return true;
        }
        return false;
    }

    //-------------------------------------------MÉTODOS PARA ELIMINAR OBJETOS DE LAS LISTAS--------------------------------------//
    public boolean eliminarCliente(Cliente c) {
        int pos = buscarCliente(c);

        if (pos != -1) {
            listaClientes.remove(pos);
            datos.actualizarInfo(AccesoDatosImpl.RUTA_LISTA_CLIENTES, listaClientes, c.getDocumento());
            return true;
        }

        return false;
    }

    public boolean eliminarEmpleado(Empleado e) {
        if(empleadoDao.search(e)){
            System.out.println("Borrar Empleado: " + e);
            empleadoDao.delete(e);
            return true;
        }
        return false;
    }

    public boolean eliminarProducto(Producto p) {
        int pos = buscarProducto(p);

        if (pos != -1) {
            listaProductos.remove(pos);
            datos.actualizarInfo(AccesoDatosImpl.RUTA_LISTA_PRODUCTOS, listaProductos, p.getCodigo());
            return true;
        }

        return false;
    }

    //------------------------------------------MÉTODOS PARA BUSCAR OBJETOS DENTRO DE LAS LISTAS----------------------------------//
    public int buscarCliente(Cliente c) {
        int pos = -1;

        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getDocumento().equals(c.getDocumento())) {
                pos = i;
            }
        }

        return pos;
    }

    public int buscarEmpleado(Empleado e) {
        int pos = -1;

        for (int i = 0; i < listaEmpleados.size(); i++) {
            if (listaEmpleados.get(i).getDocumento().equals(e.getDocumento())) {
                pos = i;
            }
        }

        return pos;
    }

    public int buscarProducto(Producto p) {
        int pos = -1;

        for (int i = 0; i < listaProductos.size(); i++) {
            if (listaProductos.get(i).getCodigo().equals(p.getCodigo())) {
                pos = i;
            }
        }

        return pos;
    }

    public int buscarMuneco(Muneco m) {
        int pos = -1;

        for (int i = 0; i < listaMunecos.size(); i++) {
            if (listaMunecos.get(i).getCodigo().equals(m.getCodigo())) {
                pos = i;
            }
        }

        return pos;
    }

    public boolean buscarContra(Object o) {
        if (o instanceof Empleado) {
            Empleado e = (Empleado) o;
            for (int i = 0; i < listaEmpleados.size(); i++) {
                if ((listaEmpleados.get(i).getUserName().equals(e.getUserName())) && (listaEmpleados.get(i).getPassword().equals(e.getPassword()))) {
                    e = listaEmpleados.get(i);
                    return true;
                }
            }
        } else {
//            Cliente c = (Cliente) o;
//            for (int i = 0; i < listaClientes.size(); i++) {
//                if(listaClientes.get(i)){
//                    c = listaClientes.get(i);
//                    return true;
//                }
//            }
        }
        return false;
    }

//    public boolean asignarAutorProducto(Producto p) {
//        if (buscarEmpleado() != -1) {
//            return true;
//        }
//        return false;
//    }
}
