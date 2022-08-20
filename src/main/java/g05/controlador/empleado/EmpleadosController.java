package g05.controlador.empleado;

import g05.App;
import g05.controlador.SoundController;
import g05.modelo.Empleado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
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
    private Button regresarE;
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
    private TableView<Empleado> tablaEmpleados;

    // ArrayList donde se almacenan todos los empleados.
    public static ArrayList<Empleado> empleadosCSV = Empleado.cargarEmpleados(App.pathEmpleadosCSV);

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colNombreE.setCellValueFactory(new PropertyValueFactory<Empleado, String>("nombre"));
        colCedulaE.setCellValueFactory(new PropertyValueFactory<Empleado, String>("cedula"));
        colEmailE.setCellValueFactory(new PropertyValueFactory<Empleado, String>("email"));
        colEstadoE.setCellValueFactory(new PropertyValueFactory<Empleado, Void>("estado"));
        colTelefonoE.setCellValueFactory(new PropertyValueFactory<Empleado, String>("telefono"));
        tablaEmpleados.setItems(obtenerEmpleados());
        botonEditarE.setDisable(true);
        botonEliminarE.setDisable(true);
        botonAgregarE.setOnMouseEntered(ev -> SoundController.button_hoverSound());
        botonEditarE.setOnMouseEntered(ev -> SoundController.button_hoverSound());
        botonEliminarE.setOnMouseEntered(ev -> SoundController.button_hoverSound());
        regresarE.setOnMouseEntered(ev -> SoundController.button_hoverSound());
    }

    public static ObservableList<Empleado> obtenerEmpleados() {
        ObservableList<Empleado> empleados = FXCollections.observableArrayList();
        for (Empleado e : empleadosCSV) {
            empleados.add(e);
        }
        return empleados;
    }

    //Eventos al presionar los botones del menú Empleados
    @FXML
    void backEmpleados(ActionEvent event) {
        App.changeRootFXML("vista/fxml/Menu");
    }

    @FXML
    void agregarEmpleado(ActionEvent actionEvent) {
        App.changeRootFXML("vista/fxml/empleado/AgregarEmpleado");
    }

    @FXML
    void editarEmpleado(ActionEvent event) {
        Empleado e = (Empleado) tablaEmpleados.getSelectionModel().getSelectedItem();
        EditarEmpleadoController controladorEditarE = (EditarEmpleadoController) App.changeRootFXML("vista/fxml/empleado/EditarEmpleado", EditarEmpleadoController.class);
        controladorEditarE.cargarDatosEmpleado(e);
    }
    @FXML
    void eliminarEmpleado(ActionEvent event){
        Empleado e = (Empleado) tablaEmpleados.getSelectionModel().getSelectedItem();
        Alert alertaEliminarE = new Alert(Alert.AlertType.CONFIRMATION);
        alertaEliminarE.setTitle("Eliminar empleado "+e.getNombre());
        alertaEliminarE.setHeaderText("Confirmación");
        alertaEliminarE.setContentText("¿Está seguro que quiere eliminar al empleado "+e.getNombre()+"?");
        Optional<ButtonType> resultado = alertaEliminarE.showAndWait();
        //Si el usuario da OK, se eliminará el empleado seleccionado.
        if(resultado.get() == ButtonType.OK) {
            ArrayList<Empleado> empleados = empleadosCSV;
            int ind = empleados.indexOf(e);
            empleados.remove(ind);
            Empleado.actualizarCSV(App.pathEmpleadosCSV, empleados);
            tablaEmpleados.setItems(obtenerEmpleados());
            // Los botones se desactivan nuevamente.
            botonEditarE.setDisable(true);
            botonEliminarE.setDisable(true);
        }
    }
    @FXML
    void comprobarSeleccion(MouseEvent event) {
        Empleado e = (Empleado) tablaEmpleados.getSelectionModel().getSelectedItem();
        if(e == null){
            botonEditarE.setDisable(true);
            botonEliminarE.setDisable(true);
        } else{
            botonEditarE.setDisable(false);
            botonEliminarE.setDisable(false);
        }
    }
}

