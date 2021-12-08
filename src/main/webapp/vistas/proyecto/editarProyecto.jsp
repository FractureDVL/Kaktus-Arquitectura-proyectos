<%@page session="true" %>

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
    <title>Kaktus | Editar Proyecto</title>
</head>

<body class="register-page">

    <div class="register background-image">

        <div class="myform__container">
            <form class="myform" action="<%=request.getContextPath()%>/ProyectoController?accion=editar&id=<%= request.getParameter("id") %>" method="POST">
                <h1 class="myform__title">Editar proyecto</h1>

                <div class="myform__field">
                    <label class="form__label" for="titulo">Titulo</label>
                    <input class="form__input form__input-contain input--no-outline" type="text" name="titulo"
                           id="titulo" value=<%= request.getParameter("titulo") %> required>
                </div>

                <div class="myform__field">
                    <label class="form__label" for="descripcion">Descripción</label>
                    <input class="form__input form__input-contain input--no-outline" type="text" name="descripcion" id="descripcion"
                        value=<%= request.getParameter("descripcion") %> required>
                </div>

                <div class="myform__btns">
                    <button class="btn--submit btn--noBorder btn--noOutline" type="submit">Actualizar</button>
                </div>
            </form>
        </div>
    </div>

</body>

</html>
