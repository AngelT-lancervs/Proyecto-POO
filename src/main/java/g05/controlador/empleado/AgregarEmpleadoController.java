package g05.controlador.empleado;

import g05.App;
import g05.modelo.Empleado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        botonAgregarE.setDisable(true);
        botonAgregarE.setOnMouseEntered(mouseEvent -> App.button_hoverSound());
        botonCancelar.setOnMouseEntered(mouseEvent -> App.button_hoverSound());
    }

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
        App.changeRootFXML("vista/Empleados");
    }

    @FXML
    void backAgregarEmpleados(ActionEvent event) {
        App.changeRootFXML("vista/Empleados");
    }


    @FXML
    void datosCorrectos(KeyEvent event) {
        if(txtCedE.getText()!="" && txtCorreoE.getText()!="" && txtNomE.getText()!= "" && txtTelE.getText()!=""){
            botonAgregarE.setDisable(false);
        } else {
            botonAgregarE.setDisable(true);
        }
    }
    void escribirEmpleado(Empleado e){
        ArrayList<Empleado> empleados = EmpleadosController.empleadosCSV;
        empleados.add(e);
        Empleado.actualizarCSV(App.pathEmpleadosCSV,empleados);
    }
}
