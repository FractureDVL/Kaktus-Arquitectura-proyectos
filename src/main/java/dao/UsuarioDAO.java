package dao;

import controller.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.UsuarioDTO;

public class UsuarioDAO implements UsuarioServices{
    
  private static final String GET_ALL = "SELECT id_user, name, email, nickname,image_url, role FROM users";
    private static final String SQL_CREATE_USER = "INSERT INTO `users`(`name`, `email`, `nickname`, `password`) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE_PASS = "UPDATE users SET password = ? WHERE id_user = ?";
    private static final String LOGIN = "SELECT * FROM users WHERE nickname=? and password=?";

    public int crearUsuario(UsuarioDTO u) {

        return this.ejecutarSQL(u, 1);
    }

    public int changePassword(UsuarioDTO u) {

        return this.ejecutarSQL(u, 2);
    }
    
     private int ejecutarSQL(UsuarioDTO u, int s) {

        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;

        try {
            con = ConnectionDB.getConnection();

            switch (s) {
                case 1: {
                    ps = con.prepareStatement(this.SQL_CREATE_USER);
                    ps.setString(1, u.getName());
                    ps.setString(2, u.getEmail());
                    ps.setString(3, u.getUser());
                    ps.setString(4, u.getPassword());
                    
                    break;
                }
            }
            registros = ps.executeUpdate();

        } catch (SQLException ex) {
           Logger.getLogger(UsuarioDTO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No se logro introducir los datos");
        } finally {

            try {
                ConnectionDB.close(ps);
                ConnectionDB.close(con);

            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDTO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return registros;
    }
     
   public int login(UsuarioDTO u){
       Connection con;
       PreparedStatement ps;
       ResultSet rs;
       int registros = 0;
       
       try{
           con = ConnectionDB.getConnection();
           ps = con.prepareStatement(LOGIN);
           ps.setString(1, u.getUser());
           ps.setString(2, u.getPassword());
           rs = ps.executeQuery();
           
           while(rs.next()){
               registros=registros+1;
               u.setUser(rs.getString("nickname"));
               u.setPassword(rs.getString("password"));
           }
           if(registros==1){
               return 1;
           }
           else return 0;
                              
       }
       catch(Exception e){
           return 0;
       }
   }
}
