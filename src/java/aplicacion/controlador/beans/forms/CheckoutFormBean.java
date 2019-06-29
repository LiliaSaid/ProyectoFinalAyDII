package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.FacturaBean;
import aplicacion.controlador.beans.PagoBean;
import aplicacion.modelo.dominio.Factura;
import aplicacion.modelo.dominio.Pago;
import aplicacion.modelo.dominio.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class CheckoutFormBean implements Serializable {

    @ManagedProperty(value = "#{facturaBean}")
    private FacturaBean facturaBean;

    @ManagedProperty(value = "#{pagoBean}")
    private PagoBean pagoBean;

    private List<Factura> facturas;
    private double subTotal;

    private String marcaTarjeta;
    private String numeroTarjeta;
    private String titularTarjeta;
    private String vencimientoTarjeta;
    private int codigoTarjeta;

    public CheckoutFormBean() {
        Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        if (usuario == null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
            } catch (IOException ex) {
            }
        }
    }

    @PostConstruct
    public void init() {
        facturas = (List<Factura>) FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().get("facturasAPagar");

        facturas.stream().forEach((unaFactura) -> {
            subTotal += unaFactura.getImporte();
        });

    }

    public String pagarFacturas() {

        Pago nuevoPago = new Pago();
        nuevoPago.setId(pagoBean.getLastPagoId() + 1);
        nuevoPago.setMarca(this.marcaTarjeta);
        nuevoPago.setNumeroDeTarjeta(this.numeroTarjeta);
        nuevoPago.setTitularTarjeta(this.titularTarjeta);
        nuevoPago.setCodigoDeSeguridad(this.codigoTarjeta);
        nuevoPago.setFecha(Calendar.getInstance().getTime());
        nuevoPago.setEstado(0);

        try {
            nuevoPago.setFechaVecimiento(
                    new SimpleDateFormat("MM/yyyy")
                    .parse(this.vencimientoTarjeta));
        } catch (ParseException ex) {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
                    "Error al verificar la fecha de vencimiento."));
        }

        // se agrega un nuevo pago
        pagoBean.agregarPago(nuevoPago);
        
        
        

        return "";
    }

    public FacturaBean getFacturaBean() {
        return facturaBean;
    }

    public void setFacturaBean(FacturaBean facturaBean) {
        this.facturaBean = facturaBean;
    }

    public PagoBean getPagoBean() {
        return pagoBean;
    }

    public void setPagoBean(PagoBean pagoBean) {
        this.pagoBean = pagoBean;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public String getMarcaTarjeta() {
        return marcaTarjeta;
    }

    public void setMarcaTarjeta(String marcaTarjeta) {
        this.marcaTarjeta = marcaTarjeta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getTitularTarjeta() {
        return titularTarjeta;
    }

    public void setTitularTarjeta(String titularTarjeta) {
        this.titularTarjeta = titularTarjeta;
    }

    public String getVencimientoTarjeta() {
        return vencimientoTarjeta;
    }

    public void setVencimientoTarjeta(String vencimientoTarjeta) {
        this.vencimientoTarjeta = vencimientoTarjeta;
    }

    public int getCodigoTarjeta() {
        return codigoTarjeta;
    }

    public void setCodigoTarjeta(int codigoTarjeta) {
        this.codigoTarjeta = codigoTarjeta;
    }

}
