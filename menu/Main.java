package menu;
import modelo.*;
import usuario.*;
import java.util.ArrayList;

public class Main{
    private ArrayList <Servicio> servicios;
    private ArrayList <Empleado> empleados;
    Servicio s1= new Servicio("Terapia de Lenguaje", "30", 25, true);
    Servicio s2= new Servicio("Terapia Psicopedagógica", "30", 25, true);
    Empleado em1=new Empleado("Roberto Pluas", "0999456123", "rober.inf@gmail.com", true, "0992460023");
    public void inicializarSistema(){
        servicios.add(s1);
        servicios.add(s2);
        empleados.add(em1);
    }        
    public static void main(String[]args){
	String interfaz	= "°=-----==[Menú]==-----=°\n1.Servicios\n2.Empleados\n3.Clientes\n4.Citas\n5.Atenciones\n6.Salir\n°=-----==[*]==-----=°";
        System.out.print(interfaz);
    }
}
