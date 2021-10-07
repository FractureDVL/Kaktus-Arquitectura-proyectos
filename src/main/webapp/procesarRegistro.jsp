<%-- 
    Document   : procesarRegistro
    Created on : 6 oct. 2021, 9:02:02 p. m.
    Author     : Diego Pedrozo
--%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String user = request.getParameter("user");
    String password = request.getParameter("password");
    
    Usuario u = new Usuario(name, email, user, password);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kaktus |Procesar Registro </title>
    </head>
     
    <body>
        <h1>Wenas Tardes <%= u.getName() %> </h1>
        <p>Su registro ha sido exitoso 😎</p>
        <p>Sus datos registrados son:</p>
        <%= u.getEmail()%>
        <br>
        <%= u.getUser()%>
        <br>
        <%= u.getPassword()%>
    </body>
</html>
