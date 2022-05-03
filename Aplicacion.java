package aplicacion;

import aplicacion.bd.*;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import aplicacion.datos.*;
import aplicacion.model.*;
import java.awt.GraphicsEnvironment;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.WindowEvent;

public class Aplicacion extends Application {

    public static final Stage primaryStage = new Stage();

    //-------------------------------------------------RUTAS VENTANAS------------------------------------------------------//
    public static final String RUTA_VENTANA_INICIO = "view/VentanaInicio.fxml";
    public static final String RUTA_VENTANA_LOGIN = "view/VentanaLogin.fxml";
    public static final String RUTA_VENTANA_REGISTRO = "view/VentanaRegistro.fxml";

    //-------------------------Rutas escritorios-----------------------//
    public static final String RUTA_VENTANA_ADMIN = "view/escritorio/VentanaEscritorioAdmin.fxml";
    public static final String RUTA_VENTANA_EMPLEADO = "view/escritorio/VentanaEscritorioEmpleado.fxml";

    //------------------------------Rutas Módulos----------------------------//
    public static final String RUTA_VENTANA_GERENCIA = "view/modulos/VentanaPrincipalGerencia.fxml";
    public static final String RUTA_VENTANA_CRM = "view/modulos/VentanaPrincipalCRM.fxml";
    public static final String RUTA_VENTANA_RH = "view/modulos/VentanaRH.fxml";
    public static final String RUTA_VENTANA_TI = "view/modulos/VentanaTI.fxml";
    public static final String RUTA_VENTANA_FINANZAS = "view/modulos/VentanaPrincipalFinanzas.fxml";
    public static final String RUTA_VENTANA_ADQUISICIONES = "view/modulos/VentanaAdquisiciones.fxml";
    public static final String RUTA_VENTANA_INVENTARIO = "view/modulos/VentanaInventario.fxml";
    public static final String RUTA_VENTANA_PRODUCCION = "view/modulos/VentanaProduccion.fxml";

    //------------------------------Rutas Sub Módulos CRM----------------------------//
    public static final String RUTA_VENTANA_MARKETING = "view/modulos/crm/VentanaMarketing.fxml";
    public static final String RUTA_VENTANA_SC = "view/modulos/crm/VentanaServicioCliente.fxml";
    public static final String RUTA_VENTANA_VENTAS = "view/modulos/crm/VentanaVentas.fxml";

    //------------------------------Rutas Sub Módulos Finanzas----------------------------//
    public static final String RUTA_VENTANA_CONTABILIDAD = "view/modulos/finanzas/VentanaContabilidad.fxml";
    public static final String RUTA_VENTANA_PRESUPUESTOS = "view/modulos/finanzas/VentanaPresupuestos.fxml";
    public static final String RUTA_VENTANA_TESORERIA = "view/modulos/finanzas/VentanaTesoreria.fxml";

    //------------------------------Rutas Sub Módulos Gerencia----------------------------//
    public static final String RUTA_VENTANA_ADMINISTRACION = "view/modulos/gerencia/VentanaAdministracion.fxml";
    public static final String RUTA_VENTANA_PLANIFICACION = "view/modulos/gerencia/VentanaPlanificacion.fxml";
    public static final String RUTA_VENTANA_SECRETARIA = "view/modulos/gerencia/VentanaSecretaria.fxml";

    //----------------------------------------------TITULOS VENTANAS---------------------------------------------------//
    public static final String TITULO_VENTANA_INICIO = "Sanely Inicio";
    public static final String TITULO_VENTANA_LOGIN = "Sanely Login";

    //------------------------Titulos escritorios-----------------------//
    public static final String TITULO_VENTANA_ADMIN = "Sanely Administrador";
    public static final String TITULO_VENTANA_EMPLEADO = "Sanely Empleado";
    public static final String TITULO_VENTANA_REGISTRO = "Sanely Registro";

    //------------------------------Titulos Módulos----------------------------//
    public static final String TITULO_VENTANA_GERENCIA = "Sanely Gerencia";
    public static final String TITULO_VENTANA_CRM = "Sanely CRM";
    public static final String TITULO_VENTANA_RH = "Sanely Recursos Humanos";
    public static final String TITULO_VENTANA_TI = "Sanely TI";
    public static final String TITULO_VENTANA_FINANZAS = "Sanely Finanzas";
    public static final String TITULO_VENTANA_ADQUISICIONES = "Sanely Adquisiciones";
    public static final String TITULO_VENTANA_INVENTARIO = "Sanely Inventario";
    public static final String TITULO_VENTANA_PRODUCCION = "Sanely Producción";

