package aplicacion.utility.tipoproducto;

import java.util.*;

public enum Ninos {
    DINOSAURIOS("Dinosaurios"),
    CARS("Cars"),
    OPEN_SEASON("Open Season"),
    BICHOS("Bichos"),
    FOFUCHAS("Fofuchas"),
    PLASTILINA("Plastilina");
    
    private String tipo;
    
    private Ninos(String tipo){
        this.tipo = tipo;
    }
    
    /**
     *
     * @return Retorna una lista con los valores del enum
     */
    public static List<String> listar() {
        List<String> lista = new ArrayList<>();
        for (int i = 0; i < Ninos.values().length; i++) {
            lista.add(Ninos.values()[i].tipo);
        }
        return lista;
    }
}
