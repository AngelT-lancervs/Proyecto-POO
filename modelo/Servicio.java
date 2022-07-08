package modelo;
import usuario.*;
import java.util.ArrayList;

public class Servicio{
    private ArrayList <Servicio> servicios;
    private String nombreServicio;
    private String duracion;
    private Empleado empleado;
    private double precio;
    private boolean estado;
    
    //crear un método para los servicios y agregarlo al constructor

    public Servicio(String nomSer, String dur, double pre, boolean estado){
        this.nombreServicio= nomSer;
        this.duracion=dur;
        this.precio=pre;
        this.estado=estado;
    }
    public Servicio(String nombreServicio, String duracion, Empleado empleado)
    {
        this.nombreServicio = nombreServicio;
        this.duracion = duracion;
        this.empleado = empleado;
    }
    public String mostrarServicios(){
        return "-> " +nombreServicio +"Duración: "+duracion+ " Precio: "+precio + "Estado: "+estado;
    }
    public void agregarServicio(){

    }
    public void eliminarServicio(){
        
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
