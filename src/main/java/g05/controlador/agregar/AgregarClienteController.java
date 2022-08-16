package g05.controlador.agregar;
import g05.App;
import g05.controlador.ClientesController;
import g05.modelo.Cliente;
import g05.modelo.Empleado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class AgregarClienteController implements Initializable {
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button botonAgregarC;

    @FXML
    private Button botonCancelarC;

    @FXML
    private TextField txtCedC;

    @FXML
    private TextField txtCorreoC;

    @FXML
    private TextField txtDatR;

    @FXML
    private TextField txtNomC;

    @FXML
    private TextField txtTelC;

    String nombre;
    String cedula;
    String email;
    String telefono;
    String datosRepresentante;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnAceptar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        botonAgregarC.setDisable(true);
    }

    @FXML
    public void agregarCliente(ActionEvent event) {
        nombre = txtNomC.getText();
        cedula = txtCedC.getText();
        email = txtCorreoC.getText().toLowerCase();
        telefono = txtTelC.getText();
        datosRepresentante = txtTelC.getText();
        Cliente cliente = new Cliente(nombre, cedula, email, telefono, datosRepresentante);
        escribirCliente(cliente);
        Alert alertaRegistro = new Alert(Alert.AlertType.INFORMATION);
        alertaRegistro.setTitle("Registro existoso");
        alertaRegistro.setHeaderText("REGISTRO");
        alertaRegistro.setContentText("Cliente "+nombre+" registrado correctamente!");
        alertaRegistro.showAndWait();
        App.changeRootFXML("vista/Clientes");

    }
    @FXML
    void backAgregarCliente(ActionEvent event){
        App.changeRootFXML("vista/Clientes");
    }

    @FXML
    public void datosCorrectos(KeyEvent event){
        if(txtNomC.getText()!="" && txtCorreoC.getText()!="" && txtCedC.getText()!= "" && txtTelC.getText()!="" && txtDatR.getText()!=""){
            botonAgregarC.setDisable(false);
        } else {
            botonAgregarC.setDisable(true);
        }
    }

    void escribirCliente(Cliente c){
        ArrayList<Cliente> clientes = ClientesController.clientesCSV;
        clientes.add(c);
        Cliente.actualizarCSV(App.pathClientesCSV,clientes);
    }
}