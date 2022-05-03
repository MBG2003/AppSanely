package aplicacion.controller.modulos;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import aplicacion.Aplicacion;

public class VentanaPrincipalFinanzasController implements Initializable {

    private Aplicacion app;

    @FXML
    private Button btBack;

    @FXML
    private Button btTesoreria;

    @FXML
    private Button btContabilidad;

    @FXML
    private Button btPresupuestos;

    public void abrirTesoreria() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_TESORERIA, Aplicacion.TITULO_VENTANA_TESORERIA);
    }

    public void abrirContabilidad() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_CONTABILIDAD, Aplicacion.TITULO_VENTANA_CONTABILIDAD);
    }

    public void abrirPresupuestos() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_PRESUPUESTOS, Aplicacion.TITULO_VENTANA_PRESUPUESTOS);
    }

    public void regresar() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_ADMIN, Aplicacion.TITULO_VENTANA_ADMIN);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        app = new Aplicacion();
    }
}
