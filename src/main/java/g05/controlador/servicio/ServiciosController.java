package g05.controlador.servicio;


import g05.modelo.*;
import g05.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class ServiciosController implements Initializable {
        @FXML
        private AnchorPane anchorPane;
        @FXML
        private Button botonAgregarS;
        @FXML
        private Button botonEditarS;
        @FXML
        private Button botonEliminarS;
        @FXML
        private Button regresarS;
        @FXML
        private TableColumn<Servicio, Double> colDuracionS;
        @FXML
        private TableColumn<Servicio, Boolean> colEstadoS;
        @FXML
        private TableColumn<Servicio, String> colNombreS;
        @FXML
        private TableColumn<Servicio, Double> colPrecioS;
        @FXML
        private TableView<Servicio> tablaServicios;


        @Override
        public void initialize(URL url, ResourceBundle rb) {
            colNombreS.setCellValueFactory(new PropertyValueFactory<Servicio, String>("nombreServicio"));
            colDuracionS.setCellValueFactory(new PropertyValueFactory<Servicio, Double> ("duracion") );
            colPrecioS.setCellValueFactory(new PropertyValueFactory<Servicio, Double> ("precio"));
            colEstadoS.setCellValueFactory(new PropertyValueFactory<Servicio, Boolean>("estado"));
            tablaServicios.setItems(obtenerServicios());
            botonEditarS.setDisable(true);
            botonEliminarS.setDisable(true);
            botonAgregarS.setOnMouseEntered(mouseEvent -> App.button_hoverSound());
            botonEditarS.setOnMouseEntered(mouseEvent -> App.button_hoverSound());
            botonEliminarS.setOnMouseEntered(mouseEvent -> App.button_hoverSound());
            regresarS.setOnMouseEntered(mouseEvent -> App.button_hoverSound());
        }

    public static ArrayList<Servicio> serviciosCSV = Servicio.cargarServicios(App.pathServiciosCSV);
    @FXML
    public static ObservableList<Servicio> obtenerServicios(){
        ObservableList<Servicio> servicios = FXCollections.observableArrayList();
        for (Servicio c : serviciosCSV){
            servicios.add(c);
        }
        return servicios;
    }
    @FXML
    void agregarServicio(ActionEvent event) {
        App.changeRootFXML("vista/fxml/servicio/AgregarServicio");
    }

    @FXML
    void editarServicio(ActionEvent event) {
        Servicio s = (Servicio) tablaServicios.getSelectionModel().getSelectedItem();
        EditarServicioController controladorEditarS = (EditarServicioController) App.changeRootFXML("vista/fxml/servicio/EditarServicio", EditarServicioController.class);
        controladorEditarS.cargarDatosEmpleado(s);
    }

    @FXML
    void backServicios(ActionEvent event) {
        App.changeRootFXML("vista/fxml/Menu");
    }

    @FXML
    void eliminarServicio(ActionEvent event) {
        Servicio s = (Servicio) tablaServicios.getSelectionModel().getSelectedItem();
        Alert alertaEliminarS = new Alert(Alert.AlertType.CONFIRMATION);
        alertaEliminarS.setTitle("Eliminar Servicio " + s.getNombreServicio());
        alertaEliminarS.setHeaderText("Confirmación");
        alertaEliminarS.setContentText("¿Está seguro que quiere eliminar el Servicio " + s.getNombreServicio() + "?");
        Optional<ButtonType> resultado = alertaEliminarS.showAndWait();
        //Si el usuario da OK, se eliminará el servicio seleccionado.
        if (resultado.get() == ButtonType.OK) {
            ArrayList<Servicio> servicios = serviciosCSV;
            int ind = servicios.indexOf(s);
            servicios.remove(ind);
            Servicio.actualizarCSV(App.pathServiciosCSV, servicios);
            tablaServicios.setItems(obtenerServicios());
            // Los botones se desactivan nuevamente.
            botonEditarS.setDisable(true);
            botonEliminarS.setDisable(true);
        }
    }
    @FXML
    void comprobarSeleccion(MouseEvent event) {
        Servicio s = (Servicio) tablaServicios.getSelectionModel().getSelectedItem();
        if(s == null){
            botonEliminarS.setDisable(true);
            botonEliminarS.setDisable(true);
        } else{
            botonEditarS.setDisable(false);
            botonEliminarS.setDisable(false);
        }
    }
}