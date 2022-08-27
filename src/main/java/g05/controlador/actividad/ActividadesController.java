package g05.controlador.actividad;

import g05.App;
import g05.controlador.SoundController;
import g05.modelo.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Controlador de las actividades
 * Autor: Grupo 5
 * Version: 1.0
 */
public class ActividadesController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button botonEliminarAc;

    @FXML
    private TableColumn<Actividad, Integer> colAciertosAc;

    @FXML
    private TableColumn<Actividad, Integer> colFallosAc;

    @FXML
    private TableColumn<Actividad, LocalDate> colFechaAc;

    @FXML
    private TableColumn<Actividad, String> colNombreAc;

    @FXML
    private TableColumn<Actividad, LocalTime> colTiempoAc;

    @FXML
    private Button regresarAc;

    @FXML
    private TableView<Actividad> tablaActividades;

    @FXML
    private Label txtClienteAc;

    private static Cita citaSeleccionadaAc;
    public static ArrayList<Actividad>  actividadesSer = Actividad.cargarActividades(App.pathActividades);

    /**
     * Acciones que se realizan al iniciar la ejecucion
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        botonEliminarAc.setDisable(true);

        txtClienteAc.setText(citaSeleccionadaAc.getClienteObj().getNombre());
        colNombreAc.setCellValueFactory(new PropertyValueFactory<Actividad, String>("nombreActividad"));
        colFechaAc.setCellValueFactory(new PropertyValueFactory<Actividad, LocalDate>("fecha"));
        colAciertosAc.setCellValueFactory(new PropertyValueFactory<Actividad, Integer>("aciertos"));
        colFallosAc.setCellValueFactory(new PropertyValueFactory<Actividad, Integer>("fallos"));
        colTiempoAc.setCellValueFactory(new PropertyValueFactory<Actividad, LocalTime>("tiempo"));
        tablaActividades.setItems(obtenerActividades());

        SoundController sc = new SoundController();
        botonEliminarAc.setOnMouseEntered(ev -> sc.button_hoverSound());
        regresarAc.setOnMouseEntered(ev -> sc.button_hoverSound());
    }

    /**
     * Metodo para obtener las actividades
     * @return actividades
     */
    public ObservableList<Actividad> obtenerActividades() {
        ObservableList<Actividad> actividades = FXCollections.observableArrayList();
        for (Actividad ac : actividadesSer) {
            if(ac.getCita().getClienteObj().getNombre().equals(citaSeleccionadaAc.getClienteObj().getNombre())){
                actividades.add(ac);
            }
        }
        return actividades;
    }

    @FXML
    void backActividades(ActionEvent event) {
        App.changeRootFXML("vista/fxml/cita/Citas");
    }

    @FXML
    void comprobarSeleccion(MouseEvent event) {
        Actividad ac = (Actividad) tablaActividades.getSelectionModel().getSelectedItem();
        if (ac == null) {
            botonEliminarAc.setDisable(true);
        } else {
            botonEliminarAc.setDisable(false);
        }
    }

    /**
     * Elimina la actividad de la tabla de actividades
     * @param event
     */
    @FXML
    void eliminarActividad(ActionEvent event) {
        Actividad ac = (Actividad) tablaActividades.getSelectionModel().getSelectedItem();
        Alert alertaEliminarAc = new Alert(Alert.AlertType.CONFIRMATION);
        alertaEliminarAc.setTitle("Eliminar cita ");
        alertaEliminarAc.setHeaderText("Confirmación");
        alertaEliminarAc.setContentText("¿Está seguro que quiere eliminar la actividad de "+ac.getCita().getCliente()+"?");
        Optional<ButtonType> resultado = alertaEliminarAc.showAndWait();
        //Si el usuario da OK, se eliminará el empleado seleccionado.
        if(resultado.get() == ButtonType.OK) {
            ArrayList<Actividad> actividades = actividadesSer;
            int ind = actividades.indexOf(ac);
            actividades.remove(ind);
            Actividad.actualizarSER(App.pathActividades, actividades);
            tablaActividades.setItems(obtenerActividades());
            // Los botones se desactivan nuevamente.
            botonEliminarAc.setDisable(true);
        }
    }

    /**
     * Carga los datos de las actividades realizadas
     * @param ci
     */
    public void cargarDatosActividades(Cita ci){
        citaSeleccionadaAc = ci;
    }
}