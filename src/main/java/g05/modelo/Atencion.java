package g05.modelo;
import java.time.*;
import java.util.Scanner;


/**
 * Clase que define los datos y metodos que intervienen en la Atencion del Centro
 * Representa una atencion registrada en el Centro terapeutico
 * @author  Jeremy Poveda
 * @author Angel Tomala
 * @author Paulina Loor
 * @version 16/07/2022
 */
public class Atencion{
    private int duracionReal;
    private Empleado empleado;
    private Servicio servicio;
    private Cita cita;
    /**
     * Constructor de la clase Atencion
     * Representa una atención que se registra en el Centro Terapeutico, la crea recibiendo los datos de la misma
     * @param duracionReal La duración ya sea mayor o menor que tuvo la atención
     * @param servicio El servicio prestado en la atención
     * @param empleado El empleado que prestó el servicio
     */
    public Atencion(int duracionReal, Servicio servicio, Empleado empleado, Cita cita){
        this.duracionReal = duracionReal;
        this.servicio = servicio;
        this.empleado = empleado;
        this.cita = cita;
    }
    //Métodos de la clase

    //Getters y setters
    public int getDuracionReal(){
        return this.duracionReal;
    }
    public void setDuracionR(int t){
        duracionReal = t;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public String toString(){
        return ">> Cliente: "+cita.getCliente().getNombre()+" | Servicio: "+cita.getServicio().getNombreServicio()+" | Duración real: "+duracionReal+" minutos | Empleado que ofreció el servicio: Nombre: "+empleado.getNombre()+" | Cédula:"+empleado.getCedula();
    }
}