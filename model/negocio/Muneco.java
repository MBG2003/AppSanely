package aplicacion.model.negocio;

public class Muneco {

    private String codigo;
    private Molde molde;

    public Muneco(String codigo, Molde molde) {
        this.codigo = codigo;
        this.molde = molde;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Molde getMolde() {
        return molde;
    }

    public void setMolde(Molde molde) {
        this.molde = molde;
    }

}
