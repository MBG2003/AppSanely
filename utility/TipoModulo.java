package aplicacion.utility;

public enum TipoModulo {
    CRM("CRM"), FINANZAS("Finanzas"), GERENCIA("Gerencia"), RECURSOS_HUMANOS("Recursos Humanos");

    private String tipo;

    private TipoModulo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

}
