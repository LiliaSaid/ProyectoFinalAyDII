/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.util;

import aplicacion.modelo.dominio.Servicio;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sbalgass
 */
public class ListadoServicio {
    private List<Servicio> listaServicios;

    public ListadoServicio() {
        listaServicios = new ArrayList<>();
        
        listaServicios.add(new Servicio(218003, "Luz y Agua",               "Ejesa"));
        listaServicios.add(new Servicio(218033, "Luz y Agua",               "Agua de los Andes"));
        listaServicios.add(new Servicio(418004, "Telefonia",                "Telecom"));
        listaServicios.add(new Servicio(418014, "Telefonia",                "Movistar"));
        listaServicios.add(new Servicio(418024, "Telefonia",                "Personal"));
        listaServicios.add(new Servicio(418034, "Telefonia",                "Claro"));
        listaServicios.add(new Servicio(718059, "Proveedores de Internet",  "Wirenet"));
        listaServicios.add(new Servicio(718069, "Proveedores de Internet",  "Telecentro"));
        listaServicios.add(new Servicio(170009, "Operadoras de TV",         "Canal 2"));
        listaServicios.add(new Servicio(170019, "Operadoras de TV",         "Canal 4"));
        
    }    
    
    public void agregar(Servicio servicio){
        listaServicios.add(servicio);
    }
    
    public void eliminar(Servicio servicio){
        for(int i = 0; i< listaServicios.size();i++){
            if(listaServicios.get(i).getId() == servicio.getId()){
                listaServicios.remove(i);
            }
        }
    }
    
    public void modificar(Servicio servicioModificado){
        for(Servicio servicio : listaServicios){
            if(servicio.getId() == servicioModificado.getId()){
                servicio = servicioModificado;
            }
        }
    }
    
    public List<Servicio> getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(List<Servicio> listaServicios) {
        this.listaServicios = listaServicios;
    }

}
