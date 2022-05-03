package aplicacion.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Empleado extends Persona {

    private int idEmpleado;
    private boolean admin;
    private String userName;
    private String password;
    private String cargo;
    private Date fechaIngreso;
    private double sueldo;

    public Empleado() {

    }

    public Empleado(String documento) {
        super(documento);
    }

    public Empleado(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Empleado(boolean admin, String userName, String password, String cargo, Date fechaIngreso, double sueldo, String documento, String nombre, String telFijo, String telMovil, String direccion, String correo, Date fechaNacimiento) {
        super(documento, nombre, telFijo, telMovil, direccion, correo, fechaNacimiento);
        this.admin = admin;
        this.userName = userName;
        this.password = password;
        this.cargo = cargo;
        this.fechaIngreso = fechaIngreso;
        this.sueldo = sueldo;
    }

    public Empleado(int idEmpleado, boolean admin, String userName, String password, String cargo, Date fechaIngreso, double sueldo, String documento, String nombre, String telFijo, String telMovil, String direccion, String correo, Date fechaNacimiento) {
        super(documento, nombre, telFijo, telMovil, direccion, correo, fechaNacimiento);
        this.idEmpleado = idEmpleado;
        this.admin = admin;
        this.userName = userName;
        this.password = password;
        this.cargo = cargo;
        this.fechaIngreso = fechaIngreso;
        this.sueldo = sueldo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
        if(fechaIngreso == null){
            return admin + ", " + userName + ", " + password + ", " + super.toString() + ", " + cargo + ", " + sueldo;
        }
        
        return admin + ", " + userName + ", " + password + ", " + super.toString() + ", " + cargo + ", " + formato.format(fechaIngreso) + ", " + sueldo;
    }
    
    
}
