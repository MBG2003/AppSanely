package aplicacion.controller.modulos;

import aplicacion.model.negocio.Producto;
import aplicacion.model.negocio.Molde;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import aplicacion.Aplicacion;
import aplicacion.model.*;
import aplicacion.utility.*;

public class VentanaTIController implements Initializable {

    private Aplicacion app;

    @FXML
    private Button btVolver;

    @FXML
    private ComboBox comboTipoModulo;

    @FXML
    private ComboBox comboTipoSubModulo;

    @FXML
    private TextField txtDatoBuscar;

    @FXML
    private Button btBuscar;

    @FXML
    private TableView<Empleado> tableEmpleado;

    @FXML
    private TableView<Producto> tableProductoTerminado;

    @FXML
    private TableView<Molde> tableMolde;

    public void buscar() {

    }

    public void volver() throws Exception {
        app.cambiarVentana(Aplicacion.RUTA_VENTANA_ADMIN, Aplicacion.TITULO_VENTANA_ADMIN);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        app = new Aplicacion();

        tableEmpleado.setVisible(false);

        comboTipoModulo.setValue(SeleccioneUnaOpcion.SELECCIONE_UNA_OPCION.getTipo());
        //comboTipoSubModulo.setValue(url);

        comboTipoModulo.getItems().addAll(TipoModulo.CRM.getTipo(), TipoModulo.FINANZAS.getTipo(), TipoModulo.GERENCIA.getTipo(), TipoModulo.RECURSOS_HUMANOS.getTipo());
        //comboTipoSubModulo.getItems().addAll(c);
    }

}
