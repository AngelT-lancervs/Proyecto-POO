package usuario;
import java.util.ArrayList;
import java.util.Scanner;
import menu.*;
import modelo.Cita;

/**
 * Clase empleado
 * @author Jeremy Poveda
 * @author Angel Tomala
 * @author Paulina Loor
 * @version 16/07/2022
 */
public class Empleado extends Usuario{

    private ArrayList<Cita> citasEmpleado = new ArrayList<>();
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
        Main.empleados.add(this);
    }

    /**
     * Método que agrega empleados a la lista de empleados
     */
    public static void agregarEmpleado(Scanner sc){
        System.out.println("Ingrese nombre del empleado: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el número de cédula del empleado: ");
        String cedula = sc.nextLine();
        System.out.println("Ingrese número telefónico del empleado: ");
        String telefono = sc.nextLine();
        System.out.println("Ingrese correo del empleado: ");
        String correo = sc.nextLine();
        Empleado empl1 = new Empleado(nombre, cedula, correo, true, telefono);
    }

    /**
     * Método que cambia el estado del empleado (elimina empleado)
     */
    public void eliminarEmpleado(){
        this.estado = false;
    }

    /**
     * Muestra los empleados registrados en el Centro
     */
    public static void mostrarEmpleados(){
        int count = 0; // Contador para índices
        for(Empleado e: Main.empleados)
        {
            count++;
            System.out.print(count+". "+e);
        }
    }

    /**
     * Método que muestra las citas pendientes
     */
    public void mostrarCitasPendientes(){
        System.out.print("---Citas pendientes---\n");
        int count = 0;
        for (Cita c : this.getCitasEmpleado()){
            count++;
            System.out.println(count+". "+c);
        }
    }

    /**
     * Método que permite editar información del empleado
     * @param sc
     */
    public void editarEmpleado(Scanner sc){
        System.out.print("-----[Menú/Empleado/Editar]-----\n");
        System.out.print("1.Nombre \n2.Telefono \n3.Email");
        int opcion = Main.pedirNumero();
        switch (opcion){
            case 1:
            System.out.print("\nIngrese el nuevo nombre: ");
                String newNombre = sc.nextLine();
                this.nombre = newNombre;
                break;
            case 2:
                System.out.print("\nIngrese el nuevo telefono: ");
                String newTelefono = sc.nextLine();
                this.telefono = newTelefono;
                break;
            case 3:
                System.out.print("\nIngrese el nuevo email: ");
                String newEmail = sc.nextLine();
                this.email = newEmail;
                break;
            default:
                System.out.print("Ingrese una opción válida.");
        }
    }

    /**
     * Método que permite buscar a un empleado usando la cédula
     * @param ced
     * @return
     */
    public static Empleado buscarPorCedulaEmpleado(String ced) {
        Empleado empleadoEncontrado = null;
        for (Empleado ep : Main.empleados) {
            if (ep.getCedulaR().equals(ced)) {
                empleadoEncontrado = ep;
            }
        }
        return empleadoEncontrado;
    }

    /**
     * Metodo que muestra las opciones disponibles a realizar con la clase empleado
     */
    public static void mostrarMenu() {
            System.out.print("-----[Menú/Empleados]-----\n");
            System.out.print("1. Agregar empleado\n");
            System.out.print("2. Editar empleado\n");
            System.out.print("3. Eliminar empleado\n");
            System.out.print("4. Atrás\n");
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

    //Getters and Setters
    public boolean getEstado() {
        return estado;
    }

    public String getCedulaR(){
        return this.cedula;
    }

    public ArrayList<Cita> getCitasEmpleado() {
        return citasEmpleado;
    }

    public String toString(){
        return super.toString()+" Estado: "+activoOinactivo()+"\n";
    }
}