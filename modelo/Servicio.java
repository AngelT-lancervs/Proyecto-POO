package modelo;
import usuario.*;
import java.util.ArrayList;
import java.util.Scanner;
import menu.Main;


/**
 * Clase que define los datos y métodos que se presentan en los servicios brindados
 * @author:
 * @version: 11/07/2022
 */
public class Servicio{
    private String nombreServicio;
    private String duracion;
    private Empleado empleado;
    private double precio;
    private boolean estado;
    Scanner sc1= new Scanner(System.in);
    
    //crear un método para los servicios y agregarlo al constructor

    /**
     * Constructor de la clase Servicio, inicializa las variables
     * Representa los servicios que se brindan
     * @param nomSer es el Nombre del Servicio brindado
     * @param dur es la duración que tiene el servicio
     * @param pre es el costo del Servicio
     * @param estado indica si se encuentra disponible o no el servicio
     */
    public Servicio(String nomSer, String dur, double pre, boolean estado){
        this.nombreServicio= nomSer;
        this.duracion=dur;
        this.precio=pre;
        this.estado=estado;
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
            System.out.println(count+". "+c);
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
    public void agregarServicio(){
        System.out.println("Ingrese el nombre del servicio:");
        String nombre = sc1.nextLine();
        System.out.println("Ingrese la duración del servicio:");
        String duracion = sc1.nextLine();
        System.out.println("Ingrese el precio del servicio: ");
        double precio = sc1.nextDouble();
        Servicio ser = new Servicio(nombre, duracion, precio, true);
        Main.servicios.add(ser);
    }

    /**
     * Cambia el estado a inactivo si se elimina el Servicio
     */
    public void eliminarServicio(){
        System.out.println("Servicio a eliminar: ");
        String servicio = sc1.nextLine();
        Servicio ser = new Servicio(servicio);

        for(Servicio s: Main.servicios){
            if(s.equals(ser)){
                s.estado = false;
            }
        }
    }

    /**
     * Edita determinados campos del Servicio
     */
    public void editarServicio(){
        System.out.println("Servicio a editar: ");
        String servicio = sc1.nextLine();
        Servicio ser = new Servicio(servicio);

        
        for(Servicio s: Main.servicios){
            if(s.equals(ser)){
                System.out.println(s);
                System.out.println("Campo que desea editar: ");
                String datos=sc1.nextLine().toUpperCase();

                switch (datos) {
                    case "NOMBRE":
                        System.out.println("Nuevo nombre: ");
                        String nom=sc1.nextLine();
                        s.nombreServicio=nom; 

                    case "DURACION":
                        System.out.println("Nuevo duración: ");
                        String dura=sc1.nextLine();
                        s.duracion=dura; 

                    case  "PRECIO":
                        System.out.println("Nuevo precio: ");
                        double prec=sc1.nextDouble();
                        s.precio=prec;
                    }
            }
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
    
        
    public String toString(){
        return ">> Nombre del Servicio: "+nombreServicio +" | Duración: "+duracion+ " min | "+ "Precio: $"+precio+" | "+"Estado: "+activoOinactivo();
    }

    //Getters and Setters
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
