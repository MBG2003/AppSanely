package aplicacion.utility;

public enum SeleccioneUnaOpcion {
    SELECCIONE_UNA_OPCION("Seleccione una opción...");

    private String tipo;

    private SeleccioneUnaOpcion(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

}
