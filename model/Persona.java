package aplicacion.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Persona {

    protected String documento;
    protected String nombre;
    protected String telFijo;
    protected String telMovil;
    protected String direccion;
    protected String correo;
    protected Date fechaNacimiento;

    public Persona() {

    }

    public Persona(String documento) {
        this.documento = documento;
    }

    public Persona(String documento, String nombre, String telFijo, String telMovil, String direccion, String correo, Date fechaNacimiento) {
        this.documento = documento;
        this.nombre = nombre;
        this.telFijo = telFijo;
        this.telMovil = telMovil;
        this.direccion = direccion;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelFijo() {
        return telFijo;
    }

    public void setTelFijo(String telFijo) {
        this.telFijo = telFijo;
    }

    public String getTelMovil() {
        return telMovil;
    }

    public void setTelMovil(String telMovil) {
        this.telMovil = telMovil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
        if(fechaNacimiento == null){
            return documento + ", " + nombre + ", " + telFijo + ", " + telMovil + ", " + direccion + ", " + correo;
        }
        return documento + ", " + nombre + ", " + telFijo + ", " + telMovil + ", " + direccion + ", " + correo + ", " + formato.format(fechaNacimiento);
    }

}
