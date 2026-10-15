public class Inventario {
    private String color;
    private int cantidadDisponible;

    public Inventario(String color, int cantidadDisponible) {
        this.color = color;
        this.cantidadDisponible = cantidadDisponible;
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
}
