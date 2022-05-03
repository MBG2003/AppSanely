package aplicacion.utility;

import java.util.*;

public enum TipoPersona {
    
    CLIENTE("Cliente"), EMPLEADO("Empleado"), ADMINISTRADOR("Administrador");
    
    private String tipo;

    private TipoPersona(String tipo) {
        this.tipo = tipo;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public static List<String> listar(){
        List<String> lista = new ArrayList();
        for (int i = 0; i < TipoPersona.values().length; i++) {
            lista.add(TipoPersona.values()[i].tipo);
        }
        return lista;
    }
}
