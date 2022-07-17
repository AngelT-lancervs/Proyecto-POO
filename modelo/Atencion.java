package modelo;
import java.time.*;
import java.util.ArrayList;
import java.util.Scanner;

import menu.Main;
import usuario.*;

/**
 * Clase que define los datos y métodos que intervienen en la Atencion del Centro
 * Representa una atención registrada en el Centro terapeutico
 * @author  Jeremy Poveda
 * @author Angel Tomala
 * @author Paulina Loor
 * @version 16/07/2022
 */
public class Atencion{
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
        Main.atenciones.add(this);
    }
    //Métodos de la clase
    /**
     * Método que muestra el menú a presentarse en la opción de Atención
     */
    public static void mostrarMenu(){

        System.out.print("-----[Menú/Atención]-----\n");
        System.out.print("1.Registrar Atención\n");
	    System.out.print("2.Consultar Atención\n");
        System.out.print("3.Atrás\n");
    }

    /**
     * Método que registra las atenciones
     */
    public static void registrarAtencion(Scanner sc) {
        System.out.print("Ingrese cédula del cliente: ");
        String ced = sc.nextLine();
        Cliente n_Cliente = Cliente.buscarPorCedulaCliente(ced);
        if(n_Cliente != null){
            if(n_Cliente.getCitasCliente().size() != 0){
                n_Cliente.mostrarCitasPendientes();
                System.out.print("Seleccione cita atendida: ");
                int opcion1 = Main.pedirNumero();
                int indiceCita = opcion1-1;
                Cita n_Cita = n_Cliente.getCitasCliente().get(indiceCita);

                System.out.print("Ingrese la duración real de la Atención en min: ");
                int n_Duracion = sc.nextInt();
                sc.nextLine();

                System.out.print("Seleccione el empleado encargado: \n");
                Empleado.mostrarEmpleados();
                int opcion2 = Main.pedirNumero();
                Empleado n_Empleado = Main.empleados.get(opcion2-1);

                if(!n_Empleado.getEstado()){
                    System.out.print("[ERROR] El empleado seleccionado está inactivo.\n");
                } else {
                    Atencion atencion = new Atencion(n_Duracion, n_Cita.getServicio(), n_Empleado, n_Cita);
                    Cita.citas.remove(indiceCita); // Se elimina de las citas del sistema.
                    int indiceCitaUsuario, indiceCitaEmpleado= 0;
                    indiceCitaUsuario = n_Cita.getCliente().getCitasCliente().indexOf(n_Cita);
                    indiceCitaEmpleado = n_Cita.getProovedor().getCitasEmpleado().indexOf(n_Cita);
                    n_Cita.getCliente().getCitasCliente().remove(indiceCitaUsuario); // Se elimina de las citas pendientes del cliente.
                    n_Cita.getProovedor().getCitasEmpleado().remove(indiceCitaEmpleado); // Se elimina de las citas pendientes del empleado.
                    System.out.print("¡Atención registrada!\n");
                }
            } else {
                System.out.print("[ERROR] El usuario no tiene citas pendientes.\n");
            }
        } else {
            System.out.print("[ERROR] No se encontró el usuario.\n");
        }
    }



    /**
     * Método que permite consultar las atenciones
     */
    public static void consultarAtencion(Scanner sc){
        System.out.print("-----[Menú/Atención/Consultar]-----\n");
        System.out.print("Elija el tipo dato por el cual desea consultar:\n");
        System.out.print("1.Cédula del empleado\n");
        System.out.print("2.Cédula del cliente\n");
        System.out.print("3.Fecha de la atención\n");
        System.out.print("4.Atrás\n");

        int opcion = Main.pedirNumero();
        int count = 0;
        switch(opcion){
            case 1:
                System.out.print("Ingrese cédula del empleado: ");
                String ced = sc.nextLine();
                Empleado empleado = Empleado.buscarPorCedulaEmpleado(ced);
                if(empleado != null){
                    System.out.print("--Atenciones de "+ empleado.getNombre()+"--\n");
                    count = 0;
                    for(Atencion at : Main.atenciones){
                        if(at.empleado.equals(empleado)){
                            count++;
                            System.out.print(count+". "+at);
                        }
                    }
                } else {
                    System.out.print("[ERROR] No se encontró el empleado.\n");
                }

                break;

            case 2:
                System.out.println("Ingrese la cédula del cliente: ");
                ced = sc.nextLine();
                Cliente cliente = Cliente.buscarPorCedulaCliente(ced);
                if(cliente != null) {
                    System.out.print("--Atenciones de "+ cliente.getNombre()+"--\n");
                    count = 0;
                    for(Atencion at : Main.atenciones){
                        if(at.cita.getCliente().equals(cliente)){
                            count++;
                            System.out.print(count+". "+at);
                        }
                    }
                } else {
                    System.out.print("[ERROR] No se encontró el cliente.\n");
                }

                break;

            case 3:
                LocalDate fecha = Cita.pedirFecha(sc);
                System.out.print("--Atenciones de la fecha ("+fecha+")--\n");
                count = 0;
                for(Atencion at :Main.atenciones){
                    if(at.cita.getFecha().isEqual(fecha)){
                        count++;
                        System.out.print(count+". "+at);
                    }
                }

                break;
            case 4:
                break;
            default:
                System.out.print("\n[ERROR] Ingrese una opción válida.\n");
                break;
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

    public String toString(){
        return ">> Cliente: "+cita.getCliente().getNombre()+" | Servicio: "+cita.getServicio().getNombreServicio()+" | Duración real: "+duracionReal+" minutos | Empleado que ofreció el servicio: Nombre: "+empleado.getNombre()+" | Cédula:"+empleado.getCedulaR();
    }
}