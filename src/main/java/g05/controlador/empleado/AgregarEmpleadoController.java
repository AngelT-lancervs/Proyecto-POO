package g05.controlador.empleado;

import g05.App;
import g05.controlador.SoundController;
import g05.modelo.Empleado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Controlador asociado a la ventana de agregar empleado
 * Autor: Grupo 5
 * Version: 1.0
 */
public class AgregarEmpleadoController implements Initializable {

    @FXML
    private Button botonAgregarE;
    @FXML
    private Button botonCancelar;
    @FXML
    private ToggleGroup estado;
    @FXML
    private TextField txtCedE;
    @FXML
    private TextField txtCorreoE;
    @FXML
    private TextField txtNomE;
    @FXML
    private TextField txtTelE;

    //Datos del empleado a agregar
    String nombre;
    String cedula;
    String email;
    String telefono;
    boolean estadoE;


    /**
     * Inicializa apenas de ejecute el programa
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SoundController sc = new SoundController();
        botonAgregarE.setDisable(true);
        botonAgregarE.setOnMouseEntered(mouseEvent -> sc.button_hoverSound());
        botonCancelar.setOnMouseEntered(mouseEvent -> sc.button_hoverSound());
    }

    /**
     * Agrega el empleado al archivo de empleados
     * @param event
     */
    @FXML
    void agregarEmpleado(ActionEvent event) {
        nombre = txtNomE.getText();
        cedula = txtCedE.getText();
        email = txtCorreoE.getText().toLowerCase();
        telefono = txtTelE.getText();
        RadioButton selectedRadioButton = (RadioButton) estado.getSelectedToggle();
        estadoE = true;
        if(!selectedRadioButton.getText().equals("Activo")){
            estadoE = false;
        }
        Empleado e = new Empleado(nombre,cedula,email,estadoE,telefono);
        escribirEmpleado(e);
        Alert alertaRegistro = new Alert(Alert.AlertType.INFORMATION);
        alertaRegistro.setTitle("Registro existoso");
        alertaRegistro.setHeaderText("REGISTRO");
        alertaRegistro.setContentText("Empleado "+nombre+" registrado correctamente!");
        alertaRegistro.showAndWait();
        App.changeRootFXML("vista/fxml/empleado/Empleados");
    }

    /**
     * Regresa a la ventana principal de empleados
     * @param event
     */
    @FXML
    void backAgregarEmpleados(ActionEvent event) {
        App.changeRootFXML("vista/fxml/empleado/Empleados");
    }


    /**
     * Verifica que los datos que haya ingresado el usuario esten correctos
     * @param event
     */
    @FXML
    void datosCorrectos(KeyEvent event) {
        if(txtCedE.getText()!="" && txtCorreoE.getText()!="" && txtNomE.getText()!= "" && txtTelE.getText()!=""){
            botonAgregarE.setDisable(false);
        } else {
            botonAgregarE.setDisable(true);
        }
    }

    /**
     * Escribe los datos del empleado en el archivo
     * @param e
     */
    void escribirEmpleado(Empleado e){
        ArrayList<Empleado> empleados = EmpleadosController.empleadosCSV;
        empleados.add(e);
        Empleado.actualizarCSV(App.pathEmpleadosCSV,empleados);
    }
}
