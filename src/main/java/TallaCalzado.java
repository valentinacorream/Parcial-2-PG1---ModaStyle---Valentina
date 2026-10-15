public class TallaCalzado extends Talla{
    private int numero;

    public TallaCalzado(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String mostrarTalla() {
        return "Talla de calzado: "+numero;
    }
}
