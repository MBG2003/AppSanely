package aplicacion.model;

import java.util.Date;

public class Cliente extends Persona {

    private String pais;

    public Cliente() {

    }

    public Cliente(String pais, String documento, String nombre, String telFijo, String telMovil, String direccion, String correo, Date fechaNacimiento) {
        super(documento, nombre, telFijo, telMovil, direccion, correo, fechaNacimiento);
        this.pais = pais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + pais;
    }
}
