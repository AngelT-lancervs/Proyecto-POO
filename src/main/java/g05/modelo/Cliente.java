package g05.modelo;
import java.io.*;
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
     * @param cedula   Cedula del cliente
     * @param email    Email del cliente
     * @param telefono Telefono del Cliente
     * @param dts_re   Datos del representante del Cliente
     */
    public Cliente(String nombre, String cedula, String email, String telefono,String dts_re) {
        super(nombre, cedula, telefono, email);
        this.datos_del_representante = dts_re;
    }

    /**
     * Muestra por pantalla los datos del cliente
     */
    public String toString() {
        return super.toString() + " Datos del representante: " + datos_del_representante;
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

    public static ArrayList<Cliente> cargarClientes(String pathClientes) {

        ArrayList<Cliente> clientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(pathClientes))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] parametros = linea.split(",");
                Cliente cliente = new Cliente(parametros[0], parametros[1], parametros[2], parametros[3], parametros[4]);
                clientes.add(cliente);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public static void actualizarCSV(String pathCSV, ArrayList<Cliente> clientesActualizado){
        try(BufferedWriter br = new BufferedWriter(new FileWriter(pathCSV, false))){
            for (Cliente c : clientesActualizado){
                br.write(c.getNombre()+","+c.getCedula()+","+c.getEmail()+","+c.getTelefono()+","+c.getDatos_del_representante());
                br.newLine();
                br.write("");
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    //Getters y setters
    public String getCedulaR() {
        return this.cedula;
    }

    public ArrayList<Cita> getCitasCliente() {
        return this.citasCliente;
    }

    public void setDatos_del_representante(String datos_del_representante) {
        this.datos_del_representante = datos_del_representante;
    }

    public String getDatos_del_representante() {
        return datos_del_representante;
    }

}