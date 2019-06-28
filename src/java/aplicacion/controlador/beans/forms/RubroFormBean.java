package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.ServicioBean;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class RubroFormBean implements Serializable {

    @ManagedProperty(value = "#{servicioBean}")
    private ServicioBean servicioBean;

    private String rubro;
    private String empresa;
            
    public RubroFormBean() {
        
    }

    public ServicioBean getServicioBean() {
        return servicioBean;
    }

    public void setServicioBean(ServicioBean servicioBean) {
        this.servicioBean = servicioBean;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String goToPagarServicio() {
        return "pagar-servicio?faces-redirect=true";
    }
    
    
}
