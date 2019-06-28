/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.dao.IServicioDAO;
import aplicacion.dao.imp.IServicioDAOImp;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author sbalgass
 */
@ManagedBean
@RequestScoped
public class ServicioBean {

    private IServicioDAO iServicioDAO;
    /**
     * Creates a new instance of UsuarioBean
     */
    public ServicioBean() {
        iServicioDAO = new IServicioDAOImp();
    }
    

    
    
}
