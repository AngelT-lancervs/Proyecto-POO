package g05.controlador.agregar;
import g05.App;
import g05.modelo.Cliente;
import g05.modelo.Empleado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

public class AgregarClienteController {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button btnAceptar;
    @FXML
    private TextArea txtNombre;
    @FXML
    private TextArea txtID;
    @FXML
    private TextArea txtTelf;
    @FXML
    private TextArea txtEmail;
    @FXML
    private TextArea txtRepresent;


    String nombre;
    String cedula;
    String email;
    String telefono;
    String datosRepresentante;

    @FXML
    private Button btnCancelar;

    @FXML
    void regresarCliente(ActionEvent event){
        Alert alertaCierre=new Alert(Alert.AlertType.CONFIRMATION);
        alertaCierre.setTitle("Cancelar agregar Clientes");
        alertaCierre.setHeaderText("Confirmación");
        alertaCierre.setContentText("Desea cancelar la operación?");
        Optional<ButtonType> resultado=alertaCierre.showAndWait();
        if(resultado.get() == ButtonType.OK) {
            App.changeRootFXML("vista/Clientes");
        }
    }

    @FXML
    public void agregarCliente(ActionEvent event) {
        if (datosCorrectos()) {
            nombre = txtNombre.getText();
            cedula = txtID.getText();
            email = txtEmail.getText().toLowerCase();
            telefono = txtTelf.getText();
            datosRepresentante = txtRepresent.getText();
            Cliente cliente=new Cliente(nombre, cedula, telefono
            , email, datosRepresentante);
            escribirCliente();
            Alert alertaRegistro = new Alert(Alert.AlertType.INFORMATION);
            alertaRegistro.setTitle("Registro existoso");
            alertaRegistro.setHeaderText("REGISTRO");
            alertaRegistro.setContentText("Cliente " + nombre + " registrado correctamente!");
            alertaRegistro.showAndWait();
            App.changeRootFXML("vista/Clientes");

        } else {

            Alert alertaErrorDatos = new Alert(Alert.AlertType.ERROR);
            alertaErrorDatos.setTitle("Datos Incorrectos");
            alertaErrorDatos.setHeaderText("ERROR");
            alertaErrorDatos.setContentText("Por favor, ingrese los datos correctamente");
            alertaErrorDatos.showAndWait();

        }
        }

        public boolean datosCorrectos(){
            if(txtID.getText()!="" && txtEmail.getText()!="" && txtNombre.getText()!= "" && txtTelf.getText()!="" && txtRepresent.getText()!=""){
                return true;
            } else {
                return false;
            }
        }

    void escribirCliente(){
        try(BufferedWriter br = new BufferedWriter(new FileWriter(App.pathClientesCSV, true))){
            br.write(nombre+","+cedula+","+telefono+","+email+","+datosRepresentante);
            br.newLine();
            br.write("");
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }




    }







    




