package g05;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class MenuController {

    @FXML
    Label infoMenu;
    @FXML
    Button botonClientes;
    @FXML
    Button botonServicios;
    @FXML
    Button botonAtenciones;
    @FXML
    Button botonSalir;
    @FXML
    Button botonEmpleados;
    @FXML
    ImageView displayMenu;
    @FXML
    AnchorPane anchorPane1;
    @FXML
    VBox vBoxMenu;




    //Métodos cuando el cursor pasa por encima de cada boton
    @FXML
    public void preServicios(){
        Image im = new Image(getClass().getResourceAsStream("media/servicio.jpg"));
        displayMenu.setImage(im);
    }
    @FXML
    public void preClientes(){
        Image im = new Image(getClass().getResourceAsStream("media/cliente.jpg"));
        displayMenu.setImage(im);
    }
    @FXML
    public void preAtenciones(){
        Image im = new Image(getClass().getResourceAsStream("media/atencion.jpg"));
        displayMenu.setImage(im);
    }
    @FXML
    public void preCitas(){
        Image im = new Image(getClass().getResourceAsStream("media/cita.jpg"));
        displayMenu.setImage(im);
    }
    @FXML
    public void preEmpleados(){
        Image im = new Image(getClass().getResourceAsStream("media/empleado.jpg"));
        displayMenu.setImage(im);
    }
    @FXML
    public void preSalir(){
        Image im = new Image(getClass().getResourceAsStream("media/salir.jpg"));
        displayMenu.setImage(im);
    }

    //Métodos cuando se da click a cada boton
    @FXML
    public void entrarServicios(){

    }
    @FXML
    public void entrarClientes(){

    }
    @FXML
    public void entrarAtenciones(){

    }
    @FXML
    public void entrarCitas(){

    }
    @FXML
    public void entrarEmpleados(){

    }
    @FXML
    public void cerrarSistema(){

    }


}
