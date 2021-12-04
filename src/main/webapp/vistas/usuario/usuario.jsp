<%@page session="true" %>
<%
    HttpSession sesion =request.getSession();
    String username = "";
    
    username = sesion.getAttribute("username").toString();
  
%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Kaktus Register Architecture">
    <!--Estandar-->
    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    <!--Fuentes google-->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Quicksand&display=swap" rel="stylesheet">
    <!--Mi css-->
    <link rel="stylesheet" href="../../css/style-user.css">
    <link rel="shortcut icon" href="assets/img/Kaktus2.svg" type="image/x-icon">
    <title>Kaktus | <%= username%></title>

</head>

<body class="user-page">

    <!-- <header class="header">
        <input type="search" placeholder="Busca un proyecto :)">        

    </header> -->

    <nav class="aside_nav">
        <a class="aside_brand link--no-deco" href="../../index.html">
            <img class="brand-logo" src="../../assets/img/Kaktus2.svg" alt="kaktus logo">
            <p class="brand-text-logo">kaktus</p>
        </a>

        <ul class="menu dashboard">
            <li class="label-menu">Dashboard</li>
            <li class="option-menu">
                <a class="option-link" href="">
                    <span class="material-icons-outlined sz-icon clr-icon">dashboard</span>
                    <span class="sz-text clr-text space-text">Mis Proyectos</span>
                </a>
            </li>

            <li class="option-menu">
                <a class="option-link" href="">
                    <span class="material-icons-outlined sz-icon clr-icon">explore</span>
                    <span class="sz-text clr-text space-text">Explorar</span>
                </a>
            </li>

            <li class="option-menu">
                <a class="option-link" href="">
                    <span class="material-icons-outlined sz-icon clr-icon">file_upload</span>
                    <span class="sz-text clr-text space-text">Subir proyecto</span>
                </a>
            </li>
        </ul>

        <ul class="menu account">
            <li class="label-menu">Account</li>
            <li class="option-menu">
                <a class="option-link" href="">
                    <span class="material-icons-outlined sz-icon clr-icon">notifications</span>
                    <span class="sz-text clr-text space-text">Notificaciones</span>
                </a>
            </li>
            <li class="option-menu">
                <a class="option-link" href="">
                    <span class="material-icons-outlined sz-icon clr-icon">settings</span>
                    <span class=" sz-text clr-text space-text">Configuracion</span>
                </a>
            </li>
        </ul>

        <div class="user-info pos-last"> <img class="user-photo" src="../../assets/img/user-photo.jpg" alt="user photo"
                width="90px" height="auto">
            <p class="user-text-info">
                <span class="span-name"><%= username%></span>
            </p>
        </div>

        <div class="btn-container pos-last">

            <a class="logout-btn" type="submit"  href="<%=request.getContextPath()%>/LoginController?accion=salir"><span class="material-icons-outlined">logout</span>
                <span>Cerrar sesion</span>
            </a>
        </div>

    </nav>
    
    </div>
    <main class="section-projects">

        <h1 class="hero-text">Mis proyectos</h1>
        
        <div class="content-projects">

            <div class="project add-project"> <span class="material-icons-outlined">add</span></div>
            <!-- <div class="project"></div>
            <div class="project"></div>
            <div class="project"></div>

            <div class="project"></div>
            <div class="project"></div>
            <div class="project"></div>
            <div class="project"></div>
            <div class="project"></div>
            <div class="project"></div>
            <div class="project"></div>
            <div class="project"></div>
            <div class="project"></div> -->

        </div>

    </main>

</body>

</html>