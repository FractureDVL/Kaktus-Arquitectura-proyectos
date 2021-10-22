package controller;

import dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.UsuarioDTO;

@WebServlet("/register")
public class UsuarioController extends HttpServlet {

    
    private UsuarioDAO u = new UsuarioDAO();
    
    //Contructor
    
    public UsuarioController(){
        super();
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.getWriter().append("Server at: ").append(request.getContextPath());
        RequestDispatcher dispacher = request.getRequestDispatcher("webapp/login.html");
        dispacher.forward(request, response);
    
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String user = request.getParameter("user");
        String password = request.getParameter("password");

        UsuarioDTO usuario = new UsuarioDTO(name, email, user, password);
        
        u.crearUsuario(usuario);
        
        response.sendRedirect("registro.jsp");
    }
    
}
