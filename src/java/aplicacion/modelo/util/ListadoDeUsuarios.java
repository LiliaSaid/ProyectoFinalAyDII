/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.util;

import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LILI-PC
 */
public class ListadoDeUsuarios implements Serializable{
    private List<Usuario> listaUsuarios;

    public ListadoDeUsuarios() {
        listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new Usuario(1, "Lilia", "Said","liliasaid@gmail.com", "said2019"));
        listaUsuarios.add(new Usuario(2, "Romina", "Rojas","rominarojas@gmail.com", "rojas2019"));
        listaUsuarios.add(new Usuario(3, "Monica", "Tapia","monicatapia@gmail.com", "tapia2019"));
        listaUsuarios.add(new Usuario(4, "Carla", "Delgado","carladelgado@gmail.com", "delgado2019"));
    }
    
    public void agregar(Usuario usuario){
        listaUsuarios.add(usuario);
    }
    
    public void eliminar(Usuario usuario){
        for(int i = 0; i< listaUsuarios.size();i++){
            if(listaUsuarios.get(i).getId()== usuario.getId()){
                listaUsuarios.remove(i);
            }
        }
        
    }
    
    public void modificar(Usuario usuario){
        for(Usuario usu: listaUsuarios){
            if(usu.getId() == usu.getId()){
                usu = usuario;
            }
        }
    }
    
    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
}
