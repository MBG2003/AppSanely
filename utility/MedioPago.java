package aplicacion.utility;

public enum MedioPago {
    CONTADO("Contado"), A_CREDITO("A crédito");

    private String tipo;

    private MedioPago(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

}
