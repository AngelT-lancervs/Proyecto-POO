package g05.controlador;

import g05.App;
import g05.modelo.Servicio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ServiciosController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button botonAgregarS;

    @FXML
    private Button botonEditarS;

    @FXML
    private Button botonEliminarS;

    @FXML
    private TableColumn<Servicio, Integer> colDuracionS;

    @FXML
    private TableColumn<?, ?> colEstadoS;

    @FXML
    private TableColumn<?, ?> colNombreS;

    @FXML
    private TableColumn<?, ?> colPrecioS;

    @FXML
    private Button regresarS;

    @FXML
    private TableView<?> tablaServicios;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    @FXML
    void agregarServicio(ActionEvent event) {

    }

    @FXML
    void backServicios(ActionEvent event) {
        App.changeRootFXML("vista/Menu");
    }


}