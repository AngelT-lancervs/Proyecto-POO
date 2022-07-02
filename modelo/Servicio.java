package modelo;

public class Servicio{
    private ArrayList <Servicio> servicios;
    private String nombreServicio;
    private String duracion;
    private Empleado empleado;
    
    //crear un método para los servicios y agregarlo al constructor
    
    public Servicio(String nombreServicio, String duracion, Empleado empleado)
    {
        this.nombreServicio = nombreServicio;
        this.duracion = duracion;
        this.empleado = empleado;
    }
}
