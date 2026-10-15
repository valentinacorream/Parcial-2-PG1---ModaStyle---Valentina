import java.time.LocalDate;

public class Vendedor extends Persona{
    private String codigoEmpleado;
    private LocalDate fechaContrato;
    private double salario;

    public Vendedor(int documento, String nombre, String correo, int telefono, String codigoEmpleado, LocalDate fechaContrato, double salario) {
        super(documento, nombre, correo, telefono);
        this.codigoEmpleado = codigoEmpleado;
        this.fechaContrato = fechaContrato;
        this.salario = salario;
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

    @Override
    public String mostrarDatos() {
        return "Empleado: "+getNombre()+
                "\nDocumento: "+getDocumento()+
                ", Correo: "+getCorreo()+
                ", Teléfono: "+getTelefono()+
                ", Código de Empleado: "+codigoEmpleado+
                ", Fecha de contratación: "+fechaContrato+
                ", Salario: "+salario;
    }
}
