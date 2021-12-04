/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.ConnectionDB;
import entidades.ProyectoDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joseb
 */
public class ProyectoDAO implements Serializable {

    public static final String GET_ALL = "SELECT * FROM projects WHERE id_user = ?";
    public static final String GET_IMAGE = "SELECT image_projects.img_url FROM projects INNER JOIN image_projects ON projects.id_project = image_projects.id_project;";
    public static final String DELETE_PROJECT = "DELETE FROM projects WHERE id_project = ?";
    public static final String UPDATE_PROJECT = "UPDATE projects SET name_project = ?, description = ? VALUES (?,?) WHERE id_project = ?";
    public static final String CREATE_PROJECT = "INSERT INTO projects (name_project, description, create_at) VALUES (?,?,CURRENT_DATE())";

    public List<ProyectoDTO> buscarProyectos() throws Exception {
        List<ProyectoDTO> proyectos = new ArrayList<ProyectoDTO>();

        ConnectionDB conexion = new ConnectionDB();
        Connection con = conexion.getConnection("UsuarioDAO.buscarProyecto");

        PreparedStatement ps = con.prepareStatement(this.GET_ALL);
        ResultSet rst = ps.executeQuery();

        while (rst.next()) {

            ProyectoDTO usuario = new ProyectoDTO();

            usuario.setId(rst.getInt("id_user"));
            usuario.setTitulo(rst.getString(1));
            usuario.setDescripcion(rst.getString(2));
            usuario.setUrlImagen(rst.getString(3));
            
            proyectos.add(usuario);
        }

        rst.close();
        rst = null;

        ps.close();
        ps = null;

        con.close();
        con = null;

        return proyectos;
    }
    
    public int eliminarProyecto(ProyectoDTO proyecto)throws SQLException{
    
        ConnectionDB conexion = new ConnectionDB();
        Connection con = conexion.getConnection("UsuarioDAO.eliminarProyecto");
    
        PreparedStatement sen = null;
        int registros = 0;
        
        try{
            sen = con.prepareStatement(this.DELETE_PROJECT);
            sen.setInt(1, proyecto.getId());
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
    
    public int actualizarProyecto(ProyectoDTO proyecto) throws Exception{
        
        ConnectionDB conexion = new ConnectionDB();
        Connection con = conexion.getConnection("JugadorDao.actualizarProyecto");       
        PreparedStatement ps = null;
        
        int registros = 0;
        
        ps = con.prepareStatement(this.UPDATE_PROJECT);
        
        ps.setInt(3, proyecto.getId());
        ps.setString(1, proyecto.getTitulo());
        ps.setString(2, proyecto.getDescripcion());
        
        registros = ps.executeUpdate();
        
        ps.close();
        ps = null;
        
        con.close();
        con = null;    
        
        return registros;
    }
    
    public boolean crearProyecto(ProyectoDTO proyecto) throws Exception{
        boolean rta = false;
        
        ConnectionDB conexion = new ConnectionDB();
        Connection con = conexion.getConnection("UsuarioDAO.crearProyecto");
        
        PreparedStatement ps = con.prepareStatement(this.CREATE_PROJECT);
        
        ps.setString(1, proyecto.getTitulo());
        ps.setString(2, proyecto.getDescripcion());
        ps.setDate(3, proyecto.getFechaCreacion());
        
        
        

        ps.execute();
        rta=true;
        
        ps.close();
        ps = null;
        
        con.close();
        con = null;
        
        return rta;  
    }

}
