package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestConnection {

    public static void main(String[] args) {

        String db = "kaktus";
        String user = "root";
        String pass = "admin";
        String url = "jdbc:mysql://localhost:3306/" + db + "?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement sentencia = con.createStatement();
            String sql = "SELECT id_user,name, email, nickname,password,image_url,role FROM users";
            ResultSet resultado = sentencia.executeQuery(sql);
            while (resultado.next()){
                
                System.out.println("Usuario :"+resultado.getString(2)+""
                        + "       " + "Email:"+resultado.getString(3));
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
