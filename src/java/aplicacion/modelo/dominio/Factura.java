/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.dominio;

/**
 *
 * @author LILI-PC
 */
public class Factura {

    private int id;    
    private int numeroDeServicio;
    private int numeroDeFactura;
    private String domicilio;
    private double importe;
    private String titularFactura;

    public Factura() {
    }

    public Factura(int id,int numeroDeServicio, int numeroDeFactura, String domicilio, double importe) {
        this.id=id;
        this.numeroDeServicio = numeroDeServicio;
        this.numeroDeFactura = numeroDeFactura;
        this.domicilio = domicilio;
        this.importe = importe;
    }

    public Factura(int i, int i0, int i1, String los_Pinos_N331_BAlto_Palpalá, int i2, String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getNumeroDeServicio() {
        return numeroDeServicio;
    }

    public void setNumeroDeServicio(int numeroDeServicio) {
        this.numeroDeServicio = numeroDeServicio;
    }

    public int getNumeroDeFactura() {
        return numeroDeFactura;
    }

    public void setNumeroDeFactura(int numeroDeFactura) {
        this.numeroDeFactura = numeroDeFactura;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getTitularFactura() {
        return titularFactura;
    }

    public void setTitularFactura(String titularFactura) {
        this.titularFactura = titularFactura;
    }
    
   
}
