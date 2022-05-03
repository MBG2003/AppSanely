package aplicacion.utility.tipoproducto;

import java.util.*;

public enum OtrasTecnicas {
    CASCARA_HUEVO("Cáscara de huevo"),
    DECO_FIESTAS("Decoración de fiestas"),
    DECOUPAGE("Decoupage"),
    ECOLINES_PIROGRABADO("Ecolines y Pirograbado"),
    PINCELADA("Pincelada"),
    PUNTILLISMO("Puntillismo"),
    STENCILS("Stencil's"),
    TEXTURAS("Texturas"),
    VELONES("Velones");

    private String tipo;

    private OtrasTecnicas(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     *
     * @return Retorna una lista con los valores del enum
     */
    public static List<String> listar() {
        List<String> lista = new ArrayList<>();
        for (int i = 0; i < OtrasTecnicas.values().length; i++) {
            lista.add(OtrasTecnicas.values()[i].tipo);
        }
        return lista;
    }
}
