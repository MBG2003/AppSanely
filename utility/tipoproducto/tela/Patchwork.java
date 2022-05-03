package aplicacion.utility.tipoproducto.tela;

import java.util.*;

public enum Patchwork {
    DIARIO("Diario"),
    NAVIDAD("Navidad");
    
    private String tipo;
    
    private Patchwork(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     *
     * @return Retorna una lista con los valores del enum
     */
    public static List<String> listar() {
        List<String> lista = new ArrayList<>();
        for (int i = 0; i < Patchwork.values().length; i++) {
            lista.add(Patchwork.values()[i].tipo);
        }
        return lista;
    }
}
