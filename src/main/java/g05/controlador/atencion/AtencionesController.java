package g05.controlador.atencion;

import g05.App;
import g05.modelo.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

public class AtencionesController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button botonEliminarA;

    @FXML
    private ComboBox<String> cbConsultarPor;

    @FXML
    private TableColumn<Atencion, Cliente> colClienteA;

    @FXML
    private TableColumn<Atencion, LocalDate> getColFechaA;

    @FXML
    private TableColumn<Atencion, String> colDuracionA;

    @FXML
    private TableColumn<Atencion, Empleado> colEmpleadoA;

    @FXML
    private TableColumn<Atencion, LocalDate> colFechaA;

    @FXML
    private Button regresarA;

    @FXML
    private TableView<Atencion> tablaAtenciones;

    @FXML
    private TextField txtConsultar;

    @FXML
    public void llenarCombo(){
        cbConsultarPor.getItems().addAll("Cédula del cliente", "Cédula del empleado", "Fecha");
    }


    public static ArrayList<Atencion> atencionesSer = Atencion.cargarAtenciones(App.pathAtenciones);


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        llenarCombo();
        colClienteA.setCellValueFactory(new PropertyValueFactory<Atencion, Cliente>("cliente"));
        colFechaA.setCellValueFactory(new PropertyValueFactory<Atencion, LocalDate>("fecha"));
        colDuracionA.setCellValueFactory(new PropertyValueFactory<Atencion, String>("duracionReal"));
        colEmpleadoA.setCellValueFactory(new PropertyValueFactory<Atencion, Empleado>("empleado"));
        tablaAtenciones.setItems(obtenerAtenciones());
        botonEliminarA.setDisable(true);
        botonEliminarA.setOnMouseEntered(mouseEvent -> App.button_hoverSound());
        regresarA.setOnMouseEntered(mouseEvent -> App.button_hoverSound());
    }
    @FXML
    void backAtenciones(ActionEvent event) {
        App.changeRootFXML("vista/fxml/Menu");
    }

    public ObservableList<Atencion> obtenerAtenciones() {
        ObservableList<Atencion> atenciones = FXCollections.observableArrayList();
        for (Atencion at : atencionesSer) {
            atenciones.add(at);
        }
        return atenciones;
    }

    @FXML
    private void filtrarAtenciones() {
        ArrayList<Atencion> atenciones = new ArrayList<>();
        try {
            if (cbConsultarPor.getValue().equals("Cédula del cliente")) {

                txtConsultar.setPromptText("Ingrese cédula del cliente");
                String cedulaC = txtConsultar.getText();
                Cliente cliente = new Cliente(cedulaC);
                for (Atencion a : AtencionesController.atencionesSer) {
                    if (a.getClienteObj().equals(cliente)) {
                        atenciones.add(a);
                    }
                }
            } else if (cbConsultarPor.getValue().equals("Cédula del empleado")) {
                txtConsultar.setPromptText("Ingrese cédula del empleado");
                String cedulaE = txtConsultar.getText();
                Empleado empleado = new Empleado(cedulaE);
                for (Atencion a : AtencionesController.atencionesSer) {
                    if (a.getEmpleadoObj().equals(empleado)) {
                        atenciones.add(a);
                    }
                }
            } else {
                txtConsultar.setPromptText("Ingrese fecha a consultar");
                LocalDate fechaA = LocalDate.parse(txtConsultar.getText());
                for (Atencion a : AtencionesController.atencionesSer) {
                    if (a.getFecha().isEqual(fechaA)) {
                        atenciones.add(a);
                    }
                }
            }
            tablaAtenciones.getItems().setAll(atenciones);
        } catch (Exception e) {
            //Exception capturada
        }
    }

    @FXML
    public void eliminarAtenciones() {
        Atencion atencion = (Atencion) tablaAtenciones.getSelectionModel().getSelectedItem();
        Alert alertaEliminarA = new Alert(Alert.AlertType.CONFIRMATION);
        alertaEliminarA.setTitle("Eliminar Atencion " + atencion.getCliente());
        alertaEliminarA.setHeaderText("Confirmación");
        alertaEliminarA.setContentText("¿Está seguro que quiere eliminar la atención del cliente " + atencion.getCliente() + "?");
        Optional<ButtonType> resultado = alertaEliminarA.showAndWait();
        //Si el usuario da OK, se eliminará la atencion seleccionada.
        if (resultado.get() == ButtonType.OK) {
            ArrayList<Atencion> atenciones = atencionesSer;
            int ind = atenciones.indexOf(atencion);
            atenciones.remove(ind);
            Atencion.actualizarSER(App.pathAtenciones, atenciones);
            tablaAtenciones.setItems(obtenerAtenciones());
            // Los botones se desactivan nuevamente.
            botonEliminarA.setDisable(true);
        }
    }

    @FXML
    void comprobarSeleccion(MouseEvent event) {
        Atencion a = (Atencion) tablaAtenciones.getSelectionModel().getSelectedItem();
        if(a == null){
            botonEliminarA.setDisable(true);
        } else{
            botonEliminarA.setDisable(false);
        }
    }
}