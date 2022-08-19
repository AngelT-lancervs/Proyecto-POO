package g05.modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.*;
import java.util.*;

/**
 * Esta clase define los objetos y métodos de las citas del Centro 
 * @author Jeremy Poveda
 * @author Angel Tomala
 * @author Paulina Loor
 * @version 16/07/2022
 */
public class Cita implements Serializable{
    private Cliente cliente;
    private Empleado proovedor;
    private Servicio servicio;
    private LocalTime hora;
    private LocalDate fecha;
    public static ArrayList<Cita> citas = new ArrayList<Cita>();




    /**
     * Constructor de la clase Cita
     * Registra una cita recibiendo por parámetros los datos de la cita
     * @param fecha fecha de la Cita
     * @param hora  hora de la Cita
     * @param servicio Nombre del servicio que se realiza en la cita
     * @param cliente Cliente que asistió a la cita
     * @param proovedor Persona encargada de dar el servicio
     */
    public Cita(LocalDate fecha, LocalTime hora, Servicio servicio, Cliente cliente, Empleado proovedor){
        this.cliente = cliente;
        this.proovedor = proovedor;
        this.servicio = servicio;
        this.hora = hora;
        this.fecha = fecha;
    }

    //Métodos
    public static ArrayList<Cita> cargarCitas(String path) {
        ArrayList<Cita> citas = new ArrayList<>();
        //leer la lista de personas del archivo serializado
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(path))) {
            citas = (ArrayList<Cita>) oi.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no existe");
        } catch (IOException   ex) {
            System.out.println("Error IO: "+ex.getMessage());
            System.out.println("El archivo se encuentra vacío");
        } catch (ClassNotFoundException  ex) {
            System.out.println("Error class: "+ex.getMessage());
        }
        return citas;
    }

    public static void actualizarSER(String pathSER, ArrayList<Cita> citasActualizado){
        try(ObjectOutputStream bOS = new ObjectOutputStream(new FileOutputStream(pathSER, false))){
            bOS.writeObject(citasActualizado);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    //Getters & Setters
    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getProovedor(){
        return this.proovedor.getNombre();
    }
    public Empleado getEmpleado(){
        return proovedor;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getCliente(){
        return cliente.getNombre();
    }
    public Cliente getClienteObj(){
        return cliente;
    }

    public String getServicio(){
        return servicio.getNombreServicio();
    }
    public Servicio getServicioObj(){
        return servicio;
    }




    /**
     * Muestra datos por pantalla
     */
    public String toString(){
        return cliente.getNombre() + ", " + proovedor.getNombre() + ", " + servicio.getNombreServicio() +", " + hora+ ", "+ fecha;
    }


}
