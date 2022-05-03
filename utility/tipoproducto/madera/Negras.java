package aplicacion.utility.tipoproducto.madera;

import java.util.*;

public enum Negras {
    AFRICANAS("Africanas"),
    CALADAS("Caladas"),
    PALENQUERA("Palenquera"),
    TEXTURA("Textura"),
    ZULU("Zulú"),
    MASAI("Masai"),
    BAILARINAS("Bailarinas");
    
    private String tipo;
    
    private Negras(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     *
     * @return Retorna una lista con los valores del enum
     */
    public static List<String> listar() {
        List<String> lista = new ArrayList<>();
        for (int i = 0; i < Negras.values().length; i++) {
            lista.add(Negras.values()[i].tipo);
        }
        return lista;
    }
}
