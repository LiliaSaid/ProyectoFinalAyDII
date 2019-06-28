/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.util;

import aplicacion.modelo.dominio.Factura;
import java.util.List;

/**
 *
 * @author sbalgass
 */
public class ListadoFactura {
    private List<Factura> listaFactura;

    public ListadoFactura() {
        
    }
    
    public void agregar(Factura factura){
        listaFactura.add(factura);
    }
    
    public void eliminar(Factura factura){
        for(int i = 0; i< listaFactura.size();i++){
            if(listaFactura.get(i).getId() == factura.getId()){
                listaFactura.remove(i);
            }
        }
        
    }
    
    public void modificar(Factura facturaModificado){
        for(Factura factura : listaFactura){
            if(factura.getId() == facturaModificado.getId()){
                factura = facturaModificado;
            }
        }
    }

    public List<Factura> getListaFactura() {
        return listaFactura;
    }

    public void setListaFactura(List<Factura> listaFactura) {
        this.listaFactura = listaFactura;
    }
    
    
    
}
