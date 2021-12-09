<%@page session="true" %>
<%
    HttpSession sesion = request.getSession();
    
    int id = Integer.parseInt(sesion.getAttribute("id").toString());
    String username = sesion.getAttribute("username").toString();
%>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Kaktus Register Architecture">
    <!--Estandar-->
    <link rel="stylesheet" type="text/css" href="../../css/normalize.css">
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
            
            <form id="form" class="myform" action="<%=request.getContextPath()%>/UsuarioController?accion=foto&id=<%= id %>&user=<%= username%>"
                  method="POST" enctype="multipart/form-data">
                
                <h1 class="myform__title">Cambiar foto de perfil</h1>     
                
                <div class="myform__field">
                    <label class="form__label" for="foto">Foto</label>
                    <input class="form__input form__input-contain input--no-outline" type="file" name="foto" id="foto">
                </div>
    
                <div class="myform__btns">
                    <button class="btn--submit btn--noBorder btn--noOutline" type="submit">Guardar</button>
                </div>
            </form>
                
        </div>
    </div>
</body>

</html>