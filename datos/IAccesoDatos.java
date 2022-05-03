package aplicacion.datos;

import java.util.*;

public interface IAccesoDatos {
    
    public boolean existe(String ruta);
    
    public void crear(String ruta);
    
    public void escribir(String ruta, String contenido, boolean anexar);
    
    public List listar(String ruta);
    
    public void borrarArchivo(String ruta);
    
    public void actualizarInfo(String ruta, List lista, String buscar);
    
    public void cargarDatos(String ruta);
}
