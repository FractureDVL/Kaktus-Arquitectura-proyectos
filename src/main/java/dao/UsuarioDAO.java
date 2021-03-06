package dao;

import Controller.ConnectionDB;
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

public class UsuarioDAO implements Serializable {

    private static final String GET_ALL = "SELECT * FROM users";
    private static final String GET_ONE = "SELECT * FROM users WHERE id_user = ?";
    private static final String GET_IMG = "SELECT image_url FROM users WHERE nickname = ?";
    private static final String UPDATE_IMG = "UPDATE users SET image_url = ? WHERE nickname = ?";
    private static final String DROP_USER = "DELETE FROM users WHERE id_user = ?";
    private static final String UPDATE_USER = "UPDATE users SET name = ?, email = ?, password = ? WHERE id_user = ?";
    private static final String CREATE_USER = "INSERT INTO `users`(`name`, `email`, `nickname`, `password`) VALUES (?,?,?,?)";
    private static final String LOGIN = "SELECT * FROM users WHERE nickname = ? and password=?";

    public List<UsuarioDTO> buscarUsuarios() throws Exception {
        List<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();

        ConnectionDB conexion = new ConnectionDB();
        Connection con = conexion.getConnection("UsuarioDAO.buscarUsuarios");

        PreparedStatement ps = con.prepareStatement(this.GET_ALL);
        ResultSet rst = ps.executeQuery();

        while (rst.next()) {

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
        con = null;

        return usuarios;
    }

    public UsuarioDTO buscarUsuario(int id) throws SQLException {

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
        con = null;

        return usuario;
    }

    public int eliminarUsuario(UsuarioDTO usuario) throws SQLException {

        ConnectionDB conexion = new ConnectionDB();
        Connection con = conexion.getConnection("UsuarioDAO.eliminarUsuario");

        PreparedStatement sen = null;
        int registros = 0;

        try {
            sen = con.prepareStatement(this.DROP_USER);
            sen.setInt(1, usuario.getId());
            registros = sen.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        sen.close();
        sen = null;

        con.close();
        con = null;

        return registros;
    }

    public int actualizarUsuario(UsuarioDTO usuario) throws Exception {

        ConnectionDB conexion = new ConnectionDB();
        Connection con = conexion.getConnection("UsuarioDAO.actualizarUsuario");
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

    public boolean registrarUsuario(UsuarioDTO usuario) throws Exception {
        boolean rta = false;

        ConnectionDB conexion = new ConnectionDB();
        Connection con = conexion.getConnection("UsuarioDAO.registrarUsuario");

        PreparedStatement ps = con.prepareStatement(this.CREATE_USER);

        ps.setString(1, usuario.getName());
        ps.setString(2, usuario.getEmail());
        ps.setString(3, usuario.getUser());
        ps.setString(4, usuario.getPassword());

        ps.execute();
        rta = true;

        ps.close();
        ps = null;

        con.close();
        con = null;

        return rta;
    }

    public UsuarioDTO obtenerUsuario(String user, String password) throws SQLException {

        ConnectionDB conexion = new ConnectionDB();
        Connection con = conexion.getConnection("UsuarioDAO.obtenerUsuario");

        ResultSet rs;

        PreparedStatement ps = con.prepareStatement(this.LOGIN);
        int registros = 0;
        UsuarioDTO usuario = new UsuarioDTO();
        
        ps.setString(1, user);
        ps.setString(2, password);
        rs = ps.executeQuery();
        
        while (rs.next()) {
            registros = registros + 1;
            usuario.setId(rs.getInt("Id_user"));
            usuario.setName(rs.getString("name"));
            usuario.setEmail(rs.getString("email"));
            usuario.setUser(rs.getString("nickname"));
            usuario.setPassword(rs.getString("password"));
            usuario.setImgUrl(rs.getString("image_url"));
            usuario.setRole(rs.getString("role"));
        }

        ps.close();
        ps = null;

        con.close();
        con = null;


            return usuario;
    }

    public int validarSesion(String user, String password) {

        try {
            ConnectionDB conexion = new ConnectionDB();
            Connection con = conexion.getConnection("UsuarioDAO.validarSesion");
            ResultSet rs;
            PreparedStatement ps = con.prepareStatement(this.LOGIN);
            int registros = 0;  
            ps.setString(1, user);
            ps.setString(2, password);
            
            rs = ps.executeQuery();
        
            while(rs.next()){
            
                return 1;
            }
        } catch (SQLException ex) {

            ex.printStackTrace(System.out);
        }

        return 0;
    }
    
    public int actualizarFoto(UsuarioDTO usuario){
        int registro = 1;
        
        try {
            ConnectionDB conexion = new ConnectionDB();
            Connection con = conexion.getConnection("UsuarioDAO.agregarFoto");
            PreparedStatement ps = con.prepareStatement(this.UPDATE_IMG);
            int id = usuario.getId();
            String user = usuario.getUser();
            String ruta = usuario.getImgUrl();
            
            ps.setString(1, ruta);
            ps.setString(2, user);
            
            registro = ps.executeUpdate();
            
            ps.close();
            ps = null;
        
            con.close();
            con = null;    
            
        } 
        catch (Exception e) {
        }
        return registro;
    }
    
    public UsuarioDTO obtenerImagenUsuario(String nickname) throws SQLException{
    
        
        ConnectionDB conexion = new ConnectionDB();
        Connection con = conexion.getConnection("UsuarioDAO.obtenerImagenUsuario");

        ResultSet rs;

        PreparedStatement ps = con.prepareStatement(this.GET_IMG);
        int registros = 0;
        
        UsuarioDTO usuario = new UsuarioDTO();
        
        ps.setString(1, nickname);
        rs = ps.executeQuery();
        
        while (rs.next()) {
            registros = registros + 1;
            usuario.setImgUrl(rs.getString("image_url"));
        }

        ps.close();
        ps = null;

        con.close();
        con = null;


            return usuario;
        
    }
}
