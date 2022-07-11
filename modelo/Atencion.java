package modelo;
import java.time.*;

import javax.xml.datatype.Duration;

import usuario.*;

public class Atencion{
    private Duration duracionReal;
    private Empleado empleado;
    private Servicio servicio;
    //falta servicio, quizás importarlo desde citas con un metodo
    
    //Constructor de la clase
    public Atencion(Duration duracionReal, Servicio servicio, Empleado empleado){
        this.duracionReal = duracionReal;
        this.servicio = servicio;
        this.empleado = empleado;
    }

    //Métodos de la clase
    public void mostrarMenu(){
        System.out.print("1. Registrar Atención\n");         
	    System.out.print("2. Consultar Atención\n");
    }

    public void registrarAtencion(){
    }

    public void consultarAtencion(){
    }

    //Getters y setters
    public Duration getDuracionReal(){
        return this.duracionReal;
    }

    public void setDuracionR(Duration t){
        this.duracionReal = t;
    }

    
}
