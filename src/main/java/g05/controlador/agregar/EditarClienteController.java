package g05.controlador.agregar;

import g05.App;
import g05.modelo.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class EditarClienteController implements Initializable{

    @FXML
    private TableView<Cliente> tablaClientes2;
    @FXML
    private TableColumn<Cliente, String> colCedula;
    @FXML
    private TableColumn<Cliente, String> colNombre;
    @FXML
    private TableColumn<Cliente, String> colTelefono;
    @FXML
    private TableColumn<Cliente, String> colEmail;
    @FXML
    private TableColumn<Cliente, String> colDatosRepresentanteC;
    @FXML
    private Button btnCancelar;

    public void initialize(URL location, ResourceBundle resources) {
        colNombre.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nombre"));
        colCedula.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cedula"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefono"));
        colEmail.setCellValueFactory(new PropertyValueFactory<Cliente, String>("email"));
        colDatosRepresentanteC.setCellValueFactory(new PropertyValueFactory<Cliente, String>("datos_del_representante"));
        tablaClientes2.setItems(obtenerClientes());
    }

    @FXML
    public ObservableList<Cliente> obtenerClientes(){
        ObservableList<Cliente> clientes = FXCollections.observableArrayList();
        ArrayList<Cliente> clientesCSV= Cliente.cargarClientes(App.pathClientesCSV);
        for (Cliente c : clientesCSV){
            clientes.add(c);
            System.out.println(c);
        }
        return clientes;
    }

    @FXML
    void regresarCliente(ActionEvent event){
        Alert alertaCierre=new Alert(Alert.AlertType.CONFIRMATION);
        alertaCierre.setTitle("Cancelar editar Clientes");
        alertaCierre.setHeaderText("Confirmación");
        alertaCierre.setContentText("Desea cancelar la operación?");
        Optional<ButtonType> resultado=alertaCierre.showAndWait();
        if(resultado.get() == ButtonType.OK) {
            App.changeRootFXML("vista/Clientes");
        }
    }
}
