package aplicacion.controller;

import aplicacion.Aplicacion;
import aplicacion.model.Cliente;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VentanaRegistroController implements Initializable {

    private Aplicacion app;

    @FXML
    private Button btInicio;

    @FXML
    private Button btRegistro;

    @FXML
    private DatePicker dateNacimiento;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtDocumento;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPais;

    @FXML
    private TextField txtTelFijo;

    @FXML
    private TextField txtTelMovil;

    private String documento;
    private String nombre;
    private String telFijo;
    private String telMovil;
    private String direccion;
    private String correo;
    private Date fechaNacimiento;
    private String pais;

    @FXML
    void registrar() {
        try {
            boolean ward;
            SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
            documento = txtDocumento.getText();
            nombre = txtNombre.getText();
            telFijo = txtTelFijo.getText();
            telMovil = txtTelMovil.getText();
            direccion = txtDireccion.getText();
            correo = txtCorreo.getText();
            fechaNacimiento = formato.parse(dateNacimiento.getEditor().getText());
            pais = txtPais.getText();

            if (comprobarCampos()) {
                Cliente c = new Cliente(pais, documento, nombre, telFijo, telMovil, direccion, correo, fechaNacimiento);

                ward = app.getP().agregarCliente(c);

                if (ward) {
                    Alert mensaje = new Alert(AlertType.CONFIRMATION);

                    mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
                    mensaje.setHeaderText("Confirmación");
                    mensaje.setContentText("Su información se ha agragado con éxito.");
                    mensaje.showAndWait();
                } else {
                    Alert mensaje = new Alert(AlertType.ERROR);

                    mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Eliminar.png", 40, 40, false, false)));
                    mensaje.setContentText("Su información no se ha agregado.");
                    mensaje.showAndWait();
                }
            } else {
                Alert mensaje = new Alert(AlertType.ERROR);

                mensaje.setHeaderText("Error");
                mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Eliminar.png", 40, 40, false, false)));
                mensaje.setContentText("Debes llenar todos los campos.");
                mensaje.showAndWait();
            }

        } catch (ParseException ex) {
            ex.printStackTrace(System.err);
            System.out.println("Error al formatear la fecha");
        }
    }

    @FXML
    void volver() throws IOException {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_INICIO, Aplicacion.TITULO_VENTANA_INICIO);
    }
    
    public boolean comprobarCampos() {
        if((documento.equals("") || nombre.equals("") || telFijo.equals("") || telMovil.equals("") || direccion.equals("") 
                || correo.equals("") || dateNacimiento.getEditor().getText().equals("") || pais.equals(""))){
            return false;
        }
        return true;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        app = new Aplicacion();
    }

    
}
