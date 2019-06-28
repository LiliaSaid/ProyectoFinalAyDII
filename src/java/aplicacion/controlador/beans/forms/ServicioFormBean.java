package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.ServicioBean;
import aplicacion.modelo.dominio.Servicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ServicioFormBean implements Serializable {

    @ManagedProperty(value = "#{servicioBean}")
    private ServicioBean servicioBean;

    private String servicio;

    public ServicioFormBean() {
    }

    public List<String> autoCompletar(String query) {
        List<String> results = new ArrayList<String>();

        for (Servicio unServicio : servicioBean.getServicioList()) {
            if (query.contains(query)) {
                results.add(unServicio.getNombre());
            }
        }

        return results;
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

}