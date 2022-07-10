package usuario;

public class Cliente extends Usuario {
    private String datos_del_representante;
    private final String cedula;	

    //Constructor de la clase
    public Cliente(String nombre,String telefono,String email,String cedula,String dts_re) {
        super(nombre, telefono, email);
        this.cedula = cedula;
        this.datos_del_representante = dts_re;
    }

    

    //Getters y setters
    public String getDatosR(){
        return this.datos_del_representante;
    }

    public String getCedulaR(){
        return this.cedula;
    }

    public void setDatosR(String texto){
        this.datos_del_representante = texto;
    }


}
