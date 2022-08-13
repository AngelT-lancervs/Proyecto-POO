package g05.controlador.agregar;

import g05.App;
import g05.modelo.Empleado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
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

    }

    @FXML
    void agregarEmpleado(ActionEvent event) {
        if(datosCorrectos()){
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
            escribirEmpleado();
            Alert alertaRegistro = new Alert(Alert.AlertType.INFORMATION);
            alertaRegistro.setTitle("Registro existoso");
            alertaRegistro.setHeaderText("REGISTRO");
            alertaRegistro.setContentText("Empleado "+nombre+" registrado correctamente!");
            alertaRegistro.showAndWait();
            App.changeRootFXML("vista/Empleados");

        } else{
            //Alerta de confirmación para salir del sistema.
            Alert alertaErrorDatos = new Alert(Alert.AlertType.ERROR);
            alertaErrorDatos.setTitle("Datos Incorrectos");
            alertaErrorDatos.setHeaderText("ERROR");
            alertaErrorDatos.setContentText("Por favor, ingrese los datos correctamente");
            alertaErrorDatos.showAndWait();

        }

    }

    @FXML
    void backAgregarEmpleados(ActionEvent event) {
        Alert alertaCerrar = new Alert(Alert.AlertType.CONFIRMATION);
        alertaCerrar.setTitle("Cancelar agregar empleados");
        alertaCerrar.setHeaderText("Confimación");
        alertaCerrar.setContentText("¿Desea cancelar la operación?");
        Optional<ButtonType> resultado = alertaCerrar.showAndWait();
        //Si el usuario da OK, se vuelve al root anterior
        if(resultado.get() == ButtonType.OK) {
        App.changeRootFXML("vista/Empleados");
        }
    }
    boolean datosCorrectos() {
        if(txtCedE.getText()!="" && txtCorreoE.getText()!="" && txtNomE.getText()!= "" && txtTelE.getText()!=""){
            return true;
        } else {
            return false;
        }
    }
    void escribirEmpleado(){
        try(BufferedWriter br = new BufferedWriter(new FileWriter(App.pathEmpleadosCSV, true))){
                br.write(nombre+","+cedula+","+email+","+estadoE+","+telefono);
                br.newLine();
                br.write("");
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }




}
