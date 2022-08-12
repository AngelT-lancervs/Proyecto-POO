package g05;

import g05.modelo.Sistema;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    public static String pathEmpleados = "archivo/empleados.csv";

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Menu"),800 ,650);
        stage.setScene(scene);
        stage.setTitle("Sistema para manejo de atenciones");
        scene.getStylesheets().add(App.class.getResource("vista/css/estilos.css").toExternalForm());
        stage.show();

    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    //Método para cambiar el nodo root de la escena.
    public static void changeRootFXML(String nameFXML) {
        Parent root = null;
        try {
            root = loadFXML(nameFXML);
            scene.setRoot(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }

}