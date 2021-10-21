package controller;

import dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.UsuarioDTO;

@WebServlet("/register")
public class UsuarioController extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       String accion = request.getParameter("accion");
       if (accion != null){
       switch(accion){
           case "insertar":
               this.insertar(request, response);
               break;
           case "modificar":
               break;
       }
       }       
    }
    
    private void insertar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String name = request.getParameter("name");
       String email = request.getParameter("email");
       String user = request.getParameter("user");
       String password = request.getParameter("password");
              
       UsuarioDTO usuario = new UsuarioDTO(name, email, user, password);                   
       int registros = new UsuarioDAO().insertar(usuario);
    }
    
}
