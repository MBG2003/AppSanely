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

public class VentanaPlanificacionController implements Initializable {

    private Aplicacion app;
    
    
    //----------------------------------------------Objetos de la pestaña CRONOGRAMA---------------------------------------------//
    @FXML
    private Button btVolver;
    
    @FXML
    private Button btAgregarActividad;
    
    @FXML
    private Button btActualizarActividad;
    
    @FXML
    private Button btEliminarActividad;
    
    @FXML
    private Button btNuevaActividad;
    
    
    //----------------------------------------------Métodos de la pestaña CRONOGRAMA---------------------------------------------//
    public void agregarActividad() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Actividad agregada con éxito.");
        mensaje.showAndWait();
    }

    public void actualizarActividad() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Actividad actualizada con éxito.");
        mensaje.showAndWait();
    }

    public void eliminarActividad() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Actividad eliminada con éxito.");
        mensaje.showAndWait();
    }
    
    public void nuevaActividad() {
        
    }
    
    
    //----------------------------------------------Métodos adicionales-----------------------------------------------------------//
    public void volver()throws Exception
    {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_GERENCIA, Aplicacion.TITULO_VENTANA_GERENCIA);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        app = new Aplicacion();
    }    
    
}
