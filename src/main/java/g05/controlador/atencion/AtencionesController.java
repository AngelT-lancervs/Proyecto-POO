package g05.controlador.atencion;

import g05.App;
import g05.modelo.Atencion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AtencionesController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button botonEliminarA;

    @FXML
    private ComboBox<?> cbConsultarPor;

    @FXML
    private TableColumn<?, ?> colClienteA;

    @FXML
    private TableColumn<?, ?> colDuracionA;

    @FXML
    private TableColumn<?, ?> colEmpleadoA;

    @FXML
    private TableColumn<?, ?> colFechaA;

    @FXML
    private Button regresarA;

    @FXML
    private TableView<?> tablaEmpleados;

    @FXML
    private TextField txtConsultar;

    public static ArrayList<Atencion> atencionesSer = Atencion.cargarAtenciones(App.pathAtenciones);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        botonEliminarA.setOnMouseEntered(mouseEvent -> App.button_hoverSound());
        regresarA.setOnMouseEntered(mouseEvent -> App.button_hoverSound());
    }
    @FXML
    void backAtenciones(ActionEvent event) {
        App.changeRootFXML("vista/Menu");
    }


}