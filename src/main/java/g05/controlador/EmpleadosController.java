package g05.controlador;

import g05.App;
import g05.modelo.Empleado;
import g05.modelo.Sistema;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EmpleadosController implements Initializable {

    @FXML
    private AnchorPane anchorPane;


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
    private TableColumn<Empleado, Void> colEstadoE;

    @FXML
    private TableColumn<Empleado, String> colNombreE;

    @FXML
    private TableColumn<Empleado, String> colTelefonoE;

    @FXML
    private Button regresarE;

    @FXML
    private TableView<Empleado> tablaEmpleados;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        colNombreE.setCellValueFactory(new PropertyValueFactory<Empleado, String>("nombre"));
        colCedulaE.setCellValueFactory(new PropertyValueFactory<Empleado, String>("cedula"));
        colEmailE.setCellValueFactory(new PropertyValueFactory<Empleado, String>("email"));
        colEstadoE.setCellValueFactory(new PropertyValueFactory<Empleado, Void>("estado"));
        colTelefonoE.setCellValueFactory(new PropertyValueFactory<Empleado, String>("telefono"));
        tablaEmpleados.setItems(obtenerEmpleados());
    }

    public static ObservableList<Empleado> obtenerEmpleados(){
        ObservableList<Empleado> empleados = FXCollections.observableArrayList();
        ArrayList<Empleado> empleadosCSV = Empleado.cargarEmpleados(App.pathEmpleadosCSV);
        for (Empleado e : empleadosCSV){
            empleados.add(e);
            System.out.println(e);
        }
        return empleados;
    }
    //Eventos al presionar los botones del menú Empleados
    @FXML
    void backEmpleados(ActionEvent event) {
        App.changeRootFXML("vista/Menu");
    }
    @FXML
    void agregarEmpleado(ActionEvent actionEvent) {
        App.changeRootFXML("vista/secundarias/AgregarEmpleados");
    }
}
