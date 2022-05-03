package aplicacion.utility.tipoproducto.tela.munequeria;

import java.util.*;

public enum Navidad {
    DE_PIE("De pie"),
    SENTADOS("Sentados"),
    ACOSTADOS("Acostados"),
    COLGADOS("Colgados"),
    VARIOS("Muñecos varios"),
    IMANES_NEVERA("Imanes nevera"),
    BORDADOS("Bordados"),
    CUADROS("Cuadros");
    
    private String tipo;
    
    private Navidad(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     *
     * @return Retorna una lista con los valores del enum
     */
    public static List<String> listar() {
        List<String> lista = new ArrayList<>();
        for (int i = 0; i < Navidad.values().length; i++) {
            lista.add(Navidad.values()[i].tipo);
        }
        return lista;
    }
}
