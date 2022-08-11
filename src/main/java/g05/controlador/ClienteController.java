package g05.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import g05.App;
import g05.modelo.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class ClienteController implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    private TableView<Cliente> tablaClientes;

    @FXML
    private TableColumn<Cliente, String> colCedula;

    @FXML
    private TableColumn<Cliente, String> colNombre;

    @FXML
    private TableColumn<Cliente, String> colTelefono;

    @FXML
    private TableColumn<Cliente, String> colEmail;

    @FXML
    private TableColumn<Cliente, String> colDtosRpresentante;





    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.colNombre.setCellValueFactory(new PropertyValueFactory<Cliente, String>("Nombre"));
        this.colCedula.setCellValueFactory(new PropertyValueFactory<Cliente, String>("Cedula"));
        this.colTelefono.setCellValueFactory(new PropertyValueFactory<Cliente, String>("Telefono"));
        this.colEmail.setCellValueFactory(new PropertyValueFactory<Cliente, String>("Email"));
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
    public void agregarCliente(){

        try{ 
            Stage stageNuevoCliente = new Stage();

            FXMLLoader loader =  new FXMLLoader(App.class.getResource("secundarias/agregarCliente.fxml"));
            Scene sceneNuevoCliente = new Scene(loader.load());
            stageNuevoCliente.setScene(sceneNuevoCliente);
            stageNuevoCliente.show();}
            catch(Exception e){
                e.printStackTrace();
            }
    
    }


    



    @FXML
    public void volverPantalla(){
        try {
            Scene scene = borderPane.getScene();
            FXMLLoader loader =  new FXMLLoader(App.class.getResource("Menu.fxml"));
            scene.setRoot(loader.load());
        } catch (Exception e) { e.printStackTrace();}
    }


}
