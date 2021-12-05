/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entidades.ProyectoDTO;
import facade.ProyectoFacade;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Diego Pedrozo
 */
@WebServlet("/ProyectoController")
public class ProyectoController extends HttpServlet{
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String accion = request.getParameter("accion");
        
        if (accion.equals("crear")) {
            
            HttpSession sesion = request.getSession();
            String username = sesion.getAttribute("username").toString();
            String titulo = request.getParameter("titulo");
            String descripcion = request.getParameter("descripcion");

            ProyectoFacade proyectoFacade = new ProyectoFacade();
            
            ProyectoDTO proyectoDTO = new ProyectoDTO();
            proyectoDTO.setUsuario(username);
            proyectoDTO.setTitulo(titulo);
            proyectoDTO.setDescripcion(descripcion);

            boolean rta = false;
        
            try {
                rta = proyectoFacade.crearProyecto(proyectoDTO);
                response.sendRedirect("/Kaktus-Arquitectura-proyectos/vistas/usuario/usuario.jsp");
                
            } catch (Exception e) {
                e.printStackTrace();
            }   
        }     
        
        if (accion.equals("editar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String titulo = request.getParameter("titulo");
            String descripcion = request.getParameter("descripcion");

            ProyectoFacade proyectoFacade = new ProyectoFacade();
            
            ProyectoDTO proyectoDTO = new ProyectoDTO();
            proyectoDTO.setId_proyecto(id);
            proyectoDTO.setTitulo(titulo);
            proyectoDTO.setDescripcion(descripcion);

            int rta = 0;
        
            try {
                rta = proyectoFacade.actualizarProyecto(proyectoDTO);
                response.sendRedirect("/Kaktus-Arquitectura-proyectos/vistas/usuario/usuario.jsp");
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } 
    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String accion = request.getParameter("accion");
        int id = Integer.parseInt(request.getParameter("id"));
        
        if(accion.equals("eliminar")){
            ProyectoFacade proyectoFacade = new ProyectoFacade();
            
            ProyectoDTO proyectoDTO = new ProyectoDTO();
            proyectoDTO.setId_proyecto(id);

            int rta = 0;
        
            try {
                rta = proyectoFacade.eliminarProyecto(proyectoDTO);
                response.sendRedirect("/Kaktus-Arquitectura-proyectos/vistas/usuario/usuario.jsp");
                
            } catch (Exception e) {
                e.printStackTrace();
            }            
        }
    }
    
}
