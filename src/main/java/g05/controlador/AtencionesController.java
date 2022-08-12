package g05.controlador;

import g05.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AtencionesController {

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

    @FXML
    void backAtenciones(ActionEvent event) {
        App.changeRootFXML("vista/Menu");
    }

}