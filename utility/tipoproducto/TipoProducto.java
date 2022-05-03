package aplicacion.utility.tipoproducto;

import java.util.*;

public enum TipoProducto {
    COUNTRY("Country"),
    MADERA("Madera"),
    NINOS("Niños"),
    PAPEL("Papel"),
    PUNTO_CRUZ("Punto de cruz"),
    TELA("Tela"),
    OTRA_TECNICA("Otras técnicas");

    private String tipo;

    private TipoProducto(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    /**
     *
     * @return Retorna una lista con los valores del enum
     */
    public static List<String> listar() {
        List<String> lista = new ArrayList<>();
        for (int i = 0; i < TipoProducto.values().length; i++) {
            lista.add(TipoProducto.values()[i].tipo);
        }
        return lista;
    }
}
