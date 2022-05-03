package aplicacion.utility;

public enum Tema {
    DIARIO("Diario"), NAVIDAD("Navidad"), HALLOWEEN("Halloween");
    
    private String tipo;

    private Tema(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
