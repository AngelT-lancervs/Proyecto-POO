package g05.controlador.atencion;

import g05.App;
import g05.controlador.JuegoController;
import g05.controlador.SoundController;
import g05.controlador.cita.CitasController;
import g05.controlador.empleado.EmpleadosController;
import g05.modelo.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Controlador del registro de las atenciones
 * Autor: Grupo 5
 * Version:1.0
 */
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

    /**
     * Inicializa apenas de ejecute el programa
     * @param url
     * @param resourceBundle
     */
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

        SoundController sc = new SoundController();
        guardar.setOnMouseEntered(ev -> sc.button_hoverSound());
        cancelar.setOnMouseEntered(ev -> sc.button_hoverSound());
    }

    /**
     * Metodo que permite agregar la atencion
     * @param event
     */
    @FXML
    public void agregarAtencion(ActionEvent event) {
        nuevaAtencion = new Atencion(Integer.parseInt(duracion.getText()), citaSeleccionada.getServicioObj(), citaSeleccionada.getEmpleado(), citaSeleccionada, citaSeleccionada.getClienteObj(), citaSeleccionada.getFecha());
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
        alertaRegistroA.setContentText("¡Atención de "+ nuevaAtencion.getCliente()+" registrada correctamente!");
        alertaRegistroA.showAndWait();
        System.out.println(atenciones);
        App.changeRootFXML("vista/fxml/cita/Citas");
    }

    /**
     * Ingreso al juego: Bingo
     */
    @FXML
    public void entrarJuego(){
       JuegoController controladorJ = (JuegoController) App.changeRootFXML("vista/fxml/Juego", JuegoController.class);
       controladorJ.cargarDatosJuego(citaSeleccionada);
    }

    /**
     * Regresa a la ventana de citas
     * @param event
     */
    @FXML
    void atrasAtencion(ActionEvent event) {
        App.changeRootFXML("vista/fxml/cita/Citas");
    }

    /**
     * Carga los datos asociados a la cita
     * @param ci
     */
    public void cargarDatosCita(Cita ci){
        fecha_hora.setText(ci.getFecha()+" a las "+ci.getHora());
        cliente.setText(ci.getCliente());
        citaSeleccionada = ci;
    }

    /**
     * Verifica que los campos sean correctos
     * @param event
     */
    @FXML
    void datosCorrectosTF(KeyEvent event) {
        verificarCampos();
    }
    @FXML
    void datosCorrectosCB(ActionEvent event) {
        verificarCampos();
    }

    /**
     * Verifica los campos a ingresar
     */
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
