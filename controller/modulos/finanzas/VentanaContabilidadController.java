package aplicacion.controller.modulos.finanzas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import aplicacion.Aplicacion;

public class VentanaContabilidadController implements Initializable {

    private Aplicacion app;

    //---------------------------------------Objetos de la pestaña REGISTRO FACTURAS--------------------------------------//
    @FXML
    private Button btVolverRF;

    @FXML
    private Button btAgregarFactura;

    @FXML
    private Button btActualizarFactura;

    @FXML
    private Button btEliminarFactura;

    @FXML
    private Button btNuevaFactura;

    //---------------------------------------Objetos de la pestaña EMISION FACTURAS---------------------------------------//
    @FXML
    private Button btVolverEF;

    @FXML
    private Button btEmitirComprobante;

    @FXML
    private Button btNuevoComprobante;

    //------------------------------------------Objetos de la pestaña Créditos----------------------------------------------//
    @FXML
    private Button btVolverC;

    @FXML
    private Button btAgregarCredito;

    @FXML
    private Button btActualizarCredito;

    @FXML
    private Button btEliminarCredito;

    @FXML
    private Button btNuevoCredito;

    //-----------------------------------------Métodos de la pestaña FACTURA----------------------------------------------//
    public void agregarFactura() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Factura agregada con éxito.");
        mensaje.showAndWait();
    }

    public void actualizarFactura() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Factura actualizada con éxito.");
        mensaje.showAndWait();
    }

    public void eliminarFactura() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Factura eliminada con éxito.");
        mensaje.showAndWait();
    }

    public void nuevaFactura() {

    }

    //-----------------------------------------Métodos de la pestaña EMISION FACTURA--------------------------------------//
    public void emitirComprobante() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Comprobante emitido con éxito.");
        mensaje.showAndWait();
    }

    public void nuevoComprobante() {

    }

    //-----------------------------------------Métodos de la pestaña FACTURA----------------------------------------------//
    public void agregarCredito() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Crédito agregado con éxito.");
        mensaje.showAndWait();
    }

    public void actualizarCredito() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Crédito actualizado con éxito.");
        mensaje.showAndWait();
    }

    public void eliminarCredito() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Crédito eliminado con éxito.");
        mensaje.showAndWait();
    }

    public void nuevoCredito() {

    }

    public void volver() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_FINANZAS, Aplicacion.TITULO_VENTANA_FINANZAS);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

}
