/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Controller.ConnectionDB;
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
    
    private static final String GET_ALL_PROJECTS = "SELECT * FROM projects";
    public static final String GET_ALL = "SELECT * FROM projects WHERE id_project = ?";
    public static final String GET_ONE = "SELECT * FROM projects WHERE nickname_user = ?";
    public static final String GET_IMAGE = "SELECT image_projects.img_url FROM projects INNER JOIN image_projects ON projects.id_project = image_projects.id_project;";
    public static final String DELETE_PROJECT = "DELETE FROM projects WHERE id_project = ?";
    public static final String UPDATE_PROJECT = "UPDATE projects SET name_project = ?, description = ? WHERE id_project = ?";
    public static final String CREATE_PROJECT = "INSERT INTO projects (nickname_user, name_project, description) VALUES (?,?,?)";

    public List<ProyectoDTO> buscarProyectos() throws Exception {
        List<ProyectoDTO> proyectos = new ArrayList<ProyectoDTO>();

        ConnectionDB conexion = new ConnectionDB();
        Connection con = conexion.getConnection("ProyectoDAO.buscarProyectos");

        PreparedStatement ps = con.prepareStatement(this.GET_ALL);
        
        ResultSet rst = ps.executeQuery();

        
        while (rst.next()) {

            ProyectoDTO proyecto = new ProyectoDTO();

            proyecto.setId_proyecto(rst.getInt("id_project"));
            proyecto.setUsuario(rst.getString(1));
            proyecto.setTitulo(rst.getString(2));
            proyecto.setDescripcion(rst.getString(3));
//            proyecto.setUrlImagen(rst.getString(4));
            
            proyectos.add(proyecto);
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
        Connection con = conexion.getConnection("ProyectoDAO.eliminarProyecto");
    
        PreparedStatement sen = null;
        int registros = 0;
        
        try{
            sen = con.prepareStatement(this.DELETE_PROJECT);
            sen.setInt(1, proyecto.getId_proyecto());
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
        Connection con = conexion.getConnection("ProyectoDAO.actualizarProyecto");       
        PreparedStatement ps = null;
        
        int registros = 0;
        
        ps = con.prepareStatement(this.UPDATE_PROJECT);
        
        ps.setInt(3, proyecto.getId_proyecto());
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
        Connection con = conexion.getConnection("ProyectoDAO.crearProyecto");
        
        PreparedStatement ps = con.prepareStatement(this.CREATE_PROJECT);
        
        ps.setString(1, proyecto.getUsuario());
        ps.setString(2, proyecto.getTitulo());
        ps.setString(3, proyecto.getDescripcion());
        //ps.setDate(4, proyecto.getFechaCreacion());
        
        ps.execute();
        rta=true;
        
        ps.close();
        ps = null;
        
        con.close();
        con = null;
        
        return rta;  
    }
    
    
    public  List<ProyectoDTO> buscarProyectosUser(String username) throws SQLException{
        
        List<ProyectoDTO> proyectos = new ArrayList<ProyectoDTO>();

        ConnectionDB conexion = new ConnectionDB();
        Connection con = conexion.getConnection("ProyectoDAO.buscarProyectosUser");

        PreparedStatement ps = con.prepareStatement(this.GET_ONE);
        ps.setString(1,username);
        
        String hola = ps.toString();
        
        ResultSet rst = ps.executeQuery();
        
        

        while (rst.next()) {
            
            ProyectoDTO proyecto = new ProyectoDTO();

            
            proyecto.setId_proyecto(rst.getInt("id_project"));
            proyecto.setUsuario(rst.getString("nickname_user"));
            proyecto.setTitulo(rst.getString("name_project"));
            proyecto.setDescripcion(rst.getString("description"));
            proyecto.setFechaCreacion(rst.getDate("created_at"));
            proyectos.add(proyecto);
        }

        rst.close();
        rst = null;

        ps.close();
        ps = null;

        con.close();
        con = null;

        return proyectos;
        
    
    }
    
    public List<ProyectoDTO> listarProyectos() throws Exception {
        List<ProyectoDTO> proyectos = new ArrayList<ProyectoDTO>();

        ConnectionDB conexion = new ConnectionDB();
        Connection con = conexion.getConnection("ProyectoDAO.listarProyectos");

        PreparedStatement ps = con.prepareStatement(this.GET_ALL_PROJECTS);
        ResultSet rst = ps.executeQuery();

        while (rst.next()) {

            ProyectoDTO proyecto = new ProyectoDTO();
            
            proyecto.setId_proyecto(rst.getInt("id_project"));
            proyecto.setTitulo(rst.getString("name_project"));
            proyecto.setUsuario(rst.getString("nickname_user"));
            proyecto.setDescripcion(rst.getString("description"));

            proyectos.add(proyecto);
        }

        rst.close();
        rst = null;

        ps.close();
        ps = null;

        con.close();
        con = null;

        return proyectos;
    }


}
