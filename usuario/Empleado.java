package usuario;
import java.util.ArrayList;
import java.util.Scanner;
import menu.*;

/**
 * Clase empleado
 * @author:
 * @version: 11/07/2022
 */
public class Empleado extends Usuario{
    private ArrayList<Empleado> empleados;
    private boolean estado;
    Scanner scE = new Scanner(System.in);
    
    //Constructor de la clase

    /**
     * Constructor de la clase Empleado, recibe como parametro el nombre del empleado
     * @param nom Nombre del empleado
     */
    public Empleado(String ced){
        super(ced); // Constructor creado para la probar el método de crear cita.
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
        super(nombre, cedula, telefono, email);
        this.cedula=cedula;
        this.estado = estado;
        empleados.add(new Empleado(nombre, cedula, email, estado, telefono));
    }

    public Empleado(String cedula, String nom){
        super(nom);
        this.cedula=cedula;
    }


    public void eliminarEmpleado(){
        this.estado = false;
    }

    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj!=null && getClass()==obj.getClass()){
            Empleado other=(Empleado)obj;
            return (this.cedula.equals(other.cedula));
        }
        return false;
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
    
    public void editarEmpleado(){
        System.out.println("Empleado a editar: ");
        String nombreE = scE.nextLine();
        Empleado empl = new Empleado(nombreE);

        for(Empleado e: Main.empleados){
            if(e.equals(empl)){
                System.out.println(e);
                System.out.println("Campo que desea editar: ");
                String datos=scE.nextLine().toUpperCase();

                switch (datos) {
                    case "NOMBRE":
                        System.out.println("Nuevo nombre: ");
                        String nom=scE.nextLine();
                        e.nombre = nom; 

                    case "EMAIL":
                        System.out.println("Nuevo email: ");
                        String em=scE.nextLine();
                        e.email = em; 

                    case  "TELEFONO":
                        System.out.println("Nuevo telefono: ");
                        String tel=scE.nextLine();
                        e.telefono = tel;
                    }
                }
            }      
        }

    /**
     * Metodo Activo o Inactivo
     * @return devuelve "Activo" si es true e "Inactivo si es False"
     */
    public String activoOinactivo(){
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
