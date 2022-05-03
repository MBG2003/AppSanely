package aplicacion.utility.tipoproducto.madera;

import java.util.*;

public enum Calados {
    DIARIO("Diario"),
    NAVIDAD("Navidad");
    
    private String tipo;
    
    private Calados(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     *
     * @return Retorna una lista con los valores del enum
     */
    public static List<String> listar() {
        List<String> lista = new ArrayList<>();
        for (int i = 0; i < Calados.values().length; i++) {
            lista.add(Calados.values()[i].tipo);
        }
        return lista;
    }
}
