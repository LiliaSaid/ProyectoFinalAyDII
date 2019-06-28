package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.FacturaBean;
import aplicacion.modelo.dominio.Factura;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class FacturaFormBean implements Serializable {

    @ManagedProperty(value = "#{facturaBean}")
    private FacturaBean facturaBean;

    private List<Factura> facturaList;
    private List<Factura> facturaSelected;
    private double subTotal;
    private String titularFactura;
    private String domicilio;

    public FacturaFormBean() {
        Map<String, String> params = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();

        if (params.get("servicio") != null) {
            FacesContext.getCurrentInstance().getExternalContext()
                    .getSessionMap().put(
                            "numeroServicio", 
                            Integer.parseInt(params.get("servicio")));
        }
    }

    @PostConstruct
    public void init() {
        int numeroDeServicio = (int)FacesContext.getCurrentInstance().getExternalContext()
                    .getSessionMap().get("numeroServicio");
       
        facturaList = facturaBean.getFacturaListByServicio(numeroDeServicio);
        
        for (Factura unaFactura : facturaList){
            titularFactura = unaFactura.getTitularFactura();
            domicilio = unaFactura.getDomicilio();
            break;
        }
        
    }
    
    public FacturaBean getFacturaBean() {
        return facturaBean;
    }
    
    public void toggleCheckbox(){
        double newSubTotal = 0;
        for (Factura factura : facturaSelected){
            newSubTotal += factura.getImporte();
        }
        this.subTotal = newSubTotal;
    }

    public void setFacturaBean(FacturaBean facturaBean) {
        this.facturaBean = facturaBean;
    }

    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    public List<Factura> getFacturaSelected() {
        return facturaSelected;
    }

    public void setFacturaSelected(List<Factura> facturaSelected) {
        this.facturaSelected = facturaSelected;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public String getTitularFactura() {
        return titularFactura;
    }

    public void setTitularFactura(String titularFactura) {
        this.titularFactura = titularFactura;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }


}
