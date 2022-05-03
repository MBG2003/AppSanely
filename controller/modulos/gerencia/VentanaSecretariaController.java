package aplicacion.controller.modulos.gerencia;

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
import aplicacion.utility.*;

public class VentanaSecretariaController implements Initializable {

    private Aplicacion app;
    
    @FXML
    private Button btVolver;
    
    @FXML
    private ComboBox comboTipoDocumento;
    
    @FXML
    private Button btAgregarInforme;
    
    @FXML
    private Button btActualizarInforme;
    
    @FXML
    private Button btEliminarInforme;
    
    @FXML
    private Button btNuevoInforme;
            
            
    public void agregarInforme() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Informe agregado con éxito.");
        mensaje.showAndWait();
    }

    public void actualizarInforme() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Informe actualizado con éxito.");
        mensaje.showAndWait();
    }

    public void eliminarInforme() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Informe eliminado con éxito.");
        mensaje.showAndWait();
    }
    
    public void nuevoInforme() {
        
    }
    
    public void volver()throws Exception
    {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_GERENCIA, Aplicacion.TITULO_VENTANA_GERENCIA);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        app = new Aplicacion();
        
        //-------------------------------------------Inicializar ComboBox---------------------------------------------------------//
        comboTipoDocumento.setValue(SeleccioneUnaOpcion.SELECCIONE_UNA_OPCION.getTipo());
        
        
        //-------------------------------------------Llenar ComboBox--------------------------------------------------------------//
        comboTipoDocumento.getItems().addAll(TipoDocumento.INFORME.getTipo(), TipoDocumento.REPORTE.getTipo());
    }    
    
}
