package modelo;
import java.time.*;
import java.util.Scanner;

import menu.Main;
import usuario.*;

/**
 * Clase que define los datos y métodos que intervienen en la Atencion del Centro
 * Representa una atención registrada en el Centro terapeutico
 * @author: 
 * @version: 11/07/2022
 */
public class Atencion{
    private int duracionReal;
    private Empleado empleado;
    private Servicio servicio;
    static Scanner sc = new Scanner(System.in);
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
    }
    //Métodos de la clase
    /**
     * Método que muestra el menú a presentarse en la opción de Atención
     */
    public static void mostrarMenu(){

        System.out.print("-----[Menú/Atención]-----\n");
        System.out.print("1. Registrar Atención\n");         
	    System.out.print("2. Consultar Atención\n");
    }
    public static void registrarAtencion(){

        System.out.print("Ingrese cedula del Cliente: ");
        String ced = sc.nextLine();
        Cliente c1 = new Cliente(ced);
        Cita cita1 = null;
        
        for(Cita c: Cita.getCitas()){
            if(c.getCliente().equals(c1)){
                cita1=c;
            }
        }
        Empleado empleado = null;
        System.out.print("Ingrese la duración real de la Atención en min: ");
        int dur=sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese cédula del empleado que realizó la atención: ");
        String cedEmpleado = sc.nextLine();
        Empleado empleado1 = new Empleado(cedEmpleado);

        for(Empleado e: Main.empleados){
            if(e.equals(empleado1)){
                empleado=e;
            }
        }
        if(cita1 != null) {
            Atencion atencion1 = new Atencion(dur, cita1.getServicio(), empleado, cita1);
            Main.atenciones.add(atencion1);
        } else {
            System.out.print("[ERROR] No se el cliente o el proovedor.\n");
        }

    }
    public static void consultarAtencion(){
        System.out.println("Elija el tipo dato por el cual desea consultar: ");
        System.out.println("1.Cédula del empleado ");
        System.out.println("2.Cédula del cliente");
        System.out.println("3.Fecha de la atención");
        int opcion=sc.nextInt();
        sc.nextLine();

        for(Atencion a: Main.atenciones){
            switch(opcion){
                case 1:
                    System.out.println("Ingrese la cédula del empleado que prestó el servicio: ");
                    String cedulaEmpleado = sc.nextLine();
                    Empleado empleado2 = new Empleado(cedulaEmpleado);
                    if(a.empleado.equals(empleado2)){
                        System.out.println(a);
                    }
                    break;

                case 2:
                    System.out.println("Ingrese la cédula del cliente: ");
                    String cedulaCliente=sc.nextLine();
                    Cliente cliente1 = new Cliente(cedulaCliente);
                    if(a.cita.getCliente().equals(cliente1)){
                        System.out.println(a);
                    }

                    break;
                case 3:
                    System.out.println("Ingrese la fecha de la atención a buscar: ");
                    String fecha_a_buscar = sc.nextLine();
      
                    if(a.cita.getFecha().equals(Cita.ParseFecha(fecha_a_buscar))){
                        System.out.println(a);
                    }
                    break;
            }
        }
    }
    //Getters y setters
    public int getDuracionReal(){
        return this.duracionReal;
    }
    public void setDuracionR(int t){
        duracionReal = t;
    }
}