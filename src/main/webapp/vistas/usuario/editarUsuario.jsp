<%@page session="true" %>
<%
    HttpSession sesion = request.getSession();
    
    int id = Integer.parseInt(sesion.getAttribute("id").toString());
    String username = sesion.getAttribute("username").toString();
    String name = sesion.getAttribute("name").toString();
    String email = sesion.getAttribute("email").toString();
    String password = sesion.getAttribute("password").toString();
%>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Kaktus Register Architecture">
    <!--Estandar-->
    <link rel="shortcut icon" href="../../assets/img/Kaktus2.svg" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="../../css/normalize.css">
    <!--Fuentes google-->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Quicksand&display=swap" rel="stylesheet">
    <!--Mi css-->
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="shortcut icon" href="assets/img/Kaktus2.svg" type="image/x-icon">
    
    <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="../../js/script.js"></script>
    
    <title>Kaktus | Actualizar datos</title>
    
</head>

<body class="register-page">

    <div class="register background-image">
        <div class="myform__container">
            <form id="form" class="myform" action="<%=request.getContextPath()%>/UsuarioController?accion=editar&id=<%= id %>" method="POST">
                <h1 class="myform__title">Actualizar datos</h1>     
                <div class="myform__field">
                    <label class="form__label" for="name">Nombre</label>
                    <input class="form__input form__input-contain input--no-outline" type="text" name="name" id="name"
                           value="<%= name %>" required>
                </div>

                <div class="myform__field">
                    <label class="form__label" for="email">Correo</label>
                    <input class="form__input form__input-contain input--no-outline" type="email" name="email"
                           id="email"  value="<%= email %>" required>
                </div>

                <div class="myform__field">
                    <label class="form__label" for="user">Usuario</label>
                    <input class="form__input form__input-contain input--no-outline" type="text" name="user" id="user"
                           value="<%= username%>" readonly style="background-color: #EAF0FF">
                </div>

                <div class="myform__field">
                    <label class="form__label" for="password">Nueva Contrase&ntilde;a</label>
                    <input class="form__input form__input-contain input--no-outline" type="password" name="password" id="password"
                           value="<%= password%>" required>
                </div>
                
                <div class="myform__field">
                    <label class="form__label" for="confirm-password">Confirmar nueva Contrase&ntilde;a</label>
                    <input class="form__input form__input-contain input--no-outline" type="password" name="confirm-password" id="confirm-password"
                           value="<%= password%>" required>
                </div>
                
                <div id="alerta-contrasenas"></div>
                
                <div class="myform__btns">
                    <button class="btn--submit btn--noBorder btn--noOutline" type="submit">Actualizar datos</button>
                </div>
 
            </form>
        </div>
    </div>
</body>

</html>