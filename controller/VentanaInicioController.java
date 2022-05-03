package aplicacion.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import aplicacion.Aplicacion;
import aplicacion.model.*;
import aplicacion.model.negocio.Producto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.TextAlignment;

public class VentanaInicioController implements Initializable {

    private Aplicacion app;
    private Object usuarioActivo = Aplicacion.usuarioActivo;

    @FXML
    private Button btUsuario;

    @FXML
    private Button btRegistro;

    @FXML
    private Button btGestMod;

    @FXML
    private FlowPane paneProductos;

    @FXML
    private CheckBox checkCountry;

    @FXML
    private CheckBox checkMadera;

    @FXML
    private CheckBox checkNinos;

    @FXML
    private CheckBox checkOtrasTecnicas;

    private List<Label> productosCountry = new ArrayList<>();
    private List<Label> productosMadera = new ArrayList<>();
    private List<Label> productosNinos = new ArrayList<>();
    private List<Label> productosOtrasTec = new ArrayList<>();
    private List<Label> productosPapel = new ArrayList<>();
    private List<Label> productosPuntoCruz = new ArrayList<>();
    private List<Label> productosTela = new ArrayList<>();

    @FXML
    public void handlerbtUsuario() throws Exception {
        if (usuarioActivo == null) {
            abrirVentanaLogin();
        } else {
            cerrarSesion();
        }
    }

    public void cerrarSesion() {
        usuarioActivo = null;
        btUsuario.setText("Iniciar Sesión");
        btRegistro.setVisible(true);
        btGestMod.setVisible(false);

        Alert mensaje = new Alert(AlertType.INFORMATION);
        mensaje.setHeaderText("Confirmación");
        mensaje.setContentText("Se ha cerrado la sesión");
        mensaje.showAndWait();
    }

    public void abrirVentanaLogin() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_LOGIN, Aplicacion.TITULO_VENTANA_LOGIN);
    }

    public void abrirVentanaRegistro() throws IOException {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_REGISTRO, Aplicacion.TITULO_VENTANA_REGISTRO);
    }

    public void abrirVentanaModulos() throws Exception {
        Empleado e = (Empleado) Aplicacion.usuarioActivo;
        if (e.isAdmin()) {
            app.cambiarVentana(Aplicacion.RUTA_VENTANA_ADMIN, Aplicacion.TITULO_VENTANA_ADMIN);
        } else {
            app.cambiarVentana(Aplicacion.RUTA_VENTANA_EMPLEADO, Aplicacion.TITULO_VENTANA_EMPLEADO);
        }
    }

    public void filtros() {
        checkCountry.selectedProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection) {
                paneProductos.getChildren().addAll(productosCountry);
            } else {
                paneProductos.getChildren().removeAll(productosCountry);
            }
        });

        checkMadera.selectedProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection) {
                Label infoProd = new Label("Madera", new ImageView(new Image("aplicacion/design/Articulos/4.png", 150, 150, false, false)));
                infoProd.setContentDisplay(ContentDisplay.TOP);

                paneProductos.getChildren().add(infoProd);
            }
        });
    }

    public void mostrarProductos() {

        for (Producto producto : Principal.listaProductos) {
            Label info = new Label();

            switch (producto.getTipoProd()) {
                case "Country":
                    info.setGraphic(new ImageView(producto.getFoto()));
                    info.getGraphic().setScaleX(150);
                    info.getGraphic().setScaleY(150);
                    info.setText("Código: " + producto.getCodigo()
                            + "\nNombre: " + producto.getNombre()
                            + "\nPrecio: " + producto.getValor());
                    info.setContentDisplay(ContentDisplay.TOP);
                    info.setTextAlignment(TextAlignment.JUSTIFY);
                    productosCountry.add(info);
                    break;

                case "Madera":
                    info.setText("Código: " + producto.getCodigo()
                            + "\nNombre: " + producto.getNombre()
                            + "\nPrecio: " + producto.getValor());
                    info.setContentDisplay(ContentDisplay.TOP);
                    info.setTextAlignment(TextAlignment.JUSTIFY);
                    productosMadera.add(info);
                    break;

                case "Ninos":
                    info.setText("Código: " + producto.getCodigo()
                            + "\nNombre: " + producto.getNombre()
                            + "\nPrecio: " + producto.getValor());
                    info.setContentDisplay(ContentDisplay.TOP);
                    info.setTextAlignment(TextAlignment.JUSTIFY);
                    productosNinos.add(info);
                    break;
            }

        }
        paneProductos.getChildren().addAll(productosCountry);
        paneProductos.getChildren().addAll(productosMadera);
        paneProductos.getChildren().addAll(productosNinos);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        app = new Aplicacion();

        mostrarProductos();

        btGestMod.setVisible(false);

        if (usuarioActivo != null && usuarioActivo instanceof Empleado) {
            btUsuario.setText("Cerrar sesión (" + ((Empleado) usuarioActivo).getUserName() + ")");
            btRegistro.setVisible(false);
            btGestMod.setVisible(true);
        }

        if (usuarioActivo != null && usuarioActivo instanceof Cliente) {
//            btUsuario.setText("Cerrar sesión (" + ((Cliente) usuarioActivo).getUserName() + ")");
        }
    }

}
