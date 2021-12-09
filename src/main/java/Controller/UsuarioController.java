/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dao.UsuarioDAO;
import entidades.Imagen;
import entidades.UsuarioDTO;
import facade.UsuarioFacade;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

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

        if (accion.equals("foto")) {
            UsuarioDAO uDao = new UsuarioDAO();
            UsuarioDTO uDto = new UsuarioDTO();
            Imagen i = new Imagen();
            
            int id = Integer.parseInt(request.getParameter("id"));
            String username = request.getParameter("user");
            
            InputStream inputStream = null;
            
            Part filePart = request.getPart("foto");
            inputStream = filePart.getInputStream();
            i.setImagen(inputStream);
            i.setUsuario(username);
            uDao.eliminarFoto(username);
            uDao.agregarFoto(i);
            response.sendRedirect("/Kaktus-Arquitectura-proyectos/vistas/usuario/usuario.jsp");
        }   
    
    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String accion = request.getParameter("accion");
         if(accion.equals("verFoto")){
            response.setContentType("image/png");

        ConnectionDB conexion = new ConnectionDB();
        PreparedStatement ps = null;
        ResultSet rs = null;
        byte[] b = null;

        try {

            String username = request.getParameter("user");
            ps = conexion.getConnection("").prepareStatement("SELECT image FROM image_user WHERE usuario = ?;");
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                b = rs.getBytes(1);
            }
            InputStream bos = new ByteArrayInputStream(b);

            int tamanoInput = bos.available();
            byte[] datosIMAGEN = new byte[tamanoInput];
            bos.read(datosIMAGEN, 0, tamanoInput);

            response.getOutputStream().write(datosIMAGEN);
            bos.close();
            ps.close();
            rs.close();
            conexion = null;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        }
    }
}
