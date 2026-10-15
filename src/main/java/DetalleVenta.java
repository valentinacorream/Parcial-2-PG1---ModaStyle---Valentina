public class DetalleVenta {
    private int cantidad;
    private double precioUniFinal;
    private double subtotal;

    public DetalleVenta(int cantidad, double precioUniFinal, double subtotal) {
        this.cantidad = cantidad;
        this.precioUniFinal = precioUniFinal;
        this.subtotal = subtotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUniFinal() {
        return precioUniFinal;
    }

    public void setPrecioUniFinal(double precioUniFinal) {
        this.precioUniFinal = precioUniFinal;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "DetalleVenta" +
                "Cantidad: " + cantidad +
                ", Precio Unitario Final: " + precioUniFinal +
                ", Subtotal: " + subtotal;
    }
}
