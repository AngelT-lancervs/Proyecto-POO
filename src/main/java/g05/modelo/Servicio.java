package g05.modelo;
import java.io.*;
import java.util.ArrayList;

import g05.App;


/**
 * Clase que define los datos y metodos que se presentan en los servicios brindados
 * @author  Jeremy Poveda
 * @author  Angel Tomala
 * @author  Paulina Loor
 * @version 16/07/2022
 */
public class Servicio implements Serializable {
    private String nombreServicio;
    private double duracion;
    private Empleado empleado;
    private double precio;
    private boolean estado;

    public static ArrayList<Servicio> svs = new ArrayList<>();
    
    
    /**
     * Constructor de la clase Servicio, inicializa las variables
     * Representa los servicios que se brindan
     * @param nomSer es el Nombre del Servicio brindado
     * @param duracion es la duración que tiene el servicio
     * @param pre es el costo del Servicio
     * @param estado indica si se encuentra disponible o no el servicio
     */
    public Servicio(String nomSer, double duracion, double pre, boolean estado){
        this.nombreServicio = nomSer;
        this.duracion = duracion;
        this.precio = pre;
        this.estado = estado;

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
    public static ArrayList<Servicio> cargarServicios(String ruta){
        ArrayList<Servicio> sv = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String line;
            while ((line = br.readLine())!= null){
                String[] parametros = line.split(",");
                System.out.println(parametros.length);
                Servicio s = new Servicio(parametros[0], Double.parseDouble(parametros[1]), Double.parseDouble(parametros[2]), Boolean.parseBoolean(parametros[3]));
                sv.add(s);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no existe.");
        } catch (IOException ex) {
            System.out.println("Error IOException:"+ex.getMessage());
        }
        return sv;
    }

    public static void actualizarCSV(String pathCSV, ArrayList<Servicio> serviciosActualizado){
        try(BufferedWriter br = new BufferedWriter(new FileWriter(pathCSV, false))){
            for (Servicio s : serviciosActualizado){
                br.write(s.getNombreServicio()+","+s.getDuracion()+","+s.getPrecio()+","+ s.getEstadoBoolean());
                br.newLine();
                br.write("");
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
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
    public double getDuracion() {
        return duracion;
    }
    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }
    public String getEstado() {
        return estado?"Activo":"Inactivo";
    }
    public boolean getEstadoBoolean(){
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}