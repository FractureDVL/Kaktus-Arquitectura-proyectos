<%@page session="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String n = request.getParameter("name");
    String e = request.getParameter("email");
    String u = request.getParameter("user");
%>
<%!
    public String nulos(String parametro){
        String n = "";
        if(parametro == null){
            n = "";
        }   
        else{
            n = parametro;
        } 
        return n;
    }
%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta content="text/html" charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Kaktus Register Architecture">
        <!--Estandar-->
        <link rel="shortcut icon" href="<%=request.getContextPath()%>../../assets/img/Kaktus2.svg" type="image/x-icon">
        <link rel="shortcut icon" href="../../assets/img/Kaktus2.svg" type="image/x-icon">
        <link rel="stylesheet" type="text/css" href="../../css/normalize.css">
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/normalize.css">
        <!--Fuentes google-->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Quicksand&display=swap" rel="stylesheet">
        <!--Mi css-->
        <link rel="stylesheet" href="../../css/style-import.css">
        <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style-import.css">
        <link rel="shortcut icon" href="assets/img/Kaktus2.svg" type="image/x-icon">

        <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
        <script src="../../js/script.js"></script>
        <script src="<%= request.getContextPath() %>/js/script.js"></script>

        <title>Kaktus | Registro</title>
    </head>

    <body class="register-page">

        <div class="register background-image">

            <div class="myform__container">
                <form id="form" class="myform" action="<%=request.getContextPath()%>/RegistroController?accion=registrar" method="POST">
                    <h1 class="myform__title">Crear cuenta</h1>
                    <p class="myform__text">¿Ya tienes cuenta? <a class="text__link" href="../login/login.jsp?rta=1">Inicia sesi&oacute;n.</a></p>
                    <div class="myform__field">
                        <label class="form__label" for="name">Nombre</label>
                        <input class="form__input form__input-contain input--no-outline" type="text" name="name" id="name"
                               value="<%= nulos(n) %>" required>
                    </div>

                    <div class="myform__field">
                        <label class="form__label" for="email">Correo</label>
                        <input class="form__input form__input-contain input--no-outline" type="email" name="email"
                               id="email"  value="<%= nulos(e) %>" required>
                    </div>
                    <%
                            int rtaEmail = Integer.parseInt(request.getParameter("rtaEmail"));
                            if(rtaEmail==1){
                    %>   
                    <div id="alerta-login">Correo electronico ya en uso</div>
                    <%
                        }
                    %>

                    <div class="myform__field">
                        <label class="form__label" for="user">Usuario</label>
                        <input class="form__input form__input-contain input--no-outline" type="text" name="user" id="user"
                               value="<%= nulos(u) %>" required>
                    </div>
                    <%
                        int rtaUser = Integer.parseInt(request.getParameter("rtaUser"));
                        if(rtaUser==1){
                    %>   
                    <div id="alerta-login">Usuario ya en uso</div>
                    <%
                        }
                    %>

                    <div class="myform__field">
                        <label class="form__label" for="password">Contrase&ntilde;a</label>
                        <input class="form__input form__input-contain input--no-outline" type="password" name="password" id="password"
                               required>
                    </div>
                    <div class="myform__field">
                        <label class="form__label" for="confirm-password">Confirmar contrase&ntilde;a</label>
                        <input class="form__input form__input-contain input--no-outline" type="password" name="confirm-password" id="confirm-password"
                               required>
                    </div>

                    <div id="alerta-contrasenas"></div>

                    <div class="myform__btns">
                        <button class="btn--submit btn--noBorder btn--noOutline" type="submit">Registrarse</button>
                    </div>
                </form>
            </div>
        </div>

    </body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

</html>