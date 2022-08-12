package g05.controlador.agregar;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import g05.App;
import g05.modelo.*;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AgregarCitaController {

    @FXML
    private VBox vBox;

    @FXML
    private Stage stage;

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button botonAgregarC;

    @FXML
    private Button botonCancelar;

    @FXML
    private ComboBox opcionesCliente;

    @FXML
    private ComboBox opcionesEmpleado;

    @FXML
    private TextField cedCliente;

    @FXML
    private TextField fecha;

    @FXML
    private TextField hora;

    @FXML
    private TextField servicio;

    @FXML
    private ImageView imagenCl;

    @FXML
    private ImageView imagenE;


    //Metodos de los botones 
    @FXML
    public void guardarCita(){
        LocalDate f = LocalDate.parse(this.fecha.getText());
        LocalTime h = LocalTime.parse(this.hora.getText());

        
    }

    @FXML
    public void cancelar(Event event){
        try {
            Scene scene = vBox.getScene();
            FXMLLoader loader =  new FXMLLoader(App.class.getResource("Citas.fxml"));
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
}
