/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.util;

import aplicacion.modelo.dominio.Factura;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LILI-PC
 */
public class ListadoDeFacturas {
    private List<Factura> listaFacturas;
       
    public ListadoDeFacturas() {
        listaFacturas = new ArrayList<>();
        listaFacturas.add(new Factura(1,218003,34888237,"Los Pinos N°331 B°Alto Palpalá",800,"Said, Lilia"));
        listaFacturas.add(new Factura(2,218003,34888395,"Los Pinos N°331 B°Alto Palpalá",1200,"Said, Lilia"));
        listaFacturas.add(new Factura(3,418004,85000000,"Av Congreso S/N B°Loma Golf",1000,"Rojas, Romina"));
        listaFacturas.add(new Factura(4,418004,85000200,"Av Congreso S/N B°Loma Golf",1500,"Rojas, Romina"));
        listaFacturas.add(new Factura(5,718059,97500337,"Av 25 de Mayo N°700 B°25 de Mayo",1900,"Tapia,Monica"));
        listaFacturas.add(new Factura(6,718059,97500450,"Av 25 de Mayo N°700 B°25 de Mayo",650,"Tapia, Monica"));
        listaFacturas.add(new Factura(7,170009,45888237,"Av Irigoyen N°200 B°Carolina",1900,"Delgado, Carla"));
        listaFacturas.add(new Factura(8,170009,56888237,"Av Irigoyen N°200 B°Carolina",1450,"Delgado, Carla"));
        
    }
    
    public void agregar(Factura factura){
        listaFacturas.add(factura);
    }
    
    public void eliminar(Factura factura){
        for(int i = 0; i< listaFacturas.size();i++){
            if(listaFacturas.get(i).getId() == factura.getId()){
                listaFacturas.remove(i);
            }
        }
        
    }
    
    public void modificar(Factura facturaModificado){
        for(Factura factura : listaFacturas){
            if(factura.getId() == facturaModificado.getId()){
                factura = facturaModificado;
            }
        }
    }

    public List<Factura> getListaFactura() {
        return listaFacturas;
    }

    public void setListaFactura(List<Factura> listaFactura) {
        this.listaFacturas = listaFactura;
    }
    
    
}
