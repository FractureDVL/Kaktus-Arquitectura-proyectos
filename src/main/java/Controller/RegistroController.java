/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dao.UsuarioDAO;
import entidades.UsuarioDTO;
import facade.UsuarioFacade;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
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
            String confirmPassword = request.getParameter("confirm-password");

            UsuarioFacade usuarioFacade = new UsuarioFacade();

            UsuarioDTO usuarioDto = new UsuarioDTO();
            usuarioDto.setName(name);
            usuarioDto.setEmail(email);
            usuarioDto.setUser(user);
            usuarioDto.setPassword(password);
            usuarioDto.setImgUrl("../../assets/img/user-photo.png");

            List<UsuarioDTO> listaUsuarios = new ArrayList();
            listaUsuarios = usuarioFacade.buscarUsuarios();

            int rtaUser = 0;
            int rtaEmail = 0;

            boolean rta = false;

            try {
                for (UsuarioDTO u : listaUsuarios) {
                    String uUser = u.getUser();
                    String uEmail = u.getEmail();

                    if (uUser.equals(user)) {
                        rtaUser = 1;
                    }

                    if (uEmail.equals(email)) {
                        rtaEmail = 1;
                    }
                }
                
                if (confirmPassword.equals(password) && rtaUser==0 && rtaEmail==0) {
                    rta = usuarioFacade.registrarUsuario(usuarioDto);

                    File f = new File("C:\\Kaktus-Arquitectura-proyectos\\src\\main\\webapp\\public\\" + user);
                    File f1 = new File("C:\\Kaktus-Arquitectura-proyectos\\src\\main\\webapp\\public\\" + user + "\\Proyectos");
                    f.mkdir();
                    f1.mkdir();

                    response.sendRedirect("/Kaktus-Arquitectura-proyectos/vistas/login/login.jsp?rta=1");

                } else {
                    request.setAttribute("name", name);
                    request.setAttribute("email", email);
                    request.setAttribute("user", user);
                    
                    RequestDispatcher dispatcher = request.getRequestDispatcher("vistas/registro/registro.jsp?rtaUser="+rtaUser+"&&rtaEmail="+rtaEmail);
                    dispatcher.forward(request, response);

                    response.sendRedirect("/Kaktus-Arquitectura-proyectos/vistas/registro/registro.jsp?rtaUser="+rtaUser+"&&rtaEmail="+rtaEmail);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
