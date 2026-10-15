import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona{
    private String codigoAfiliacion;

    private CategoriaCliente categoriaCliente;

    //Lista
    private List<Venta> listaVentas;

    public Cliente(int documento, String nombre, String correo, int telefono, String codigoAfiliacion, CategoriaCliente categoriaCliente) {
        super(documento, nombre, correo, telefono);
        this.codigoAfiliacion = codigoAfiliacion;
        this.categoriaCliente = categoriaCliente;

        listaVentas= new ArrayList<>();
    }

    public String getCodigoAfiliacion() {
        return codigoAfiliacion;
    }

    public void setCodigoAfiliacion(String codigoAfiliacion) {
        this.codigoAfiliacion = codigoAfiliacion;
    }

    public CategoriaCliente getCategoriaCliente() {
        return categoriaCliente;
    }

    public void setCategoriaCliente(CategoriaCliente categoriaCliente) {
        this.categoriaCliente = categoriaCliente;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    @Override
    public String mostrarDatos() {
        return "Cliente: "+getNombre()+
                "\nDocumento: "+getDocumento()+
                ", Correo: "+getCorreo()+
                ", Teléfono: "+getTelefono()+
                ", Código de afiliación: "+codigoAfiliacion+
                ", Categoría del cliente: "+categoriaCliente+
                ", Lista de ventas: "+listaVentas;
    }
}
