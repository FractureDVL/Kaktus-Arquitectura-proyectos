import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/iniciarSesion")
public class IniciarSesion extends HttpServlet {
    private static final long serialVersionUID = -881190270020485083L;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("user");
        String password = request.getParameter("password");

        // Get the session if exists or create a new one.
        HttpSession session = request.getSession(true);

        // Set session attributes
        session.setAttribute("user", username);
        session.setAttribute("password", password);
        
        response.sendRedirect("../../vistas/procesarLogin.jsp");

        try {
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}