package modelo;
import usuario.*;
import java.util.ArrayList;
import java.util.Scanner;
import menu.Main;

public class Servicio{
    private String nombreServicio;
    private String duracion;
    private Empleado empleado;
    private double precio;
    private boolean estado;
    Scanner sc1= new Scanner(System.in);
    
    //crear un método para los servicios y agregarlo al constructor

    public Servicio(String nomSer, String dur, double pre, boolean estado){
        this.nombreServicio= nomSer;
        this.duracion=dur;
        this.precio=pre;
        this.estado=estado;
    }

    public Servicio(String nomSer){
        this.nombreServicio=nomSer;
    }

    public Servicio(String nombreServicio, String duracion, Empleado empleado)
    {
        this.nombreServicio = nombreServicio;
        this.duracion = duracion;
        this.empleado = empleado;
    }

    public static void mostrarServicios(){
        System.out.println("-----Servicios disponibles-----");
        for(Servicio c: Main.servicios)
        {
            System.out.println(c);
        }
      
    }

    public  String activoOinactivo(){
        if(estado){
            return "Activo";
        }else{
            return "Inactivo";
        }
    }

    public void agregarServicio(){
        System.out.println("Ingrese el nombre del Servicio:");
        String nombre=sc1.nextLine();
        System.out.println("Ingrese la duración del servicio:");
        String duracion=sc1.nextLine();
        System.out.println("Ingrese el precio del servicio: ");
        double precio=sc1.nextDouble();
        Servicio ser=new Servicio(nombre, duracion, precio, true);
        Main.servicios.add(ser);
    }

    public void eliminarServicio(){
        System.out.println("Servicio a eliminar: ");
        String servicio=sc1.nextLine();
        Servicio ser=new Servicio(servicio);

        for(Servicio s: Main.servicios){
            if(s.equals(ser)){
                s.estado=false;
            }
        }
    }

    public void editarServicio(){
        System.out.println("Servicio a editar: ");
        String servicio=sc1.nextLine();
        Servicio ser=new Servicio(servicio);

        
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
        return "-Nombre del Servicio: "+nombreServicio +" |"+"Duración: "+duracion+ " "+" min"+" "+" |"+ "Precio: $"+precio+" "+" |"+"Estado: "+activoOinactivo();
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