    //------------------------------Rutas Sub Módulos CRM----------------------------//
    public static final String TITULO_VENTANA_MARKETING = "Sanely Marketing";
    public static final String TITULO_VENTANA_SC = "Sanely Servicio al Cliente";
    public static final String TITULO_VENTANA_VENTAS = "Sanely Ventas";

    //------------------------------Rutas Sub Módulos Finanzas----------------------------//
    public static final String TITULO_VENTANA_CONTABILIDAD = "Sanely Contabilidad";
    public static final String TITULO_VENTANA_PRESUPUESTOS = "Sanely Presupuestos";
    public static final String TITULO_VENTANA_TESORERIA = "Sanely Tesorería";

    //------------------------------Rutas Sub Módulos Gerencia----------------------------//
    public static final String TITULO_VENTANA_ADMINISTRACION = "Sanely Administración";
    public static final String TITULO_VENTANA_PLANIFICACION = "Sanely Planificación";
    public static final String TITULO_VENTANA_SECRETARIA = "Sanely Secretaría";

    public static Object usuarioActivo;

    private IAccesoDatos datos;
    private EmpleadoDAO empleadoDao;
    private ProductoDAO productoDao;
    
    private Principal p;

    public Aplicacion() {
        p = new Principal();
    }

    public Principal getP() {
        return p;
    }

    @Override
    public void start(Stage stage) throws Exception {
//        datos = new AccesoDatosImpl();
//        cargarArchivos();
        empleadoDao = new EmpleadoDAO();
        productoDao = new ProductoDAO();
        cargarBD();

        Parent root = FXMLLoader.load(getClass().getResource("view/VentanaInicio.fxml"));

        Scene scene = new Scene(root);

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                Alert mensaje = new Alert(AlertType.INFORMATION);

                if (Aplicacion.usuarioActivo != null) {
                    Aplicacion.usuarioActivo = null;
                    
                    mensaje.setTitle("Mensaje");
                    mensaje.setHeaderText("Sesión cerrada");
                    mensaje.setContentText("La sesión en curso se ha cerrado");
                    mensaje.showAndWait();
                }

                mensaje.setHeaderText("Hasta luego :)");
                mensaje.setContentText("Gracias por usar el programa.");
                mensaje.showAndWait();
            }
        });

        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.setTitle("Sanely Inicio");
        primaryStage.getIcons().add(new Image("aplicacion/design/Sanely logo.png"));
        primaryStage.show();
    }

    public void cambiarVentana(String ruta, String titulo) throws IOException {
        Parent root = FXMLLoader.load((getClass().getResource(ruta)));
        Scene scene;
        if (primaryStage.isMaximized()) {
            double ancho = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getWidth();
            double alto = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getHeight();
            scene = new Scene(root, ancho, alto);
        } else {
            scene = new Scene(root, 1000, 600);
        }
        primaryStage.setTitle(titulo);
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void comprobarArchivos() {
        if (!datos.existe("listaClientes.txt")) {
            datos.crear("listaClientes.txt");
        }
        if (!datos.existe("listaEmpleados.txt")) {
            datos.crear("listaEmpleados.txt");
        }
        if (!datos.existe("listaProveedores.txt")) {
            datos.crear("listaProveedores.txt");
        }
        if (!datos.existe("listaConvenios.txt")) {
            datos.crear("listaConvenios.txt");
        }
        if (!datos.existe("listaProductos.txt")) {
            datos.crear("listaProductos.txt");
        }
        if (!datos.existe("listaMunecos.txt")) {
            datos.crear("listaMunecos.txt");
        }
    }

    public void cargarArchivos() {
        comprobarArchivos();

        datos.cargarDatos(AccesoDatosImpl.RUTA_LISTA_CLIENTES);
        datos.cargarDatos(AccesoDatosImpl.RUTA_LISTA_EMPLEADOS);

        System.out.println("Se han cargado los datos...");
    }
    
    public void cargarBD(){
        Principal.listaEmpleados = empleadoDao.select();
        Principal.listaProductos = productoDao.select();
    }
}
