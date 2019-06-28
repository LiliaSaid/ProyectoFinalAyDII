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
public class factura {

    private int numeroDeServicio;
    private int numeroDeFactura;
    private String domicilio;
    private double importe;

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
    
   
}
