/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.IUsuarioDAO;
import aplicacion.modelo.dominio.Usuario;
import aplicacion.modelo.util.ListadoDeUsuarios;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author LILI-PC
 */
public class UsuarioDAOImp implements Serializable, IUsuarioDAO{

    private ListadoDeUsuarios listadoUsuarios;

    public UsuarioDAOImp() {
        this.listadoUsuarios = new ListadoDeUsuarios();
    }
       
    @Override
    public void crear(Usuario usuario) {
        listadoUsuarios.agregar(usuario);
    }

    @Override
    public void borrar(Usuario usuario) {
        listadoUsuarios.eliminar(usuario);
    }

    @Override
    public void actualizar(Usuario usuario) {
        listadoUsuarios.modificar(usuario);
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return listadoUsuarios.getListaUsuarios();
    }

    @Override
    public Usuario verificarCredenciales(String email, String password) {
        Usuario usuario = null;
        for(Usuario unUsuario: obtenerUsuarios()){
            if(unUsuario.getCorreo().equals(email) && unUsuario.getContraseña().equals(password)){
                usuario = unUsuario;
            }
        }
        return usuario;
    }
    
}
