package aplicacion.controller.modulos;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import aplicacion.Aplicacion;
import aplicacion.bd.EmpleadoDAO;
import aplicacion.model.*;

public class VentanaRHController implements Initializable {

    private Aplicacion app;
    private EmpleadoDAO empleadoDao;

    @FXML
    private Button btBack;
    //--------------------------------------------------Objetos de la pestaña EMPLEADO--------------------------------------------//
    @FXML
    private TableView<Empleado> tableEmpleados;

    @FXML
    private TableColumn<Empleado, String> columnDocumento;

    @FXML
    private TableColumn<Empleado, String> columnNombre;

    @FXML
    private TableColumn<Empleado, String> columnTelFijo;

    @FXML
    private TableColumn<Empleado, String> columnTelMovil;

    @FXML
    private TableColumn<Empleado, String> columnCorreo;

    @FXML
    private TableColumn<Empleado, String> columnCargo;

    @FXML
    private TableColumn<Empleado, String> columnSueldo;

    @FXML
    private CheckBox checkAdmin;

    @FXML
    private TextField txtDocumento;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelFijo;

    @FXML
    private TextField txtTelMovil;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtCargo;

    @FXML
    private TextField txtSueldo;

    @FXML
    private DatePicker dateNacimiento;

    @FXML
    private DatePicker dateIngreso;

    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtPassword;

    @FXML
    private Button btAdd;

    @FXML
    private ImageView btUpdate;

    @FXML
    private ImageView btDelete;

    @FXML
    private Button btNew;

    private ObservableList<Empleado> listaEmpleados = FXCollections.observableArrayList();

    private Empleado empleadoSeleccionado;
    private SimpleDateFormat formato;

    private boolean admin;
    private String userName, password, nombre, documento, telFijo, telMovil, direccion, correo, cargo;
    private Date fechaNacimiento, fechaIngreso;
    private double sueldo;

    @FXML
    public void agregarEmpleado() {
        try {
            boolean ward = false;

            admin = checkAdmin.isSelected();
            documento = txtDocumento.getText();
            nombre = txtNombre.getText();
            telFijo = txtTelFijo.getText();
            telMovil = txtTelMovil.getText();
            direccion = txtDireccion.getText();
            correo = txtCorreo.getText();
            cargo = txtCargo.getText();
            sueldo = Double.parseDouble(txtSueldo.getText());
            fechaNacimiento = formato.parse(dateNacimiento.getEditor().getText());
            fechaIngreso = formato.parse(dateIngreso.getEditor().getText());
            userName = txtUserName.getText();
            password = txtPassword.getText();

            Empleado e = new Empleado(admin, userName, password, cargo, fechaIngreso, sueldo, documento, nombre, telFijo, telMovil, direccion, correo, fechaNacimiento);
            ward = app.getP().agregarEmpelado(e);

            if (ward) {
                tableEmpleados.getItems().clear();
                Principal.listaEmpleados = empleadoDao.select();
                listaEmpleados.addAll(Principal.listaEmpleados);
                tableEmpleados.setItems(listaEmpleados);
                tableEmpleados.refresh();

                Alert mensaje = new Alert(AlertType.CONFIRMATION);

                mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
                mensaje.setContentText("Empleado agregado con éxito.");
                mensaje.showAndWait();
            } else {
                Alert mensaje = new Alert(AlertType.ERROR);

                mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Eliminar.png", 40, 40, false, false)));
                mensaje.setContentText("Empleado no ha sido agregado.");
                mensaje.showAndWait();
            }
        } catch (ParseException ex) {
            ex.printStackTrace(System.err);
            System.err.println("Error al agregar la información del empleado.");
        }

    }

