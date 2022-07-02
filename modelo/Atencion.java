package modelo;

public class Atencion{
	private Time duracionReal;
	private Empleado empleado;
	//falta servicio, quizás importarlo desde citas con un metodo
	
	public Atencion(Time duracionReal, Servicio servicio, Empleado empleado)
	{
		this.duracionReal = duracionReal;
		this.servicio = servicio;
		this.empleado = empleado;
	}
		
}
