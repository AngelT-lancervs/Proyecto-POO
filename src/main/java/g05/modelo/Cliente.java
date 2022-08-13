package g05.modelo;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



/**
 * Clase Cliente
 * @author Jeremy Poveda
 * @author Angel Tomala
 * @author Paulina Loor
 * @version 16/07/2022
 */
public class Cliente extends Usuario {

    private String datos_del_representante;
    private ArrayList<Cita> citasCliente = new ArrayList<Cita>();


    /**
     * Contructor de la clase Cliente que recibe como parametros el nombre, telefono, email, cedula, datos del representante
     *
     * @param nombre   Nombre del Cliente
     * @param telefono Telefono del Cliente
     * @param email    Email del cliente
     * @param cedula   Cedula del cliente
     * @param dts_re   Datos del representante del Cliente
     */
    public Cliente(String nombre, String cedula, String telefono, String email, String dts_re) {
        super(nombre, cedula, telefono, email);
        this.datos_del_representante = dts_re;
        Sistema.clientes.add(this);
    }

    /**
     * Muestra por pantalla los datos del cliente
     */
    public String toString() {
        return super.toString() + " Datos del representante: " + datos_del_representante;
    }

    /**
     * Muestra los clientes registrados en el Centro
     */
    public static void mostrarClientes() {
        int count = 0; // Contador para índices
        for (Cliente c : Sistema.clientes) {
            count++;
            System.out.println(count + ". " + c);
        }
    }

    /**
     * Menu de la opcion Cliente
     */
    public static void mostrarMenu() {
        System.out.print("\n-----[Menú/Cliente]-----\n");
        System.out.print("1. Agregar cliente\n");
        System.out.print("2. Editar cliente\n");
        System.out.print("3. Atrás\n");
    }


    /**
     * Metodo que compara las cedulas
     */
    @Override
    public boolean equals(Object obj) {
        if (this.cedula == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Cliente other = (Cliente) obj;
            return (super.cedula.equals(other.cedula));
        }
        return false;
    }

    /**
     * Método que permite editar la información del cliente
     * @param sc
     */
    public void editarCliente(Scanner sc) {
        System.out.print("-----[Menú/Cliente/Editar]-----\n");
        System.out.print("1.Nombre \n2.Telefono \n3.Email \n4.Datos representante \n");
        int opcion = Sistema.pedirNumero();
        switch (opcion) {
            case 1:
                System.out.print("\nIngrese el nuevo nombre: ");
                String newNombre = sc.nextLine();
                this.nombre = newNombre;
                break;
            case 2:
                System.out.print("\nIngrese el nuevo telefono: ");
                String newTelefono = sc.nextLine();
                this.telefono = newTelefono;
                break;
            case 3:
                System.out.print("\nIngrese el nuevo email: ");
                String newEmail = sc.nextLine();
                this.email = newEmail;
                break;
            case 4:
                System.out.print("\nIngrese los nuevos datos del representante: ");
                String newD_Representante = sc.nextLine();
                this.datos_del_representante = newD_Representante;
                break;
            default:
                System.out.print("Ingrese una opción válida.");
        }
    }

    /**
     * Metodo que permite agregar Clientes al sistema
     */
    public static void agregarCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese nombre del usuario: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el número de cédula del usuario: ");
        String cedula = sc.nextLine();
        System.out.println("Ingrese número telefónico del usuario: ");
        String telefono = sc.nextLine();
        System.out.println("Ingrese correo del usuario: ");
        String correo = sc.nextLine();
        System.out.println("Ingrese los datos del representante del usuario: ");
        String datosRepresentante = sc.nextLine();
        Cliente cl = new Cliente(nombre, cedula, telefono, correo, datosRepresentante);

    }
    /**
     * Metodo utilizado para buscar clientes por cedula
     * @param ced
     * @return
     */
    public static Cliente buscarPorCedulaCliente(String ced) {
        Cliente clienteEncontrado = null;
        for (Cliente cl : Sistema.clientes) {
            if (cl.getCedulaR().equals(ced)) {
                clienteEncontrado = cl;
            }
        }
        return clienteEncontrado;
    }

    /**
     * Metodo que muestra las citas pendientes
     */
    public void mostrarCitasPendientes(){
        System.out.print("---Citas pendientes---\n");
        int count = 0;
        for (Cita c : this.getCitasCliente()){
            count++;
            System.out.println(count+". "+c);
        }
    }


    //Getters y setters
    public String getCedulaR(){
        return this.cedula;
    }

    public ArrayList<Cita> getCitasCliente(){
        return this.citasCliente;
    }

    public String getDatos_del_representante() {
        return datos_del_representante;
    }

    public static ArrayList<Cliente> cargarClientes(String pathClientes){

        ArrayList<Cliente> clientes=new ArrayList<>();
        try(BufferedReader lectura=new BufferedReader(new FileReader(pathClientes))){
            String linea;
            while((linea=lectura.readLine())!=null){
                String[] datos=linea.split(",");
                Cliente cliente=new Cliente(datos[0], datos[1], datos[2],datos[3], datos[4]);
                clientes.add(cliente);}}
        catch(FileNotFoundException ex){
            ex.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        return clientes;}}