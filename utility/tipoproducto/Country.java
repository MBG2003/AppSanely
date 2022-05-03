package aplicacion.utility.tipoproducto;

import java.util.*;

public enum Country {
    NORMAL("Normal"),
    NORMAL_NAVIDAD("Normal navidad"),
    AMERICANO("Americano"),
    AMERICANO_AGUADAS("Americano Aguadas"),
    AMERICANO_HALLOWEEN("Americano Halloween"),
    AMERICANO_NAVIDAD("Americano navidad");
    
    private String tipo;
    
    private Country(String tipo){
        this.tipo = tipo;
    }
    
    /**
     *
     * @return Retorna una lista con todos los valores del enum
     */
    public static List<String> listar(){
        List<String> lista = new ArrayList<>();
        
        for (int i = 0; i < Country.values().length; i++) {
            lista.add(Country.values()[i].tipo);
        }
        
        return lista;
    }
}
