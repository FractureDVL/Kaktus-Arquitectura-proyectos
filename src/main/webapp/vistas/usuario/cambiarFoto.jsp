<%@page session="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession();

    int id = Integer.parseInt(sesion.getAttribute("id").toString());
    String username = sesion.getAttribute("username").toString();
%>

<!DOCTYPE html>
<html lang="es">

    <head>
         <meta content="text/html" charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Kaktus Register Architecture">
        <!--Estandar-->
        <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
        <link rel="stylesheet" type="text/css" href="../../css/normalize.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css"
        <!--Fuentes google-->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Quicksand&display=swap" rel="stylesheet">
        <!--Mi css-->
        <link rel="stylesheet" href="../../css/style.css">
        <link rel="shortcut icon" href="assets/img/Kaktus2.svg" type="image/x-icon">

        <title>Kaktus | Cambiar foto</title>

    </head>

    <body class="register-page">

        <div class="register background-image">
            <div class="myform__container">

                <form id="form" class="myform" action="<%=request.getContextPath()%>/UsuarioController?accion=foto&id=<%= id%>&user=<%= username%>"
                      method="POST" enctype="multipart/form-data">

                    <h1 class="myform__title" style="font-size: 30px">Cambiar foto de perfil</h1>     
                    
                    <div class="file is-boxed">
                        <label class="file-label" for="foto">
                          <input class="file-input" type="file" name="foto" id="foto">
                          <span class="file-cta">
                            <span class="file-icon">
                                <i class='bx bx-cloud-upload' style="font-size: 40px"></i>
                            </span>
                            <span class="file-label">
                              Escoge una imagen…
                            </span>
                          </span>
                        </label>
                      </div>
                    <div class="myform__btns cancel-btn">
                        <button class="btn--submit btn--noBorder btn--noOutline" type="submit">Guardar</button>
                        <a hidden="true" class="btn--cancel btn--noBorder btn--noOutline" style="background-color: " href="../usuario/usuario.jsp">Cancelar</a>
                    </div>
                </form>

            </div>
        </div>
    </body>

</html>