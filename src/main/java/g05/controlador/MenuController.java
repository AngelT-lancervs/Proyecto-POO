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
import java.util.Optional;


public class MenuController{


    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView displayMenu;

    @FXML
    private Label infoMenu;


    //Métodos cuando el cursor pasa por encima de cada boton
    @FXML
    public void preServicios(){
        App.button_hoverSound();
        Image im = new Image(App.class.getResourceAsStream("vista/img/servicios.png"));
        displayMenu.setImage(im);
        infoMenu.setText("Podrá ver, agregar, editar y/o desactivar \nalgún servicio. Presione el botón\n -Servicios- para continuar");
    }
    @FXML
    public void preClientes(){
        App.button_hoverSound();
        Image im = new Image(App.class.getResourceAsStream("vista/img/clientes.png"));
        displayMenu.setImage(im);
        infoMenu.setText("Podrá ver, agregar y/o editar clientes.\nPresione el botón -Clientes- para\n continuar");
    }
    @FXML
    public void preAtenciones(){
        App.button_hoverSound();
        Image im = new Image(App.class.getResourceAsStream("vista/img/atenciones.png"));
        displayMenu.setImage(im);
        infoMenu.setText("Podrá consultar las atenciones.\nPresione el botón -Atenciones- para\n continuar");
    }
    @FXML
    public void preCitas(){
        App.button_hoverSound();
        Image im = new Image(App.class.getResourceAsStream("vista/img/citas.png"));
        displayMenu.setImage(im);
        infoMenu.setText("Podrá ver, crear, eliminar, consultar\ncitas, y/o registrar su atención \nPresione el botón -Citas- para continuar");
    }
    @FXML
    public void preEmpleados(){
        App.button_hoverSound();
        Image im = new Image(App.class.getResourceAsStream("vista/img/empleados.png"));
        displayMenu.setImage(im);
        infoMenu.setText("Podrá ver, agregar, editar y/o eliminar \nempleados. Presione el botón\n -Empleados- para continuar");
    }
    @FXML
    public void preSalir(){
        App.button_hoverSound();
        Image im = new Image(App.class.getResourceAsStream("vista/img/salir.png"));
        displayMenu.setImage(im);
        infoMenu.setText("Cerrará la sesión actual.\nPresione el botón -Salir- para cerrar\n el sistema");
    }

    //Métodos cuando se da click a cada botón
    @FXML
    public void entrarServicios(){
        App.changeRootFXML("vista/fxml/servicio/Servicios");

    }
    @FXML
    public void entrarClientes(){
        App.changeRootFXML("vista/fxml/cliente/Clientes");
    }
    @FXML
    public void entrarAtenciones(){
        App.changeRootFXML("vista/fxml/atencion/Atenciones");
    }
    @FXML
    public void entrarCitas(){
        App.changeRootFXML("vista/fxml/cita/Citas");
    }
    @FXML
    public void entrarEmpleados(){
        App.changeRootFXML("vista/fxml/empleado/Empleados");
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
            Stage stage = (Stage)anchorPane.getScene().getWindow();
            stage.close();
        }
    }
}
