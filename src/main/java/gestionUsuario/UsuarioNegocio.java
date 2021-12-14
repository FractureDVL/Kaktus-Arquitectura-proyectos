/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionUsuario;

import dao.UsuarioDAO;
import entidades.UsuarioDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UsuarioNegocio implements Serializable {

    private UsuarioDAO usuariodao;

    //Contructor
    public UsuarioNegocio() {
        usuariodao = new UsuarioDAO();
    }

    //Metodo get usuarios
    public List<UsuarioDTO> buscarUsuarios() {
        List<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();

        try {
            usuarios = usuariodao.buscarUsuarios();
        } catch (Exception e) {
            e.printStackTrace();
            usuarios = null;
        }

        return usuarios;
    }

    public boolean registrarUsuario(UsuarioDTO usuario) {
        boolean rta = false;
        try {
            rta = usuariodao.registrarUsuario(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rta;
    }

    public UsuarioDTO buscarUsuario(int id) {
        UsuarioDTO usuario = new UsuarioDTO();
        try {
            usuario = usuariodao.buscarUsuario(id);
        } catch (Exception e) {
            usuario = null;
            e.printStackTrace();
        }
        return usuario;
    }

    public int eliminarUsuario(UsuarioDTO usuario) {
        int rta = 0;

        try {
            rta = usuariodao.eliminarUsuario(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rta;
    }

    public int actualizarUsuario(UsuarioDTO usuario) {

        int rta = 0;

        try {

            rta = usuariodao.actualizarUsuario(usuario);

        } catch (Exception e) {

            e.printStackTrace();

        }
        return rta;
    }

    public UsuarioDTO iniciarSesion(String user, String password) {

        UsuarioDTO usuario = new UsuarioDTO();

        try {

            usuario = usuariodao.obtenerUsuario(user, password);

        } catch (Exception e) {
            e.printStackTrace();

        }
        return usuario;
    }
    public int actualizarFoto(UsuarioDTO usuario) {

        int rta = 0;
        try {

            rta = usuariodao.actualizarFoto(usuario);

        } catch (Exception e) {

            e.printStackTrace();

        }
        return rta;
    }
    
    public UsuarioDTO obtenerImagenUsuario(String nickname) {
        UsuarioDTO usuario = new UsuarioDTO();
        try {
            usuario = usuariodao.obtenerImagenUsuario(nickname);
        } catch (Exception e) {
            usuario = null;
            e.printStackTrace();
        }
        return usuario;
    }
}
