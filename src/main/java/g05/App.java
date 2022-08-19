package g05;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    private static File file;
    private static Media media;
    private static MediaPlayer mp;

    public static String pathSound = "src/main/resources/g05/vista/sound-fx/";
    public static String pathEmpleadosCSV = "archivo/registros/empleados.csv";
    public static String pathClientesCSV= "archivo/registros/clientes.csv";
    public static String pathServiciosCSV = "archivo/registros/servicios.csv";
    public static String pathCitas = "archivo/registros/citas.ser";
    public static String pathAtenciones = "archivo/registros/atenciones.ser";


    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("vista/Menu"),800 ,650);
        stage.setScene(scene);
        stage.setTitle("Sistema para manejo de atenciones");
        scene.getStylesheets().add(App.class.getResource("vista/css/estilos.css").toExternalForm());
        stage.show();

    }

    public static void setRoot(String fxml) {
        try {
            scene.setRoot(loadFXML(fxml));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    //Método para cambiar el nodo root de la escena.
    public static void changeRootFXML(String pathFXML) {
        Parent root = null;
        try {
            root = loadFXML(pathFXML);
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Método para cambiar el nodo root de la escena, y recuperar el controlador.

    public static Object changeRootFXML(String pathFXML, Class controllerClass){

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(pathFXML+ ".fxml"));
            Object controller = controllerClass.newInstance();
            fxmlLoader.setController(controller);
            Parent root = (Parent) fxmlLoader.load();
            scene.setRoot(root);
            return controller;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        launch();
    }

    /**
     * Sonidos para javafx media
     */
    public static void button_hoverSound(){
        file = new File(pathSound+"button-hover.mp3");
        media = new Media(file.toURI().toString());
        mp = new MediaPlayer(media);
        mp.play();
    }

}