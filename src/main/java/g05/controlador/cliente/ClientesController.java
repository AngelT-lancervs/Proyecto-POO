package g05.controlador.cliente;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import g05.App;
import g05.modelo.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


public class ClientesController implements Initializable {
    @FXML
    private TableView<Cliente> tablaClientes;
    @FXML
    private TableColumn<Cliente, String> colCedulaC;
    @FXML
    private TableColumn<Cliente, String> colNombreC;

    @FXML
    private TableColumn<Cliente, String> colTelefonoC;

    @FXML
    private TableColumn<Cliente, String> colEmailC;

    @FXML
    private TableColumn<Cliente, String> colDatosRepresentante;
    @FXML
    private Button botonEditarC;
    @FXML
    private Button botonAgregarC;
    @FXML
    private Button regresarC;

    // ArrayList donde se almacenan todos los empleados.
    public static ArrayList<Cliente> clientesCSV = Cliente.cargarClientes(App.pathClientesCSV);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        colNombreC.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nombre"));
        colCedulaC.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cedula"));
        colTelefonoC.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefono"));
        colEmailC.setCellValueFactory(new PropertyValueFactory<Cliente, String>("email"));
        colDatosRepresentante.setCellValueFactory(new PropertyValueFactory<Cliente, String>("datos_del_representante"));
        tablaClientes.setItems(obtenerClientes());
        botonEditarC.setDisable(true);
        botonEditarC.setOnMouseEntered(ev -> App.button_hoverSound());
        botonAgregarC.setOnMouseEntered(ev -> App.button_hoverSound());
        regresarC.setOnMouseEntered(ev -> App.button_hoverSound());
    }

    @FXML
    public static ObservableList<Cliente> obtenerClientes(){
        ObservableList<Cliente> clientes = FXCollections.observableArrayList();
        for (Cliente c : clientesCSV){
            clientes.add(c);
        }
        return clientes;
    }

    @FXML
    public void agregarCliente(ActionEvent event) {
        App.changeRootFXML("vista/fxml/cliente/AgregarCliente");
    }

    @FXML
    void comprobarSeleccion(MouseEvent event) {
        Cliente c = (Cliente) tablaClientes.getSelectionModel().getSelectedItem();
        if(c == null){
            botonEditarC.setDisable(true);

        } else{
            botonEditarC.setDisable(false);
        }
    }

    @FXML
    public void regresarClientes(ActionEvent event) {
        App.changeRootFXML("vista/fxml/Menu");
    }

    @FXML
    public void editarClientes(ActionEvent event) {
        Cliente c = (Cliente) tablaClientes.getSelectionModel().getSelectedItem();
        EditarClienteController editarController = (EditarClienteController) App.changeRootFXML("vista/fxml/cliente/EditarCliente", EditarClienteController.class);
        editarController.cargarDatosCliente(c);
    }
}