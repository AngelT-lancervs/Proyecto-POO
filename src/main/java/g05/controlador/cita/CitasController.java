package g05.controlador.cita;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import g05.App;
import g05.controlador.atencion.RegistrarAtencionController;
import g05.modelo.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class CitasController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button botonCrearCi;

    @FXML
    private Button botonEliminarCi;

    @FXML
    private Button botonFecha;

    @FXML
    private Button regresarCi;

    @FXML
    private TableView<Cita> tablaCitas;

    @FXML
    private Button botonRegistrarA;

    @FXML
    private Button botonConsultarAc;



    //@FXML
    //private TableColumn<Cliente, String> colCedula;

    @FXML
    private TableColumn<Cita, Cliente> colNombreCi;
    @FXML
    private TableColumn<Cita, Empleado> colEmpleadoCi;
    @FXML
    private TableColumn<Cita, LocalDate> colFechaCi;
    @FXML
    private TableColumn<Cita, LocalTime> colHoraCi;
    @FXML
    private TableColumn<Cita, Servicio> colServicioCi;
    @FXML
    private TextField txtCedCliente;

    public static ArrayList<Cita> citasSer = (ArrayList<Cita>) Cita.cargarCitas(App.pathCitas);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //colCedula.setCellValueFactory(new PropertyValueFactory<Cita, String>("cedula"));
        colNombreCi.setCellValueFactory(new PropertyValueFactory<Cita, Cliente>("cliente"));
        colEmpleadoCi.setCellValueFactory(new PropertyValueFactory<Cita, Empleado>("proovedor"));
        colFechaCi.setCellValueFactory(new PropertyValueFactory<Cita, LocalDate>("fecha"));
        colHoraCi.setCellValueFactory(new PropertyValueFactory<Cita, LocalTime>("hora"));
        colServicioCi.setCellValueFactory(new PropertyValueFactory<Cita, Servicio>("servicio"));
        tablaCitas.setItems(obtenerCitas());
        botonRegistrarA.setDisable(true);
        botonEliminarCi.setDisable(true);
        botonCrearCi.setOnMouseEntered(mouseEvent -> App.button_hoverSound());
        botonConsultarAc.setOnMouseEntered(mouseEvent -> App.button_hoverSound());
        botonEliminarCi.setOnMouseEntered(mouseEvent -> App.button_hoverSound());
        botonRegistrarA.setOnMouseEntered(mouseEvent -> App.button_hoverSound());
        regresarCi.setOnMouseEntered(mouseEvent -> App.button_hoverSound());
    }

    public ObservableList<Cita> obtenerCitas() {
        ObservableList<Cita> citas = FXCollections.observableArrayList();
        for (Cita ci : citasSer) {
            citas.add(ci);
        }
        return citas;
    }

    //Metodos de las opciones de cita
    @FXML
    public void crearCita() {
        App.changeRootFXML("vista/secundarias/AgregarCitas");
    }


    @FXML
    public void backCitas(){
        App.changeRootFXML("vista/Menu");
    }

    @FXML
    public void eliminarCita(){
        Cita ci = (Cita) tablaCitas.getSelectionModel().getSelectedItem();
        Alert alertaEliminarCi = new Alert(Alert.AlertType.CONFIRMATION);
        alertaEliminarCi.setTitle("Eliminar cita "+ci.getCliente());
        alertaEliminarCi.setHeaderText("Confirmación");
        alertaEliminarCi.setContentText("¿Está seguro que quiere eliminar la cita del cliente "+ci.getCliente()+"?");
        Optional<ButtonType> resultado = alertaEliminarCi.showAndWait();
        //Si el usuario da OK, se eliminará el empleado seleccionado.
        if(resultado.get() == ButtonType.OK) {
            ArrayList<Cita> citas = citasSer;
            int ind = citas.indexOf(ci);
            citas.remove(ind);
            Cita.actualizarSER(App.pathCitas, citas);
            tablaCitas.setItems(obtenerCitas());
            // Los botones se desactivan nuevamente.
            botonEliminarCi.setDisable(true);
            botonRegistrarA.setDisable(true);
        }

    }

    @FXML
    public void consultarActividades(){

    }

    @FXML
    public void registrarAtencion(){
        Cita ci = (Cita) tablaCitas.getSelectionModel().getSelectedItem();
        RegistrarAtencionController controladorRegistroA = (RegistrarAtencionController) App.changeRootFXML("vista/secundarias/RegistrarAtencion", RegistrarAtencionController.class);
        controladorRegistroA.cargarDatosCita(ci);
    }
    @FXML
    void comprobarSeleccion(MouseEvent event) {
        Cita ci = (Cita) tablaCitas.getSelectionModel().getSelectedItem();
        if (ci == null) {
            botonRegistrarA.setDisable(true);
            botonEliminarCi.setDisable(true);
        } else {
            botonRegistrarA.setDisable(false);
            botonEliminarCi.setDisable(false);
        }
    }
}
