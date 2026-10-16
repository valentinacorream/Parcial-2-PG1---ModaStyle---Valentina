import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private String color;
    private int cantidadDisponible;

    private Prenda prenda;
    private Talla talla;

    //Lista
    private List<DetalleVenta> listaDetalleVentas;

    public Inventario(String color, int cantidadDisponible, Prenda prenda, Talla talla) {
        this.color = color;
        this.cantidadDisponible = cantidadDisponible;
        this.prenda = prenda;
        this.talla = talla;

        listaDetalleVentas = new ArrayList<>();
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

    public Prenda getPrenda() {
        return prenda;
    }

    public void setPrenda(Prenda prenda) {
        this.prenda = prenda;
    }

    public Talla getTalla() {
        return talla;
    }

    public void setTalla(Talla talla) {
        this.talla = talla;
    }

    @Override
    public String toString() {
        return  "Prenda: "+prenda.getNombre()+
                ", Código: "+prenda.getCodigo()+
                ", Talla: "+talla.mostrarTalla()+
                ", Color:" + color +
                ", Cantidad Disponible: " + cantidadDisponible +
                ", Lista detalle de venta: " + listaDetalleVentas;
    }

    //Agregar existencias
    public boolean agregarExistencias(int cantidad) {
        boolean agregado = false;
        if (cantidad > 0) {
            cantidadDisponible += cantidad;
            agregado = true;
        }
        return agregado;
    }

    //Verificar existencias
    public boolean verificarExistencias(int cantidad) {
        boolean disponible = false;
        if (cantidad > 0 && cantidadDisponible >= cantidad) {
            disponible = true;
        }
        return disponible;
    }

    //Descontar existencias
    public boolean descontarExistencias(int cantidad) {
        boolean descontado = false;
        if (verificarExistencias(cantidad) == true) {
            cantidadDisponible -= cantidad;
            descontado = true;
        }
        return descontado;
    }

    //Verificar si está agotado
    public boolean estaAgotado() {
        boolean agotado = false;
        if (cantidadDisponible == 0) {
            agotado = true;
        }
        return agotado;
    }

    //Agregar detalle de venta
    public boolean agregarDetalleVenta(DetalleVenta detalle) {
        boolean agregado = false;
        if (detalle.getCantidad() > 0){
            listaDetalleVentas.add(detalle);
            agregado= true;
        }
        return agregado;
    }
}
