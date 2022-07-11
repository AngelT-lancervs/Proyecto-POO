package usuario;

public abstract class Usuario {
    protected String nombre;
    protected String telefono;
    protected String email;	

    //Constructor de la clase Usuario
    public Usuario(String nombre, String telefono, String email){
        this.nombre = nombre;
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

}

