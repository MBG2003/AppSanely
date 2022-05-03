package aplicacion.controller;

import aplicacion.Aplicacion;
import aplicacion.utility.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import aplicacion.model.*;

public class VentanaLoginController implements Initializable {

    private Aplicacion app;

    @FXML
    private ComboBox comboTipoPersona;

    @FXML
    private Button btInicio;

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField passContra;
    
    @FXML
    private Label labelIncorrecto;

    @FXML
    private Button btIngresar;

    public void ingresar() throws Exception {
        String tp = (String) comboTipoPersona.getValue();
        boolean ward = false;

        switch (tp) {
            case "Administrador":
                Empleado a = new Empleado(txtUsuario.getText(), passContra.getText());
                a.setAdmin(true);
                if (app.getP().buscarContra(a)) {
                    Aplicacion.usuarioActivo = a;
                    app.cambiarVentana(Aplicacion.RUTA_VENTANA_ADMIN, Aplicacion.TITULO_VENTANA_ADMIN);
                    ward = true;
                } else {
                    labelIncorrecto.setVisible(true);
                }
                break;

            case "Empleado":
                Empleado e = new Empleado(txtUsuario.getText(), passContra.getText());
                if (app.getP().buscarContra(e)) {
                    Aplicacion.usuarioActivo = e;
                    app.cambiarVentana(Aplicacion.RUTA_VENTANA_EMPLEADO, Aplicacion.TITULO_VENTANA_EMPLEADO);
                    ward = true;
                } else {
                    labelIncorrecto.setVisible(true);
                }
                break;

            case "Cliente":
//                app.cambiarVentana("", "");
                break;
        }

        if (ward) {
            Alert mensaje = new Alert(AlertType.INFORMATION);

            mensaje.setHeaderText("Bienvenido");
            mensaje.setContentText("ATENCIÓN: El programa se encuentra en fase de desarrollo, por lo tanto se pueden encontrar algunos fallos, de ser así póngase en contacto con el servicio técnico.");
            mensaje.showAndWait();
        }

    }

    public void disableFields() {
        String tp = (String) comboTipoPersona.getValue();
        switch (tp) {
            case "Administrador":
                txtUsuario.setVisible(true);
                passContra.setVisible(true);
                break;

            case "Empleado":
                txtUsuario.setVisible(true);
                passContra.setVisible(true);
                break;

            case "Cliente":
                txtUsuario.setVisible(false);
                passContra.setVisible(false);
                break;

        }
    }

    public void regresar() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_INICIO, Aplicacion.TITULO_VENTANA_INICIO);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        app = new Aplicacion();
        
        labelIncorrecto.setVisible(false);

        comboTipoPersona.setValue(SeleccioneUnaOpcion.SELECCIONE_UNA_OPCION.getTipo());
        comboTipoPersona.getItems().addAll(TipoPersona.listar());
    }

}
