package aplicacion.utility;

public enum Meses {
    ENERO("Enero"), FEBRERO("Febrero"), MARZO("Marzo"), ABRIL("Abril"), MAYO("Mayo"), JUNIO("Junio"), JULIO("Juilo"), AGOSTO("Agosto"), SEPTIEMBRE("Septiembre"), OCTUBRE("Octubre"), NOVIEMBRE("Noviembre"), DICIEMBRE("Diciembre");
    
    private String tipo;

    private Meses(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
