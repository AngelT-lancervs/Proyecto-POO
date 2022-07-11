package usuario;
import modelo.*;
import java.util.ArrayList;
import menu.*;

public class Cliente extends Usuario {
    private String datos_del_representante;
    private final String cedula;
    private ArrayList<Cita> citasCliente = new ArrayList<Cita>();


    //Constructor de la clase
    public Cliente(String nombre,String telefono,String email,String cedula,String dts_re) {
        super(nombre, telefono, email);
        this.cedula = cedula;
        this.datos_del_representante = dts_re;
        Main.ListaClientes.add(new Cliente(nombre, telefono, email, cedula, dts_re));
    }

    public String toString(){
        return super.toString()+"Datos del representante: "+datos_del_representante;
    }

    public static void mostrarClientes(){
        System.out.println("-----Clientes-----");
        for(Cliente c: Main.ListaClientes)
        {
            System.out.println(c);
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
