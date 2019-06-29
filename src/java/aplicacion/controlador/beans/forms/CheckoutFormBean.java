package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.FacturaBean;
import aplicacion.controlador.beans.ServicioBean;
import aplicacion.modelo.dominio.Factura;
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
public class CheckoutFormBean implements Serializable {

    @ManagedProperty(value = "#{facturaBean}")
    private FacturaBean facturaBean;

    private List<Factura> facturas;
    private double subTotal;
    
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

 
}
