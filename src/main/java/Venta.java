import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    private String codigo;
    private LocalDate fecha;

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

    @Override
    public String toString() {
        return "Venta" +
                "\nCódigo: " + codigo +
                ", Fecha: " + fecha+
                ", Lista detalle de venta: "+listaDetalleVentas;
    }
}
