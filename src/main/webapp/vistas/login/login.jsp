
<%@page import="entidades.UsuarioDTO"%>
<%@page import="dao.UsuarioDAO"%>
<%@page session="true" %>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Login Kaktus Architecture">
        <meta name="keywords" content="">
        <!--Estandar-->
        <link rel="shortcut icon" href="../../assets/img/Kaktus2.svg" type="image/x-icon">
        <link rel="stylesheet" href="../../css/normalize.css">
        <!--Iconos google-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Outlined" rels="stylesheet">
        <!--Fuentes google-->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Quicksand&display=swap" rel="stylesheet">
        <!--Mi css-->
        <link rel="stylesheet" href="../../css/style-import.css">
        <link rel="shortcut icon" href="assets/img/Kaktus2.svg" type="image/x-icon">

        <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
        <!--<script src="../../js/script.js"></script>-->

        <title> Kaktus | Iniciar sesi&oacute;n</title>
    </head>

    <body class="login-page">

        <div class="login background-image">

            <div class="myform__container">
                <form id="login" class="myform" action="<%=request.getContextPath()%>/LoginController?accion=ingresar" method="POST">
                    <h1 class="myform__title">Iniciar sesi&oacute;n</h1>
                    <p class="myform__text"><span>A&uacute;n no tienes cuenta?</span><a class="text__link" href="../registro/registro.jsp?rtaUser=0&&rtaEmail=0"> Crea una cuenta.</a></p>

                    <div class="myform__field">
                        <label class="form__label" for="user">Usuario</label>
                        <input class="form__input form__input-contain" type="text" name="user" id="user" required>
                    </div>
                    <div class="myform__field">
                        <label class="form__label" for="password">Contrase&ntilde;a</label>
                        <input class="form__input form__input-contain input--no-outline" type="password" name="password"
                               id="password" required>
                        <p class="forgot-pass--ctn"><a class="forgot__pass" href="../recuperacionContrasenia/reset_password.jsp">Olvidaste tu contrase&ntilde;a?</a></p>
                    </div>
                    <%
                        int a = Integer.parseInt(request.getParameter("rta"));
                        if(a==0){
                    %>   
                    <div id="alerta-login">Usuario o contraseña incorrectos</div>
                    <%
                        }
                    %>
                    
                    <div class="myform__btns">
                        <button class="btn--submit btn--noBorder btn--noOutline" type="submit">Ingresar</button>
                        <!--<input class="btn--submit btn--noBorder btn--noOutline" type="submit" value="Ingresar">-->

                        <p class="myform__text text--nodisplay"><span>A&uacute; no tienes cuenta?</span><br>
                            <a class="text__link" href="register.html"> Crea una cuenta.</a></p>
                    </div>
                </form>
            </div>
        </div>
    </body>

</html>