package aplicacion.model.negocio;

import javafx.scene.image.Image;

public class Producto {

    private int idProd;
    private String codigo;
    private String nombre;
    private String autor;
    private String caract;
    private String tipoProd;
    private String subTipo1;
    private String subTipo2;
    private String subTipo3;
    private String disp;
    private Image foto;
    private int cant;
    private double valor;
    
    public Producto() {
        
    }

    public Producto(int idProd, String codigo, String nombre, String autor, String caract, String tipoProd, String subTipo1, String subTipo2, String subTipo3, String disp, Image foto, int cant, double valor) {
        this.idProd = idProd;
        this.codigo = codigo;
        this.nombre = nombre;
        this.autor = autor;
        this.caract = caract;
        this.tipoProd = tipoProd;
        this.subTipo1 = subTipo1;
        this.subTipo2 = subTipo2;
        this.subTipo3 = subTipo3;
        this.disp = disp;
        this.foto = foto;
        this.cant = cant;
        this.valor = valor;
    }
    
    public Producto(String codigo, String nombre, String autor, String caract, String tipoProd, String disp, int cant, double valor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.autor = autor;
        this.caract = caract;
        this.tipoProd = tipoProd;
        this.disp = disp;
        this.cant = cant;
        this.valor = valor;
    }

    public Producto(String codigo, String nombre, String autor, String caract, String tipoProd, String subTipo1, String disp, int cant, double valor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.autor = autor;
        this.caract = caract;
        this.tipoProd = tipoProd;
        this.subTipo1 = subTipo1;
        this.disp = disp;
        this.cant = cant;
        this.valor = valor;
    }

    public Producto(String codigo, String nombre, String autor, String caract, String tipoProd, String subTipo1, String subTipo2, String disp, int cant, double valor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.autor = autor;
        this.caract = caract;
        this.tipoProd = tipoProd;
        this.subTipo1 = subTipo1;
        this.subTipo2 = subTipo2;
        this.disp = disp;
        this.cant = cant;
        this.valor = valor;
    }

    public Producto(String codigo, String nombre, String autor, String caract, String tipoProd, String subTipo1, String subTipo2, String subTipo3, String disp, int cant, double valor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.autor = autor;
        this.caract = caract;
        this.tipoProd = tipoProd;
        this.subTipo1 = subTipo1;
        this.subTipo2 = subTipo2;
        this.subTipo3 = subTipo3;
        this.disp = disp;
        this.cant = cant;
        this.valor = valor;
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCaract() {
        return caract;
    }

    public void setCaract(String caract) {
        this.caract = caract;
    }

    public String getTipoProd() {
        return tipoProd;
    }

    public void setTipoProd(String tipoProd) {
        this.tipoProd = tipoProd;
    }

    public String getSubTipo1() {
        return subTipo1;
    }

    public void setSubTipo1(String subTipo1) {
        this.subTipo1 = subTipo1;
    }

    public String getSubTipo2() {
        return subTipo2;
    }

    public void setSubTipo2(String subTipo2) {
        this.subTipo2 = subTipo2;
    }

    public String getSubTipo3() {
        return subTipo3;
    }

    public void setSubTipo3(String subTipo3) {
        this.subTipo3 = subTipo3;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }
    
    public String getDisp() {
        return disp;
    }

    public void setDisp(String disp) {
        this.disp = disp;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
