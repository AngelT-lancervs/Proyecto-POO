package modelo;
import usuario.*;
import java.util.Date;
import menu.Main;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.*;
import java.util.*;

/**
 * Esta clase define los objetos y métodos de las citas del Centro 
 * @author
 * @version:11/07/2022
 */
public class Cita{
    private Cliente cliente;
    private Empleado proovedor;
    private Servicio servicio;
    private LocalTime hora;
    private Date fecha;
    private static ArrayList<Cita> ListaCitas = new ArrayList<Cita>();
    private static Scanner sc = new Scanner(System.in);

    /**
     * Constructor de la clase Cita
     * Registra una cita recibiendo por parámetros los datos de la cita
     * @param fecha fecha de la Cita
     * @param hora  hora de la Cita
     * @param servicio Nombre del servicio que se realiza en la cita
     * @param cliente Cliente que asistió a la cita
     * @param proovedor Persona encargada de dar el servicio
     */
    public Cita(Date fecha, LocalTime hora, Servicio servicio, Cliente cliente, Empleado proovedor){
        this.cliente = cliente;
        this.proovedor = proovedor;
        this.servicio = servicio;
        this.hora = hora;
        this.fecha = fecha;
    }

    //Métodos
    /**
     * Método que presenta el menú de la opcion cita al Usuario
     *Representa el menú que se presenta al usuario al ingresar a la opcion de Citas
     */
    public static void mostrarMenu(){
        System.out.print("1. Crear cita\n");
        System.out.print("2. Eliminar cita\n");
        System.out.print("3. Consultar citas por fecha\n");
    }

    /**
     * Crea una cita recibiendo como parametros los datos de la misma, a su vez verifica que no exista otra cita a la misma fecha y hora con la persona encargada
     * @param f_nuevaC fecha de la cita que se creará
     * @param h_nuevaC hora de la cita que se creará
     * @param s_nuevoC Servicio a prestarse en la cita
     * @param c_nuevaC Cliente que accederá a la cita
     * @param p_nuevaC Empleado que prestará el Servicio en la cita
     */
    public static void crearCita(Date f_nuevaC, LocalTime h_nuevaC, Servicio s_nuevoC, Cliente c_nuevaC, Empleado p_nuevaC){
        Cita cita1= new Cita(f_nuevaC, h_nuevaC, s_nuevoC, c_nuevaC, p_nuevaC);

    
        if( ListaCitas.size() == 0 ){
            ListaCitas.add(cita1);
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

    /**
     * Elimina una cita usando el número de cédula del Cliente
     */
    public static void eliminarCita(){
        System.out.println("Ingrese su número de cédula");
        String c = sc.nextLine();
        
        for (Cliente cl: Main.ListaClientes){
            String cedulaComprobar = cl.getCedulaR();
            
            if(cedulaComprobar.equals(c)){
                for(Cita ci: cl.getCitasCliente()){
                    ci.toString(); // Falta implementar
                }    
            }
        }
    }
    /**
     * Consulta las citas que existen pidiendo una fecha y una hora
     */
    public static void consultarCitasPorFecha() throws ParseException{
        System.out.println("Ingrese fecha a consultar: ");
        String fecha_i = sc.nextLine();
        SimpleDateFormat miDate = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaConsultada = miDate.parse(fecha_i);

        for(Cita c: listaCitas ){
            if (c.getFecha().equals(fechaConsultada)){
                System.out.println(c.toString() + "\n");
            }
        }
    }

    //Metodo de conversion de String a Date
    /**
     * Convierte el String ingresado por el usuario a un dato de tipo Fecha
     */
    public static Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
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
