package g05.controlador;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

import g05.App;
import g05.modelo.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JuegoController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private GridPane gridPane;

    @FXML
    private Label label0_0;
    @FXML
    private Label label0_1;
    @FXML
    private Label label0_2;
    @FXML
    private Label label0_3;
    @FXML
    private Label label1_0;
    @FXML
    private Label label1_1;
    @FXML
    private Label label1_2;
    @FXML
    private Label label1_3;
    @FXML
    private Label label2_0;
    @FXML
    private Label label2_1;
    @FXML
    private Label label2_2;
    @FXML
    private Label label2_3;
    @FXML
    private Label label3_0;
    @FXML
    private Label label3_1;
    @FXML
    private Label label3_2;
    @FXML
    private Label label3_3;
    @FXML
    private Label label4_0;
    @FXML
    private Label label4_1;
    @FXML
    private Label label4_2;
    @FXML
    private Label label4_3;

    @FXML
    private Label numero;

    @FXML
    private Button botonGuardar;

    @FXML
    private Button botonSalir;

    @FXML
    private Label aciertos;

    @FXML
    private Label errores;


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }


    @FXML
    public void guardarPuntaje(ActionEvent event) {

    }

    @FXML
    public void salir(ActionEvent event) {
        App.changeRootFXML("vista/Menu");
    }

    @FXML
    public void accionJugador(){

    }
}