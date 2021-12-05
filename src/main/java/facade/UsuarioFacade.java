/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidades.UsuarioDTO;
import gestionUsuario.UsuarioNegocio;
import java.util.List;

/**
 *
 * @author joseb
 */
public class UsuarioFacade {
    
    private UsuarioNegocio usuarioNegocio;

    public UsuarioFacade() {
        usuarioNegocio = new UsuarioNegocio();
    }
    
    public List<UsuarioDTO> buscarUsuarios(){
        return usuarioNegocio.buscarUsuarios();
    }
    
    public UsuarioDTO buscarUsuario(int id){
        return usuarioNegocio.buscarUsuario(id);
    }
    
    public int eliminarUsuario(UsuarioDTO usuario){
        return usuarioNegocio.eliminarUsuario(usuario);
    }
    
    public int actualizarUsuario(UsuarioDTO usuario){
        return usuarioNegocio.actualizarUsuario(usuario);    
    }
    
    public boolean registrarUsuario(UsuarioDTO usuario){
        return usuarioNegocio.registrarUsuario(usuario);
    }
    
    public UsuarioDTO iniciarSesion(String username, String password){
        return usuarioNegocio.iniciarSesion(username, password);
    }
}
