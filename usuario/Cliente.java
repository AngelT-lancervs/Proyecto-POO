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
    Scanner sc = new Scanner(System.in);

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
        Main.clientes.add(this);
    }
  
    public String toString(){
        return super.toString() + " Datos del representante: "+datos_del_representante;
    }

    /**
     * Muestra los clientes registrados en el Centro
     */
    public static void mostrarClientes() {
        int count = 0; // Contador para índices
        for(Cliente c: Main.clientes)
        {
            count++;
            System.out.println(count+". "+c);
        }
    }

    public static void mostrarMenu() {
        System.out.print("-----[Menú/Cliente]-----\n");
        System.out.print("1. Agregar cliente\n");
        System.out.print("2. Editar cliente\n");
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj!=null && getClass() == obj.getClass()){
            Cliente other=(Cliente)obj;
            return (this.cedula.equals(other.cedula));
        }
        return false;
    }


    public void editarCliente() {
        System.out.print("-----[Menú/Cliente/Editar]-----\n");
        System.out.print("1.Nombre \n2.Telefono \n3.Email \n4.Datos representante \n");
        int opcion = Main.pedirNumero();
        switch (opcion){
            case 1:
                System.out.print("\nIngrese el nuevo nombre: ");
                String newNombre = sc.nextLine();
                this.nombre = newNombre;
                break;
            case 2:
                System.out.print("\nIngrese el nuevo telefono: ");
                String newTelefono = sc.nextLine();
                this.telefono = newTelefono;
                break;
            case 3:
                System.out.print("\nIngrese el nuevo email: ");
                String newEmail = sc.nextLine();
                this.email = newEmail;
                break;
            case 4:
                System.out.print("\nIngrese los nuevos datos del representante: ");
                String newD_Representante = sc.nextLine();
                this.datos_del_representante = newD_Representante;
                break;
            default:
                System.out.print("Ingrese una opción válida.");
        }
        /*
        System.out.println("Cliente a editar: ");
        String nombreC = sc.nextLine();
        Cliente cli = new Cliente(nombreC);

        for(Cliente c: Main.clientes){
            if(c.equals(cli)){
                System.out.println(c);
                System.out.println("Campo que desea editar: ");
                String datos=sc.nextLine().toUpperCase();

                switch (datos) {
                    case "NOMBRE":
                        System.out.println("Nuevo nombre: ");
                        String nom=sc.nextLine();
                        c.nombre = nom; 

                    case "EMAIL":
                        System.out.println("Nuevo email: ");
                        String em=sc.nextLine();
                        c.email = em; 

                    case  "TELEFONO":
                        System.out.println("Nuevo telefono: ");
                        String tel =sc.nextLine();
                        c.telefono = tel;
                    
                    case  "DATOS DEL REPRESENTANTE":
                        System.out.println("Nuevo telefono: ");
                        String dts =sc.nextLine();
                        c.datos_del_representante = dts;
                    }
                }
            }

         */
        }
    public static void agregarCliente(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese nombre del usuario: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el número de cédula del usuario: ");
        String cedula = sc.nextLine();
        System.out.println("Ingrese número telefónico del usuario: ");
        String telefono = sc.nextLine();
        System.out.println("Ingrese correo del usuario: ");
        String correo = sc.nextLine();
        System.out.println("Ingrese los datos del representante del usuario: ");
        String datosRepresentante = sc.nextLine();
        Cliente cl = new Cliente(nombre, cedula, telefono, correo, datosRepresentante);
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