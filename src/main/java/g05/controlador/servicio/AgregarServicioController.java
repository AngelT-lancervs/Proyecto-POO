package g05.controlador.servicio;

import g05.App;
import g05.modelo.Servicio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AgregarServicioController implements Initializable{


    @FXML
    private ToggleGroup estado;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField txtNombreS;
    @FXML
    private TextField txtDuracionS;
    @FXML
    private TextField txtPrecioS;
    @FXML
    private Button botonAgregarS;
    @FXML
    private Button botonCancelarS;
    String nombreS;
    double duracionS;
    double precioS;
    boolean estadoS;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        botonAgregarS.setDisable(true);
        botonAgregarS.setOnMouseEntered(mouseEvent -> App.button_hoverSound());
        botonCancelarS.setOnMouseEntered(mouseEvent -> App.button_hoverSound());
    }

    @FXML
    void agregarServicio( ActionEvent event){
        nombreS = txtNombreS.getText();
        duracionS = Double.parseDouble(txtDuracionS.getText());
        precioS= Double.parseDouble(txtPrecioS.getText());
        RadioButton selectedRadioButton = (RadioButton)estado.getSelectedToggle();
        estadoS = true;
        if(!selectedRadioButton.getText().equals("Activo")){
            estadoS = false;
        }
        Servicio s = new Servicio(nombreS, duracionS, precioS, estadoS);
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
        if(txtPrecioS.getText()!="" && txtDuracionS.getText()!="" && txtNombreS.getText()!=""){
            try {
                double precio = Double.parseDouble(txtPrecioS.getText());
                botonAgregarS.setDisable(false);
            }catch (Exception e){
                botonAgregarS.setDisable(true);
            }
        } else {
            botonAgregarS.setDisable(true);
        }
    }


    @FXML
    void escribirServicio(Servicio s){
        ArrayList<Servicio> servicios = ServiciosController.serviciosCSV;
        servicios.add(s);
        Servicio.actualizarCSV(App.pathServiciosCSV,servicios);
    }
}


