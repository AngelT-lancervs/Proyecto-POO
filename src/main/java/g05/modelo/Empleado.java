package g05.modelo;
import g05.App;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Clase empleado
 * @author Jeremy Poveda
 * @author Angel Tomala
 * @author Paulina Loor
 * @version 16/07/2022
 */
public class Empleado extends Usuario implements Serializable{

    private boolean estado;

    /**
     * Constructor de la clase Empleado, recibe como parametro el nombre del empleado, cedula, email, estado y telefono
     * @param nombre  Nombre del empleado
     * @param cedula Cedula del empleado
     * @param email Email del empleado
     * @param estado Indica si el empleado se encuentra activo o inactivo
     * @param telefono Telefono del empleado
     */
    public Empleado(String nombre, String cedula, String email, boolean estado, String telefono)
    {
        super(nombre, cedula, telefono, email);
        this.estado = estado;
    }

    public static ArrayList<Empleado> cargarEmpleados(String pathEmpleados){
        ArrayList<Empleado> empleados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(pathEmpleados))) {
            String line;
            while ((line = br.readLine())!= null){
                String[] parametros = line.split(",");
                Empleado empleado = new Empleado(parametros[0],parametros[1],parametros[2],Boolean.parseBoolean(parametros[3]),parametros[4]);
                empleados.add(empleado);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no existe.");
        } catch (IOException ex) {
            System.out.println("Error IOException:"+ex.getMessage());
        }
        return empleados;
    }
    public static void actualizarCSV(String pathCSV, ArrayList<Empleado> empleadosActualizado){
        try(BufferedWriter br = new BufferedWriter(new FileWriter(pathCSV, false))){
            for (Empleado e : empleadosActualizado){
                br.write(e.getNombre()+","+e.getCedula()+","+e.getEmail()+","+e.getEstadoBoolean()+","+e.getTelefono());
                br.newLine();
                br.write("");
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this.cedula == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Empleado other = (Empleado) obj;
            return (super.cedula.equals(other.cedula));
        }
        return false;
    }

    //Getters and Setters
    public String getEstado() {
        return estado?"Activo":"Inactivo";
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean getEstadoBoolean() {
        return estado;
    }
    public String toString(){
        return super.toString()+" Estado: "+getEstado()+"\n";
    }
}