package usuario;
import modelo.*;
import java.util.ArrayList;
import java.util.Scanner;
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
    Scanner scC = new Scanner(System.in);

    //Constructor de la clase
    /**
     * Constructor de la clase Cliente que recibe el nombre del cliente
     * @param nom Nombre del Cliente
     */
    public Cliente(String nom){
        super(nom); // Constructor creado para la probar el método de crear cita.
    }

    
    public Cliente(String cedula, String nom){
        super(nom);
        this.cedula=cedula;
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
        this.cedula = cedula;
    }

    public void anadirCliente(Cliente c){
        Main.listaClientes.add(c);
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

    public static void mostrarMenu(){
        System.out.print("1. Crear cita\n");
        System.out.print("2. Eliminar cita\n");
        System.out.print("3. Consultar citas por fecha\n");
    }

    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj!=null && getClass()==obj.getClass()){
            Cliente other=(Cliente)obj;
            return (this.cedula.equals(other.cedula));
        }
        return false;
    }


    public void editarCliente(){
        System.out.println("Cliente a editar: ");
        String nombreC = scC.nextLine();
        Cliente cli = new Cliente(nombreC);

        for(Cliente c: Main.listaClientes){
            if(c.equals(cli)){
                System.out.println(c);
                System.out.println("Campo que desea editar: ");
                String datos=scC.nextLine().toUpperCase();

                switch (datos) {
                    case "NOMBRE":
                        System.out.println("Nuevo nombre: ");
                        String nom=scC.nextLine();
                        c.nombre = nom; 

                    case "EMAIL":
                        System.out.println("Nuevo email: ");
                        String em=scC.nextLine();
                        c.email = em; 

                    case  "TELEFONO":
                        System.out.println("Nuevo telefono: ");
                        String tel =scC.nextLine();
                        c.telefono = tel;
                    
                    case  "DATOS DEL REPRESENTANTE":
                        System.out.println("Nuevo telefono: ");
                        String dts =scC.nextLine();
                        c.datos_del_representante = dts;
                    }
                }
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