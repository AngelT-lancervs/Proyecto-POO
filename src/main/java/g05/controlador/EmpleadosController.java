package g05.controlador;

import g05.App;
import g05.modelo.Empleado;
import g05.modelo.Sistema;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EmpleadosController implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button botonAgregarE;

    @FXML
    private Button botonEditarE;

    @FXML
    private Button botonEliminarE;

    @FXML
    private TableColumn<Empleado, String> colCedulaE;

    @FXML
    private TableColumn<Empleado, String> colEmailE;

    @FXML
    private TableColumn<Empleado, Boolean> colEstadoE;

    @FXML
    private TableColumn<Empleado, String> colNombreE;

    @FXML
    private TableColumn<Empleado, String> colTelefonoE;

    @FXML
    private Button regresarE;

    @FXML
    private TableView<Empleado> tEmpleados;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        colNombreE.setCellValueFactory(new PropertyValueFactory<Empleado, String>("nombre"));
        colCedulaE.setCellValueFactory(new PropertyValueFactory<Empleado, String>("cedula"));
        colEmailE.setCellValueFactory(new PropertyValueFactory<Empleado, String>("email"));
        colEstadoE.setCellValueFactory(new PropertyValueFactory<Empleado, Boolean>("estado"));
        colTelefonoE.setCellValueFactory(new PropertyValueFactory<Empleado, String>("telefono"));
        tEmpleados.setItems(obtenerEmpleados());
    }

    public ObservableList<Empleado> obtenerEmpleados(){
        ObservableList<Empleado> empleados = FXCollections.observableArrayList();
        for (Empleado e : Sistema.empleados){
            empleados.add(e);
        }
        return empleados;
    }
    //Eventos al presionar los botones del menú Empleados
    @FXML
    void backEmpleados(ActionEvent event) {
        try {
            Scene scene = borderPane.getScene();
            FXMLLoader loader =  new FXMLLoader(App.class.getResource("Menu.fxml"));
            scene.setRoot(loader.load());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void agregarEmpleado(ActionEvent actionEvent) {
        try {

            Stage stageAgregarEmpleado = new Stage();

            FXMLLoader loader =  new FXMLLoader(App.class.getResource("AgregarEmpleado.fxml"));
            Scene sceneAgregarEmpleado = new Scene(loader.load());
            stageAgregarEmpleado.setScene(sceneAgregarEmpleado);
            stageAgregarEmpleado.show();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
