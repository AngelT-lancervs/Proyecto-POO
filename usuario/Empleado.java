package usuario;

public class Empleado extends Usuario{
    private boolean estado;
    
    //constructor de la clase
    public Empleado(String nombre, String cedula, String email, boolean estado, String telefono)
    {
        super(nombre, cedula, email, estado, telefono);
        this.estado = estado;
    }
    
    
}
