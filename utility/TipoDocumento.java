package aplicacion.utility;

public enum TipoDocumento {
    INFORME("Informe"), REPORTE("Reporte");

    private String tipo;

    private TipoDocumento(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
