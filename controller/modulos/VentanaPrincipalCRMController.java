package aplicacion.controller.modulos;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import aplicacion.Aplicacion;
import aplicacion.model.Empleado;

public class VentanaPrincipalCRMController implements Initializable {

    private Aplicacion app;

    @FXML
    private Button btBack;

    @FXML
    private Button btMarketing;

    @FXML
    private Button btVentas;

    @FXML
    private Button btSC;

    public void abrirVentanaMarketing() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_MARKETING, Aplicacion.TITULO_VENTANA_MARKETING);
    }

    public void abrirVentanaVentas() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_VENTAS, Aplicacion.TITULO_VENTANA_VENTAS);
    }

    public void abrirVentanaServicioCliente() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_SC, Aplicacion.TITULO_VENTANA_SC);
    }

    public void volver() throws Exception {
        Empleado e = (Empleado) Aplicacion.usuarioActivo;
        if(e.isAdmin()){
            app.cambiarVentana(Aplicacion.RUTA_VENTANA_ADMIN, Aplicacion.TITULO_VENTANA_ADMIN);
        } else {
            app.cambiarVentana(Aplicacion.RUTA_VENTANA_EMPLEADO, Aplicacion.TITULO_VENTANA_EMPLEADO);
        }
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        app = new Aplicacion();
    }
}
