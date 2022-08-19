package g05.controlador.atencion;

import g05.App;
import g05.controlador.cita.CitasController;
import g05.controlador.empleado.EmpleadosController;
import g05.modelo.Atencion;
import g05.modelo.Cita;
import g05.modelo.Empleado;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RegistrarAtencionController implements Initializable {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button guardar;
    @FXML
    private Button botonJuego;
    @FXML
    private Button cancelar;
    @FXML
    private Label fecha_hora;
    @FXML
    private Label cliente;
    @FXML
    private TextField duracion;
    @FXML
    private ComboBox<Empleado> empleadosAtencion;
    private Cita citaSeleccionada;
    private Atencion nuevaAtencion;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<Empleado> empleados = EmpleadosController.obtenerEmpleados();
        for (Empleado e: empleados){
            if(e.getEstadoBoolean()){
                empleadosAtencion.getItems().add(e);
            }
            //Solo se podrá registrar a los empleados activos
        }
        guardar.setDisable(true);
        guardar.setOnMouseEntered(ev -> App.button_hoverSound());
        cancelar.setOnMouseEntered(ev -> App.button_hoverSound());
    }
    @FXML
    public void agregarAtencion(ActionEvent event) {
        nuevaAtencion = new Atencion(Integer.parseInt(duracion.getText()), citaSeleccionada.getServicioObj(), citaSeleccionada.getEmpleado(), citaSeleccionada);
        ArrayList<Atencion> atenciones = AtencionesController.atencionesSer;
        ArrayList<Cita> citas = CitasController.citasSer;
        atenciones.add(nuevaAtencion);
        int ind = citas.indexOf(citaSeleccionada);
        citas.remove(ind);
        Cita.actualizarSER(App.pathCitas,citas);
        Atencion.actualizarSER(App.pathAtenciones, atenciones);

        Alert alertaRegistroA = new Alert(Alert.AlertType.INFORMATION);
        alertaRegistroA.setTitle("Registro existoso");
        alertaRegistroA.setHeaderText("Atención realizada");
        alertaRegistroA.setContentText("¡Atención de "+ nuevaAtencion.getCliente().getNombre()+" registrada correctamente!");
        alertaRegistroA.showAndWait();
        System.out.println(atenciones);
        App.changeRootFXML("vista/Citas");
    }
    @FXML
    public void entrarJuego(){
        App.changeRootFXML("vista/secundarias/Juego");
    }

    @FXML
    void atrasAtencion(ActionEvent event) {
        App.changeRootFXML("vista/Citas");
    }
    public void cargarDatosCita(Cita ci){
        fecha_hora.setText(ci.getFecha()+" a las "+ci.getHora());
        cliente.setText(ci.getCliente());
        citaSeleccionada = ci;
    }
    @FXML
    void datosCorrectosTF(KeyEvent event) {
        verificarCampos();
    }
    @FXML
    void datosCorrectosCB(ActionEvent event) {
        verificarCampos();
    }
    void verificarCampos(){
        try {
            Double.parseDouble(duracion.getText());
            if((duracion.getText() != "" && empleadosAtencion.getSelectionModel().getSelectedItem() != null)){
                guardar.setDisable(false);
            } else {
                guardar.setDisable(true);
            }
        }catch (Exception e){
            guardar.setDisable(true);
        }

    }
}
