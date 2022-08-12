package g05.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import g05.App;
import g05.modelo.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;


public class ClientesController implements Initializable {

    @FXML
    private BorderPane borderPane;

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





    @Override
    public void initialize(URL location, ResourceBundle resources) {

        colNombreC.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nombre"));
        colCedulaC.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cedula"));
        colTelefonoC.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefono"));
        colEmailC.setCellValueFactory(new PropertyValueFactory<Cliente, String>("email"));
        colDatosRepresentante.setCellValueFactory(new PropertyValueFactory<Cliente, String>("datos_del_representante"));

        tablaClientes.setItems(obtenerClientes());

    }

    @FXML
    public ObservableList<Cliente> obtenerClientes(){
        ObservableList<Cliente> clientes = FXCollections.observableArrayList();
        for (Cliente c : Sistema.clientes){
            clientes.add(c);
        }
        return clientes;
    }

    @FXML
    void agregarCliente(ActionEvent event) {
        App.changeRootFXML("vista/secundarias/AgregarClientes");
    }

    @FXML
    void regresarClientes(ActionEvent event) {
        App.changeRootFXML("vista/Menu");
    }

}
