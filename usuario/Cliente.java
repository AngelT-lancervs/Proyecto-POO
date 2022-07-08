package usuario;

public class Cliente extends Usuario {
    private String datos_del_representante;
    private final String cedula;	
    public Cliente(String nombre,String telefono,String email,String cedula,String dts_re){
        super(nombre, telefono, email);
        this.cedula=cedula;
        this.datos_del_representante = dts_re;
    }
}
