package g05.controlador;

import g05.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Optional;

public class AgregarEmpleadoController {

    @FXML
    private Button botonAgregarE;

    @FXML
    private Button botonCancelar;

    @FXML
    private ComboBox<?> cbEstadoE;

    @FXML
    private TextField txtCedE;

    @FXML
    private TextField txtCorreoE;

    @FXML
    private TextField txtNomE;

    @FXML
    private TextField txtTelE;

    @FXML
    void agregarEmpleado(ActionEvent event) {
        System.out.println("holiwis");
    }

    @FXML
    void backAgregarEmpleados(ActionEvent event) {
        Alert alertaCerrar = new Alert(Alert.AlertType.CONFIRMATION);
        alertaCerrar.setTitle("Cancelar agregar empleados");
        alertaCerrar.setHeaderText("Confirmación de cancelación");
        alertaCerrar.setContentText("¿Está seguro que quiere cancelar el registro del empleado?");
        Optional<ButtonType> resultado = alertaCerrar.showAndWait();
        //Si el usuario da OK, se vuelve al root anterior
        if(resultado.get() == ButtonType.OK) {
        App.changeRootFXML("vista/Empleados");
        }
    }
}
