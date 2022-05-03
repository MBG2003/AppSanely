package aplicacion.utility.tipoproducto;

import java.util.*;

public enum Madera {
    PINTURA_DECORATIVA("Pintura decorativa"),
    OLEO("Oleo"),
    CACHARROS("Cacharros"),
    CALADOS("Calados"),
    BATEAS("Bateas"),
    NEGRAS("Negras"),
    LOLITAS("Lolitas");
    
    private String tipo;
    
    private Madera(String tipo){
        this.tipo = tipo;
    }
    
    /**
     *
     * @return Retorna una lista con los valores del enum
     */
    public static List<String> listar() {
        List<String> lista = new ArrayList<>();
        for (int i = 0; i < Madera.values().length; i++) {
            lista.add(Madera.values()[i].tipo);
        }
        return lista;
    }
}
