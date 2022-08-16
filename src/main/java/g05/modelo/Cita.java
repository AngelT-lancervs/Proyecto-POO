package g05.modelo;

import java.time.format.DateTimeParseException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.*;
import java.util.*;

import g05.App;

/**
 * Esta clase define los objetos y métodos de las citas del Centro 
 * @author Jeremy Poveda
 * @author Angel Tomala
 * @author Paulina Loor
 * @version 16/07/2022
 */
public class Cita{
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

    public static void escribirCita(Cita c){

        try(BufferedWriter br = new BufferedWriter(new FileWriter(App.pathCitas, true))){
            br.write(c.toString());
            br.newLine();
            br.write("");
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public static ArrayList<String> leerCita(){
        ArrayList<String> ci = new ArrayList<>();

        try(BufferedReader bf = new BufferedReader(new FileReader(App.pathCitas))){
            String line;
            while ((line = bf.readLine())!= null){
                String[] parametros = line.split(",");
                String c = parametros[4] + parametros[3] + parametros[2]+ parametros[0] + parametros[1];
                ci.add(c);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no existe.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ci;
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

    public Empleado getProovedor(){
        return this.proovedor;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public static ArrayList<Cita> getCitas(){
        return citas;
    }
    
    public Cliente getCliente(){
        return cliente;
    }

    public Servicio getServicio(){
        return servicio;
    }


    /**
     * Muestra datos por pantalla
     */
    public String toString(){
        return cliente.getNombre() + ", " + proovedor.getNombre() + ", " + servicio.getNombreServicio() +", " + hora+ ", "+ fecha;
    }
}
