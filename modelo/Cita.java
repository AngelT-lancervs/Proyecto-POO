package modelo;
import usuario.*;

import java.time.format.DateTimeParseException;
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
    private LocalDate fecha;
    public static ArrayList<Cita> citas = new ArrayList<Cita>();
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
    public Cita(LocalDate fecha, LocalTime hora, Servicio servicio, Cliente cliente, Empleado proovedor){
        this.cliente = cliente;
        this.proovedor = proovedor;
        this.servicio = servicio;
        this.hora = hora;
        this.fecha = fecha;
        citas.add(this);
    }

    public Cita(LocalDate d, String hora2, Servicio servicio2, Empleado empleado) {
    }

    //Métodos
    /**
     * Método que presenta el menú de la opcion cita al Usuario
     *Representa el menú que se presenta al usuario al ingresar a la opcion de Citas
     */
    public static void mostrarMenu(){
        System.out.print("-----[Menú/Citas]-----\n");
        System.out.print("1. Crear cita\n");
        System.out.print("2. Eliminar cita\n");
        System.out.print("3. Consultar citas por fecha\n");
        System.out.print("4. Consultar citas por cédula\n");
        System.out.print("5. Salir\n");
    }

    public static void buscarPorCedula(){
        Cita c2=null;
        Cliente cl=null;
        System.out.println("Ingrese el número de cédula de un cliente: ");
        String cd = sc.nextLine();
        ArrayList <Cliente> cedulasCoinciden= new ArrayList<>();
        ArrayList <Cita> citasCoinciden=new ArrayList<>(); 
        Cliente clienteBuscar=new Cliente(cd);
        for(Cliente c : Main.clientes){
            if(c.equals(clienteBuscar)){
                cl=c;
                cedulasCoinciden.add(cl);
            }
            }
        
        if(cedulasCoinciden.size()>0){
            for(Cita c: citas){
                if(c.getCliente().equals(cl)){
                    c2=c;
                    citasCoinciden.add(c2);
                }
            }
        }else{
                System.out.println("El cliente no se encuentra registrado");
            }
        
        if(citasCoinciden.size()>0 && cedulasCoinciden.size()>0){
            System.out.println(c2);
        }else{
            System.out.println("El cliente no tiene citas");
        }}

   
    
    /**
     * Crea una cita recibiendo como parametros los datos de la misma, a su vez verifica que no exista otra cita a la misma fecha y hora con la persona encargada
     * @param f_nuevaC fecha de la cita que se creará
     * @param h_nuevaC hora de la cita que se creará
     * @param s_nuevoC Servicio a prestarse en la cita
     * @param c_nuevaC Cliente que accederá a la cita
     * @param p_nuevaC Empleado que prestará el Servicio en la cita
     */

    public static void comprobarCita(LocalDate f_nuevaC, LocalTime h_nuevaC, Servicio s_nuevoC, Cliente c_nuevaC, Empleado p_nuevaC){
        Cita cita1 = new Cita(f_nuevaC, h_nuevaC, s_nuevoC, c_nuevaC, p_nuevaC);
        // Si no hay ninguna cita
        if(getCitas().size() == 0){
            getCitas().add(cita1);
            System.out.print("¡Se creó la cita correctamente!\n");
        }
        else {
            Cita citaCorrecta = null;
            for(Cita c : citas){
                LocalDate f = c.getFecha();
                LocalTime h = c.getHora();
                Empleado p = c.getProovedor();

                if(!(f_nuevaC.equals(f) && h_nuevaC.equals(h) && p_nuevaC.equals(p))){ // Comprueba si existe otra cita con el mismo empleado a la misma fecha y hora.
                    citaCorrecta = c;
                    System.out.print("¡Se creó la cita correctamente !\n");
                    citas.add(citaCorrecta);
                    break;
                }
                else{
                    System.out.println("[ERROR] No está disponible una cita en esa fecha y hora con "+p_nuevaC.getNombre());
                }
            }
            
        }
     }


    /**
     * Elimina una cita usando el número de cédula del Cliente
     */
    public static void eliminarCita(){
        System.out.println("Ingrese su número de cédula: ");
        String c = sc.nextLine();
        
        for (Cliente cl: Main.clientes){
            String cedulaComprobar = cl.getCedulaR();
            
            if(cedulaComprobar.equals(c)){

                for(Cita ci: cl.getCitasCliente()){
                    System.out.println("¿Desea eliminar esta cita? Y/N");
                    ci.toString();
                    String comp = sc.nextLine();
                
                    if(comp.equals("Y")){
                        ci = null;
                    }
                }    
            }
        }
    }
    /**
     * Consulta las citas que existen pidiendo una fecha y una hora
     */
    public static void consultarCitasPorFecha(){
        if (citas.size() == 0){
            System.out.println("[ERROR] No existe ninguna citas registrada, por favor, registre alguna\n");
        }
        else{
            System.out.println("Ingrese fecha a consultar con el formato YYYY/MM/DD (Ejemplo: 2022-01-04): ");
            String fecha_i = sc.nextLine();
            LocalDate fecha=LocalDate.parse(fecha_i);
            ArrayList <Cita> citasFecha= new ArrayList<>();
        
            for(Cita c: citas ){
                if (c.getFecha().equals(fecha)){
                    citasFecha.add(c);
                }}

            if(citasFecha.size()>0){        
                for(Cita ci: citasFecha){
                    System.out.println(ci);
                }
                } else{
                    System.out.println("[ERROR] No existe ninguna cita en esa fecha\n");
            }
            }}
    

    public static void agregarCita (){
        System.out.println("Ingrese fecha de la cita con el formato YYYY-MM-DD (Ejemplo: 2022-01-04): ");
        String fecha_Cita = sc.nextLine();
        LocalDate local_date = LocalDate.parse(fecha_Cita);

        System.out.println("Ingrese la hora de la cita con el formato HH:MM:SS ");
        String hora = sc.nextLine();
        LocalTime t = null;
        try{
            t = LocalTime.parse(hora);
        } catch (DateTimeParseException e){
            System.out.print("[ERROR] Ingrese la hora en el formato HH:MM:SS ");
        }


        System.out.println("Seleccione el servicio: ");
        Servicio.mostrarServicios();
        int opcion = Main.pedirNumero();
        Servicio servicio = Main.servicios.get(opcion-1);

        System.out.println("Seleccione el cliente: ");
        Cliente.mostrarClientes();
        opcion = Main.pedirNumero();
        Cliente cliente = Main.clientes.get(opcion-1);
        

        System.out.println("Seleccione el empleado: ");
        Empleado.mostrarEmpleados();
        opcion = Main.pedirNumero();
        Empleado empleado = Main.empleados.get(opcion-1);
        cliente.getCitasCliente().add(new Cita(local_date, hora, servicio, empleado));


        if(local_date == null || t == null) {
            System.out.print("\n[ERROR] No se creó la cita, errores ocurrieron.\n");
        } else if (!servicio.getEstado()) {
            System.out.print("\n[ERROR] El servicio seleccionado no está disponible por el momento.\n");
        } else if (empleado.getEstado()==false) {
            System.out.print("\n[ERROR] El empleado seleccionado no está disponible por el momento.\n");
        }
        else {
            comprobarCita(local_date, t, servicio, cliente, empleado);
        }
    }

    
    //Getters & Setters
    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Empleado getProovedor(){
        return this.proovedor;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public static ArrayList<Cita> getCitas(){
        return citas;
    }
    
    public Cliente getCliente(){
        return cliente;
    }

    public Servicio getServicio(){
        return servicio;
    }


    //ToString de Cita
    public String toString(){
        return "Cliente: " + this.cliente.getNombre() + "\n Proovedor: " + this.proovedor.getNombre() + " Servicio: " + this.servicio +"\n Hora: " + this.hora+"\n";
    }


}
