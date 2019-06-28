package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.ServicioBean;
import aplicacion.modelo.dominio.Servicio;
import aplicacion.modelo.dominio.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class RubroFormBean implements Serializable {

    @ManagedProperty(value = "#{servicioBean}")
    private ServicioBean servicioBean;

    private String rubro;
    private String empresa;
    private List<Servicio> servicioList;
    private List<String> rubroList;

    public RubroFormBean() {
        Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        if (user == null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
            } catch (IOException ex) {
            }
        }
    }

    @PostConstruct
    public void init() {
        rubroList = servicioBean.getRubroList();

        servicioList = servicioBean.getServicioList();

    }

    public void applyFilter() {
        if (rubro == null || rubro.isEmpty()) {
            return;
        }

        servicioList = servicioBean.getServicioListByRubro(rubro);
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

    public List<String> getRubroList() {
        return rubroList;
    }

    public void setRubroList(List<String> rubroList) {
        this.rubroList = rubroList;
    }

    public List<Servicio> getServicioList() {
        return servicioList;
    }

    public void setServicioList(List<Servicio> servicioList) {
        this.servicioList = servicioList;
    }

}