    @FXML
    public void actualizarEmpleado() {
        try {
            boolean ward;

            admin = checkAdmin.isSelected();
            documento = txtDocumento.getText();
            nombre = txtNombre.getText();
            telFijo = txtTelFijo.getText();
            telMovil = txtTelMovil.getText();
            direccion = txtDireccion.getText();
            correo = txtCorreo.getText();
            fechaNacimiento = formato.parse(dateNacimiento.getEditor().getText());
            fechaIngreso = formato.parse(dateIngreso.getEditor().getText());
            cargo = txtCargo.getText();
            sueldo = Double.parseDouble(txtSueldo.getText());
            userName = txtUserName.getText();
            password = txtPassword.getText();

            if (comprobarCampos()) {
                Empleado e = new Empleado(admin, userName, password, cargo, fechaIngreso, sueldo, documento, nombre, telFijo, telMovil, direccion, correo, fechaNacimiento);
                ward = app.getP().actualizarEmpleado(e);

                if (ward) {
                    tableEmpleados.getItems().clear();
                    Principal.listaEmpleados = empleadoDao.select();
                    listaEmpleados.addAll(Principal.listaEmpleados);
                    tableEmpleados.setItems(listaEmpleados);
                    tableEmpleados.refresh();

                    Alert mensaje = new Alert(AlertType.CONFIRMATION);

                    mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
                    mensaje.setContentText("Empleado actualizado con éxito.");
                    mensaje.showAndWait();
                } else {
                    Alert mensaje = new Alert(AlertType.ERROR);

                    mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Eliminar.png", 40, 40, false, false)));
                    mensaje.setContentText("Empleado no ha sido actualizado.");
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
            System.err.println("Error al actualizar la información del empleado");
        }

    }

    @FXML
    public void eliminarEmpleado() {
        boolean ward;

        SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");

        try {
            admin = checkAdmin.isSelected();
            documento = txtDocumento.getText();
            nombre = txtNombre.getText();
            telFijo = txtTelFijo.getText();
            telMovil = txtTelMovil.getText();
            direccion = txtDireccion.getText();
            correo = txtCorreo.getText();
            fechaNacimiento = formato.parse(dateNacimiento.getEditor().getText());
            fechaIngreso = formato.parse(dateIngreso.getEditor().getText());
            cargo = txtCargo.getText();
            sueldo = Double.parseDouble(txtSueldo.getText());
            userName = txtUserName.getText();
            password = txtPassword.getText();

            if (comprobarCampos()) {
                Empleado e = new Empleado(admin, userName, password, cargo, fechaIngreso, sueldo, documento, nombre, telFijo, telMovil, direccion, correo, fechaNacimiento);
                ward = app.getP().eliminarEmpleado(e);

                if (ward) {
                    tableEmpleados.getItems().clear();
                    Principal.listaEmpleados = empleadoDao.select();
                    listaEmpleados.addAll(Principal.listaEmpleados);
                    tableEmpleados.setItems(listaEmpleados);
                    tableEmpleados.refresh();

                    nuevoEmpleado();

                    Alert mensaje = new Alert(AlertType.CONFIRMATION);

                    mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
                    mensaje.setContentText("Empleado eliminado con éxito.");
                    mensaje.showAndWait();
                } else {
                    Alert mensaje = new Alert(AlertType.ERROR);

                    mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Eliminar.png", 40, 40, false, false)));
                    mensaje.setContentText("Empleado no ha sido eliminado.");
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
        }

    }

    @FXML
    public void nuevoEmpleado() {
        txtDocumento.setText("");
        txtNombre.setText("");
        txtTelFijo.setText("");
        txtTelMovil.setText("");
        txtDireccion.setText("");
        txtCorreo.setText("");
        txtCargo.setText("");
        txtSueldo.setText("");
        dateNacimiento.setValue(LocalDate.of(2004, 1, 1));
        dateIngreso.setValue(LocalDate.of(2022, 1, 1));
        txtUserName.setText("");
        txtPassword.setText("");
    }

    public void volver() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_ADMIN, Aplicacion.TITULO_VENTANA_ADMIN);
    }

    public void seleccionarEmpleado() {
        tableEmpleados.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if ((empleadoSeleccionado = newSelection) != null) {
                mostrarInfoEmpleado();
            }
        });
    }

    public void mostrarInfoEmpleado() {
        txtDocumento.setText(empleadoSeleccionado.getDocumento());
        txtNombre.setText(empleadoSeleccionado.getNombre());
        txtTelFijo.setText(empleadoSeleccionado.getTelFijo());
        txtTelMovil.setText(empleadoSeleccionado.getTelMovil());
        txtDireccion.setText(empleadoSeleccionado.getDireccion());
        txtCorreo.setText(empleadoSeleccionado.getCorreo());
        txtCargo.setText(empleadoSeleccionado.getCargo());
        txtSueldo.setText(String.valueOf(empleadoSeleccionado.getSueldo()));
        dateNacimiento.getEditor().setText(formato.format(empleadoSeleccionado.getFechaNacimiento()));
        dateIngreso.getEditor().setText(formato.format(empleadoSeleccionado.getFechaNacimiento()));
        txtUserName.setText(empleadoSeleccionado.getUserName());
        txtPassword.setText(empleadoSeleccionado.getPassword());
        checkAdmin.setSelected(empleadoSeleccionado.isAdmin());
    }

    public boolean comprobarCampos() {
        if (documento.equals("") || nombre.equals("") || telFijo.equals("") || telMovil.equals("") || direccion.equals("") || correo.equals("")
                || cargo.equals("") || txtSueldo.getText().equals("") || dateNacimiento.getEditor().getText().equals("") || dateIngreso.getEditor().getText().equals("")
                || userName.equals("") || password.equals("")) {
            return false;
        }
        return true;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        app = new Aplicacion();
        empleadoDao = new EmpleadoDAO();

        formato = new SimpleDateFormat("dd/mm/yyyy");

        listaEmpleados.addAll(Principal.listaEmpleados);
        tableEmpleados.setItems(listaEmpleados);
        tableEmpleados.refresh();

        //Inicializar columnas de la tabla
        this.columnDocumento.setCellValueFactory(new PropertyValueFactory("documento"));
        this.columnNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.columnTelFijo.setCellValueFactory(new PropertyValueFactory("telFijo"));
        this.columnTelMovil.setCellValueFactory(new PropertyValueFactory("telMovil"));
        this.columnCorreo.setCellValueFactory(new PropertyValueFactory("correo"));
        this.columnCargo.setCellValueFactory(new PropertyValueFactory("cargo"));
        this.columnSueldo.setCellValueFactory(new PropertyValueFactory("sueldo"));

        seleccionarEmpleado();

    }

}
