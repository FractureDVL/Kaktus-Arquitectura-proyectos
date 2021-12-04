package Controller;

import dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String accion = request.getParameter("accion");
        
        if (accion.equals("ingresar")) {

            String username = request.getParameter("user");
            String password = request.getParameter("password");

            UsuarioDAO usuario = new UsuarioDAO();
            int rta = 0;
        
            try {
                rta = usuario.validarSesion(username, password);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (rta == 1) {
                
                request.getSession().setAttribute("username", username);
                response.sendRedirect("/Kaktus-Arquitectura-proyectos/vistas/usuario/usuario.jsp");
            } else {
                response.sendRedirect("/login/login.jsp?rta=" + rta);
            }
        }
        if(accion.equals("salir")){
        
        response.sendRedirect("/Kaktus-Arquitectura-proyectos/");
        }

    }
    
    
}
