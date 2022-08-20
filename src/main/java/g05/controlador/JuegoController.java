package g05.controlador;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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

    @FXML
    private Button botonIniciar;

    @FXML
    private Label timer;

    ArrayList<Integer> nms = JuegoController.generarNumeros();

    ArrayList<Label> labels = new ArrayList<>();

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        labels.add(label0_0);
        labels.add(label0_1);
        labels.add(label0_2);
        labels.add(label0_3);
        labels.add(label1_0);
        labels.add(label1_1);
        labels.add(label1_2);
        labels.add(label1_3);
        labels.add(label2_0);
        labels.add(label2_1);
        labels.add(label2_2);
        labels.add(label2_3);
        labels.add(label3_0);
        labels.add(label3_1);
        labels.add(label3_2);
        labels.add(label3_3);
        labels.add(label4_0);
        labels.add(label4_1);
        labels.add(label4_2);
        labels.add(label4_3);


        
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

        
        reproducirIdle();
        cambiarNumero();

        casillasVacias(labels, nms);
        for(Integer i: nms){
            System.out.println(i);
        }
        
    }


    @FXML
    public void guardarPuntaje(ActionEvent event) {

    }

    //ERROR AL QUERER REGRESAR A LA PANTALLA REGISTRARATENCION
    @FXML
    public void salir(ActionEvent event) {
        App.changeRootFXML("vista/fxml/cita/Citas");
    }


    @FXML
    public void accionJugador(){
        comprobarAccion(labels);
    }

    @FXML
    public void iniciar(){
        this.botonIniciar.setDisable(true);
        accionJugador();
    }

    //Generar numeros aleatorios no repetidos
    public static ArrayList<Integer> generarNumeros(){
        ArrayList<Integer> nums = new ArrayList<>();

        while (nums.size() < 20){
            int rd = (int) (Math.random()*30 +1);
            Integer i = (int) rd;

            if(!nums.contains(i)){
                nums.add(i);
            }
        }


        return nums;
    }

    //Comprobar movimiento
    public void comprobarAccion(ArrayList<Label> lb){

        for(Label l: lb){
            

            l.setOnMouseClicked(ev -> {
                int numAciertos = Integer.parseInt(aciertos.getText());
                int numErrores = Integer.parseInt(errores.getText());
        

                if(l.getText().equals(numero.getText())){
                    numAciertos += 1;
                    this.aciertos.setText(String.valueOf(numAciertos));
                    l.setText("");
                    Image im = new Image(App.class.getResourceAsStream("vista/img/gato/gifgato.gif"), 200.0,100.0, true, false);
                    l.setGraphic(new ImageView(im));
                    reproducirCorrecto();
                    cambiarNumero();


                } else {
                    numErrores += 1;
                    this.errores.setText(String.valueOf(numErrores));
                    reproducirError();
                } 

            });

        }
    }


    //Cambiar Numero
    public void cambiarNumero(){

        int numA = (int) (Math.random()*nms.size());
        this.numero.setText(String.valueOf(nms.get(numA)));
        nms.remove(numA);

    }


    //Cambiar imagen Perro
    public void cambiarImagen(Label l){
        l.setText("");
        Image im = new Image(App.class.getResourceAsStream("vista/img/gato/perro2.jpg"), 200.0,100.0, true, false);
        l.setGraphic(new ImageView(im));
    }

    //Generar Casillas Vacias
    public void casillasVacias(ArrayList<Label> lbs, ArrayList<Integer> ints){
        ArrayList<Integer> indices = new ArrayList<>();

        while (indices.size() <5){
            int c = (int) (Math.random()*ints.size());
            Integer n = (int) c;
            if(!indices.contains(n)){
                indices.add(n);
            }
        }

        for (Integer i: indices){
            ints.remove(i);
            lbs.get(i).setText("");
            cambiarImagen(lbs.get(i));
        }
    }

    public void reproducirCorrecto(){
        Media correcto = new Media(new File("src/main/resources/g05/vista/sound-fx/sonidosJuego/correcto.mp3").toURI().toString());
        MediaPlayer correctoP = new MediaPlayer(correcto);
        correctoP.play();
    }

    public void reproducirError(){
        Media error = new Media(new File("src/main/resources/g05/vista/sound-fx/sonidosJuego/error.mp3").toURI().toString());
        MediaPlayer errorP = new MediaPlayer(error);
        errorP.play();
    }

    public void reproducirIdle(){
        Media soundtrack = new Media(new File("src/main/resources/g05/vista/sound-fx/sonidosJuego/juego.mp3").toURI().toString());
        MediaPlayer soundtrackP = new MediaPlayer(soundtrack);
        soundtrackP.setAutoPlay(true);
        soundtrackP.play();
    
    }

}