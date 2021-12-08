<%@page session="true" %>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Navbar | Kaktus</title>
        <!--Estándar-->
        <link rel="stylesheet" href="css/normalize.css">
        <!--Iconos google-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Outlined" rels="stylesheet">
        <!--Fuentes google-->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Quicksand&display=swap" rel="stylesheet">
        <!--Brand logo font-->
        <link href="https://fonts.googleapis.com/css2?family=Oxygen:wght@700&display=swap" rel="stylesheet">
        <!--Mi css-->
        <link rel="stylesheet" href="css/style-nav.css">
    </head>

    <body class="landing-page">

        <header class="header">

            <a class="header__brand link--no-deco" href="#">
                <img class="nav__brand-logo" src="assets/img/Kaktus2.svg" alt="">
                <p class="nav__brand-text-logo">kaktus</p>
            </a>

            <div class="header__search-bar">
                <form class="search-bar__form" action="search.jsp">
                    <button class="search-bar__btn" type="submit">
                        <span class="material-icons-outlined clr-white">search</span>
                    </button>

                    <input class="search-bar__input input--no-deco" type="search" name="" id="" placeholder="Buscar...">
                </form>
            </div>

            <nav class="header__nav">
                <a class="nav__option-link link--no-deco link-clr cursor-p" href="">ES</a>
                <%
                    HttpSession sesion =request.getSession();
                    String username;
                    username = (String) sesion.getAttribute("username");
                    
                    if(username==null){
                %>
                <a class="nav__option-link link--no-deco link-clr btn--style-nb cursor-p" href="vistas/login/login.jsp?rta=1">Iniciar sesión</a>
                <a class="nav__option-link link--no-deco link-clr btn--style-b cursor-p" href="vistas/registro/registro.jsp">Registrarse</a>
                <%
                    }
                    else{
                %>
                <a class="nav__option-link link--no-deco link-clr btn--style-nb cursor-p" href="vistas/usuario/usuario.jsp"> <%= username%> </a>
                <%
                    }
                %>
            </nav>
        </header>
        <article class="article">

            <div class="reference">
                <div class="images">
                    <img src="assets/img/reference.png" alt="project reference" width="450px">
                </div>

                <div class="info-text">
                    <h2 class="title">Lorem ipsum dolor sit amet consectetur, adipisicing elit. </h2>
                    <p class="description">Lorem ipsum dolor sit amet consectetur adipisicing elit. Quasi est aliquam
                        dolorum, aperiam placeat laboriosam harum ea consequatur non! Laudantium facere rerum ad quae vero
                        maxime eveniet, non nihil! Porro?</p>
                </div>

            </div>

            <div class="reference">
                <div class="images">
                    <img src="assets/img/reference2.png" alt="project reference" width="450px">
                </div>

                <div class="info-text">
                    <h2 class="title">Lorem ipsum dolor sit amet consectetur, adipisicing elit. </h2>
                    <p class="description">Lorem ipsum dolor sit amet consectetur adipisicing elit. Quasi est aliquam
                        dolorum, aperiam placeat laboriosam harum ea consequatur non! Laudantium facere rerum ad quae vero
                        maxime eveniet, non nihil! Porro?</p>
                </div>

            </div>
        </article>
    </body>

</html>