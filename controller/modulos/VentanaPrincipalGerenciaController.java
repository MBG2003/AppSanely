package aplicacion.controller.modulos;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import aplicacion.Aplicacion;

public class VentanaPrincipalGerenciaController implements Initializable {

    private Aplicacion app;

    @FXML
    private Button btBack;

    @FXML
    private Button btAdministracion;

    @FXML
    private Button btPlanificacion;

    @FXML
    private Button btSecretaria;

    public void abrirAdministracion() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_ADMINISTRACION, Aplicacion.TITULO_VENTANA_ADMINISTRACION);
    }

    public void abrirPlanificacion() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_PLANIFICACION, Aplicacion.TITULO_VENTANA_PLANIFICACION);
    }

    public void abrirSecretaria() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_SECRETARIA, Aplicacion.TITULO_VENTANA_SECRETARIA);
    }

    public void regresar() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_ADMIN, Aplicacion.TITULO_VENTANA_ADMIN);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        app = new Aplicacion();
    }
}
