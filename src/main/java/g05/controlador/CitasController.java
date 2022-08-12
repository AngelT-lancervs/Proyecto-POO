package g05.controlador;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import g05.App;
import g05.modelo.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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


public class CitasController implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button botonCrear;

    @FXML
    private Button botonEliminar;

    @FXML
    private Button botonFecha;

    @FXML
    private Button botonRegresar;

    @FXML
    private TableView<Cita> tablaCitas;

    //@FXML
    //private TableColumn<Cliente, String> colCedula;

    @FXML
    private TableColumn<Cliente, String> colCliente;

    @FXML
    private TableColumn<Empleado, String> colEmpleado;

    @FXML
    private TableColumn<Cita, LocalDate> colFecha;

    @FXML
    private TableColumn<Cita, LocalTime> colHora;

    @FXML
    private TableColumn<Servicio, String> colServicio;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //this.colCedula.setCellValueFactory(new PropertyValueFactory<Cliente, String>("Cédula"));
        this.colCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("Nombre del cliente"));
        this.colEmpleado.setCellValueFactory(new PropertyValueFactory<Empleado, String>("Empleado"));
        this.colFecha.setCellValueFactory(new PropertyValueFactory<Cita, LocalDate>("Fecha"));
        this.colHora.setCellValueFactory(new PropertyValueFactory<Cita, LocalTime>("Hora"));
        this.colServicio.setCellValueFactory(new PropertyValueFactory<Servicio, String>("Servicio"));
        tablaCitas.setItems(obtenerCitas());

    }

    public ObservableList<Cita> obtenerCitas(){
        ObservableList<Cita> citas = FXCollections.observableArrayList();
        for (Cita c : Cita.citas){
            citas.add(c);
        }
        return citas;
    }


    //Metodos de las opciones de cita
    @FXML
    public void crearCita(){
        try {
            Stage stageNuevaCita = new Stage();

            FXMLLoader loader =  new FXMLLoader(App.class.getResource("secundarias/AgregarCitas.fxml"));
            Scene sceneNuevaCita = new Scene(loader.load());
            stageNuevaCita.setScene(sceneNuevaCita);
            stageNuevaCita.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void eliminarCita(){
        
    
    }

    @FXML
    public void consultarPorFecha(){
        
    
    }

    @FXML
    public void volverPantalla(){
        try {
            Scene scene = borderPane.getScene();
            FXMLLoader loader =  new FXMLLoader(App.class.getResource("Menu.fxml"));
            scene.setRoot(loader.load());
        } catch (Exception e) { e.printStackTrace();}
    }


}
