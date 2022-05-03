package aplicacion.utility.tipoproducto.tela.munequeria;

import java.util.*;

public enum Munecas {
    ANGELITAS("Angelitas"),
    GRANDES("Grandes"),
    MEDIANAS("Medianas"),
    PEQUENAS("Pequeñas"),
    TIPICAS("Tipicas");
    
    private String tipo;
    
    private Munecas(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     *
     * @return Retorna una lista con los valores del enum
     */
    public static List<String> listar() {
        List<String> lista = new ArrayList<>();
        for (int i = 0; i < Munecas.values().length; i++) {
            lista.add(Munecas.values()[i].tipo);
        }
        return lista;
    }
}
