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
import org.primefaces.event.ToggleEvent;
import org.primefaces.event.ToggleSelectEvent;

@ManagedBean
@RequestScoped
public class FacturaFormBean implements Serializable {

    @ManagedProperty(value = "#{facturaBean}")
    private FacturaBean facturaBean;

    private List<Factura> facturaList;
    private List<Factura> facturaSelected;
    
    private int numeroDeServicio;
    
    private double subTotal;

    public FacturaFormBean() {
        subTotal = 0;
    }

    @PostConstruct
    public void init() {
        Map<String, String> params = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();

        if (params.get("servicio") != null) {
            numeroDeServicio = Integer.parseInt(params.get("servicio"));
        }
        
        facturaList = facturaBean.getFacturaListByServicio(numeroDeServicio);
        
    }

    public FacturaBean getFacturaBean() {
        return facturaBean;
    }
    
    public void toggleCheckbox(){
        double subTotal = 0;
        for (Factura factura : facturaSelected){
            subTotal += factura.getImporte();
        }
        this.subTotal = subTotal;
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
    
    

}
