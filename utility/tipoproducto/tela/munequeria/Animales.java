package aplicacion.utility.tipoproducto.tela.munequeria;

import java.util.*;

public enum Animales {
    CONEJOS("Conejos"),
    GALLINAS("Gallinas"),
    GATOS("Gatos"),
    JIRAFAS("Jirafas"),
    OSOS("Osos"),
    VACAS("Vacas"),
    VARIOS("Varios");
    
    private String tipo;
    
    private Animales(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     *
     * @return Retorna una lista con los valores del enum
     */
    public static List<String> listar() {
        List<String> lista = new ArrayList<>();
        for (int i = 0; i < Animales.values().length; i++) {
            lista.add(Animales.values()[i].tipo);
        }
        return lista;
    }
}
