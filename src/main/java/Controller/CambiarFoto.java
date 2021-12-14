package Controller;

import entidades.UsuarioDTO;
import facade.UsuarioFacade;
import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;
@WebServlet("/CambiarFoto")
public class CambiarFoto extends HttpServlet {
           
          
    
	   boolean isMultipart;	   
	   long maxFileSize = 1024 * 1024*1024;
	   int maxMemSize = 4 * 1024;
	   File file ;
	   String fileName;
	   
	   
	   public void doPost(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, java.io.IOException {
              
              UsuarioFacade usuarioFacade = new UsuarioFacade();
              UsuarioDTO usuario = new UsuarioDTO(); 
              int id = Integer.parseInt(request.getParameter("id"));
              String user = String.valueOf(request.getParameter("user"));
              
              String FileLocation="C:/Kaktus-Arquitectura-proyectos/src/main/webapp/public/"+user+"/";
	      isMultipart = ServletFileUpload.isMultipartContent(request);
	      
	      response.setContentType("text/html");
	      java.io.PrintWriter out = response.getWriter( );

	  
	      DiskFileItemFactory factory = new DiskFileItemFactory();
	   
	      // maximum size that will be stored in memory
	      factory.setSizeThreshold(maxMemSize);
	   
	      // Location to save data that is larger than maxMemSize.
	      factory.setRepository(new File(FileLocation));

	      // Create a new file upload handler
	      ServletFileUpload upload = new ServletFileUpload(factory);
	   
	      // maximum file size to be uploaded.
	      upload.setSizeMax( maxFileSize );

	      try { 
	         // Parse the request to get file items.
	         List fileItems = upload.parseRequest(request);
	         System.out.println(fileItems);
		
	         // Process the uploaded file items
	         Iterator i = fileItems.iterator();

	         while ( i.hasNext () ) {
	            FileItem fi = (FileItem)i.next();
	            
	            //to get image 
	            if ( !fi.isFormField () ) {
	               // Get the uploaded file parameters
	               String fieldName = fi.getFieldName();
	               fileName = fi.getName();
	               String contentType = fi.getContentType();
	               boolean isInMemory = fi.isInMemory();
	               long sizeInBytes = fi.getSize();
	               // Write the file
	               if( fileName.lastIndexOf("\\") >= 0 ) {
	                  file = new File( FileLocation + fileName.substring( fileName.lastIndexOf("\\"))) ;
	               } else {
	                  file = new File( FileLocation + fileName.substring(fileName.lastIndexOf("\\")+1)) ;
	               }
	               fi.write( file ) ;

	            }
	            //to get form data field
	            else
	            {
	            	  String name = fi.getFieldName();//text1
	                  String value =fi.getString();
	                  System.out.println(name);
	                  System.out.println(value);
	            }
	         
	         }
                 String ruta = fileName;
                 usuario.setImgUrl(ruta);
                 usuario.setId(id);
                 usuario.setUser(user);
                 
                 usuarioFacade.actualizarFoto(usuario);
                 
                 request.getSession().setAttribute("image_url",ruta);
                
                 response.sendRedirect("../Kaktus-Arquitectura-proyectos/vistas/usuario/usuario.jsp");
                 
	         } catch(Exception ex) {
	            System.out.println(ex);
	         }
	      }
	      
	   }
   
