package dao;

import modelo.UsuarioDTO;

public interface UsuarioServices {
    
     public int crearUsuario(UsuarioDTO u);
     public int login(UsuarioDTO u);
    
}
