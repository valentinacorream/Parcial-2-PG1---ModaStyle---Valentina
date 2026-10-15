public class Cliente extends Persona{
    private String codigoAfiliacion;

    public Cliente(int documento, String nombre, String correo, int telefono, String codigoAfiliacion) {
        super(documento, nombre, correo, telefono);
        this.codigoAfiliacion = codigoAfiliacion;
    }

    public String getCodigoAfiliacion() {
        return codigoAfiliacion;
    }

    public void setCodigoAfiliacion(String codigoAfiliacion) {
        this.codigoAfiliacion = codigoAfiliacion;
    }

    @Override
    public String mostrarDatos() {
        return "Cliente: "+getNombre()+
                "\nDocumento: "+getDocumento()+
                ", Correo: "+getCorreo()+
                ", Teléfono: "+getTelefono()+
                ", Código de afiliación: "+codigoAfiliacion;
    }
}
