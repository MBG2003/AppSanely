package aplicacion.utility;

public enum Uso {
    COLGADO("Colgado"), PARADO("Parado"), SENTADO("Sentado"), AGACHADO("Agachado"), ACOSTADO("Acostado");
    
    private String tipo;

    private Uso(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
