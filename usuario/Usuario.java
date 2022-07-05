package usuario;

public abstract class Usuario {
	protected String nombre;
	protected String telefono;
	protected String email;
	
	//constructor de la clase Usuario
	public Usuario(String nombre, String telefono, String email)
	{
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
	}
}
