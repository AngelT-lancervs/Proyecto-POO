package g05.controlador.agregar;

import g05.App;
import g05.controlador.CitasController;
import g05.controlador.EmpleadosController;
import g05.modelo.Empleado;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class RegistrarAtencionController implements Initializable {
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button guardar;

    @FXML
    private Button botonJuego;

    @FXML
    private Button cancelar;

    @FXML
    private Label fecha_hora;

    @FXML
    private Label cliente;

    @FXML
    private TextField duracion;

    @FXML
    private ComboBox<Empleado> empleadosAtencion;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<Empleado> empleados = EmpleadosController.obtenerEmpleados();
        for (Empleado e: empleados){
            CitasController.añadirComboBoxE(empleadosAtencion, e);
        }
    }

    @FXML
    public void agregarAtencion(ActionEvent event) {
        

    }
    
    @FXML
    public void entrarJuego(){
        App.changeRootFXML("vista/secundarias/Juego");
    }
    
    

    @FXML
    void atrasAtencion(ActionEvent event) {
        try {
            Scene scene = anchorPane.getScene();
            FXMLLoader loader =  new FXMLLoader(App.class.getResource("vista/Citas.fxml"));
            scene.setRoot(loader.load());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
 
        




}
