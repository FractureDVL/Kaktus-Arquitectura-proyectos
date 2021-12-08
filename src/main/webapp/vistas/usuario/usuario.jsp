<%@page import="entidades.ProyectoDTO"%>
<%@page session="true" %>
<jsp:useBean id="facade" class="facade.ProyectoFacade" scope="session"/>
<%
    HttpSession sesion = request.getSession();
    int id;
    String username = "";
    String image_url = "";
    id = Integer.parseInt(sesion.getAttribute("id").toString());
    username = sesion.getAttribute("username").toString();
    image_url = sesion.getAttribute("image_url").toString();
%>

<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="../../css/style-main.css">
        <!--Estandar-->
        <link rel="shortcut icon" href="../../assets/img/Kaktus2.svg" type="image/x-icon">
        <!-- Boxicons CDN Link -->
        <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
        <title>KAKTUS | <%=username%></title>
    </head>

    <body>
        <div class="sidebar">

            <div class="logo-details">
                <img class="img_logo" src="../../assets/img/Kaktus2.svg" alt="logo kaktus">
                <span class="logo_name">kaktus</span>
            </div>
            <ul id="nav-links" class="nav-links">
                <li>
                    <a href="#" class="option active">
                        <i class='bx bx-grid-alt'></i>
                        <span class="links_name">Mis proyectos</span>
                    </a>
                </li>

                <li>
                    <a href="../../index.jsp" class="option">
                        <i class='bx bx-compass'></i>
                        <span class="links_name">Explorar</span>
                    </a>
                </li>

                <li>
                    <a href="editarUsuario.jsp" class="option">
                        <i class='bx bx-cog'></i>
                        <span class="links_name">Configuración</span>
                    </a>
                </li>

                <li class="log_out">
                    <a href="<%=request.getContextPath()%>/LoginController?accion=salir" class="option">
                        <i class='bx bx-log-out'></i>
                        <span class="links_name">Cerrar sesión</span>
                    </a>
                </li>
            </ul>
        </div>

        <section class="home-section">
            <nav>
                <div class="sidebar-button">
                    <i class='bx bx-menu sidebarBtn'></i>
                    <span class="dashboard">Mis proyectos</span>
                </div>
                <div class="search-box">
                    <input type="text" placeholder="Search...">
                    <i class='bx bx-search'></i>
                </div>
                <div class="profile-details">
                    <img src="<%=image_url%>" alt="user-photo">
                    <span class="admin_name"><%=username%></span>
                </div>
            </nav>

            <div class="home-content">
                <div class="overview-boxes">

                    <a class="box" href="../proyecto/proyectoForm.jsp">
                        <i class='bx bxs-add-to-queue'></i>
                    </a>

                    <%
                        for (ProyectoDTO p : facade.buscarProyectosUser(username)) {
                            int id_proyecto = p.getId_proyecto();
                            String titulo = p.getTitulo();
                            String descripcion = p.getDescripcion();
                            String fechaCreacion = p.getFechaCreacion().toString();
                    %>
                    <div style="background-image: url(../../assets/img/stringio.jpg);" class="box-project background_proyect">
                        <a href="../proyecto/editarProyecto.jsp?id=<%= id_proyecto %>&titulo=<%= titulo %>&descripcion=<%= descripcion %>"><i class='bx bxs-edit'></i></a>
                        <a class="delete" href="<%=request.getContextPath()%>/ProyectoController?accion=eliminar&id=<%= p.getId_proyecto()%>">
                            <i class='bx bxs-trash'></i>
                        </a>
                        <div class="right-side "> 
                            
                            <div class="box-topic"><%=titulo%></div>
                            <div class="indicator">
                                <span class="text"><%=fechaCreacion%></span>
                            </div>
                        </div>
                    </div>
                    <%
                        }
                    %>
                </div>
            </div>


        </section>
        <script>
            let sidebar = document.querySelector(".sidebar");
            let sidebarBtn = document.querySelector(".sidebarBtn");
            sidebarBtn.onclick = function () {
                sidebar.classList.toggle("active");
                if (sidebar.classList.contains("active")) {
                    sidebarBtn.classList.replace("bx-menu", "bx-menu-alt-right");
                } else
                    sidebarBtn.classList.replace("bx-menu-alt-right", "bx-menu");
            }
        </script>

         <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="../../js/sweetAlert.js" type="text/javascript"></script>
        
    </body>

</html>