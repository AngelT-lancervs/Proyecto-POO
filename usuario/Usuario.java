package usuario;

public abstract class Usuario {
	protected String nombre;
	protected String cedula;
	protected String telefono;
	protected String email;
	
	//constructor de la clase Usuario
	public Usuario(String nombre, String cedula, String telefono, String email)
	{
		this.nombre = nombre;
		this.cedula = cedula;
		this.telefono = telefono;
		this.email = email;
	}
}
