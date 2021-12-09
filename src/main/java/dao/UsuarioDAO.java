package dao;

import Controller.ConnectionDB;
import entidades.Imagen;
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
    
    public void agregarFoto(Imagen i){
        int r = 0;
        String sql = "INSERT INTO image_user ( image, usuario) VALUES (?,?)";
        
        try {
            ConnectionDB conexion = new ConnectionDB();
            Connection con = conexion.getConnection("UsuarioDAO.agregarFoto");
            PreparedStatement ps = con.prepareStatement(sql);     
            
            ps.setBlob(1, i.getImagen());
            ps.setString(2, i.getUsuario());
            ps.executeUpdate();
            
        } catch (Exception e) {
        }    
    }
    
    public void eliminarFoto(String usuario) {
        ConnectionDB conexion = new ConnectionDB();
        String sql = "DELETE FROM image_user WHERE usuario = ?;";
        PreparedStatement ps = null;
        try {
            ps = conexion.getConnection("UsuarioDAO.eliminarFoto").prepareStatement(sql);
            ps.setString(1, usuario);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (Exception ex) {
            }
        }
    }
    
    public Imagen obtenerFotoUsuario(String usuario) throws SQLException{
        Imagen i = new Imagen();
        String sql = "SELECT FROM image_user WHERE usuario=?";
        
        try{
            ConnectionDB conexion = new ConnectionDB();
            Connection con = conexion.getConnection("UsuarioDAO.obtenerFotoUsuario");
            PreparedStatement ps = con.prepareStatement(sql);     
            ResultSet rs = null;
            
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            while(rs.next()){
                i.setId(rs.getInt(1));
                i.setImg(rs.getBytes(2));
                i.setUsuario(rs.getString(3));
            }     
        }
        catch(SQLException ex){
            
        }
        return i;
    }
    
    public void modificarFoto(Imagen i) throws SQLException{
        String sql = "UPDATE image_user SET image = ? WHERE usuario = ?";
        
        try{
            ConnectionDB conexion = new ConnectionDB();
            Connection con = conexion.getConnection("UsuarioDAO.modificarFoto");
            PreparedStatement ps = con.prepareStatement(sql);     
            
            ps.setBlob(1, i.getImagen());
            ps.setString(2, i.getUsuario());
            ps.executeUpdate();
        }
        catch(SQLException ex){
        }
    }
 
}
