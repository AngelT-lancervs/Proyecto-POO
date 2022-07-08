package modelo;
import java.time.*;
import usuario.*;

public class Atencion{
    private Duration duracionReal;
    private Empleado empleado;
    private Servicio servicio;
    //falta servicio, quizás importarlo desde citas con un metodo
    
    public Atencion(Duration duracionReal, Servicio servicio, Empleado empleado){
        this.duracionReal = duracionReal;
        this.servicio = servicio;
        this.empleado = empleado;
    }
    public void mostrarMenu(){
            System.out.print("1. Registrar Atención");         
	    System.out.print("2. Consultar Atención");
    }
    public void registrarAtencion(){
    }
    public void consultarAtencion(){
    }
}
