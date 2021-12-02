package controller;

import dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.UsuarioDTO;

@WebServlet("/register")
public class UsuarioController extends HttpServlet {

    
//    private UsuarioDAO u = new UsuarioDAO();
//    UsuarioDTO usuario = new UsuarioDTO();
//    int r;
//    
//    //Contructor
//    
//    public UsuarioController(){
//        super();
//    }
//    
//    
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        response.getWriter().append("Server at: ").append(request.getContextPath());
//        RequestDispatcher dispacher = request.getRequestDispatcher("webapp/login.html");
//        dispacher.forward(request, response);
//    
//    }
//    
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//       String accion = request.getParameter("accion");
//       if (accion != null){
//       switch(accion){
//           case "insertar":
//               this.insertar(request, response);
//               break;
//           case "login":
//               this.login(request, response);
//               break;
//       }
//       }       
//    }
//    
//    protected void insertar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String user = request.getParameter("user");
//        String password = request.getParameter("password");
//
//        usuario = new UsuarioDTO(name, email, user, password);
//        
//        u.crearUsuario(usuario);
//        
//        response.sendRedirect("vistas/login/login.jsp");
//    }
//    
//    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        String user = request.getParameter("user");
//        String password = request.getParameter("password");
//            
//        usuario.setUser(user);
//        usuario.setPassword(password);
//        r = u.login(usuario);
//        if(r==1){
//            response.sendRedirect("vistas/usuario/usuario.html");
//        }
//        else{ 
//            response.sendRedirect("vistas/registro/registro.jsp");
//        }
//    }
}
