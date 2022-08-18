package g05.controlador;

import g05.controlador.agregar.AgregarCitaController;
import g05.controlador.editar.EditarEmpleadoController;
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
        private TableColumn<Servicio, String> colDuracionS;

        @FXML
        private TableColumn<Servicio, Boolean> colEstadoS;

        @FXML
        private TableColumn<Servicio, String> colNombreS;

        @FXML
        private TableColumn<Servicio, Double> colPrecioS;

        @FXML
        private Button regresarS;

        @FXML
        private TableView<Servicio> tablaServicios;


        @Override
        public void initialize(URL url, ResourceBundle rb) {
            colNombreS.setCellValueFactory(new PropertyValueFactory<Servicio, String>("nombreServicio"));
            colDuracionS.setCellValueFactory(new PropertyValueFactory<Servicio, String> ("duracion") );
            colPrecioS.setCellValueFactory(new PropertyValueFactory<Servicio, Double> ("precio"));
            colEstadoS.setCellValueFactory(new PropertyValueFactory<Servicio, Boolean>("estado"));
            tablaServicios.setItems(obtenerServicios());
        }

    public static ArrayList<Servicio> serviciosCSV = Servicio.leerServicios(App.pathServiciosCSV);
    @FXML
    public static ObservableList<Servicio> obtenerServicios(){
        ObservableList<Servicio> servicios = FXCollections.observableArrayList();
        for (Servicio c : serviciosCSV){
            servicios.add(c);
            System.out.println(c);
        }
        return servicios;
    }
    @FXML
    void agregarServicio(ActionEvent event) {
        App.changeRootFXML("vista/secundarias/AgregarServicio");
    }

    @FXML
    void backServicios(ActionEvent event) {
        App.changeRootFXML("vista/Menu");
    }

    @FXML
    void eliminarServicio(ActionEvent event) {
        try {

            Servicio s = (Servicio) tablaServicios.getSelectionModel().getSelectedItem();
            Alert alertaEliminarS = new Alert(Alert.AlertType.CONFIRMATION);
            alertaEliminarS.setTitle("Eliminar Servicio " + s.getNombreServicio());
            alertaEliminarS.setHeaderText("Confirmación");
            alertaEliminarS.setContentText("¿Está seguro que quiere eliminar el Servicio " + s.getNombreServicio() + "?");
            Optional<ButtonType> resultado = alertaEliminarS.showAndWait();
            //Si el usuario da OK, se eliminará el servicio seleccionado.
            if(resultado.get() == ButtonType.OK){
                ArrayList<Servicio> servicios = serviciosCSV;
                int ind = servicios.indexOf(s);
                servicios.remove(ind);
                Servicio.actualizarCSV(App.pathServiciosCSV,servicios);
                tablaServicios.setItems(obtenerServicios());
                // Los botones se desactivan nuevamente.
                botonEditarS.setDisable(true);
                botonEliminarS.setDisable(true);}
        }catch (NullPointerException e){
            Alert alertaNull= new Alert(Alert.AlertType.ERROR);
            alertaNull.setTitle("ERROR");
            alertaNull.setContentText("[Error] Seleccione un Servicio");
            alertaNull.showAndWait();
        }

        }
    
    }


