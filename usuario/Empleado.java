package usuario;
import java.util.ArrayList;
import menu.*;

/**
 * Clase empleado
 * @author:
 * @version: 11/07/2022
 */
public class Empleado extends Usuario{
    private ArrayList<Empleado> empleados;
    private boolean estado;
    
    //Constructor de la clase

    /**
     * Constructor de la clase Empleado, recibe como parametro el nombre del empleado
     * @param nom Nombre del empleado
     */
    public Empleado(String nom){
        super(nom); // Constructor creado para la probar el método de crear cita.
    }

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
        super(nombre,telefono, email);
        this.cedula=cedula;
        this.estado = estado;
    }


    public void eliminarEmpleado(){
        this.estado = false;
    }

    /**
     * Muestra los empleados registrados en el Centro
     */
    public static void mostrarEmpleados(){
        int count = 0; // Contador para índices
        System.out.println("-----Empleados-----");
        for(Empleado e: Main.empleados)
        {
            System.out.println(count+". "+e);
        }
    }

    /**
     * Metodo Activo o Inactivo
     * @return devuelve "Activo" si es true e "Inactivo si es False"
     */
    public  String activoOinactivo(){
        if(estado){
            return "Activo";
        }else{
            return "Inactivo";
        }
    }

    public String toString(){
        return super.toString()+"Estado: "+activoOinactivo();
    }
    
}
