package g05.controlador.cita;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import g05.App;
import g05.controlador.SoundController;
import g05.controlador.cliente.ClientesController;
import g05.controlador.empleado.EmpleadosController;
import g05.controlador.servicio.ServiciosController;
import g05.modelo.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * Controlador de agregar cita
 * Autor: Grupo 5
 * Version:1.0
 */

public class AgregarCitaController implements Initializable{

    @FXML
    private DatePicker fechaCita;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Stage stage;
    @FXML
    private VBox vBox;
    @FXML
    private Button botonAgregarC;
    @FXML
    private Button botonCancelar;
    @FXML
    private ComboBox<Cliente> opcionesCliente;
    @FXML
    private ComboBox<Empleado> opcionesEmpleado;
    @FXML
    private ComboBox<Servicio> serviciosCita;
    @FXML
    private TextField fecha;
    @FXML
    private TextField hora;

    /**
     * Metodo para deshabilitar fechas anteriores en el DatePicker
     */
    final Callback<DatePicker, DateCell> dayCellFactory= new Callback<DatePicker, DateCell>() {
        @Override
        public DateCell call(final DatePicker datePicker) {
            return new DateCell() {
                public void updateItem(LocalDate item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item.isBefore(LocalDate.now())) {
                        setDisable(true);
                    }
                }
            };
        }
    };

    /**
     * Inicializa apenas de ejecute el programa
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        botonAgregarC.setDisable(true);
        fechaCita.setEditable(false);
        fechaCita.setDayCellFactory(dayCellFactory);

        ObservableList<Empleado> empleados = EmpleadosController.obtenerEmpleados();
        for (Empleado e: empleados){
            if(e.getEstadoBoolean()){
                opcionesEmpleado.getItems().add(e);
            }
            //Solo se podrá registrar a los empleados activos
        }

        if(!(opcionesEmpleado.getItems().size()>=1)){
            opcionesEmpleado.setPromptText("No hay empleados activos");
        }

        ObservableList<Cliente> clientes = ClientesController.obtenerClientes();
        for (Cliente c: clientes){
            opcionesCliente.getItems().add(c);
        }
        if(!(opcionesCliente.getItems().size()>=1)){
            opcionesCliente.setPromptText("No hay clientes registrados");
        }

        ObservableList<Servicio> servicios = ServiciosController.obtenerServicios();
        for (Servicio s: servicios){
            //Solo se podrá registrar a los servicios activos
            if(s.getEstadoBoolean()){
                serviciosCita.getItems().add(s);
            }
        }
        if(!(serviciosCita.getItems().size()>=1)){
            serviciosCita.setPromptText("No hay servicios activos");
        }
        SoundController sc = new SoundController();

        botonAgregarC.setOnMouseEntered(mouseEvent -> sc.button_hoverSound());
        botonCancelar.setOnMouseEntered(mouseEvent -> sc.button_hoverSound());
    }

    /**
     * Obtiene la fecha seleccionada en el DatePicker
     * @param event
     */
    public void getDate(ActionEvent event){
        LocalDate fechaC= fechaCita.getValue();
    }


    /**
     * Metodo asociado al boton Guardar, guarda la cita
     */
    @FXML
    public void guardarCita(){

        Cita cita = new Cita(fechaCita.getValue(),LocalTime.parse(hora.getText()),serviciosCita.getValue(),opcionesCliente.getValue(),opcionesEmpleado.getValue());
        ArrayList<Cita> citas = CitasController.citasSer;
        citas.add(cita);
        Cita.actualizarSER(App.pathCitas,citas);
        Alert alertaRegistro = new Alert(Alert.AlertType.INFORMATION);
        alertaRegistro.setTitle("Registro existoso");
        alertaRegistro.setHeaderText("REGISTRO");
        alertaRegistro.setContentText("Cita registrada correctamente!");
        alertaRegistro.showAndWait();
        App.changeRootFXML("vista/fxml/cita/Citas");
    }


    /**
     * Rgeresa al menu principal de citas
     * @param event
     */
    @FXML
    public void cancelar(Event event){
        App.changeRootFXML("vista/fxml/cita/Citas");
    }

    /**
     * Confirma que la fecha ingresada sea del formato correcto
     */
    void confirmarFormato(){
        try{
            LocalTime.parse(hora.getText());
            botonAgregarC.setDisable(false);
            } catch (DateTimeParseException e){
            botonAgregarC.setDisable(true);
        }
    }

    /**
     * Verifica que los datos ingresados sean los correctos
     * @param event
     */
    @FXML
    void datosCorrectosTF(KeyEvent event) {
        verificarCampos();
    }
    @FXML
    void datosCorrectosCB(ActionEvent event) {
        verificarCampos();
    }

    /**
     * Verifica que los datos ingresados sean los correctos
     */
    void verificarCampos(){
        if((fechaCita.getValue())!=null && (hora.getText())!="" && opcionesEmpleado.getSelectionModel().getSelectedItem() != null && opcionesCliente.getSelectionModel().getSelectedItem() != null && serviciosCita.getSelectionModel().getSelectedItem() != null){
            confirmarFormato();
        } else {
            botonAgregarC.setDisable(true);
        }
    }
}

