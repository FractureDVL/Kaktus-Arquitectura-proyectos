/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entidades.UsuarioDTO;
import facade.UsuarioFacade;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diego Pedrozo
 */
@MultipartConfig
@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String accion = request.getParameter("accion");

        if (accion.equals("editar")) {

            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            UsuarioFacade usuarioFacade = new UsuarioFacade();

            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setId(id);
            usuarioDTO.setName(name);
            usuarioDTO.setEmail(email);
            usuarioDTO.setPassword(password);

            request.getSession().setAttribute("name", name);
            request.getSession().setAttribute("email", email);
            request.getSession().setAttribute("password", password);

            int rta = 0;

            try {
                rta = usuarioFacade.actualizarUsuario(usuarioDTO);
                response.sendRedirect("/Kaktus-Arquitectura-proyectos/vistas/usuario/usuario.jsp");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

       
        }
}



