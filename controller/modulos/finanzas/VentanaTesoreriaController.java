package aplicacion.controller.modulos.finanzas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import aplicacion.Aplicacion;
import aplicacion.utility.Meses;
import aplicacion.utility.SeleccioneUnaOpcion;
import java.util.Calendar;

public class VentanaTesoreriaController implements Initializable {

    private Aplicacion app;

    //----------------------------------------Objetos de la pestaña ESTADOS FINANCIEROS---------------------------------------------//
    @FXML
    private Button btVolverEF;

    //-----------------------------------------------Objetos de la pestaña NÓMINA---------------------------------------------------//
    @FXML
    private Button btVolverN;

    @FXML
    private ComboBox comboMesLiquidar;

    @FXML
    private ComboBox comboQuincena;

    @FXML
    private Button btAgregarNomina;

    @FXML
    private Button btActualizarNomina;

    @FXML
    private Button btEliminarNomina;

    @FXML
    private Button btNuevaNomina;

    //-----------------------------------------------Objetos de la pestaña PRESUPUESTOS---------------------------------------------//
    @FXML
    private Button btVolverP;

    //----------------------------------------------Métodos de la pestaña NÓMINA-------------------------------------------------//
    public void agregarNomina() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Nómina agregada con éxito.");
        mensaje.showAndWait();
    }

    public void actualizarNomina() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Nómina actualizada con éxito.");
        mensaje.showAndWait();
    }

    public void eliminarNomina() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Nómina eliminada con éxito.");
        mensaje.showAndWait();
    }

    public void nuevaNomina() {

    }

    public void volver() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_FINANZAS, Aplicacion.TITULO_VENTANA_FINANZAS);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboMesLiquidar.setValue(SeleccioneUnaOpcion.SELECCIONE_UNA_OPCION.getTipo());

        comboMesLiquidar.getItems().addAll(Calendar.JANUARY, Calendar.FEBRUARY);
    }

}
