package g05.controlador.cita;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import g05.App;
import g05.controlador.cita.CitasController;
import g05.controlador.cliente.ClientesController;
import g05.controlador.empleado.EmpleadosController;
import g05.controlador.servicio.ServiciosController;
import g05.modelo.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;


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

    //Deshabilita fechas anteriores
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
    }

    public void getDate(ActionEvent event){
        LocalDate fechaC= fechaCita.getValue();
    }


    //Metodos de los botones 
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


    @FXML
    public void cancelar(Event event){
        App.changeRootFXML("vista/fxml/cita/Citas");
    }

    void confirmarFormato(){
        try{
            LocalTime.parse(hora.getText());
            botonAgregarC.setDisable(false);
            } catch (DateTimeParseException e){
            botonAgregarC.setDisable(true);
        }
    }

    @FXML
    void datosCorrectosTF(KeyEvent event) {
        verificarCampos();
    }
    @FXML
    void datosCorrectosCB(ActionEvent event) {
        verificarCampos();
    }
    void verificarCampos(){
        if((fechaCita.getValue())!=null && (hora.getText())!="" && opcionesEmpleado.getSelectionModel().getSelectedItem() != null && opcionesCliente.getSelectionModel().getSelectedItem() != null && serviciosCita.getSelectionModel().getSelectedItem() != null){
            confirmarFormato();
        } else {
            botonAgregarC.setDisable(true);
        }
    }
}

