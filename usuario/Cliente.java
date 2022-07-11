package usuario;
import modelo.*;
import java.util.ArrayList;

public class Cliente extends Usuario {
    private String datos_del_representante;
    private final String cedula;
    private ArrayList<Cita> citasCliente = new ArrayList<Cita>();
    private static ArrayList<Cliente> ListaClientes = new ArrayList<Cliente>();


    //Constructor de la clase
    public Cliente(String nombre,String telefono,String email,String cedula,String dts_re) {
        super(nombre, telefono, email);
        this.cedula = cedula;
        this.datos_del_representante = dts_re;
        ListaClientes.add(new Cliente(nombre, telefono, email, cedula, dts_re));
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

    public ArrayList<Cliente> getListaClientes(){
        return this.ListaClientes;
    }

    public void setDatosR(String texto){
        this.datos_del_representante = texto;
    }


}
