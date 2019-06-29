/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.IServicioDAO;
import aplicacion.modelo.dominio.Servicio;
import aplicacion.modelo.util.ListadoServicio;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author sbalgass
 */
public class IServicioDAOImp implements IServicioDAO, Serializable {

    private ListadoServicio listadoServicio;

    public IServicioDAOImp() {
        this.listadoServicio = new ListadoServicio();
    }
    
    @Override
    public void crear(Servicio servicio) {
        listadoServicio.agregar(servicio);
    }

    @Override
    public void borrar(Servicio servicio) {
        listadoServicio.eliminar(servicio);
    }

    @Override
    public void actualizar(Servicio servicio) {
        listadoServicio.modificar(servicio);
    }

    @Override
    public List<Servicio> obtenerServicios() {
        return listadoServicio.getListaServicios();
    }
    
}
