/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import sun.jvm.hotspot.utilities.soql.SOQLException;

/**
 *
 * @author Diego Pedrozo
 */
public class ConnectionBD {
    
    private static final  String db = "kaktus";
    public static final String JDBC_URL = "jdbc:mariadb://localhost:3306/" + db + "?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    public static final String BD_USERNAME = "root";
    public static final String BD_PASSWORD = "admin";

    public static DataSource getDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(BD_USERNAME);
        ds.setPassword(BD_PASSWORD);
        
        ds.setInitialSize(5);
        return ds;
    }
    
    public static Connection getConnection() throws SQLException{
        try{
            Class.forName("org.mariadb.jdbc.Driver");
        }
        catch(ClassNotFoundException ex){
            System.out.println(ex);  
        }
        return getDataSource().getConnection();
    }
    
    public static void close(Connection con) throws SQLException{
        con.close();   
    }
    
    public static void close(ResultSet res) throws SQLException{
        res.close();   
    }
    
    public static void close(Statement sen) throws SQLException{
        sen.close();   
    }
    
    public static void close(PreparedStatement psen) throws SQLException{
        psen.close();   
    }
}
