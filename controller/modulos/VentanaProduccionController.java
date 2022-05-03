package aplicacion.controller.modulos;

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

public class VentanaProduccionController implements Initializable {

    private Aplicacion app;

    @FXML
    private Button btVolverPed;

    @FXML
    private Button btVolverE;

    @FXML
    private Button btVolverProd;

    //-----------------------------------Objetos de la pestaña PEDIDOS----------------------------------------------------//
    @FXML
    private Button btAgregarPedido;

    @FXML
    private Button btActualizarPedido;

    @FXML
    private Button btEliminarPedido;

    @FXML
    private Button btNuevoPedido;

    //-----------------------------------Objetos de la pestaña ENTREGA----------------------------------------------------//
    @FXML
    private ComboBox comboTipoEntrega;

    @FXML
    private Button btGenerarOrden;

    @FXML
    private Button btNuevaOrden;

    //----------------------------------------------Métodos de la pestaña PEDIDOS-----------------------------------------//
    public void agregarPedido() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Pedido agregado con éxito.");
        mensaje.showAndWait();
    }

    public void actualizarPedido() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Pedido actualizado con éxito.");
        mensaje.showAndWait();
    }

    public void eliminarPedido() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Pedido eliminado con éxito.");
        mensaje.showAndWait();
    }

    public void nuevoPedido() {

    }

    //----------------------------------------------Métodos de la pestaña PEDIDOS-----------------------------------------//
    public void nuevaOrden() {

    }

    public void volver() throws Exception {
        app.cambiarVentana("view/escritorio/VentanaEscritorioAdministrador.fxml", "Sanely Administrador");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    

}
