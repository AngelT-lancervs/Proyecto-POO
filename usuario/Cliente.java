package usuario;
import modelo.*;
import java.util.ArrayList;
import menu.*;

/**
 * Clase Cliente
 * @author:
 * @version: 11/07/2022
 */
public class Cliente extends Usuario {
    private String datos_del_representante;
    private String cedula;
    private ArrayList<Cita> citasCliente = new ArrayList<Cita>();


    //Constructor de la clase
    /**
     * Constructor de la clase Cliente que recibe el nombre del cliente
     * @param nom Nombre del Cliente
     */
    public Cliente(String nom){
        super(nom); // Constructor creado para la probar el método de crear cita.
    }

    /**
     * Contructor de la clase Cliente que recibe como parametros el nombre, telefono, email, cedula, datos del representante
     * @param nombre Nombre del Cliente
     * @param telefono Telefono del Cliente
     * @param email Email del cliente
     * @param cedula Cedula del cliente
     * @param dts_re Datos del representante del Cliente
     */
    public Cliente(String nombre, String cedula, String telefono,String email,String dts_re) {
        super(nombre, cedula, telefono, email);
        this.datos_del_representante = dts_re;
        Main.ListaClientes.add(this);
    }
  
    public String toString(){
        return super.toString()+"Datos del representante: "+datos_del_representante;
    }

    /**
     * Muestra los clientes registrados en el Centro
     */
    public static void mostrarClientes(){
        System.out.println("-----Clientes-----");
        int count = 0; // Contador para índices
        for(Cliente c: Main.listaClientes)
        {
            count++;
            System.out.println(count+". "+c);
        }
    }

    //Getters y setters
    public String getDatosR(){
        return this.datos_del_representante;
    }

    public String getCedulaR(){
        return this.cedula;
    }

    public ArrayList<Cita> getCitasCliente(){
        return this.citasCliente;
    }

    public void setDatosR(String texto){
        this.datos_del_representante = texto;
    }
}