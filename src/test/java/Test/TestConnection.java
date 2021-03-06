package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {

    public static void main(String[] args) {

        String db = "kaktus";
        String user = "root";
        String pass = "admin";
        String url = "jdbc:mariadb://localhost:3306/" + db + "?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement sentencia = con.createStatement();
            
            String sql = "SELECT id_user,name, email, nickname,password,image_url,role FROM users";
            ResultSet resultado = sentencia.executeQuery(sql);
            while (resultado.next()){
                
                System.out.println("Usuario :"+resultado.getString(2)+""
                        + "       " + "Email:"+resultado.getString(3));
                
            }
            resultado.close();
            sentencia.close();
            con.close();

        } catch (SQLException ex) {
                System.out.println("-----------------------------------------------");
                System.out.println("No se pudo conectar con la base de datos");
                System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⣤⣤\n" +
                                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿\n" +
                                    "⠀⠀⣶⠀⠀⣀⣤⣶⣤⣉⣿⣿⣤⣀\n" +
                                    "⠤⣤⣿⣤⣿⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣀\n" +
                                    "⠀⠛⠿⠀⠀⠀⠀⠉⣿⣿⣿⣿⣿⠉⠛⠿⣿⣤\n" +
                                    "⠀⠀⠀⠀⠀⠀⠀⠀⠿⣿⣿⣿⠛⠀⠀⠀⣶⠿\n" +
                                    "⠀⠀⠀⠀⠀⠀⠀⠀⣀⣿⣿⣿⣿⣤⠀⣿⠿\n" +
                                    "⠀⠀⠀⠀⠀⠀⠀⣶⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                                    "⠀⠀⠀⠀⠀⠀⠀⠿⣿⣿⣿⣿⣿⠿⠉⠉\n" +
                                    "⠀⠀⠀⠀⠀⠀⠀⠉⣿⣿⣿⣿⠿\n" +
                                    "⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⠉\n" +
                                    "⠀⠀⠀⠀⠀⠀⠀⠀⣛⣿⣭⣶⣀\n" +
                                    "⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿\n" +
                                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⠉⠛⣿\n" +
                                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⠀⠀⣿⣿\n" +
                                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣉⠀⣶⠿\n" +
                                    "⠀⠀⠀⠀⠀⠀⠀⠀⣶⣿⠿\n" +
                                    "⠀⠀⠀⠀⠀⠀⠀⠛⠿⠛");
                                            }

    }

}
