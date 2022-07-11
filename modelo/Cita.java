package modelo;
import usuario.*;
import java.util.Date;

import menu.Main;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.*;
import java.util.*;

public class Cita{
    private Cliente cliente;
    private Empleado proovedor;
    private Servicio servicio;
    private LocalTime hora;
    private Date fecha;
    private ArrayList<Cita> ListaCitas = new ArrayList<Cita>();
    private Scanner sc = new Scanner(System.in);

    //Constructor de la clase
    public Cita(Date fecha, LocalTime hora, Servicio servicio, Cliente cliente, Empleado proovedor){
        this.cliente = cliente;
        this.proovedor = proovedor;
        this.servicio = servicio;
        this.hora = hora;
        this.fecha = fecha;
    }

    //Métodos 
    public static void mostrarMenu(){
        System.out.print("1. Crear cita\n");
        System.out.print("2. Eliminar cita\n");
        System.out.print("3. Consultar citas por fecha");
    }

    public void crearcita(Date f_nuevaC, LocalTime h_nuevaC, Servicio s_nuevoC, Cliente c_nuevaC, Empleado p_nuevaC){
        Cita cita1= new Cita(f_nuevaC, h_nuevaC, s_nuevoC, c_nuevaC, p_nuevaC);

        if( this.ListaCitas.size() == 0 ){
            this.ListaCitas.add(cita1);
        }
        else{
            for(Cita c: ListaCitas ){
                Date f = c.getFecha();
                LocalTime h= c.getHora();
                Empleado p = c.getProovedor();

                if (!(f_nuevaC.equals(f) && h_nuevaC.equals(h) && p_nuevaC.equals(p))){
                    ListaCitas.add(cita1);
                    c_nuevaC.getCitasCliente().add(cita1);
                }
                else{System.out.println("No está disponible esa hora");}
            }
        }
     }


    public void eliminarCita(){
        System.out.println("Ingrese su número de cédula");
        String c = sc.nextLine();
        
        for (Cliente cl: Main.ListaClientes){
            String cedulaComprobar = cl.getCedulaR();
            
            if(cedulaComprobar.equals(c)){
                for(Cita ci: cl.getCitasCliente()){
                    ci.toString();
                }
                
            }
        }
        
        


    }

    public void consultarCitas() throws ParseException{
        System.out.println("Ingrese fecha a consultar: ");
        String fecha_i = sc.nextLine();
        SimpleDateFormat miDate = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaConsultada = miDate.parse(fecha_i);

        for(Cita c: ListaCitas ){
            if (c.getFecha().equals(fechaConsultada)){
                System.out.println(c.toString() + "\n");
            }
        }
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

    public Empleado getProovedor(){
        return this.proovedor;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    //ToString de Cita
    public String toString(){
        return "Cliente: " + this.cliente.getNombre() + "\n Proovedor: " + this.proovedor.getNombre() + "Servicio: " + this.servicio +"\n Hora: " + this.hora;
    }
}
