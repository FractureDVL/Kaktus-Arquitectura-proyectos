<%@page session="true" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Navbar | Kaktus</title>
    <!--Estándar-->
    <link rel="shortcut icon" href="../../assets/img/Kaktus2.svg" type="image/x-icon">
    <link rel="stylesheet" href="css/normalize.css">
    <!--Iconos google-->
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
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

        <div class="logo-details">
            <img class="img_logo" src="assets/img/Kaktus2.svg" alt="logo kaktus">
            <span class="logo_name">kaktus</span>
        </div>

        <div class="search-box">
            <input type="text" placeholder="Search...">
            <i class='bx bx-search'></i>
        </div>

        <%
                    HttpSession sesion =request.getSession();
                    String username;
                    String url_photo;
                    username = (String) sesion.getAttribute("username");
                    url_photo = (String) sesion.getAttribute("image_url");
                    String a = "/Kaktus-Arquitectura-proyectos/UsuarioController?accion=verFoto&user="+username;
                    
                    if(username == null){
                %>
        <div>
            <div class="option-link option-login">
                <a href="vistas/login/login.jsp?rta=1"">Iniciar Sesión</a>
            </div>
            <div class="option-link option-register">
                <a href="vistas/registro/registro.jsp?rtaUser=0&&rtaEmail=0">Registrarse</a>
            </div>

        </div>
        <%}
            else
        {%>
        
        <a href="vistas/usuario/usuario.jsp" class="profile-details">
            <img class="" src="<%=a%>" alt="user-photo">
            <span class="admin_name"><%=username%></span>
        </a> 
        
        <%
            }
        %>
    </header>

    <article class="home-content">

        <div class="box">
            <div class="box-images">
                <img class="image" src="assets/img/reference.png" alt="project reference">
            </div>
            <div class="box-text">
                <h2 class="box-title">Lorem ipsum dolor sit amet consectetur, adipisicing elit. </h2>
                <p class="box-description">Lorem ipsum dolor sit amet consectetur adipisicing elit. Quasi est aliquam
                    dolorum, aperiam placeat laboriosam harum ea consequatur non! Laudantium facere rerum ad quae vero
                    maxime eveniet, non nihil! Porro?</p>
            </div>
        </div>
        <div class="box">
            <div class="box-images">
                <img class="image" src="assets/img/reference2.png" alt="project reference">
            </div>
            <div class="box-text">
                <h2 class="box-title">Lorem ipsum dolor sit amet consectetur, adipisicing elit. </h2>
                <p class="box-description">Lorem ipsum dolor sit amet consectetur adipisicing elit. Quasi est aliquam
                    dolorum, aperiam placeat laboriosam harum ea consequatur non! Laudantium facere rerum ad quae vero
                    maxime eveniet, non nihil! Porro?</p>
            </div>
        </div>

        <div class="box">
            <div class="box-images">
                <img class="image" src="assets/img/reference.png" alt="project reference">
            </div>
            <div class="box-text">
                <h2 class="box-title">Lorem ipsum dolor sit amet consectetur, adipisicing elit. </h2>
                <p class="box-description">Lorem ipsum dolor sit amet consectetur adipisicing elit. Quasi est aliquam
                    dolorum, aperiam placeat laboriosam harum ea consequatur non! Laudantium facere rerum ad quae vero
                    maxime eveniet, non nihil! Porro?</p>
            </div>
        </div>
        <div class="box">
            <div class="box-images">
                <img class="image" src="assets/img/reference2.png" alt="project reference">
            </div>
            <div class="box-text">
                <h2 class="box-title">Lorem ipsum dolor sit amet consectetur, adipisicing elit. </h2>
                <p class="box-description">Lorem ipsum dolor sit amet consectetur adipisicing elit. Quasi est aliquam
                    dolorum, aperiam placeat laboriosam harum ea consequatur non! Laudantium facere rerum ad quae vero
                    maxime eveniet, non nihil! Porro?</p>
            </div>
        </div>

    </article>
</body>

</html>