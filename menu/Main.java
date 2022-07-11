package menu;
import modelo.*;
import usuario.*;
import java.util.ArrayList;
import java.util.Scanner;



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
    
    public void menu(){
        Scanner sc=new Scanner(System.in);
        String interfaz	= "°=-----==[Menú]==-----=°\n1.Servicios\n2.Empleados\n3.Clientes\n4.Citas\n5.Atenciones\n6.Salir\n°=-----==[*]==-----=°";
        System.out.print(interfaz);
        System.out.print("Ingrese una opción: ");
        int opcion=sc.nextInt();

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
                break;
            case 5:
                Cita.mostrarMenu();
            case 6:
        }


        sc.close();
    }
    
    public static void main(String[]args){
	Main sistema=new Main();
    sistema.inicializarSistema();
    sistema.menu();

    

}
}   
