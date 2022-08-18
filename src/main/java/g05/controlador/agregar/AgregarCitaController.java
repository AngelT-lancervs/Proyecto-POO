package g05.controlador.agregar;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

import g05.App;
import g05.controlador.CitasController;
import g05.controlador.ClientesController;
import g05.controlador.EmpleadosController;
import g05.controlador.ServiciosController;
import g05.modelo.*;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AgregarCitaController implements Initializable{

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Empleado> empleados = EmpleadosController.obtenerEmpleados();
        for (Empleado e: empleados){
            CitasController.añadirComboBoxE(opcionesEmpleado, e);
        }

        ObservableList<Cliente> clientes = ClientesController.obtenerClientes();
        for (Cliente c: clientes){
            CitasController.añadirComboBoxCl(opcionesCliente, c);
        }

        ObservableList<Servicio> servicios1 = CitasController.obtenerServicios();
        for (Servicio s: servicios1){
            CitasController.añadirComboBoxSer(serviciosCita, s);
        }
        


    }


    //Metodos de los botones 
    @FXML
    public void guardarCita(){
        String f = this.fecha.getText();
        String h = this.hora.getText();

        if(confirmarFormato(f, h)){
            Cita cita1 = new Cita(LocalDate.parse(f), LocalTime.parse(h), this.serviciosCita.getValue(), this.opcionesCliente.getValue(), this.opcionesEmpleado.getValue());
            Cita.escribirCita(cita1);
            Alert alertaRegistro = new Alert(Alert.AlertType.INFORMATION);
            alertaRegistro.setTitle("Registro existoso");
            alertaRegistro.setHeaderText("REGISTRO");
            alertaRegistro.setContentText("Cita registrada correctamente!");
            alertaRegistro.showAndWait();
            App.changeRootFXML("vista/Citas");

        
        }
        else{ mostrarAlerta(); }
    }


    @FXML
    public void cancelar(Event event){
        try {
            Scene scene = anchorPane.getScene();
            FXMLLoader loader =  new FXMLLoader(App.class.getResource("vista/Citas.fxml"));
            scene.setRoot(loader.load());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void mostrarCl(){

    }

    @FXML
    public void mostrarE(){
        
    }



    public void mostrarAlerta(){
        Alert alertaRegistro = new Alert(Alert.AlertType.INFORMATION);
        alertaRegistro.setTitle("CITA");
        alertaRegistro.setHeaderText("Campos Erróneos");
        alertaRegistro.setContentText("Ingrese correctamente la fecha y/o la hora.\n El formato de la fecha es: YYYY-MM-DD \nEl formato de la hora es: HH:MM:SS ");
        alertaRegistro.showAndWait();

    }

    public boolean confirmarFormato(String f, String h){
        try{
            LocalTime t = LocalTime.parse(h);
            LocalDate fe = LocalDate.parse(f);
            return true;

            } catch (DateTimeParseException e){}
            return false;
        }
    }

