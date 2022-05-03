package aplicacion.controller.modulos.finanzas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import aplicacion.Aplicacion;

public class VentanaPresupuestosController implements Initializable {

    private Aplicacion app;

    @FXML
    private Button btVolver;

    public void volver() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_FINANZAS, Aplicacion.TITULO_VENTANA_FINANZAS);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        app = new Aplicacion();
    }
}
