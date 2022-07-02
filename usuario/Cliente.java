package usuario;

public class Cliente extends usuario {
	private String datos_del_representante;
	
	public Cliente(String nombre, String email, String cedula, String dts_re, String telefono)
	{
		super(nombre, cedula, telefono, email);
		this.datos_del_representante = dts_re;
	}
}
