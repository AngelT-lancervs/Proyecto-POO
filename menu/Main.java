package menu;
import modelo.*;
import usuario.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.*;
import java.text.ParseException;



/**
 * Clase donde se ejecutara el sistema
 * @author Jeremy Poveda
 * @author Angel Tomala
 * @author Paulina Loor
 * @version 16/07/2022
 */
public class Main{
    Scanner sc = new Scanner(System.in); // Iniciamos objeto de tipo Scanner.
    final String interfaz	= "\n-----[Menú]-----\n1.Servicios\n2.Empleados\n3.Clientes\n4.Citas\n5.Atenciones\n6.Salir\n";
    public static ArrayList<Servicio> servicios = new ArrayList<Servicio>();
    public static ArrayList<Empleado> empleados = new ArrayList<Empleado>();
    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public static ArrayList<Atencion> atenciones = new ArrayList<Atencion>();
    public void inicializarSistema(){
        //Se inicializan los servicios, un empleado y un cliente.
        Servicio s1 = new Servicio("Terapia de Lenguaje", "30", 25, true);
        Servicio s2 = new Servicio("Terapia Psicopedagógica", "30", 25, false);
        Empleado em1 = new Empleado("Roberto Pluas", "0999456123", "rober.inf@gmail.com", true, "0992460023");
        Cliente cl = new Cliente("Paco", "0958161168", "0961642035", "hola123@hotmail.com", "Maria Rosales, 32 años");
    }

    /**
     * Metodo que pide un numero al usuario, se usa para los distintos menus del programa
     */
    public static int pedirNumero() {
        Scanner sc = new Scanner(System.in); // Iniciamos objeto de tipo Scanner en un metodo estatico.
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
        String cedula = "";
        while(opcion != 6){
                System.out.print(interfaz);
                opcion = pedirNumero();
            switch(opcion){
                case 1:
                    System.out.print("\n--Servicios ofrecidos--\n");
                    Servicio.mostrarServicios();
                    Servicio.mostrarMenu();
                    opcion = pedirNumero();
                    switch(opcion){
                        case 1:
                            Servicio.agregarServicio();
                            Servicio.mostrarServicios();
                            break;

                        case 2:
                            System.out.print("\nSeleccione el Servicio a editar: \n");
                            Servicio.mostrarServicios();
                            opcion = pedirNumero();
                            if(opcion > servicios.size()) {
                                System.out.print("\n[ERROR] Ingrese una opción válida.\n");
                            } else {
                                Servicio servicioEditar = Main.servicios.get(opcion-1);
                                servicioEditar.editarServicio();
                            }
                            System.out.print("\n¡Servicio Actualizado!\n");
                            Servicio.mostrarServicios();
                            break;

                        case 3:
                            System.out.print("\nSeleccione el servicio a eliminar: \n");
                            Servicio.mostrarServicios();
                            opcion = pedirNumero();
                            if (opcion > servicios.size()) {
                                System.out.print("\n[ERROR] Ingrese una opción válida.\n");
                            } else {
                                Servicio servicioEliminar = servicios.get(opcion-1);
                                servicioEliminar.eliminarServicio();;
                                System.out.print("\n¡Servicio Eliminado!\n");
                                Servicio.mostrarServicios();
                            }
                            break;
                        case 4:
                            break;
                    }
                    break;

                case 2:
                    System.out.print("\nEmpleados Registrados:\n");
                    Empleado.mostrarEmpleados();
                    Empleado.mostrarMenu();
                    opcion = pedirNumero();
                    switch(opcion){
                        case 1:
                            Empleado.agregarEmpleado(sc);
                            System.out.print("\n¡Empleado Agregado!\n");
                            Empleado.mostrarEmpleados();
                            break;

                        case 2:
                            System.out.print("\nSeleccione el empleado a editar: \n");
                            Empleado.mostrarEmpleados();
                            opcion=pedirNumero();
                            if(opcion > empleados.size()) {
                                System.out.print("\n[ERROR] Ingrese una opción válida.\n");
                            } else {
                                Empleado empleadoEditar = empleados.get(opcion-1);
                                empleadoEditar.editarEmpleado(sc);
                            }
                            System.out.print("\n¡Empleado Actualizado!\n");
                            Empleado.mostrarEmpleados();
                            break;

                        case 3:
                            System.out.print("\nSeleccione el empleado a eliminar: \n");
                            Empleado.mostrarEmpleados();
                            opcion=pedirNumero();
                            if(opcion > empleados.size()) {
                                System.out.print("\n[ERROR] Ingrese una opción válida.\n");
                            } else {
                                Empleado empleadoEliminar = empleados.get(opcion-1);
                                empleadoEliminar.eliminarEmpleado();
                                System.out.print("\n¡Empleado Eliminado!\n");
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
                            System.out.print("\n¡Cliente Agregado!\n");
                            Cliente.mostrarClientes();
                            break;
                        case 2:
                            System.out.print("\nSeleccione cliente a editar: \n");
                            Cliente.mostrarClientes();
                            opcion = pedirNumero();
                            if(opcion > clientes.size()) {
                                System.out.print("\n[ERROR] Ingrese una opción válida.\n");
                            } else {
                                Cliente clienteEditar = clientes.get(opcion-1);
                                clienteEditar.editarCliente(sc);
                                System.out.print("\n¡Cliente Actualizado!\n");
                            }
                            Cliente.mostrarClientes();
                            break;
                        case 3:
                            break;
                        default:
                            System.out.print("\n[ERROR] Ingrese una opción válida.\n");
                            break;
                        }   
                    break;
                case 4:
                    Cita.mostrarMenu();
                    opcion = pedirNumero();
                    switch(opcion) {
                        case 1:
                            Cita.agregarCita(sc);
                            break;
                        case 2:
                            System.out.println("Ingrese cédula del cliente: ");
                            cedula = sc.nextLine();
                            Cita.eliminarCita(cedula);
                            break;
                        case 3:
                            Cita.consultarCitasPorFecha(sc);
                            break;
                        case 4:
                            break;
                        default:
                            System.out.print("\n[ERROR] Ingrese una opción válida.\n");
                            break;
                    }
                    break;
                case 5:
                    Atencion.mostrarMenu();
                    opcion = pedirNumero();
                    switch(opcion){
                        case 1:
                            Atencion.registrarAtencion(sc);
                            break;
                        case 2:
                            Atencion.consultarAtencion(sc);
                            break;
                        case 3:
                            break;
                        default:
                            System.out.print("\n[ERROR] Ingrese una opción válida.\n");
                            break;
                    }
                    break;
                case 6:
                    break;
                default:
                    System.out.print("\n[ERROR] Ingrese una opción válida.\n");
                    break;
            }
        }
        System.out.print("\nCerrando el sistema...");
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
