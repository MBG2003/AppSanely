package aplicacion.utility.tipoproducto.tela;

import java.util.*;

public enum Munequeria {
    OTROS("Otros"),
    COSTURA("Costura"),
    IMANES_NEVERA("Imanes nevera"),
    CARAS_FACC("Caras faccionadas"),
    ANIMALES("Animales"),
    BRUJAS("Brujas"),
    ESPANTAPAJAROS("Espantapajaros"),
    MUNECAS("Muñecas"),
    PAYASO("Payaso"),
    NAVIDAD("Navidad");
    
    private String tipo;
    
    private Munequeria(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     *
     * @return Retorna una lista con los valores del enum
     */
    public static List<String> listar() {
        List<String> lista = new ArrayList<>();
        for (int i = 0; i < Munequeria.values().length; i++) {
            lista.add(Munequeria.values()[i].tipo);
        }
        return lista;
    }
}
