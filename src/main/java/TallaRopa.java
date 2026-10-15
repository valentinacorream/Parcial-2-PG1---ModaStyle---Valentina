public class TallaRopa extends Talla{
    private String medida;

    public TallaRopa(String medida) {
        this.medida = medida;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    @Override
    public String mostrarTalla() {
        return medida;
    }
}
