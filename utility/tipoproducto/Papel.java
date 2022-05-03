package aplicacion.utility.tipoproducto;

import java.util.*;

public enum Papel {
    SCRAP("Scrap"),
    TARJETERIA("Tarjetería");
    
    private String tipo;
    
    private Papel(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     *
     * @return Retorna una lista con los valores del enum
     */
    public static List<String> listar() {
        List<String> lista = new ArrayList<>();
        for (int i = 0; i < Papel.values().length; i++) {
            lista.add(Papel.values()[i].tipo);
        }
        return lista;
    }
}
