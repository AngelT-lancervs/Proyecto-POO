package g05;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MenuController {

    @FXML
    private BorderPane borderPane;
    @FXML
    private Button botonAtenciones;

    @FXML
    private Button botonCitas;

    @FXML
    private Button botonClientes;

    @FXML
    private Button botonEmpleados;

    @FXML
    private Button botonSalir;

    @FXML
    private Button botonServicios;

    @FXML
    private ImageView displayMenu;

    @FXML
    private Label infoMenu;

    @FXML
    private VBox vBoxMenu;

    //Métodos cuando el cursor pasa por encima de cada boton
    @FXML
    public void preServicios(){
        Image im = new Image(getClass().getResourceAsStream("media/servicios.png"));
        displayMenu.setImage(im);
        infoMenu.setText("Podrá ver, agregar, editar y/o desactivar \n algún servicio. Presione el botón\n -Servicios- para continuar");
    }
    @FXML
    public void preClientes(){
        Image im = new Image(getClass().getResourceAsStream("media/clientes.png"));
        displayMenu.setImage(im);
        infoMenu.setText("Podrá ver, agregar y/o editar clientes.\n Presione el botón -Clientes- para\n continuar");
    }
    @FXML
    public void preAtenciones(){
        Image im = new Image(getClass().getResourceAsStream("media/atenciones.png"));
        displayMenu.setImage(im);
        infoMenu.setText("Podrá ver, registrar y/o consultar las atenciones.\n Presione el botón -Atenciones- para\n continuar");
    }
    @FXML
    public void preCitas(){
        Image im = new Image(getClass().getResourceAsStream("media/citas.png"));
        displayMenu.setImage(im);
        infoMenu.setText("Podrá ver, crear, eliminar, y/o consultar\n citas. Presione el botón -Citas- para\n continuar");
    }
    @FXML
    public void preEmpleados(){
        Image im = new Image(getClass().getResourceAsStream("media/empleados.png"));
        displayMenu.setImage(im);
        infoMenu.setText("Podrá ver, agregar, editar y/o eliminar\n empleados. Presione el botón\n -Empleados- para continuar");
    }
    @FXML
    public void preSalir(){
        Image im = new Image(getClass().getResourceAsStream("media/salir.png"));
        displayMenu.setImage(im);
        infoMenu.setText("Cerrará la sesión actual.\n Presione el botón -Salir- para cerrar\n el sistema");
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
        //Alerta de confirmación para salir del sistema.
        Alert alertaCerrar = new Alert(Alert.AlertType.CONFIRMATION);
        alertaCerrar.setTitle("Cierre del sistema");
        alertaCerrar.setHeaderText("Confirmación de cierre");
        alertaCerrar.setContentText("¿Está seguro que quiere salir del sistema?");
        Optional<ButtonType> resultado = alertaCerrar.showAndWait();
        //Si el usuario da OK, se cerrará el stage actual.
        if(resultado.get() == ButtonType.OK){
            Stage stage = (Stage)borderPane.getScene().getWindow();
            stage.close();
        }
    }
}
