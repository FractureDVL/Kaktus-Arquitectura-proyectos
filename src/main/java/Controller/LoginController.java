package Controller;

import dao.UsuarioDAO;
import entidades.UsuarioDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
            try{
                if (rta == 1) {
                    
                    UsuarioDTO usuario1 = new UsuarioDTO();
                    usuario1 = usuario.obtenerUsuario(username, password);
                    
                    request.getSession().setAttribute("id",usuario1.getId());
                    request.getSession().setAttribute("name",usuario1.getName());
                    request.getSession().setAttribute("email",usuario1.getEmail());
                    request.getSession().setAttribute("username",username);
                    request.getSession().setAttribute("password",password);
                    request.getSession().setAttribute("image_url",usuario1.getImgUrl());
                    request.getSession().setAttribute("role",usuario1.getRole());
                    
                    response.sendRedirect("/Kaktus-Arquitectura-proyectos/vistas/usuario/usuario.jsp");
                    
                } else {
                    //request.setAttribute("rta", rta);
                    response.sendRedirect("/Kaktus-Arquitectura-proyectos/vistas/login/login.jsp?rta="+rta);
                    //PrintWriter out = response.getWriter();
                    //response.setContentType("text/html;charset=UTF-8");
                    //out.println("<script type=\"text/javascript\">");
                    //out.println("alert('Usuario o contraseña incorrectos');");
                    //out.println("location='/Kaktus-Arquitectura-proyectos/vistas/login/login.jsp';");
                    //out.println("</script>");
                } 
                } catch (Exception e) {
                    response.sendRedirect("/Kaktus-Arquitectura-proyectos/vistas/login/login.jsp");
                }

        }
    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String accion = request.getParameter("accion");
        HttpSession sesion = request.getSession();
        
        if (accion.equals("salir")) {
            sesion.invalidate();
        
            response.sendRedirect("#");
        }
    }
}
