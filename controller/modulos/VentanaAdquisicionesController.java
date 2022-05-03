package aplicacion.controller.modulos;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import aplicacion.Aplicacion;
import aplicacion.model.*;

public class VentanaAdquisicionesController implements Initializable {

    private Aplicacion app;

    //--------------------------------------------------Objetos de la pestaña PROVEEDOR--------------------------------------------//
    @FXML
    private TableView<Proveedor> tableProveedores;

    @FXML
    private Button btBackProv;

    @FXML
    private TextField txtNomProv;

    @FXML
    private Button btAddProveedor;

    @FXML
    private Button btUpdateProv;

    @FXML
    private Button btDeleteProv;

    @FXML
    private Button btNewProv;

    //--------------------------------------------------Objetos de la pestaña CONVENIO----------------------------------------------//
    @FXML
    private TableView<Convenio> tableConvenios;

    @FXML
    private Button btBackConv;

    @FXML
    private Button btAddConv;

    @FXML
    private Button btUpdateConv;

    @FXML
    private Button btDeleteConv;

    @FXML
    private Button btNewConv;

    //--------------------------------------------------Objetos de la pestaña COMPRAS--------------------------------------------//
    @FXML
    private TableView<Compra> tableCompras;

    @FXML
    private Button btBackCom;

    @FXML
    private Button btAddCompra;

    @FXML
    private Button btUpdateCompra;

    @FXML
    private Button btDeleteCompra;

    @FXML
    private Button btNewCompra;

    //--------------------------------------------------Métodos de la pestaña PROVEEDOR--------------------------------------------//
    public void agregarProveedor() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Proveedor agregado con éxito.");
        mensaje.showAndWait();
    }

    public void actualizarProveedor() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Proveedor actualizado con éxito.");
        mensaje.showAndWait();
    }

    public void eliminarProveedor() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Proveedor eliminado con éxito.");
        mensaje.showAndWait();
    }

    public void nuevoProveedor() {

    }

    //--------------------------------------------------Métodos de la pestaña CONVENIO----------------------------------------------//
    public void agregarConvenio() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Convenio agregado con éxito.");
        mensaje.showAndWait();
    }

    public void actualizarConvenio() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Convenio actualizado con éxito.");
        mensaje.showAndWait();
    }

    public void eliminarConvenio() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Convenio eliminado con éxito.");
        mensaje.showAndWait();
    }

    public void nuevoConvenio() {

    }

    //--------------------------------------------------Métodos de la pestaña COMPRAS-----------------------------------------------//
    public void agregarCompra() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Compra agregada con éxito.");
        mensaje.showAndWait();
    }

    public void actualizarCompra() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Compra actualizada con éxito.");
        mensaje.showAndWait();
    }

    public void eliminarCompra() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Compra eliminada con éxito.");
        mensaje.showAndWait();
    }

    public void nuevaCompra() {

    }

    //--------------------------------------------------Métodos adicionales---------------------------------------------------------//

    public void regresar() throws Exception {
        Empleado e = (Empleado) Aplicacion.usuarioActivo;
        if(e.isAdmin()){
            app.cambiarVentana(Aplicacion.RUTA_VENTANA_ADMIN, Aplicacion.TITULO_VENTANA_ADMIN);
        } else {
            app.cambiarVentana(Aplicacion.RUTA_VENTANA_EMPLEADO, Aplicacion.TITULO_VENTANA_EMPLEADO);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        app = new Aplicacion();
    }
}
