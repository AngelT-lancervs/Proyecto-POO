package menu;
import modelo.*;
import usuario.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Clase donde se ejecutará el sistema
 * @author 
 * @version
 */
public class Main{
    Scanner sc = new Scanner(System.in); // Iniciamos objeto de tipo Scanner.
    final String interfaz	= "\n-----[Menú]-----\n1.Servicios\n2.Empleados\n3.Clientes\n4.Citas\n5.Atenciones\n6.Salir\n";
    public static ArrayList <Servicio> servicios = new ArrayList<Servicio>();
    public static ArrayList<Empleado> empleados = new ArrayList<Empleado>();
    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public static ArrayList<Atencion> atenciones = new ArrayList<Atencion>();
    public void inicializarSistema(){
        //Al momento de inicializar el sistema se ejecuta infinitas veces
        Servicio s1 = new Servicio("Terapia de Lenguaje", "30", 25, true);
        Servicio s2 = new Servicio("Terapia Psicopedagógica", "30", 25, false);
        Empleado em1 = new Empleado("Roberto Pluas", "0999456123", "rober.inf@gmail.com", true, "0992460023");
        Cliente cl = new Cliente("Paco", "0958161168", "0961642035", "hola123@hotmail.com", "Maria Rosales, 32 años");
    }

    public static int pedirNumero() {
        Scanner sc = new Scanner(System.in); // Iniciamos objeto de tipo Scanner en un método estático.
        System.out.print("\n>>Elija una opción: ");
        int op = sc.nextInt();
        sc.nextLine();
        return op;
    }

    /**
     * Representa la interfaz del Menu del Sistema
     * @throws ParseException
     */
    public void menu() throws ParseException{

        int opcion = 0;
        while(opcion != 6){
                System.out.print(interfaz);
                opcion = pedirNumero();
            switch(opcion){
                case 1:
                    Servicio.mostrarServicios();
                    break;
                case 2:
                    System.out.print("\nEmpleados Registrados:\n");
                    Empleado.mostrarEmpleados();
                    Empleado.mostrarMenu();
                    int opcion1 = pedirNumero();
                    switch(opcion1){
                        case 1:
                            Empleado.agregarEmpleado();
                            System.out.print("¡Empleado Agregado!\n");
                            Empleado.mostrarEmpleados();
                            break;

                        case 2:
                            System.out.println("Seleccione el empleado a editar: ");
                            Empleado.mostrarEmpleados();
                            opcion=pedirNumero();
                            if(opcion > empleados.size()) {
                                System.out.print("Ingrese una opción válida.");
                            } else {
                                Empleado empleadoEditar = empleados.get(opcion-1);
                                empleadoEditar.editarEmpleado();
                            }
                            System.out.print("¡Empleado Actualizado!\n");
                            Empleado.mostrarEmpleados();
                            break;
                        case 3:
                            System.out.println("Seleccione el empleado a eliminar: ");
                            Empleado.mostrarEmpleados();
                            opcion=pedirNumero();
                            if(opcion > empleados.size()) {
                                System.out.print("Ingrese una opción válida.");
                            } else {
                                Empleado empleadoEliminar = empleados.get(opcion-1);
                                empleadoEliminar.eliminarEmpleado();
                                System.out.print("¡Empleado Eliminado!\n");
                                Empleado.mostrarEmpleados();
                            }
                        case 4:
                            break;
                    }
                    break;

                case 3:
                    System.out.print("\nClientes Registrados:\n");
                    Cliente.mostrarClientes();
                    Cliente.mostrarMenu();
                    opcion = pedirNumero();
                    switch(opcion){
                        case 1:
                            Cliente.agregarCliente();
                            System.out.print("¡Cliente Agregado!\n");
                            Cliente.mostrarClientes();
                            break;
                        case 2:
                            System.out.println("\nSeleccione cliente a editar: ");
                            Cliente.mostrarClientes();
                            opcion = pedirNumero();
                            if(opcion > clientes.size()) {
                                System.out.print("Ingrese una opción válida.\n");
                            } else {
                                Cliente clienteEditar = clientes.get(opcion-1);
                                clienteEditar.editarCliente();
                                System.out.print("¡Cliente Actualizado!\n");
                            }
                            Cliente.mostrarClientes();
                            break;
                        default:
                            System.out.print("Ingrese una opción válida.");
                            break;
                        case 3: 
                            break;
                        }   
                    break;
                case 4:
                    Cita.mostrarMenu();
                    opcion = pedirNumero();
                    switch(opcion) {
                        case 1:
                            Cita.agregarCita();
                            break;
                        case 2:
                            Cita.eliminarCita();
                            break;
                        case 3:
                            Cita.consultarCitasPorFecha();
                        case 4:
                            
                            Cita.buscarPorCedula();
                        case 5:
                            break;
                        default:
                            System.out.print("Ingrese una opción válida.");
                            break;
                    }
                    break;
                case 5:
                    Atencion.mostrarMenu();
                    opcion = pedirNumero();
                    switch(opcion){
                        case 1:
                            Atencion.registrarAtencion();
                            break;
                        case 2:
                            Atencion.consultarAtencion();
                            break;
                        default:
                            System.out.print("Ingrese una opción válida.");
                            break;
                    }
                    break;
                case 6:
                    break;
                default:
                    System.out.print("Ingrese una opción válida.");
                    break;
            }
        }
        System.out.print("Cerrando el sistema...");
    }

    public static void main(String[]args) throws ParseException {

        Main sistema = new Main();
        sistema.inicializarSistema();

        try {
            sistema.menu();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}   
