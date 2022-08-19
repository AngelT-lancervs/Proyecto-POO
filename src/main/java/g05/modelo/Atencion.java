package g05.modelo;
import java.io.*;
import java.time.*;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Clase que define los datos y metodos que intervienen en la Atencion del Centro
 * Representa una atencion registrada en el Centro terapeutico
 * @author  Jeremy Poveda
 * @author Angel Tomala
 * @author Paulina Loor
 * @version 16/07/2022
 */
public class Atencion implements Serializable{
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

    public static ArrayList<Atencion> cargarAtenciones(String path) {
        ArrayList<Atencion> atenciones = new ArrayList<>();
        //leer la lista de personas del archivo serializado
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(path))) {
            atenciones = (ArrayList<Atencion>) oi.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no existe");
        } catch (IOException ex) {
            System.out.println("Error IO: "+ex.getMessage());
        } catch (ClassNotFoundException  ex) {
            System.out.println("Error class: "+ex.getMessage());
        }
        return atenciones;
    }

    public static void actualizarSER(String pathSER, ArrayList<Atencion> atencionesActualizado){
        try(ObjectOutputStream bOS = new ObjectOutputStream(new FileOutputStream(pathSER, false))){
            bOS.writeObject(atencionesActualizado);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

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
    public Cliente getCliente(){
        return cita.getClienteObj();
    }

    public String toString(){
        return ">> Cliente: "+cita+" | Servicio: "+cita+" | Duración real: "+duracionReal+" minutos | Empleado que ofreció el servicio: Nombre: "+empleado+" | Cédula:"+empleado.getCedula();
    }
}