package g05.controlador.servicio;

import g05.App;
import g05.modelo.Servicio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EditarServicioController implements Initializable {

    @FXML
    private Button botonCancelarS;
    @FXML
    private Button botonEditarS;
    @FXML
    private ToggleGroup estado;
    @FXML
    private RadioButton rbA;
    @FXML
    private RadioButton rbI;
    @FXML
    private TextField txtDuracionS;
    @FXML
    private TextField txtNombreS;
    @FXML
    private TextField txtPrecioS;
    private Servicio servicioSeleccionado;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        botonEditarS.setOnMouseEntered(mouseEvent -> App.button_hoverSound());
        botonCancelarS.setOnMouseEntered(mouseEvent -> App.button_hoverSound());
    }
    @FXML
    void backEditarServicios(ActionEvent event) {
        App.changeRootFXML("vista/fxml/servicio/Servicios");
    }

    @FXML
    void datosCorrectos(KeyEvent event) {
        if(txtPrecioS.getText()!="" && txtDuracionS.getText()!="" && txtNombreS.getText()!=""){
            try {
                Double.parseDouble(txtPrecioS.getText());
                botonEditarS.setDisable(false);
            }catch (Exception e){
                botonEditarS.setDisable(true);
            }
        } else {
            botonEditarS.setDisable(true);
        }
    }

    @FXML
    void editarServicio(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) estado.getSelectedToggle();
        if(!selectedRadioButton.getText().equals("Activo")){
            servicioSeleccionado.setEstado(false);
        } else{
            servicioSeleccionado.setEstado(true);
        }

        servicioSeleccionado.setNombreServicio(txtNombreS.getText());
        servicioSeleccionado.setDuracion(Double.parseDouble(txtDuracionS.getText()));
        servicioSeleccionado.setPrecio(Double.parseDouble(txtPrecioS.getText()));

        ArrayList<Servicio> servicios = ServiciosController.serviciosCSV;
        if(servicios.contains(servicioSeleccionado)){
            int ind = servicios.indexOf(servicioSeleccionado);
            servicios.set(ind, servicioSeleccionado);
            Servicio.actualizarCSV(App.pathServiciosCSV,servicios);
            App.changeRootFXML("vista/fxml/servicio/Servicios");
        }
    }
    public void cargarDatosEmpleado(Servicio s){
        txtNombreS.setText(s.getNombreServicio());
        txtDuracionS.setText(String.valueOf(s.getDuracion()));
        txtPrecioS.setText(String.valueOf(s.getPrecio()));

        if (s.getEstado().equals("Activo"))
            rbA.setSelected(true);
        else
            rbI.setSelected(true);
        servicioSeleccionado = s;
    }
}