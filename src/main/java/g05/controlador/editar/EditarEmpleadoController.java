package g05.controlador.editar;
import g05.App;
import g05.controlador.EmpleadosController;
import g05.modelo.Empleado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.ArrayList;

public class EditarEmpleadoController{
    @FXML
    private RadioButton rbA;
    @FXML
    private RadioButton rbI;

    @FXML
    private Button botonAgregarE;

    @FXML
    private Button botonCancelar;

    @FXML
    private ToggleGroup estado;

    @FXML
    private Label lbCed;

    @FXML
    private TextField txtCorreoE;

    @FXML
    private TextField txtNomE;

    @FXML
    private TextField txtTelE;

    /*
     *  Nuevos datos del empleado
     */
    private String nombreE;
    private String correoE;
    private boolean estadoE;
    private String telefonoE;
    private Empleado empleadoSeleccionado;

    @FXML
    void editarEmpleado(ActionEvent event) {
        nombreE = txtNomE.getText();
        correoE = txtCorreoE.getText();
        RadioButton selectedRadioButton = (RadioButton) estado.getSelectedToggle();
        if(!selectedRadioButton.getText().equals("Activo")){
            estadoE = false;
        }else{
            estadoE = true;
        }
        telefonoE = txtTelE.getText();
        empleadoSeleccionado.setNombre(nombreE);
        empleadoSeleccionado.setEstado(estadoE);
        empleadoSeleccionado.setTelefono(telefonoE);
        empleadoSeleccionado.setEmail(correoE);

        ArrayList<Empleado> empleados = EmpleadosController.empleadosCSV;
        if(empleados.contains(empleadoSeleccionado)){
            int ind = empleados.indexOf(empleadoSeleccionado);
            empleados.set(ind, empleadoSeleccionado);
            Empleado.actualizarCSV(App.pathEmpleadosCSV,empleados);
            App.changeRootFXML("vista/Empleados");
        }
    }

    @FXML
    void backEditarEmpleados(ActionEvent event) {
        App.changeRootFXML("vista/Empleados");
    }

    public void cargarDatosEmpleado(Empleado e){
        lbCed.setText(e.getCedula());
        txtNomE.setText(e.getNombre());
        txtTelE.setText(e.getTelefono());
        txtCorreoE.setText(e.getEmail());
        if (e.getEstado().equals("Activo"))
            rbA.setSelected(true);
        else
            rbI.setSelected(true);
        empleadoSeleccionado = e;
    }
}