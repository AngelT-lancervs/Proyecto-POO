package usuario;

/**
 * Clase Usuario
 * @author:
 * @version:
 */
public abstract class Usuario {
    protected String nombre;
    protected String cedula;
    protected String telefono;
    protected String email;	

    /**
     * Constructor de la clase Usuario, recibe como parametro el nombre del Usuario, esta se hereda a Cliente y Empleado
     * @param nom Nombre del Usuario
     */

    public Usuario(String ced){
        this.cedula = ced; // Constructor creado para probar la creación de citas.
    }



    /**
     * Constructor de la clase Usuario, recibe como parametros el nombre del Usuario, telefono, email
     * @param nombre Nombre del Usuario
     * @param telefono Telefono del Usuario
     * @param email Email del Usuario
     */
    public Usuario(String nombre, String cedula, String telefono, String email){
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.email = email;
    }

    //Getters y Setters
    public String getNombre(){
        return this.nombre;
    }

    public String getTelefono(){
        return this.telefono;
    }

    public String getEmail(){
        return this.email;
    }

    public void setNombre(String n){
        this.nombre = n;
    }

    public void setTelefono(String t){
        this.telefono = t;
    }

    public void setEmail(String e){
        this.email = e;
    }

    public String toString(){
        return ">> Nombre: "+nombre+" | "+" Cédula: "+cedula+" | Teléfono: "+telefono+" | Email: "+email+" |";
    }

    
   
}