package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.ServicioBean;
import aplicacion.modelo.dominio.Servicio;
import aplicacion.modelo.dominio.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class ServicioFormBean implements Serializable {

    @ManagedProperty(value = "#{servicioBean}")
    private ServicioBean servicioBean;

    private String servicio;
    private String numeroServicio;

    public ServicioFormBean() {
        Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        if (user == null){
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
            } catch (IOException ex) {
            }
        }
    }
    
    public List<Servicio> autoCompletar(String query) {
        List<Servicio> results = new ArrayList<>();

        Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        
        for (Servicio unServicio : servicioBean.obtenerServiciosPorIds(user.getServiciosHabilitados())) {
            if (query.contains(query)) {
                results.add(unServicio);
            }
        }

        return results;
    }
    
    public String buscarFacturasPorServicioYEmpresa(){
        return "facturas?faces-redirect=true&empresa="+servicio+
                "&numero="+numeroServicio;
    }

    public ServicioBean getServicioBean() {
        return servicioBean;
    }

    public void setServicioBean(ServicioBean servicioBean) {
        this.servicioBean = servicioBean;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getNumeroServicio() {
        return numeroServicio;
    }

    public void setNumeroServicio(String numeroServicio) {
        this.numeroServicio = numeroServicio;
    }
    
    public String goToCrearServicio() {
        return "crear-servicio?faces-redirect=true";
    }

}
