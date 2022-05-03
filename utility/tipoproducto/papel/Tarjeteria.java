package aplicacion.utility.tipoproducto.papel;

import java.util.*;

public enum Tarjeteria {
    FILIGRANA("Filigrana"),
    TROQUELADA("Troquelada");
    
    private String tipo;
    
    private Tarjeteria(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     *
     * @return Retorna una lista con los valores del enum
     */
    public static List<String> listar() {
        List<String> lista = new ArrayList<>();
        for (int i = 0; i < Tarjeteria.values().length; i++) {
            lista.add(Tarjeteria.values()[i].tipo);
        }
        return lista;
    }
}
