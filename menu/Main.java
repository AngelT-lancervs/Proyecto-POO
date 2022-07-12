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
 * Clase donde se ejecutara el Sistema
 * @author 
 * @version
 */
public class Main{
        public static ArrayList <Servicio> servicios= new ArrayList<Servicio>();
        public static ArrayList<Empleado> empleados=new ArrayList<Empleado>();
        public  static ArrayList<Cliente> ListaClientes = new ArrayList<Cliente>();

        public static void inicializarSistema(){
        Servicio s1= new Servicio("Terapia de Lenguaje", "30", 25, true);
        Servicio s2= new Servicio("Terapia Psicopedagógica", "30", 25, true);
        Empleado em1=new Empleado("Roberto Pluas", "0999456123", "rober.inf@gmail.com", true, "0992460023");
        servicios.add(s1);
        servicios.add(s2);
        empleados.add(em1);
    }  
    
    /**
     * Representa la interfaz del Menu del Sistema
     * @throws ParseException
     */
    public void menu() throws ParseException{
        Scanner sc=new Scanner(System.in);
        String interfaz	= "°=-----==[Menú]==-----=°\n1.Servicios\n2.Empleados\n3.Clientes\n4.Citas\n5.Atenciones\n6.Salir\n°=-----==[*]==-----=°";
        System.out.print(interfaz);
        System.out.print("Ingrese una opción: ");
        int opcion=sc.nextInt();
        sc.nextLine();

        switch(opcion){
            case 1:
                Servicio.mostrarServicios();
                break;
            case 2:
                Empleado.mostrarEmpleados();
                break;
            case 3:
                Cliente.mostrarClientes();
                break;
            case 4:
            Cita.mostrarMenu();
            System.out.println("Elija una opción: ");
            int op=sc.nextInt();
            sc.nextLine();
            switch(op){
                case 1:
                System.out.println("Ingrese fecha de la cita con el formato DD/MM/YYYY: ");
                String fecha_Cita=sc.nextLine();
                System.out.println("Ingrese la hora de la cita con el formato HH:MM: ");
                String hora=sc.nextLine();
                LocalTime t = LocalTime.parse(hora) ;
                System.out.println("Ingrese el servicio: ");
                String servi=sc.nextLine();
                Servicio ser=new Servicio(servi);
                System.out.println("Ingrese el nombre del cliente: ");
                String cliente=sc.nextLine();
                Cliente cl=new Cliente(cliente);
                System.out.println("Ingrese el nombre de la persona encargada del servicio: ");
                String proveedor=sc.nextLine();
                Empleado empl=new Empleado(proveedor);
                Cita.crearCita(Cita.ParseFecha(fecha_Cita), t,ser,cl,empl);
                break;

                case 2:
                Cita.eliminarCita();
                break;

                case 3:
                Cita.consultarCitas();
                break;

            case 5:
                Atencion.mostrarMenu();

                }   

            case 6:
        }


        sc.close();
    }
    
    public static void main(String[]args){
	Main sistema=new Main();
    sistema.inicializarSistema();
    try {
        sistema.menu();
    } catch (ParseException e) {
        e.printStackTrace();
    }

}
}   
