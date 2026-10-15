import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Persona{
    private String codigoEmpleado;
    private LocalDate fechaContrato;
    private double salario;

    //Lista
    private List<Venta> listaVentas;

    public Vendedor(int documento, String nombre, String correo, int telefono, String codigoEmpleado, LocalDate fechaContrato, double salario) {
        super(documento, nombre, correo, telefono);
        this.codigoEmpleado = codigoEmpleado;
        this.fechaContrato = fechaContrato;
        this.salario = salario;

        listaVentas= new ArrayList<>();
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public LocalDate getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(LocalDate fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    @Override
    public String mostrarDatos() {
        return "Empleado: "+getNombre()+
                "\nDocumento: "+getDocumento()+
                ", Correo: "+getCorreo()+
                ", Teléfono: "+getTelefono()+
                ", Código de Empleado: "+codigoEmpleado+
                ", Fecha de contratación: "+fechaContrato+
                ", Salario: "+salario+
                ", Lista de ventas: "+listaVentas;
    }
}
