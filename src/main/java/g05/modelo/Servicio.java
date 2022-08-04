package g05.modelo;
import g05.usuario.*;
import java.util.ArrayList;
import java.util.Scanner;
import g05.menu.Main;


/**
 * Clase que define los datos y metodos que se presentan en los servicios brindados
 * @author  Jeremy Poveda
 * @author  Angel Tomala
 * @author  Paulina Loor
 * @version 16/07/2022
 */
public class Servicio{
    private String nombreServicio;
    private String duracion;
    private Empleado empleado;
    private double precio;
    private boolean estado;

    /**
     * Constructor de la clase Servicio, inicializa las variables
     * Representa los servicios que se brindan
     * @param nomSer es el Nombre del Servicio brindado
     * @param dur es la duración que tiene el servicio
     * @param pre es el costo del Servicio
     * @param estado indica si se encuentra disponible o no el servicio
     */
    public Servicio(String nomSer, String dur, double pre, boolean estado){
        this.nombreServicio = nomSer;
        this.duracion = dur;
        this.precio = pre;
        this.estado = estado;
        Main.servicios.add(this);
    }

    /**
     * Constructor de la clase Servicio que solo recibe el nombre del mismo
     * @param nomSer representa el nombre del Servicio que se brinda
     */
    public Servicio(String nomSer){
        this.nombreServicio=nomSer;
    }

    /**
     * Contructor de la clase Servicio que recibe tres parametros
     * @param nombreServicio es el nombre del Servicio que se brinda
     * @param duracion es la duracion del Servicio brindado
     * @param empleado es el empleado que provee el Servicio
     */
    public Servicio(String nombreServicio, String duracion, Empleado empleado)
    {
        this.nombreServicio = nombreServicio;
        this.duracion = duracion;
        this.empleado = empleado;
    }

    /**
     * Muestra la lista de Servicios que se encuentran disponibles
     */
    public static void mostrarServicios(){
        int count = 0;
        for(Servicio c: Main.servicios)
        {
            count++;
            System.out.println(count+ ". " + c);
        }
    }

    /**
     * Metodo que presenta "Activo" si es true y "Inactivo" si es false
     * @return retorna Activo O Inactivo
     */
    public  String activoOinactivo(){
        if(estado){
            return "Activo";
        }else{
            return "Inactivo";
        }
    }

    /**
     * Agrega el servicio a la lista de servicios que tiene el Centro
     */
    public static void agregarServicio(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del servicio:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese la duración del servicio en minutos:");
        String duracion = sc.nextLine();
        System.out.println("Ingrese el precio del servicio: ");
        double prec= sc.nextDouble();
        Servicio ser = new Servicio(nombre, duracion, prec, true);
    }


    /**
     * Edita determinados campos del Servicio
     */
    public void editarServicio(){
        Scanner sc = new Scanner(System.in);
        System.out.print("-----[Menú/Servicio/Editar]-----\n");
        System.out.print("1.Nombre \n2.Duración \n3.Precio\n");
        int opcion = Main.pedirNumero();
        switch (opcion){
            case 1:
                System.out.print("\nIngrese el nuevo nombre: ");
                String newNombre = sc.nextLine();
                this.nombreServicio = newNombre;
                break;
            case 2:
                System.out.print("\nIngrese nueva duración: ");
                String newDuracion = sc.nextLine();
                this.duracion = newDuracion;
                break;
            case 3:
                System.out.print("\nIngrese el nuevo precio: ");
                Double newPrecio = sc.nextDouble();
                this.precio = newPrecio;
                break;
            }  
    }

    /**
     * Compara los servicios por el nombre haciendo uso del metodo equals
     */
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj!=null && getClass()==obj.getClass()){
            Servicio other=(Servicio)obj;
            return(this.nombreServicio.equals(other.nombreServicio));
        }
        return false;
        }
    
     /**
     * Cambia el estado a inactivo si se elimina el Servicio
     */
    public void eliminarServicio(){
        this.estado = false;
    }
        
    public String toString(){
        return ">> Nombre del Servicio: "+nombreServicio +" | Duración: "+duracion+ " min | "+ "Precio: $"+precio+" | "+"Estado: "+activoOinactivo();
    }

    public static void mostrarMenu(){
        System.out.print("-----[Menú/Servicios]-----\n");
        System.out.print("1. Agregar Servicio\n");
        System.out.print("2. Editar Servicio\n");
        System.out.print("3. Eliminar Servicio\n");
        System.out.print("4. Atrás\n");
    }

    /**
     * Getters and setters
     * 
     */

    public String getNombreServicio(){
        return nombreServicio;
    }
    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getDuracion() {
        return duracion;
    }
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
    public boolean getEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}