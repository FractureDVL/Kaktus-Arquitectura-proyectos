<%-- 
    Document   : procesarLogin
    Created on : 8 oct. 2021, 11:07:41 a. m.
    Author     : Diego Pedrozo
--%>
<%@page import="modelo.Usuario" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="gestion" class="modelo.ListaUsuarios" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Kaktus |Procesar Login</title>
    </head>
    <body>
        <h1>Wenas</h1>
        <%
            boolean verificar = false;
            for(Usuario u: gestion.getLista()){
                String user = u.getUser();
                String password =u.getPassword();
                String userIngresado = request.getParameter("user");
                String passwordIngresada = request.getParameter("password");
                
                if(user.equals(userIngresado)&& password.equals(passwordIngresada)){
                    verificar = true;
        %>
                    <p>Bienvenido <%=user%>, su inicio de sesión se llevo a cabo correctamente</p>
                    <p>Usuario ingresado --> <%=userIngresado%></p>
                    <p>Contraseña ingresada --> <%=passwordIngresada%></p>
        <%
                    break;
               }
               else{
                    verificar = false;         
                }
            }
            if(verificar==false){

         %>
                     <p>Los datos ingresados no coinciden con alguno de nuestros usuarios</p>
                     <p>Usuario ingresado --> <%=request.getParameter("user")%></p>
                     <p>Contraseña ingresada --> <%=request.getParameter("password")%></p>
         <%
            }
        %>
        <h1>Usuarios registrados</h1>
        <div>
            <table>
                <thead>
                    <tr>
                        <th>Usuario</th>
                        <th>Contraseña</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Usuario us : gestion.getLista()){
                    %>
                    <tr>
                        <td><%= us.getUser() %></td>
                        <td><%= us.getPassword() %></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
        <input type="button" value="Registrarse" onclick="location.href = 'register.html'">
        <input type="button" value="Ingresar" onclick="location.href = 'login.html'">
    </body>
</html>
