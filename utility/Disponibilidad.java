package aplicacion.utility;

public enum Disponibilidad {
    POR_ENCARGO("Por encargo"), ENTREGA_INMEDIATA("Entrega inmediata");
    
    private String tipo;

    private Disponibilidad(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
