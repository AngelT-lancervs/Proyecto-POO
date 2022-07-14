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
    final String interfaz	= "-----[Menú]-----\n1.Servicios\n2.Empleados\n3.Clientes\n4.Citas\n5.Atenciones\n6.Salir\n";
    public static ArrayList <Servicio> servicios = new ArrayList<Servicio>();
    public static ArrayList<Empleado> empleados = new ArrayList<Empleado>();
    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public static ArrayList<Atencion> atenciones = new ArrayList<Atencion>();
    public void inicializarSistema(){
        //Al momento de inicializar el sistema se ejecuta infinitas veces
        Servicio s1 = new Servicio("Terapia de Lenguaje", "30", 25, true);
        Servicio s2 = new Servicio("Terapia Psicopedagógica", "30", 25, true);
        Empleado em1 = new Empleado("Roberto Pluas", "0999456123", "rober.inf@gmail.com", true, "0992460023");
        Cliente cl = new Cliente("Paco", "0958161168", "0961642035", "hola123@hotmail.com", "Maria Rosales, 32 años");
    }

    public static int pedirNumero() {
        Scanner sc = new Scanner(System.in); // Iniciamos objeto de tipo Scanner en un método estático.
        System.out.print("\n>>Elija una opción: ");
        int op = sc.nextInt();
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
                    Empleado.mostrarEmpleados();
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
                            System.out.println("Seleccione cliente a editar: ");
                            Cliente.mostrarClientes();
                            opcion = pedirNumero();
                            if(opcion > clientes.size()) {
                                System.out.print("Ingrese una opción válida.");
                            } else {
                                Cliente clienteEditar = clientes.get(opcion-1);
                                clienteEditar.editarCliente();
                            }
                            System.out.print("¡Cliente Actualizado!\n");
                            Cliente.mostrarClientes();
                            break;
                        default:
                            System.out.print("Ingrese una opción válida.");
                            break;
                    }
                    break;
                case 4:
                    Cita.mostrarMenu();
                    opcion = pedirNumero();
                    switch(opcion) {
                        case 1:
                            System.out.println("Ingrese fecha de la cita con el formato DD/MM/YYYY: ");
                            String fecha_Cita = sc.nextLine();
                            System.out.println("Ingrese la hora de la cita con el formato HH:MM: ");
                            String hora = sc.nextLine();
                            LocalTime t = LocalTime.parse(hora) ;
                            System.out.println("Ingrese el servicio: ");
                            String servi = sc.nextLine();
                            System.out.println("Ingrese el nombre del cliente: ");
                            String cliente = sc.nextLine();
                            System.out.println("Ingrese la cedula del cliente: ");
                            String cedula = sc.nextLine();
                            Cliente cl = new Cliente(cliente,cedula);
                            System.out.println("Ingrese el nombre de la persona encargada del servicio: ");
                            String proveedor = sc.nextLine();
                            Empleado empl = new Empleado(proveedor);
                            Cita.crearCita(Cita.ParseFecha(fecha_Cita), t,servi,cl,empl);
                            break;
                        case 2:
                            Cita.eliminarCita();
                            break;
                        case 3:
                            Cita.consultarCitasPorFecha();
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
        System.out.print("Cerrando sistema...");

    }
    public static void main(String[]args) throws ParseException {

        Main sistema = new Main();
        sistema.inicializarSistema();
        sistema.menu();
        /*
        try {
            sistema.menu();
        } catch (ParseException e) {
            e.printStackTrace();
        }
         */
    }
}   
