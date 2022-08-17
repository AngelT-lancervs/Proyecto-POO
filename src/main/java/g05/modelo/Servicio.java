package g05.modelo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import g05.App;


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

    public static ArrayList<Servicio> svs = new ArrayList<>();
    
    
    /**
     * Constructor de la clase Servicio, inicializa las variables
     * Representa los servicios que se brindan
     * @param nomSer es el Nombre del Servicio brindado
     * @param duracion2 es la duración que tiene el servicio
     * @param pre es el costo del Servicio
     * @param estado indica si se encuentra disponible o no el servicio
     */
    public Servicio(String nomSer, String duracion2, double pre, boolean estado){
        this.nombreServicio = nomSer;
        this.duracion = duracion2;
        this.precio = pre;
        this.estado = estado;

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
     * Compara los servicios por el nombre haciendo uso del metodo equals
     */
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj!=null && getClass()==obj.getClass()){
            Servicio other=(Servicio)obj;
            return(this.nombreServicio.equals(other.nombreServicio));
        }
        return false;
    }

    //Escribir servicios
    public void escribirServicio(Servicio s){
        try(BufferedWriter bf = new BufferedWriter(new FileWriter(App.pathServiciosCSV, true))){
            bf.write(s.getNombreServicio() +"," +  s.getDuracion() + "," + s.getPrecio()+","+getEstado());
        }
        catch(Exception e) { e.printStackTrace(); }
    }

    public static ArrayList<Servicio> leerServicios(String ruta){
        ArrayList<Servicio> sv = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String line;
            while ((line = br.readLine())!= null){
                String[] parametros = line.split(",");
                System.out.println(parametros.length);
                Servicio s = new Servicio(parametros[0], parametros[1], Double.parseDouble(parametros[2]), Boolean.parseBoolean(parametros[3]));
                sv.add(s);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no existe.");
        } catch (IOException ex) {
            System.out.println("Error IOException:"+ex.getMessage());
        }
        return sv;
    }

    public String toString(){
        return ">> Nombre del Servicio: "+nombreServicio +" | Duración: "+duracion+ " min | "+ "Precio: $"+precio+" | "+"Estado: "+getEstado();
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
    public String getEstado() {
        return estado?"Activo":"Inactivo";
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public static boolean retornaEstado(String s){
        if (s.equals("Activo")){
            return true;
        }else{
            return false;
        }
    }

    public static void actualizarCSV(String pathCSV, ArrayList<Servicio> serviciosActualizado){
        try(BufferedWriter br = new BufferedWriter(new FileWriter(pathCSV, false))){
            for (Servicio s : serviciosActualizado){
                br.write(s.getNombreServicio()+","+s.getDuracion()+","+s.getPrecio()+","+ retornaEstado(s.getEstado()));
                br.newLine();
                br.write("");
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}