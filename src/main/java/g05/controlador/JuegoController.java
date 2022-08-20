package g05.controlador;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
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
    private Label label0;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private Label label6;
    @FXML
    private Label label7;
    @FXML
    private Label label8;
    @FXML
    private Label label9;
    @FXML
    private Label label10;
    @FXML
    private Label label11;
    @FXML
    private Label label12;
    @FXML
    private Label label13;
    @FXML
    private Label label14;
    @FXML
    private Label label15;
    @FXML
    private Label label16;
    @FXML
    private Label label17;
    @FXML
    private Label label18;
    @FXML
    private Label label19;

    @FXML
    private Label numero;

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

    //ArrayList<Label> labels = new ArrayList<>();
    //ArrayList<Label> lVacios = new ArrayList<>();

    ArrayList<Integer> indicesV = indicesVacios();
    ArrayList<Integer> numerosReales = new ArrayList<>();
   
    HashMap<String, Label> labels = new HashMap<>();
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        labels.put("label0", label0);
        labels.put("label1", label1);
        labels.put("label2", label2);
        labels.put("label3", label3);
        labels.put("label4", label4);
        labels.put("label5", label5);
        labels.put("label6", label6);
        labels.put("label7", label7);
        labels.put("label8", label8);
        labels.put("label9", label9);
        labels.put("label10", label10);
        labels.put("label11", label11);
        labels.put("label12", label12);
        labels.put("label13", label13);
        labels.put("label14", label14);
        labels.put("label15", label15);
        labels.put("label16", label16);
        labels.put("label17", label17);
        labels.put("label18", label18);
        labels.put("label19", label19);

        indicesV = indicesVacios();
        numerosReales = listaOriginal();
        System.out.println(indicesV);
        System.out.println(nms);
        System.out.println(numerosReales);
        System.out.println(numerosReales.size());
        
        reproducirIdle();
        
    }


    //ERROR AL QUERER REGRESAR A LA PANTALLA REGISTRARATENCION
    @FXML
    public void salir(ActionEvent event) {
        App.changeRootFXML("vista/fxml/cita/Citas");
    }


    @FXML
    public void accionJugador(){
        comprobarAccion();
    }

    @FXML
    public void iniciar(){
        this.botonIniciar.setDisable(true);
        numerosR();
        cambiarNumero();
        casillasVacias();
        accionJugador();
        
    }

    //Generar numeros aleatorios no repetidos
    public static ArrayList<Integer> generarNumeros(){
        ArrayList<Integer> nums = new ArrayList<>();

        while (nums.size() < 20){
            int rd = (int) (Math.random()*80 +1);
            Integer i = (int) rd;

            if(!nums.contains(i)){
                nums.add(i);
            }
        }


        return nums;
    }

    //Comprobar movimiento
    public void comprobarAccion(){

        for(Label l: labels.values()){
            

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
                    //nms.remove(cambiarNumero());
                } else {
                    numErrores += 1;
                    this.errores.setText(String.valueOf(numErrores));
                    reproducirError();
                } 
            });
        }
    }
    public void numerosR(){
        for(int i = 0; i<20; i++){
            labels.get("label" + String.valueOf(i)).setText(nms.get(i).toString());
        }

    }


    //Cambiar Numero
    public int cambiarNumero(){

        int numA = (int) (Math.random()*(numerosReales.size()-1));
        this.numero.setText(String.valueOf(numerosReales.get(numA)));
        numerosReales.remove(numA);
        return numA;
    }

    //Cambiar imagen Perro
    public void cambiarImagen(Label l){
        l.setText("");
        Image im = new Image(App.class.getResourceAsStream("vista/img/gato/perro2.jpg"), 200.0,100.0, true, false);
        l.setGraphic(new ImageView(im));
    }

    //GENERAR CASILLAS VACIAS
    //Generar indices
    public ArrayList<Integer> indicesVacios(){
        ArrayList<Integer> indices = new ArrayList<>();

        while (indices.size() <5){
            int c = (int) (Math.random()*(nms.size()-1));
            Integer n = (int) c;
            if(!indices.contains(n)){
                indices.add(n);
            }
        }
        return indices;
    }

    //cambiar por perritos
    public void casillasVacias(){

        for (Integer i: indicesV){

            labels.get("label" + String.valueOf(i)).setText("");
            cambiarImagen(labels.get("label" + String.valueOf(i)));

        }
    }
       
    public ArrayList<Integer> listaOriginal(){

        ArrayList<Integer> numerosPro = new ArrayList<>();

        Integer n1 = this.nms.get(this.indicesV.get(0));
        Integer n2 = this.nms.get(this.indicesV.get(1));
        Integer n3 = this.nms.get(this.indicesV.get(2));
        Integer n4 = this.nms.get(this.indicesV.get(3));
        Integer n5 = this.nms.get(this.indicesV.get(4));

        for(int i=0 ; i<20 ; i++){
            Integer indiceP = nms.get(i);
            if(indiceP != n1 && indiceP != n2 && indiceP != n3 && indiceP != n4 && indiceP != n5){
                numerosPro.add(nms.get(i));
            }
        }
        return numerosPro;
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