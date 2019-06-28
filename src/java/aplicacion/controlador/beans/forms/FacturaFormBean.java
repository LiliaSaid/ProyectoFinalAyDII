package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.FacturaBean;
import aplicacion.modelo.dominio.Factura;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class FacturaFormBean implements Serializable {

    @ManagedProperty(value = "#{facturaBean}")
    private FacturaBean facturaBean;

    private List<Factura> facturaList;
    private List<Factura> facturaSelected;    
    
    public FacturaFormBean() {
    }
    
    @PostConstruct
    public void init() {
        facturaList = facturaBean.getFacturaList();
    }

    public FacturaBean getFacturaBean() {
        return facturaBean;
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
    
    


}
