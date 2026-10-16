public class DetalleVenta {
    private int cantidad;
    private double precioUniFinal;
    private double subtotal;

    private Inventario inventario;

    public DetalleVenta(int cantidad, double precioUniFinal, double subtotal, Inventario inventario) {
        this.cantidad = cantidad;
        this.precioUniFinal = precioUniFinal;
        this.subtotal = subtotal;
        this.inventario = inventario;
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

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    @Override
    public String toString() {
        return "DetalleVenta" +
                "\nPrenda: "+inventario.getPrenda().getNombre()+
                ", Talla: "+inventario.getTalla().mostrarTalla()+
                ", Color: "+ inventario.getColor()+
                ", Cantidad: " + cantidad +
                ", Precio Unitario Final: " + precioUniFinal +
                ", Subtotal: " + subtotal;
    }

    //Calcular subtotal
    public double calcularSubtotal() {
        subtotal = cantidad * precioUniFinal;
        return subtotal;
    }

    //Calcular precio unitario final
    public double calcularPrecioFinal(Prenda prenda, Cliente cliente) {
        double precioConRecargo = prenda.calcularPrecio();
        double descuento = cliente.getCategoriaCliente().getDescuento();
        precioUniFinal = precioConRecargo - (precioConRecargo * descuento);
        return precioUniFinal;
    }
}
