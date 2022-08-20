package g05.controlador.cliente;
import g05.App;
import g05.controlador.SoundController;
import g05.controlador.cliente.ClientesController;
import g05.modelo.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EditarClienteController implements Initializable {

    @FXML
    private Button botonCancelarC;
    @FXML
    private Button botonEditarC;
    @FXML
    private Label lbCedC;
    @FXML
    private TextField txtCorreoC;
    @FXML
    private TextField txtDatR;
    @FXML
    private TextField txtNomC;
    @FXML
    private TextField txtTelC;
    private Cliente clienteSeleccionado;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        botonEditarC.setOnMouseEntered(ev -> SoundController.button_hoverSound());
        botonCancelarC.setOnMouseEntered(ev -> SoundController.button_hoverSound());
    }

    @FXML
    void backEditarCliente(ActionEvent event) {
        App.changeRootFXML("vista/fxml/cliente/Clientes");
    }

    @FXML
    void datosCorrectos(KeyEvent event) {
        if(txtNomC.getText()!="" && txtNomC.getText()!="" && txtCorreoC.getText()!= "" && txtDatR.getText()!=""){
            botonEditarC.setDisable(false);
        } else {
            botonEditarC.setDisable(true);
        }
    }

    @FXML
    void editarCliente(ActionEvent event) {
        clienteSeleccionado.setNombre(txtNomC.getText());
        clienteSeleccionado.setEmail(txtCorreoC.getText());
        clienteSeleccionado.setTelefono(txtTelC.getText());
        clienteSeleccionado.setDatos_del_representante(txtDatR.getText());

        ArrayList<Cliente> clientes = ClientesController.clientesCSV;
        if(clientes.contains(clienteSeleccionado)){
            int ind = clientes.indexOf(clienteSeleccionado);
            clientes.set(ind, clienteSeleccionado);
            Cliente.actualizarCSV(App.pathClientesCSV,clientes);
            App.changeRootFXML("vista/fxml/cliente/Clientes");
        }
    }
    public void cargarDatosCliente(Cliente c){
        lbCedC.setText(c.getCedula());
        txtNomC.setText(c.getNombre());
        txtTelC.setText(c.getTelefono());
        txtCorreoC.setText(c.getEmail());
        txtDatR.setText(c.getDatos_del_representante());
        clienteSeleccionado = c;
    }
}