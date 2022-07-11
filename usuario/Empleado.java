package usuario;
import java.util.ArrayList;
import menu.*;

public class Empleado extends Usuario{
    private ArrayList<Empleado> empleados;
    private boolean estado;
    private String cedula;
    
    //constructor de la clase

    public Empleado(String nom){
        super(nom);
    }

    public Empleado(String nombre, String cedula, String email, boolean estado, String telefono)
    {
        super(nombre,telefono, email);
        this.cedula=cedula;
        this.estado = estado;
    }
    public void eliminarEmpleado(){

    }

    public static void mostrarEmpleados(){
        System.out.println("-----Empleados-----");
        for(Empleado e: Main.empleados)
        {
            System.out.println(e);
        }
    }

    public  String activoOinactivo(){
        if(estado){
            return "Activo";
        }else{
            return "Inactivo";
        }
    }

    public String toString(){
        return super.toString()+"Estado: "+activoOinactivo();
    }
    
}
