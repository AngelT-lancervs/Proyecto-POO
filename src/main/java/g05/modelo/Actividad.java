package g05.modelo;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import g05.modelo.*;

public class Actividad implements Serializable {

    String nombreActividad;
    LocalDate fecha;
    int aciertos;
    int fallos;
    LocalTime tiempo;
    Cita cita;
    public Actividad(String nombreActividad, LocalDate fecha, int aciertos, int fallos, LocalTime tiempo, Cita cita){
        this.nombreActividad = nombreActividad;
        this.fecha = fecha;
        this.aciertos = aciertos;
        this.fallos = fallos;
        this.tiempo = tiempo;
        this.cita = cita;
    }
    //Métodos
    public static ArrayList<Actividad> cargarActividades(String path) {
        ArrayList<Actividad> actividades = new ArrayList<>();
        //leer la lista de personas del archivo serializado
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(path))) {
            actividades = (ArrayList<Actividad>) oi.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no existe");
        } catch (IOException ex) {
            System.out.println("Error IO: "+ex.getMessage());
            System.out.println("El archivo se encuentra vacío");
        } catch (ClassNotFoundException  ex) {
            System.out.println("Error class: "+ex.getMessage());
        }
        return actividades;
    }
    public static void actualizarSER(String pathSER, ArrayList<Actividad> actividadesActualizado){
        try(ObjectOutputStream bOS = new ObjectOutputStream(new FileOutputStream(pathSER, false))){
            bOS.writeObject(actividadesActualizado);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }



    /**
     * Getters and setters
     *
     */
    public String getNombreActividad() {
        return nombreActividad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getAciertos() {
        return aciertos;
    }

    public int getFallos() {
        return fallos;
    }

    public LocalTime getTiempo() {
        return tiempo;
    }
    public Cita getCita() {
        return cita;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    public void setFallos(int fallos) {
        this.fallos = fallos;
    }

    public void setTiempo(LocalTime tiempo) {
        this.tiempo = tiempo;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }
}
