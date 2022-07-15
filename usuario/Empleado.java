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
        this.estado = estado;
        Main.empleados.add(this);
    }

    public Empleado(String cedula, String nom){
        super(nom);
        this.cedula = cedula;
    }

    /**
     * Método que agrega empleados a la lista de empleados
     */

    public static void agregarEmpleado(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese nombre del empleado: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el número de cédula del empleado: ");
        String cedula = sc.nextLine();
        System.out.println("Ingrese número telefónico del empleado: ");
        String telefono = sc.nextLine();
        System.out.println("Ingrese correo del empleado: ");
        String correo = sc.nextLine();
        Empleado empl1= new Empleado(nombre, cedula, correo, true, telefono);
    }





    public void eliminarEmpleado(){
        this.estado = false;
    }

    public boolean equals(Object obj){
        if(this == obj){
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
        for(Empleado e: Main.empleados)
        {
            count++;
            System.out.println(count+". "+e);
        }
    }
    
    public void editarEmpleado(){
        System.out.print("-----[Menú/Empleado/Editar]-----\n");
        System.out.print("1.Nombre \n2.Telefono \n3.Email");
        int opcion = Main.pedirNumero();
        switch (opcion){
            case 1:
            System.out.print("\nIngrese el nuevo nombre: ");
                String newNombre = scE.nextLine();
                this.nombre = newNombre;
                break;
            case 2:
                System.out.print("\nIngrese el nuevo telefono: ");
                String newTelefono = scE.nextLine();
                this.telefono = newTelefono;
                break;
            case 3:
                System.out.print("\nIngrese el nuevo email: ");
                String newEmail = scE.nextLine();
                this.email = newEmail;
                break;
            default:
                System.out.print("Ingrese una opción válida.");
        }
        }
            

        /**
         * Metodo que muestra las opciones disponibles a realizar con la clase empleado
         */

        public static void mostrarMenu() {
            System.out.print("-----[Menú/Empleados]-----\n");
            System.out.print("1. Agregar empleado\n");
            System.out.print("2. Editar empleado\n");
            System.out.println("3. Eliminar empleado\n");
        }

    /**
     * Metodo Activo o Inactivo
     * @return devuelve "Activo" si es true e "Inactivo" si es False
     */
    public String activoOinactivo(){
        if(estado){
            return "Activo";
        } else {
            return "Inactivo";
        }
    }
    public boolean getEstado() {
        return estado;
    }

    public String toString(){
        return super.toString()+" Estado: "+activoOinactivo();
    }
}