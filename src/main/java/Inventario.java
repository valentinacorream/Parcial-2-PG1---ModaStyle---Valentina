import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private String color;
    private int cantidadDisponible;

    //Lista
    private List<DetalleVenta> listaDetalleVentas;

    public Inventario(String color, int cantidadDisponible) {
        this.color = color;
        this.cantidadDisponible = cantidadDisponible;

        listaDetalleVentas= new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public List<DetalleVenta> getListaDetalleVentas() {
        return listaDetalleVentas;
    }

    public void setListaDetalleVentas(List<DetalleVenta> listaDetalleVentas) {
        this.listaDetalleVentas = listaDetalleVentas;
    }

    @Override
    public String toString() {
        return "Inventario" +
                "\nColor:" + color +
                ", Cantidad Disponible: " + cantidadDisponible+
                ", Lista detalle de venta: "+listaDetalleVentas;
    }
}
