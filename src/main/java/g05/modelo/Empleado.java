package g05.modelo;
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
public class Empleado extends Usuario{

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
        Sistema.empleados.add(this);
    }
    public static ArrayList<Empleado> cargarEmpleados(String pathEmpleados){
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        try (BufferedReader br = new BufferedReader(new FileReader(pathEmpleados))) {
            String line;
            while ((line = br.readLine())!= null){
                String[] parametros = line.split(",");
                Empleado e = new Empleado(parametros[0],parametros[1],parametros[2],Boolean.parseBoolean(parametros[3]),parametros[4]);
                empleados.add(e);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no existe.");
        } catch (IOException ex) {
            System.out.println("Error IOException:"+ex.getMessage());
        }
        return empleados;
    }
    /**
     * Metodo que agrega empleados a la lista de empleados
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
     * Metodo que cambia el estado del empleado (elimina empleado)
     */
    public void eliminarEmpleado(){
        this.estado = false;
    }

    /**
     * Muestra los empleados registrados en el Centro
     */
    public static void mostrarEmpleados(){
        int count = 0; // Contador para índices
        for(Empleado e: Sistema.empleados)
        {
            count++;
            System.out.print(count+". "+e);
        }
    }

    /**
     * Metodo que permite editar informacion del empleado
     * @param sc
     */
    public void editarEmpleado(Scanner sc){
        System.out.print("-----[Menú/Empleado/Editar]-----\n");
        System.out.print("1.Nombre \n2.Telefono \n3.Email");
        int opcion = Sistema.pedirNumero();
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
     * Metodo que permite buscar a un empleado usando la cedula
     * @param ced
     * @return
     */
    public static Empleado buscarPorCedulaEmpleado(String ced) {
        Empleado empleadoEncontrado = null;
        for (Empleado ep : Sistema.empleados) {
            if (ep.getCedula().equals(ced)) {
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
    public String getEstado() {
        return estado?"Activo":"Inactivo";
    }


    public String toString(){
        return super.toString()+" Estado: "+activoOinactivo()+"\n";
    }
}