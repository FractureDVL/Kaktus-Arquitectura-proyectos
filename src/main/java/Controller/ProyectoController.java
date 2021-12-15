/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entidades.ProyectoDTO;
import facade.ProyectoFacade;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Diego Pedrozo
 */
@WebServlet("/ProyectoController")
public class ProyectoController extends HttpServlet{
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String accion = request.getParameter("accion");
        if (accion.equals("crear")) {
            
            HttpSession sesion = request.getSession();
            String username = sesion.getAttribute("username").toString();
            String titulo = request.getParameter("titulo");
            String descripcion = request.getParameter("descripcion");
            sesion.setAttribute("titulo", titulo);
            File f = new File("C:\\Kaktus-Arquitectura-proyectos\\src\\main\\webapp\\public\\" + username + "\\Proyectos\\"+ titulo+"\\");
            f.mkdir();
                    
            
            ProyectoFacade proyectoFacade = new ProyectoFacade();
            
            ProyectoDTO proyectoDTO = new ProyectoDTO();
            proyectoDTO.setUsuario(username);
            proyectoDTO.setTitulo(titulo);
            proyectoDTO.setDescripcion(descripcion);
            
            
            boolean rta = false;
        
            try {
                rta = proyectoFacade.crearProyecto(proyectoDTO);
                
                response.sendRedirect("/Kaktus-Arquitectura-proyectos/vistas/proyecto/agregarImagen.jsp?t="+titulo);
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }   
        }
        
        
        if (accion.equals("editar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String titulo = request.getParameter("titulo");
            String descripcion = request.getParameter("descripcion");

            ProyectoFacade proyectoFacade = new ProyectoFacade();
            
            ProyectoDTO proyectoDTO = new ProyectoDTO();
            proyectoDTO.setId_proyecto(id);
            proyectoDTO.setTitulo(titulo);
            proyectoDTO.setDescripcion(descripcion);

            int rta = 0;
        
            try {
                rta = proyectoFacade.actualizarProyecto(proyectoDTO);
                response.sendRedirect("/Kaktus-Arquitectura-proyectos/vistas/usuario/usuario.jsp");
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
        if (accion.equals("foto")) {
            
            HttpSession sesion = request.getSession();
            String username = sesion.getAttribute("username").toString();
            String titulo = sesion.getAttribute("titulo").toString();
            
            
            boolean isMultipart;	   
            long maxFileSize = 1024 * 1024*1024;
            int maxMemSize = 4 * 1024;
            File file ;
            String fileName = null;
        
            String FileLocation = "C:/Kaktus-Arquitectura-proyectos/src/main/webapp/public/" + username + "/Proyectos/"+titulo+"/";
            isMultipart = ServletFileUpload.isMultipartContent(request);

            response.setContentType("text/html");
            java.io.PrintWriter out = response.getWriter();

            DiskFileItemFactory factory = new DiskFileItemFactory();

            // maximum size that will be stored in memory
            factory.setSizeThreshold(maxMemSize);

            // Location to save data that is larger than maxMemSize.
            factory.setRepository(new File(FileLocation));

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            // maximum file size to be uploaded.
            upload.setSizeMax(maxFileSize);

            try {
                // Parse the request to get file items.
                List fileItems = upload.parseRequest(request);
                System.out.println(fileItems);

                // Process the uploaded file items
                Iterator i = fileItems.iterator();

                while (i.hasNext()) {
                    FileItem fi = (FileItem) i.next();

                    //to get image 
                    if (!fi.isFormField()) {
                        // Get the uploaded file parameters
                        String fieldName = fi.getFieldName();
                        fileName = fi.getName();
                        String contentType = fi.getContentType();
                        boolean isInMemory = fi.isInMemory();
                        long sizeInBytes = fi.getSize();
                        // Write the file
                        if (fileName.lastIndexOf("\\") >= 0) {
                            file = new File(FileLocation + fileName.substring(fileName.lastIndexOf("\\")));
                        } else {
                            file = new File(FileLocation + fileName.substring(fileName.lastIndexOf("\\") + 1));
                        }
                        fi.write(file);

                    } //to get form data field
                    else {
                        String name = fi.getFieldName();//text1
                        String value = fi.getString();
                        System.out.println(name);
                        System.out.println(value);
                    }

                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
            
            ProyectoDTO proyecto = new ProyectoDTO(); 
            ProyectoFacade proyectoFacade = new ProyectoFacade();
            String ruta = fileName;
            
            //String titulo = request.getParameter("t");
            
            proyecto.setTitulo(titulo);
            
            proyecto.setImagen(ruta);
                 
            proyectoFacade.actualizarImagen(proyecto);
                
            response.sendRedirect("../Kaktus-Arquitectura-proyectos/vistas/usuario/usuario.jsp");

        
        }
        
    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String accion = request.getParameter("accion");
        int id = Integer.parseInt(request.getParameter("id"));
        
        if(accion.equals("eliminar")){
            ProyectoFacade proyectoFacade = new ProyectoFacade();
            
            ProyectoDTO proyectoDTO = new ProyectoDTO();
            proyectoDTO.setId_proyecto(id);

            int rta = 0;
        
            try {
                
                rta = proyectoFacade.eliminarProyecto(proyectoDTO);
                
                response.sendRedirect("/Kaktus-Arquitectura-proyectos/vistas/usuario/usuario.jsp");
                
            } catch (Exception e) {
                e.printStackTrace();
            }            
        }
    }
    
}