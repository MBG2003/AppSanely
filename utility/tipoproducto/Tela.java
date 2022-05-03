package aplicacion.utility.tipoproducto;

import java.util.*;

public enum Tela {
    BORDADOS("Bordados"),
    MUNEQUERIA("Muñequería"),
    PATCHWORK("Patchwork"),
    PINTURA_TELA("Pintura en tela"),
    TENDIDOS("Tendidos");
    
    private String tipo;
    
    private Tela(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     *
     * @return Retorna una lista con los valores del enum
     */
    public static List<String> listar() {
        List<String> lista = new ArrayList<>();
        for (int i = 0; i < Tela.values().length; i++) {
            lista.add(Tela.values()[i].tipo);
        }
        return lista;
    }
}
