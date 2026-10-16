import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    private String codigo;
    private LocalDate fecha;

    private Cliente cliente;
    private Vendedor vendedor;
    private Sucursal sucursal;

    //Lista
    private List<DetalleVenta> listaDetalleVentas;

    public Venta(String codigo, LocalDate fecha) {
        this.codigo = codigo;
        this.fecha = fecha;

        listaDetalleVentas= new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<DetalleVenta> getListaDetalleVentas() {
        return listaDetalleVentas;
    }

    public void setListaDetalleVentas(List<DetalleVenta> listaDetalleVentas) {
        this.listaDetalleVentas = listaDetalleVentas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        return "Venta" +
                "\nCódigo: " + codigo +
                ", Fecha: " + fecha+
                ", Ciente: "+cliente.getNombre()+
                ", Vendedor: "+vendedor.getNombre()+
                ", Sucursal: "+sucursal.getNombre()+
                ", Lista detalle de venta: "+listaDetalleVentas+
                ", Total: "+calcularTotal();
    }

    //Calcular total de la venta
    public double calcularTotal() {
        double total = 0;
        for (DetalleVenta detalle : listaDetalleVentas) {
            total += detalle.getSubtotal();
        }
        return total;
    }

    //Agregar detalle venta
    public boolean agregarDetalleVenta(DetalleVenta detalle) {
        boolean agregado = false;
        if (detalle.getCantidad() > 0) {
            listaDetalleVentas.add(detalle);
            agregado = true;
        }
        return agregado;
    }
}
