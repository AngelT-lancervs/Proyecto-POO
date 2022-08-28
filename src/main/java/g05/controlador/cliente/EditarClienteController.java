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

/**
 * Controlador asociado a editar clientes
 * Autor: Grupo 5
 * Version: 1.0
 */
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

    /**
     * Inicializa apenas de ejecute el programa
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SoundController sc = new SoundController();
        botonEditarC.setOnMouseEntered(ev -> sc.button_hoverSound());
        botonCancelarC.setOnMouseEntered(ev -> sc.button_hoverSound());
    }

    /**
     * Regresa a la ventana principal de clientes
     * @param event
     */
    @FXML
    void backEditarCliente(ActionEvent event) {
        App.changeRootFXML("vista/fxml/cliente/Clientes");
    }

    /**
     * Verifica que los datos que el usuario ingresa esten correctos
     * @param event
     */
    @FXML
    void datosCorrectos(KeyEvent event) {
        if(txtNomC.getText()!="" && txtNomC.getText()!="" && txtCorreoC.getText()!= "" && txtDatR.getText()!=""){
            botonEditarC.setDisable(false);
        } else {
            botonEditarC.setDisable(true);
        }
    }

    /**
     * Edita los datos del cliente en el archivo
     * @param event
     */
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

    /**
     * Carga los datos asociados al cliente a la ventana de clientes
     * @param c
     */
    public void cargarDatosCliente(Cliente c){
        lbCedC.setText(c.getCedula());
        txtNomC.setText(c.getNombre());
        txtTelC.setText(c.getTelefono());
        txtCorreoC.setText(c.getEmail());
        txtDatR.setText(c.getDatos_del_representante());
        clienteSeleccionado = c;
    }
}