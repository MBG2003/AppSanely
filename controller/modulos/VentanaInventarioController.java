package aplicacion.controller.modulos;

import aplicacion.model.negocio.Producto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.*;
import aplicacion.Aplicacion;
import aplicacion.bd.ProductoDAO;
import aplicacion.model.*;
import aplicacion.utility.*;
import aplicacion.utility.tipoproducto.*;
import aplicacion.utility.tipoproducto.madera.*;
import aplicacion.utility.tipoproducto.papel.Tarjeteria;
import aplicacion.utility.tipoproducto.tela.Munequeria;
import aplicacion.utility.tipoproducto.tela.Patchwork;
import aplicacion.utility.tipoproducto.tela.munequeria.Animales;
import aplicacion.utility.tipoproducto.tela.munequeria.Navidad;
import java.io.File;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class VentanaInventarioController implements Initializable {

    private Aplicacion app;
    private ProductoDAO productoDao;

    //-----------------------------------------------Objetos de la pestaña PRODUCTO TERMINADO-------------------------------------//
    @FXML
    private Button btBackPT;

    @FXML
    private TableView<Producto> tablePT;

    @FXML
    private TableColumn<String, Producto> columnCodPT;

    @FXML
    private TableColumn<String, Producto> columnNomPT;

    @FXML
    private TableColumn<String, Producto> columnAutorPT;

    @FXML
    private TableColumn<String, Producto> columnCaractPT;

    @FXML
    private TableColumn<String, Producto> columnTipoPT;

    @FXML
    private TableColumn<String, Producto> columnDispPT;

    @FXML
    private TableColumn<String, Producto> columnCantPT;

    @FXML
    private TableColumn<String, Producto> columnPrecioPT;

    @FXML
    private TextField txtCodPT;

    @FXML
    private TextField txtNomPT;

    @FXML
    private TextField txtAutorPT;

    @FXML
    private TextArea txtCaractPT;

    @FXML
    private Label labelSubTipo1;

    @FXML
    private Label labelSubTipo2;

    @FXML
    private Label labelSubTipo3;

    @FXML
    private ComboBox comboTipoProducto;

    @FXML
    private ComboBox comboSubTipo1;

    @FXML
    private ComboBox comboSubTipo2;

    @FXML
    private ComboBox comboSubTipo3;

    @FXML
    private ComboBox comboDispPT;

    @FXML
    private Spinner<Integer> spinnerCant;

    @FXML
    private Label labelFotoPT;

    @FXML
    private TextField txtPrecioPT;

    @FXML
    private Button btAddPT;

    @FXML
    private Button btUpdatePT;

    @FXML
    private Button btDeletePT;

    @FXML
    private Button btNewPT;

    private ObservableList<Producto> listaProductos = FXCollections.observableArrayList();

    SpinnerValueFactory<Integer> valorSpinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);

    //----------------------------------------------Objetos de la pestaña MOLDE---------------------------------------------------//
    @FXML
    private Button btBackMolde;

    @FXML
    private Button btBuscarMunecoMolde;

    @FXML
    private Label labelNomMunecoMolde;

    @FXML
    private Label labelAutorMunecoMolde;

    @FXML
    private Label labelTPMunecoMolde;

    @FXML
    private Label labelTemaMunecoMolde;

    @FXML
    private Label labelPersMunecoMolde;

    @FXML
    private Label labelUsoMunecoMolde;

    @FXML
    private TextField txtCodMunecoMolde;

    @FXML
    private TextField txtCodMolde;

    @FXML
    private TextField txtCantMolde;

    @FXML
    private TextField txtValorMolde;

    @FXML
    private Button btAgregarMolde;

    @FXML
    private Button btActualizarMolde;

    @FXML
    private Button btEliminarMolde;

    @FXML
    private Button btNuevoMolde;

    //----------------------------------------------Objetos de la pestaña KIT-----------------------------------------------------//
    @FXML
    private Button btVolverK;

    @FXML
    private ComboBox comboDispKit;

    @FXML
    private Button btBuscarMunecoKit;

    @FXML
    private Button btAgregarKit;

    @FXML
    private Button btActualizarKit;

    @FXML
    private Button btEliminarKit;

    @FXML
    private Button btNuevoKit;

    //----------------------------------------------Objetos de la pestaña MATERIAL------------------------------------------------//
    @FXML
    private Button btVolverMat;

    @FXML
    private TextField txtCodMaterial;

    @FXML
    private TextField txtNomMaterial;

    @FXML
    private TextField txtProvMaterial;

    @FXML
    private ComboBox comboTipoMaterial;

    @FXML
    private ComboBox comboDispMaterial;

    @FXML
    private TextField txtValorAdMaterial;

    @FXML
    private TextField txtValorVentaMaterial;

    @FXML
    private Button btAgregarMaterial;

    @FXML
    private Button btActualizarMaterial;

    @FXML
    private Button btEliminarMaterial;

    @FXML
    private Button btNuevoMaterial;

    //--------------------------------------------Variables universales-------------------------------------------------//
    boolean ward;
    String codigo, nombre;
    String nomAutor;
    String codMuneco, codMolde, codKit;

    //--------------------------------------Variables pestaña productos terminados------------------------------------------//
    String caract;
    String tipoProd;
    String subTipo1;
    String subTipo2;
    String subTipo3;
    String disp;
    int cant;
    Image foto;
    double valor;

    //----------------------------------------------Métodos de la pestaña PRODUCTO TERMINADO--------------------------------------//
    public void addPT() {
        codigo = txtCodPT.getText();
        nombre = txtNomPT.getText();
        nomAutor = txtAutorPT.getText();
        caract = txtCaractPT.getText();
        tipoProd = (String) comboTipoProducto.getValue();
        disp = (String) comboDispPT.getValue();
        cant = spinnerCant.getValue();
        valor = Double.parseDouble(txtPrecioPT.getText());
        Producto prod = new Producto(codigo, nombre, nomAutor, caract, tipoProd, disp, cant, valor);
        seleccionarSubTipos(prod);

        if(foto != null){
            prod.setFoto(foto);
            ward = app.getP().agregarProducto(prod);
        } else {
            ward = false;
        }

        if (ward) {
            tablePT.getItems().clear();
            Principal.listaProductos = productoDao.select();
            listaProductos.addAll(Principal.listaProductos);
            tablePT.setItems(listaProductos);
            tablePT.refresh();

            Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

            mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
            mensaje.setContentText("Producto agregado con éxito.");
            mensaje.showAndWait();

        } else {
            Alert mensaje = new Alert(Alert.AlertType.ERROR);

            mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Eliminar.png", 40, 40, false, false)));
            mensaje.setContentText("El producto no se ha agregado.");
            mensaje.showAndWait();
        }
    }

    public void actualizarProducto() {

        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Producto actualizado con éxito.");
        mensaje.showAndWait();
    }

    public void eliminarProducto() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Producto eliminado con éxito.");
        mensaje.showAndWait();
    }

    public void newPT() {
        txtCodPT.setText("");
        txtNomPT.setText("");
        txtAutorPT.setText("");
        txtCaractPT.setText("");
        comboTipoProducto.setValue(SeleccioneUnaOpcion.SELECCIONE_UNA_OPCION.getTipo());
        comboDispPT.setValue(SeleccioneUnaOpcion.SELECCIONE_UNA_OPCION.getTipo());
        valorSpinner.setValue(0);
        spinnerCant.setValueFactory(valorSpinner);
        labelFotoPT.setContentDisplay(ContentDisplay.TEXT_ONLY);
        txtPrecioPT.setText("");
    }

    //----------------------------------------------Métodos de la pestaña MOLDE--------------------------------------------------//
    public void agregarMolde() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Molde agregado con éxito.");
        mensaje.showAndWait();
    }

    public void actualizarMolde() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Molde actualizado con éxito.");
        mensaje.showAndWait();
    }

    public void eliminarMolde() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Molde eliminado con éxito.");
        mensaje.showAndWait();
    }

    public void nuevoMolde() {
        txtCodMunecoMolde.setText("");
        labelNomMunecoMolde.setText("...");
        labelAutorMunecoMolde.setText("...");
        labelTPMunecoMolde.setText("");
        labelTemaMunecoMolde.setText("");
        labelPersMunecoMolde.setText("");
        labelUsoMunecoMolde.setText("");
        txtCodMolde.setText("");
        txtCantMolde.setText("");
        txtValorMolde.setText("");
    }

    //----------------------------------------------Métodos de la pestaña KIT----------------------------------------------------//
    public void agregarKit() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Kit agregado con éxito.");
        mensaje.showAndWait();
    }

    public void actualizarKit() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Kit actualizado con éxito.");
        mensaje.showAndWait();
    }

    public void eliminarKit() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Kit eliminado con éxito.");
        mensaje.showAndWait();
    }

    public void nuevoKit() {

    }

    //----------------------------------------------Métodos de la pestaña MATERIAL-----------------------------------------------//
    public void agregarMaterial() {

        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Material agregado con éxito.");
        mensaje.showAndWait();
    }

    public void actualizarMaterial() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Material actualizado con éxito.");
        mensaje.showAndWait();
    }

    public void eliminarMaterial() {
        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);

        mensaje.setGraphic(new ImageView(new Image("aplicacion/design/Check.png", 40, 40, false, false)));
        mensaje.setContentText("Material eliminado con éxito.");
        mensaje.showAndWait();
    }

    public void nuevoMaterial() {
        txtCodMaterial.setText("");
        txtNomMaterial.setText("");
        txtProvMaterial.setText("");
        comboTipoMaterial.setValue(SeleccioneUnaOpcion.SELECCIONE_UNA_OPCION.getTipo());
        comboDispMaterial.setValue(SeleccioneUnaOpcion.SELECCIONE_UNA_OPCION.getTipo());
        txtValorAdMaterial.setText("");
        txtValorVentaMaterial.setText("");
    }

    //-----------------------------------------------Métodos EXTRAS----------------------------------------------------------//
    public void volver() throws Exception {
        if (Aplicacion.usuarioActivo instanceof Empleado) {
            Empleado e = (Empleado) Aplicacion.usuarioActivo;
            if (e.isAdmin()) {
                app.cambiarVentana(Aplicacion.RUTA_VENTANA_ADMIN, Aplicacion.TITULO_VENTANA_ADMIN);
            } else {
                app.cambiarVentana(Aplicacion.RUTA_VENTANA_EMPLEADO, Aplicacion.TITULO_VENTANA_EMPLEADO);
            }
        }
    }

    public void escogerFoto() {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images", "*.*"), new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"));
        File imagen = fc.showOpenDialog(new Stage() {
        });
        System.out.println(imagen.getAbsolutePath());
        foto = new Image(imagen.getAbsolutePath());
        labelFotoPT.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        Image imagenLabel = new Image(imagen.getAbsolutePath(), 100, 60, false, false);
        labelFotoPT.setGraphic(new ImageView(imagenLabel));
    }

    public void llenarSubTipos() {
        comboTipoProducto.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                labelSubTipo1.setText((String) comboTipoProducto.getValue() + ":");
                comboSubTipo1.getItems().clear();
                labelSubTipo1.setVisible(false);
                comboSubTipo1.setVisible(false);

                switch ((String) newValue) {
                    case "Country":
                        comboSubTipo1.getItems().addAll(Country.listar());
                        labelSubTipo1.setVisible(true);
                        comboSubTipo1.setVisible(true);
                        break;

                    case "Madera":
                        comboSubTipo1.getItems().addAll(Madera.listar());
                        labelSubTipo1.setVisible(true);
                        comboSubTipo1.setVisible(true);
                        break;

                    case "Niños":
                        comboSubTipo1.getItems().addAll(Ninos.listar());
                        labelSubTipo1.setVisible(true);
                        comboSubTipo1.setVisible(true);
                        break;

                    case "Papel":
                        comboSubTipo1.getItems().addAll(Papel.listar());
                        labelSubTipo1.setVisible(true);
                        comboSubTipo1.setVisible(true);
                        break;

                    case "Punto de cruz":
                        labelSubTipo1.setVisible(false);
                        comboSubTipo1.setVisible(false);
                        break;

                    case "Tela":
                        comboSubTipo1.getItems().addAll(Tela.listar());
                        labelSubTipo1.setVisible(true);
                        comboSubTipo1.setVisible(true);
                        break;

                    case "Otras técnicas":
                        comboSubTipo1.getItems().addAll(OtrasTecnicas.listar());
                        labelSubTipo1.setVisible(true);
                        comboSubTipo1.setVisible(true);
                        break;
                }
            } else {
                comboSubTipo1.setValue("Seleccione una opción");
                labelSubTipo1.setVisible(false);
                comboSubTipo1.setVisible(false);
            }
        });

        comboSubTipo1.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                labelSubTipo2.setText((String) comboSubTipo1.getValue() + ":");
                comboSubTipo2.getItems().clear();
                labelSubTipo2.setVisible(false);
                comboSubTipo2.setVisible(false);

                switch ((String) newValue) {
                    case "Calados":
                        comboSubTipo2.getItems().addAll(Calados.listar());
                        labelSubTipo2.setVisible(true);
                        comboSubTipo2.setVisible(true);
                        break;

                    case "Negras":
                        comboSubTipo2.getItems().addAll(Negras.listar());
                        labelSubTipo2.setVisible(true);
                        comboSubTipo2.setVisible(true);
                        break;

                    case "Tarjetería":
                        comboSubTipo2.getItems().addAll(Tarjeteria.listar());
                        labelSubTipo2.setVisible(true);
                        comboSubTipo2.setVisible(true);
                        break;

                    case "Patchwork":
                        comboSubTipo2.getItems().addAll(Patchwork.listar());
                        labelSubTipo2.setVisible(true);
                        comboSubTipo2.setVisible(true);
                        break;

                    case "Muñequería":
                        comboSubTipo2.getItems().addAll(Munequeria.listar());
                        labelSubTipo2.setVisible(true);
                        comboSubTipo2.setVisible(true);
                        break;

                }
            } else {
                comboSubTipo1.setValue("Seleccione una opción");
                labelSubTipo2.setVisible(false);
                comboSubTipo2.setVisible(false);
            }
        });

        comboSubTipo2.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                labelSubTipo3.setText((String) comboSubTipo2.getValue() + ":");
                comboSubTipo3.getItems().clear();
                labelSubTipo3.setVisible(false);
                comboSubTipo3.setVisible(false);

                switch ((String) newValue) {
                    case "Animales":
                        comboSubTipo3.getItems().addAll(Animales.listar());
                        labelSubTipo3.setVisible(true);
                        comboSubTipo3.setVisible(true);
                        break;

                    case "Navidad":
                        comboSubTipo3.getItems().addAll(Navidad.listar());
                        labelSubTipo3.setVisible(true);
                        comboSubTipo3.setVisible(true);
                        break;
                }
            } else {
                comboSubTipo2.setValue("Seleccione una opción");
                labelSubTipo3.setVisible(false);
                comboSubTipo3.setVisible(false);
            }
        });
    }

    public void seleccionarSubTipos(Producto prod) {

        switch (tipoProd) {
            case "Country":
                subTipo1 = (String) comboSubTipo1.getValue();
                break;

            case "Madera":
                subTipo1 = (String) comboSubTipo1.getValue();
                subTipo2 = (String) comboSubTipo2.getValue();
                break;

            case "Niños":
                subTipo1 = (String) comboSubTipo1.getValue();
                break;

            case "Papel":
                subTipo1 = (String) comboSubTipo1.getValue();
                subTipo2 = (String) comboSubTipo2.getValue();

                break;

            case "Punto de cruz":

                break;

            case "Tela":
                subTipo1 = (String) comboSubTipo1.getValue();
                subTipo2 = (String) comboSubTipo2.getValue();
                subTipo3 = (String) comboSubTipo3.getValue();
                break;

            case "Otras técnicas":
                subTipo1 = (String) comboSubTipo1.getValue();
                break;
        }
        prod.setSubTipo1(subTipo1);
        prod.setSubTipo2(subTipo2);
        prod.setSubTipo3(subTipo3);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        app = new Aplicacion();
        productoDao = new ProductoDAO();

        //------------------------------------------------Inicializar Label---------------------------------------------------//
        labelSubTipo1.setVisible(false);
        labelSubTipo2.setVisible(false);
        labelSubTipo3.setVisible(false);
        //--------------------------------------------Inicializar Objetos pestañas------------------------------------------//
        //--------------------------------------Inicializar Objetos pestaña PRODUCTO TERMINADO-------------------------------//
//        comboTipoProducto.setValue(SeleccioneUnaOpcion.SELECCIONE_UNA_OPCION.getTipo());
        comboTipoProducto.setPromptText(SeleccioneUnaOpcion.SELECCIONE_UNA_OPCION.getTipo());
        comboSubTipo1.setPromptText(SeleccioneUnaOpcion.SELECCIONE_UNA_OPCION.getTipo());
        comboSubTipo2.setPromptText(SeleccioneUnaOpcion.SELECCIONE_UNA_OPCION.getTipo());
        comboSubTipo3.setPromptText(SeleccioneUnaOpcion.SELECCIONE_UNA_OPCION.getTipo());
        comboSubTipo1.setVisible(false);
        comboSubTipo2.setVisible(false);
        comboSubTipo3.setVisible(false);
        comboDispPT.setValue(SeleccioneUnaOpcion.SELECCIONE_UNA_OPCION.getTipo());

        labelFotoPT.setText("Escoger foto...");
        labelFotoPT.setAlignment(Pos.CENTER);

        llenarSubTipos();

        valorSpinner.setValue(0);
        spinnerCant.setValueFactory(valorSpinner);

        //--------------------------------------Inicializar ComboBox pestaña MATERIAL-----------------------------------------//
//        comboTipoMaterial.setValue(SeleccioneUnaOpcion.SELECCIONE_UNA_OPCION.getTipo());
//        comboDispMaterial.setValue(SeleccioneUnaOpcion.SELECCIONE_UNA_OPCION.getTipo());
        //--------------------------------------Inicializar ComboBox pestaña KIT----------------------------------------------//
//        comboDispKit.setValue(SeleccioneUnaOpcion.SELECCIONE_UNA_OPCION.getTipo());
        //------------------------------------------------Llenar ComboBox-----------------------------------------------------//
        //--------------------------------------Llenar ComboBox pestaña PRODUCTO TERMINADO------------------------------------//
        comboTipoProducto.getItems().addAll(TipoProducto.listar());
        comboDispPT.getItems().addAll(Disponibilidad.POR_ENCARGO.getTipo(), Disponibilidad.ENTREGA_INMEDIATA.getTipo());

        //--------------------------------------Llenar ComboBox pestaña MATERIAL----------------------------------------------//
//        comboTipoMaterial.getItems().addAll();
//        comboDispMaterial.getItems().addAll(Disponibilidad.POR_ENCARGO.getTipo(), Disponibilidad.ENTREGA_INMEDIATA.getTipo());
        //--------------------------------------Llenar ComboBox pestaña KIT---------------------------------------------------//
//        comboDispKit.getItems().addAll(Disponibilidad.POR_ENCARGO.getTipo(), Disponibilidad.ENTREGA_INMEDIATA.getTipo());
    }
}
