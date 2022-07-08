package modelo;
import usuario.*;
import java.util.Date;
import java.time.*;

public class Cita{
    private Cliente cliente;
    private Empleado proovedor;
    private Servicio servicio;
    private LocalTime hora;
    private Date fecha;

    public Cita(Date fecha, LocalTime hora, Servicio servicio, Cliente cliente, Empleado proovedor){
        this.cliente = cliente;
        this.proovedor = proovedor;
        this.servicio = servicio;
        this.hora = hora;
        this.fecha = fecha;
    }
    public void mostrarMenu(){
        System.out.print("1. Crear cita");
        System.out.print("2. Eliminar cita");
        System.out.print("3. Consultar citas por fecha");
    }
    public void crearcita(){
    }
    public void eliminarCita(){
    }
    public void consultarCitas(){
        System.out.println("Ingrese fecha a consultar: ");	
    }
    //Getters & Setters
    public LocalTime getHora() {
        return hora;
    }
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
