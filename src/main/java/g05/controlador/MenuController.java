package g05.controlador;

import g05.App;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.SocketOption;
import java.util.Optional;

/**
 * Controlador asociado al menu principal
 * Autor: Grupo 5
 * Version:1.0
 */
public class MenuController{


    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView displayMenu;

    @FXML
    private Label infoMenu;

    SoundController sc = new SoundController();


    /**
     * Metodos cuando el cursor pasa por encima del boton
     */
    @FXML
    public void preServicios(){
        sc.button_hoverSound();
        Image im = new Image(App.class.getResourceAsStream("vista/img/servicios.png"));
        displayMenu.setImage(im);
        infoMenu.setText("Podrá ver, agregar, editar y/o desactivar \nalgún servicio. Presione el botón\n -Servicios- para continuar");
    }

    /**
     * Metodos cuando el cursor pasa por encima del boton
     */
    @FXML
    public void preClientes(){
        sc.button_hoverSound();
        Image im = new Image(App.class.getResourceAsStream("vista/img/clientes.png"));
        displayMenu.setImage(im);
        infoMenu.setText("Podrá ver, agregar y/o editar clientes.\nPresione el botón -Clientes- para\n continuar");
    }
    /**
     * Metodos cuando el cursor pasa por encima del boton
     */
    @FXML
    public void preAtenciones(){
        sc.button_hoverSound();
        Image im = new Image(App.class.getResourceAsStream("vista/img/atenciones.png"));
        displayMenu.setImage(im);
        infoMenu.setText("Podrá consultar las atenciones.\nPresione el botón -Atenciones- para\n continuar");
    }
    /**
     * Metodos cuando el cursor pasa por encima del boton
     */
    @FXML
    public void preCitas(){
        sc.button_hoverSound();
        Image im = new Image(App.class.getResourceAsStream("vista/img/citas.png"));
        displayMenu.setImage(im);
        infoMenu.setText("Podrá ver, crear, eliminar, consultar\ncitas, y/o registrar su atención \nPresione el botón -Citas- para continuar");
    }

    /**
     * Metodos cuando el cursor pasa por encima del boton
     */
    @FXML
    public void preEmpleados(){
        sc.button_hoverSound();
        Image im = new Image(App.class.getResourceAsStream("vista/img/empleados.png"));
        displayMenu.setImage(im);
        infoMenu.setText("Podrá ver, agregar, editar y/o eliminar \nempleados. Presione el botón\n -Empleados- para continuar");
    }

    /**
     * Metodos cuando el cursor pasa por encima del boton
     */
    @FXML
    public void preSalir(){
        sc.button_hoverSound();
        Image im = new Image(App.class.getResourceAsStream("vista/img/salir.png"));
        displayMenu.setImage(im);
        infoMenu.setText("Cerrará la sesión actual.\nPresione el botón -Salir- para cerrar\n el sistema");
    }

    /**
     * Ingresa a la ventana de Servicios
     */
    @FXML
    public void entrarServicios(){
        App.changeRootFXML("vista/fxml/servicio/Servicios");

    }

    /**
     * Ingresa a la ventana de Clientes
     */
    @FXML
    public void entrarClientes(){
        App.changeRootFXML("vista/fxml/cliente/Clientes");
    }

    /**
     * Ingresa a la ventana de atenciones
     */
    @FXML
    public void entrarAtenciones(){
        App.changeRootFXML("vista/fxml/atencion/Atenciones");
    }

    /**
     * Ingresa a la ventana de citas
     */
    @FXML
    public void entrarCitas(){
        App.changeRootFXML("vista/fxml/cita/Citas");
    }

    /**
     * Ingresa a la ventana de Empleados
     */
    @FXML
    public void entrarEmpleados(){
        App.changeRootFXML("vista/fxml/empleado/Empleados");
    }

    /**
     * Cierra el sistema
     */
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
            Stage stage = (Stage)anchorPane.getScene().getWindow();
            stage.close();
        }
    }
}
