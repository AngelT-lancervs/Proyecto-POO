package g05.controlador;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
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

    ArrayList<Integer> nms = JuegoController.generarNumeros();

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        this.label0_0.setText(String.valueOf(nms.get(0)));
        this.label0_1.setText(String.valueOf(nms.get(1)));
        this.label0_2.setText(String.valueOf(nms.get(2)));
        this.label0_3.setText(String.valueOf(nms.get(3)));
        this.label1_0.setText(String.valueOf(nms.get(4)));
        this.label1_1.setText(String.valueOf(nms.get(5)));
        this.label1_2.setText(String.valueOf(nms.get(6)));
        this.label1_3.setText(String.valueOf(nms.get(7)));
        this.label2_0.setText(String.valueOf(nms.get(8)));
        this.label2_1.setText(String.valueOf(nms.get(9)));
        this.label2_2.setText(String.valueOf(nms.get(10)));
        this.label2_3.setText(String.valueOf(nms.get(11)));
        this.label3_0.setText(String.valueOf(nms.get(12)));
        this.label3_1.setText(String.valueOf(nms.get(13)));
        this.label3_2.setText(String.valueOf(nms.get(14)));
        this.label3_3.setText(String.valueOf(nms.get(15)));
        this.label4_0.setText(String.valueOf(nms.get(16)));
        this.label4_1.setText(String.valueOf(nms.get(17)));
        this.label4_2.setText(String.valueOf(nms.get(18)));
        this.label4_3.setText(String.valueOf(nms.get(19)));

        int numaleatorio = (int) (Math.random()*20);
        this.numero.setText(String.valueOf(nms.get(numaleatorio)));
        


    }


    @FXML
    public void guardarPuntaje(ActionEvent event) {

    }

    @FXML
    public void salir(ActionEvent event) {
        App.changeRootFXML("vista/secundarias/RegistrarAtencion");
    }


    @FXML
    public void accionJugador(){
        
    }


    //Generar numeros aleatorios no repetidos
    public static ArrayList<Integer> generarNumeros(){
        ArrayList<Integer> nums = new ArrayList<>();
        int contador = 0;

        while (contador <20){
            int rd = (int) (Math.random()*30) +1;
            Integer i = (int) rd;
            if(!nums.contains(i)){
                nums.add(i);
            }
            else{ nums.add(contador+31);}

            contador ++;
                
            }


        return nums;
    }

}