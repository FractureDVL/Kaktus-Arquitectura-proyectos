/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entidades.UsuarioDTO;
import facade.UsuarioFacade;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diego Pedrozo
 */
@WebServlet("/RegistroController")
public class RegistroController extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String accion = request.getParameter("accion");
        
        if (accion.equals("registrar")) {

            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String user = request.getParameter("user");
            String password = request.getParameter("password");
            

            UsuarioFacade usuarioFacade = new UsuarioFacade();
            
            UsuarioDTO usuarioDto = new UsuarioDTO();
            usuarioDto.setName(name);
            usuarioDto.setEmail(email);
            usuarioDto.setUser(user);
            usuarioDto.setPassword(password);

            boolean rta = false;
        
            try {
                rta = usuarioFacade.registrarUsuario(usuarioDto);
                response.sendRedirect("/Kaktus-Arquitectura-proyectos/vistas/login/login.jsp");
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }
    
}
