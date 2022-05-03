package aplicacion.controller.escritorio;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import aplicacion.Aplicacion;
import aplicacion.model.*;

public class VentanaEscritorioEmpleadoController implements Initializable {

    private Aplicacion app;

    @FXML
    private Button btInicio;

    @FXML
    private Button btCRM;

    @FXML
    private Button btProduccion;

    @FXML
    private Button btTI;

    @FXML
    private Button btAdquisiciones;

    @FXML
    private Button btInventario;

    public void abrirVentanaCRM() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_CRM, Aplicacion.TITULO_VENTANA_CRM);
    }

    public void abrirVentanaProduccion() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_PRODUCCION, Aplicacion.TITULO_VENTANA_PRODUCCION);
    }

    public void abrirVentanaTI() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_TI, Aplicacion.TITULO_VENTANA_TI);
    }

    public void abrirVentanaAdquisiciones() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_ADQUISICIONES, Aplicacion.TITULO_VENTANA_ADQUISICIONES);
    }

    public void abrirVentanaInventario() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_INVENTARIO, Aplicacion.TITULO_VENTANA_INVENTARIO);
    }

    public void regresar() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_INICIO, Aplicacion.TITULO_VENTANA_INICIO);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        app = new Aplicacion();
    }

}
