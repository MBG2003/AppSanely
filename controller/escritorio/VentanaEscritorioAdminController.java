package aplicacion.controller.escritorio;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import aplicacion.Aplicacion;

public class VentanaEscritorioAdminController implements Initializable {

    private Aplicacion app;

    @FXML
    private Button btInicio;

    @FXML
    private Button btCRM;

    @FXML
    private Button btGerencia;

    @FXML
    private Button btProduccion;

    @FXML
    private Button btTI;

    @FXML
    private Button btRH;

    @FXML
    private Button btAdquisiciones;

    @FXML
    private Button btInventario;

    @FXML
    private Button btFinanzas;

    public void abrirVentanaCRM() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_CRM, Aplicacion.TITULO_VENTANA_CRM);
    }

    public void abrirVentanaGerencia() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_GERENCIA, Aplicacion.TITULO_VENTANA_GERENCIA);
    }

    public void abrirVentanaProduccion() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_PRODUCCION, Aplicacion.TITULO_VENTANA_PRODUCCION);
    }

    public void abrirVentanaTI() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_TI, Aplicacion.TITULO_VENTANA_TI);
    }

    public void abrirVentanaRH() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_RH, Aplicacion.TITULO_VENTANA_RH);
    }

    public void abrirVentanaAdquisiciones() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_ADQUISICIONES, Aplicacion.TITULO_VENTANA_ADQUISICIONES);
    }

    public void abrirVentanaInventario() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_INVENTARIO, Aplicacion.TITULO_VENTANA_INVENTARIO);
    }

    public void abrirVentanaFinanzas() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_FINANZAS, Aplicacion.TITULO_VENTANA_FINANZAS);
    }

    public void regresar() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_INICIO, Aplicacion.TITULO_VENTANA_INICIO);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        app = new Aplicacion();
    }
}