package dao;

import controller.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import entidades.UsuarioDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements Serializable{
    
    private static final String GET_ALL = "SELECT * FROM users";
    private static final String GET_ONE = "SELECT * FROM users WHERE id_user = ?";
    private static final String DROP_USER = "DELETE FROM users WHERE id_user = ?";
    private static final String UPDATE_USER = "UPDATE users SET name = ?, nickname = ?, password = ? WHERE id_user = ?";
    private static final String UPDATE_PHOTO = "UPDATE users SET image_url = ?  WHERE id_user = ?";
    private static final String CREATE_USER = "INSERT INTO `users`(`name`, `email`, `nickname`, `password`) VALUES (?,?,?,?)";
    private static final String UPDATE_PASS = "UPDATE users SET password = ? WHERE id_user = ?";
    private static final String LOGIN = "SELECT * FROM users WHERE nickname=? and password=?";

    public List<UsuarioDTO> buscarUsuarios() throws Exception{
        List<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
        
        ConnectionDB conexion = new ConnectionDB();
        Connection con = conexion.getConnection("UsuarioDAO.buscarUsuarios");
     
        PreparedStatement ps = con.prepareStatement(this.GET_ALL);
        ResultSet rst = ps.executeQuery();
               
        while (rst.next()){
            
            UsuarioDTO usuario = new UsuarioDTO();
            
            usuario.setId(rst.getInt("id_user"));
            usuario.setName(rst.getString(2));
            usuario.setEmail(rst.getString(3));
            usuario.setUser(rst.getString(4));
            usuario.setPassword(rst.getString(5));
            usuario.setImgUrl(rst.getString(6));
            usuario.setRole(rst.getString(7));
            
            
            usuarios.add(usuario);
        }        
        
        rst.close();
        rst = null;
        
        ps.close();
        ps = null;
        
        con.close();
        con=null;
        
        return usuarios;
    }
    
    public UsuarioDTO buscarUsuario(int id) throws SQLException{
     
     ConnectionDB conexion = new ConnectionDB();
     Connection con = conexion.getConnection("UsuarioDAO.buscarUsuario");
     
     PreparedStatement ps = con.prepareStatement(this.GET_ONE);
     ResultSet rst = ps.executeQuery();
     
        UsuarioDTO usuario = new UsuarioDTO();
            
        usuario.setId(rst.getInt("id_user"));
        usuario.setName(rst.getString(2));
        usuario.setEmail(rst.getString(3));
        usuario.setUser(rst.getString(4));
        usuario.setPassword(rst.getString(5));
        usuario.setImgUrl(rst.getString(6));
        usuario.setRole(rst.getString(7));
        
        rst.close();
        rst = null;
        
        ps.close();
        ps = null;
        
        con.close();
        con=null;
        
        return usuario;
    }
    
    public int eliminarUsuario(UsuarioDTO usuario)throws SQLException{
    
        ConnectionDB conexion = new ConnectionDB();
        Connection con = conexion.getConnection("UsuarioDAO.eliminarUsuario");
    
        PreparedStatement sen = null;
        int registros = 0;
        
        try{
            sen = con.prepareStatement(this.DROP_USER);
            sen.setInt(1, usuario.getId());
            registros = sen.executeUpdate();
        } catch (SQLException ex){
            ex.printStackTrace(System.out);
        }
        
        sen.close();
        sen = null;
        
        con.close();
        con = null;
    
        return registros;
    }
    
    public int actualizarUsuario(UsuarioDTO usuario) throws Exception{
        
        ConnectionDB conexion = new ConnectionDB();
        Connection con = conexion.getConnection("JugadorDao.actualizar");       
        PreparedStatement ps = null;
        
        int registros = 0;
        
        ps = con.prepareStatement(this.UPDATE_USER);
        
        ps.setInt(4, usuario.getId());
        ps.setString(1, usuario.getName());
        ps.setString(2, usuario.getEmail());
        ps.setString(3, usuario.getPassword());
        
        registros = ps.executeUpdate();
        
        ps.close();
        ps = null;
        
        con.close();
        con = null;    
        
        return registros;
    }
    
    
    public boolean registrarUsuario(UsuarioDTO usuario) throws Exception{
        boolean rta = false;
        
        ConnectionDB conexion = new ConnectionDB();
        Connection con = conexion.getConnection("UsuarioDAO.registrarUsuario");
        
        PreparedStatement ps = con.prepareStatement(this.CREATE_USER);
        
        ps.setInt(1, usuario.getId());
        ps.setString(2, usuario.getName());
        ps.setString(3, usuario.getEmail());
        ps.setString(4, usuario.getUser());
        ps.setString(5, usuario.getPassword());
        ps.setString(6, usuario.getImgUrl());
        ps.setString(7, usuario.getRole());
        

        ps.execute();
        rta=true;
        
        ps.close();
        ps = null;
        
        con.close();
        con = null;
        
        return rta;  
    }
   
    public int iniciarSesion(UsuarioDTO u) throws SQLException{
       
       ConnectionDB conexion = new ConnectionDB();
       Connection con = conexion.getConnection("UsuarioDAO.iniciarSesion");
        
       ResultSet rs;
       
       PreparedStatement ps = con.prepareStatement(this.LOGIN);
       int registros = 0;
       
       ps.setString(1, u.getUser());
       ps.setString(2, u.getPassword());
       rs = ps.executeQuery();
           
       while(rs.next()){
          registros = registros+1;
          u.setUser(rs.getString("nickname"));
          u.setPassword(rs.getString("password"));
       }
        
        ps.close();
        ps = null;
        
        con.close();
        con = null;
       
       if(registros==1){
        return 1;
       }
       else return 0;  
 
   }
}
