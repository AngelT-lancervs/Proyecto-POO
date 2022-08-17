package g05.controlador.agregar;

import g05.App;
import g05.controlador.ServiciosController;
import g05.modelo.Servicio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.*;
import java.net.URL;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AgregarServicioController{


    @FXML
    private ToggleGroup estado;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField nombreSer;
    @FXML
    private TextField duracionSer;
    @FXML
    private TextField precioSer;
    @FXML
    private Button botonAgregarS;
    @FXML
    private Button botonCancelarS;
    String nombreS;
    String duracionS;
    double precioS;
    boolean estadoS;




    @FXML
    void agregarServicio( ActionEvent event){
        nombreS= nombreSer.getText();
        duracionS=duracionSer.getText();
        precioS= Double.parseDouble(precioSer.getText());
        RadioButton selectedRadioButton = (RadioButton)estado.getSelectedToggle();
        estadoS = true;
        if(!selectedRadioButton.getText().equals("Activo")){
            estadoS = false;
        }
        Servicio s= new Servicio(nombreS, duracionS, precioS, estadoS);
        escribirServicio(s);
        Alert alertaRegistro = new Alert(Alert.AlertType.INFORMATION);
        alertaRegistro.setTitle("Registro existoso");
        alertaRegistro.setHeaderText("REGISTRO");
        alertaRegistro.setContentText("Servicio "+nombreS+" registrado correctamente!");
        alertaRegistro.showAndWait();
        App.changeRootFXML("vista/Servicios");
    }

    @FXML
    void backAgregarServicios(ActionEvent event) {
        App.changeRootFXML("vista/Servicios");
    }

    @FXML
    void datosCorrectos(KeyEvent event) {
        if(nombreSer.getText()!="" && duracionSer.getText()!="" && precioSer.getText()!=""){
            botonAgregarS.setDisable(false);
        } else {
            botonAgregarS.setDisable(true);
        }
    }



    @FXML
    void escribirServicio(Servicio s){
        ArrayList<Servicio> servicios = ServiciosController.serviciosCSV;
        servicios.add(s);
        Servicio.actualizarCSV(App.pathServiciosCSV,servicios);
    }}


