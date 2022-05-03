package aplicacion.controller.modulos.crm;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import aplicacion.Aplicacion;
import aplicacion.utility.MedioPago;
import aplicacion.utility.SeleccioneUnaOpcion;

public class VentanaVentasController implements Initializable {

    private Aplicacion app;

    @FXML
    private Button btVolver;

    @FXML
    private TextField txtNomVenta;

    @FXML
    private DatePicker dateFechaVenta;

    @FXML
    private ComboBox comboMedioPago;

    @FXML
    private TextField txtDocVendedor;

    @FXML
    private TextField txtDocCliente;

    @FXML
    private TextField txtValorVenta;

    public void volver() throws Exception {
        app.cambiarVentana("view/principal/VentanaPrincipalCRM.fxml", "Sanely CRM");
    }

    public void agregarVenta() {

    }

    public void actualizarVenta() {

    }

    public void eliminarVenta() {

    }

    public void nuevaVenta() {
        txtNomVenta.setText("");

        comboMedioPago.setValue(SeleccioneUnaOpcion.SELECCIONE_UNA_OPCION.getTipo());
        txtDocVendedor.setText("");
        txtDocCliente.setText("");
        txtValorVenta.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        app = new Aplicacion();
        
        comboMedioPago.getItems().addAll(MedioPago.CONTADO.getTipo(), MedioPago.A_CREDITO.getTipo());
        comboMedioPago.setValue(SeleccioneUnaOpcion.SELECCIONE_UNA_OPCION.getTipo());
    }

}
