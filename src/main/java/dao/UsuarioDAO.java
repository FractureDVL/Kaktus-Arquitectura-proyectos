package dao;

import controller.ConnectionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.UsuarioDTO;

public class UsuarioDAO implements UsuarioServices{
    
   public static final String SQL_INSERTAR = "INSERT INTO users (id_user, name, email, nickname, password, image_url, role) VALUES(?,?,?,?,?,?,?)";
   
   
   
   public int insertar(UsuarioDTO u){
       Connection con = null;
       PreparedStatement sen = null;
       int registros = 0;
      
       try{
           con = ConnectionBD.getConnection();
           sen = con.prepareStatement(SQL_INSERTAR);
           sen.setInt(1, u.getId());
           sen.setString(2, u.getName());
           sen.setString(3, u.getEmail());
           sen.setString(4, u.getUser());
           sen.setString(5, u.getPassword());
           sen.setString(6, u.getImgUrl());
           sen.setString(7, u.getRole());
           
           registros = sen.executeUpdate();
       }
       catch(SQLException ex){
           ex.printStackTrace(System.out);
       }
       
       finally{
            try {
                ConnectionBD.close(sen);
                ConnectionBD.close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    
        return registros;
   }
}
