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
        System.out.print("4. Atras\n");
    }

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
            citas.add(cita1);//Registramos la cita en el sistema.
            c_nuevaC.getCitasCliente().add(cita1); //Registramos en las citas pendientes del cliente.
            p_nuevaC.getCitasEmpleado().add(cita1); //Registramos en las citas pendientes del empleado.
            System.out.print("\n¡Se creó la cita correctamente!\n");
        }
        else {

            for(Cita c : citas){
                LocalDate f = c.getFecha();
                LocalTime h = c.getHora();
                Empleado p = c.getProovedor();

                if(!(f_nuevaC.equals(f) && h_nuevaC.equals(h) && p_nuevaC.equals(p))){ // Comprueba si existe otra cita con el mismo empleado a la misma fecha y hora.
                    citas.add(cita1); //Registramos la cita en el sistema.
                    c_nuevaC.getCitasCliente().add(cita1); //Registramos en las citas pendientes del cliente.
                    System.out.print("¡Se creó la cita correctamente !\n");
                    break;
                }
                else{
                    System.out.println("[ERROR] No está disponible una cita en esa fecha y hora con "+p_nuevaC.getNombre()+".\n");
                }
            }
        }
    }

    public static ArrayList<Cita> buscarCitasPorCedulaCliente(String ced) {
        Cliente clienteEncontrado = null;
        if(citas.size() != 0){
            for(Cliente c : Main.clientes) {
                if(c.getCedulaR().equals(ced)) {
                    clienteEncontrado = c;
                }
            }
            if (clienteEncontrado == null){
                System.out.print("[ERROR] El cliente no está registrado.\n");
                return null;
            } else if (clienteEncontrado.getCitasCliente().size() == 0){
                System.out.print("[AVISO] El cliente no tiene citas pendientes.\n");
                return null;
            }
            return clienteEncontrado.getCitasCliente();
        } else {
          System.out.print("[ERROR] No existe ninguna cita registrada, por favor, registre alguna.\n");
          return null;
        }
    }

    public static LocalDate pedirFecha(Scanner sc){
        LocalDate d = null; // Variable de la fecha.

        while(d == null) { //Comprueba que la fecha se escriba correctamente.
            try {
                System.out.print("\nIngrese fecha de la cita con el formato YYYY-MM-DD (Ejemplo: 2022-01-04): ");
                String fecha_Cita = sc.nextLine();
                d = LocalDate.parse(fecha_Cita);
            } catch (DateTimeParseException e) {
                System.out.print("\n[ERROR] Se ingresó la fecha incorrectamente. (Formato -> YYYY-MM-DD)\n");
                d = null;
            }
        }
        return d;
    }
    public static LocalTime pedirHora(Scanner sc){
        LocalTime t = null; // Variable de la hora.
        while(t == null) { //Comprueba que la hora se escriba correctamente.
            try{
                System.out.print("\nIngrese la hora de la cita con el formato HH:MM:SS ");
                String hora_Cita = sc.nextLine();
                t = LocalTime.parse(hora_Cita);
            } catch (DateTimeParseException e){
                System.out.print("\n[ERROR] Se ingresó la hora incorrectamente. (Formato -> HH:MM:SS)\n");
                t = null;
            }
        }
        return t;
    }

    /**
     * Elimina una cita usando el número de cédula del Cliente
     */
    public static void eliminarCita(String ced){
        ArrayList<Cita> citasPendientes = buscarCitasPorCedulaCliente(ced);
        if(citasPendientes != null){
            System.out.print("--Citas Pendientes--\n");
            for(int i = 0; i <= citasPendientes.size()-1 ; i++) {
                int count = i + 1;
                System.out.print(count+". "+citasPendientes.get(i)+"\n");
            }
            System.out.print("Seleccione una cita a eliminar: \n");
            int opcion = Main.pedirNumero();
            int indiceCita = 0;
            Cita citaEliminar = citasPendientes.get(opcion-1);
            citasPendientes.remove(opcion-1); // Eliminar la cita de las citas pendientes del cliente.
            for(Cita c : citas){
                if(c.equals(citaEliminar)){
                    indiceCita = citas.indexOf(citaEliminar);
                }
            }
            citas.remove(indiceCita); // Eliminar la cita del sistema.
            System.out.print("¡Cita eliminada!\n");
        }
    }
    /**
     * Consulta las citas que existen pidiendo una fecha y una hora
     */
    public static void consultarCitasPorFecha(Scanner sc) {
        if (citas.size() == 0){
            System.out.print("[ERROR] No existe ninguna cita registrada, por favor, registre alguna.\n");
        }
        else{
            LocalDate fecha = pedirFecha(sc);
            ArrayList <Cita> citasFecha = new ArrayList<>();

            for(Cita c: citas ){
                if (c.getFecha().isEqual(fecha)){
                    citasFecha.add(c);
                }
            }

            if(citasFecha.size()!=0){
                System.out.print("Citas para el día "+fecha+" :\n");
                for(Cita ci: citasFecha){
                    System.out.println(ci);
                }
            } else{
                    System.out.print("\n[ERROR] No existe ninguna cita en esa fecha.\n");
            }
        }
    }
    

    public static void agregarCita (Scanner sc) {
        LocalDate d = pedirFecha(sc);
        LocalTime t = pedirHora(sc);
        System.out.print("Seleccione el servicio: \n");
        Servicio.mostrarServicios();
        int opcion = Main.pedirNumero();
        Servicio n_Servicio = Main.servicios.get(opcion-1);

        System.out.print("Seleccione el cliente: \n");
        Cliente.mostrarClientes();
        opcion = Main.pedirNumero();
        Cliente n_Cliente = Main.clientes.get(opcion-1);

        System.out.print("Seleccione el empleado: \n");
        Empleado.mostrarEmpleados();
        opcion = Main.pedirNumero();
        Empleado n_Empleado = Main.empleados.get(opcion-1);

       if (!n_Servicio.getEstado()) {
           System.out.print("\n[ERROR] El servicio seleccionado no está disponible por el momento.\n");
       } else if (!n_Empleado.getEstado()) {
           System.out.print("\n[ERROR] El empleado seleccionado no está disponible por el momento.\n");
       }
       else {
           comprobarCita(d, t, n_Servicio, n_Cliente, n_Empleado);
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
        return ">> Cliente: " + cliente.getNombre() + " | Proovedor: " + proovedor.getNombre() + " | Servicio: " + servicio.getNombreServicio() +" | Hora: " + hora+ " | Fecha: "+ fecha;
    }
}
