package modelo;

public class Cita{
	private Cliente cliente;
	private Empleado proovedor;
	private Servicio servicio;
	private Time hora;
	private Date fecha;
	
	public Cita(Date fecha, Time hora, Servicio servicio, Cliente cliente, Empleado proovedor)
	{
		this.cliente = cliente;
		this.proovedor = proovedor;
		this.servicio = servicio;
		this.hora = hora;
		this.fecha = fecha;
		
		
	}


}
