package usuario;
import java.util.ArrayList;

public class Empleado extends Usuario{
    private ArrayList<Empleado> empleados;
    private boolean estado;
    private String cedula;
    
    //constructor de la clase
    public Empleado(String nombre, String cedula, String email, boolean estado, String telefono)
    {
        super(nombre,telefono, email);
        this.cedula=cedula;
        this.estado = estado;
    }

    public void eliminarEmpleado(){

    }

  
    
    
}
