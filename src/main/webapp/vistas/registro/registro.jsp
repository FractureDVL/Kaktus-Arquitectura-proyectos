
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
    <title>Kaktus | Registro</title>
</head>

<body class="register-page">

    <div class="register background-image">

        <div class="myform__container">
            <form class="myform" action="<%=request.getContextPath()%>/RegistroController?accion=registrar" method="POST">
                <h1 class="myform__title">Crear cuenta</h1>
                <p class="myform__text">¿Ya tienes cuenta? <a class="text__link" href="../login/login.jsp">Inicia sesi&oacute;n.</a></p>
                <div class="myform__field">
                    <label class="form__label" for="name">Nombre</label>
                    <input class="form__input form__input-contain input--no-outline" type="text" name="name" id="name"
                        required>
                </div>

                <div class="myform__field">
                    <label class="form__label" for="email">Correo</label>
                    <input class="form__input form__input-contain input--no-outline" type="email" name="email"
                        id="email" required>
                </div>

                <div class="myform__field">
                    <label class="form__label" for="user">Usuario</label>
                    <input class="form__input form__input-contain input--no-outline" type="text" name="user" id="user"
                        required>
                </div>


                <div class="myform__field">
                    <label id="password" class="form__label" for="password">Contrase&ntilde;a</label>
                    <input class="form__input form__input-contain input--no-outline" type="password" name="password" id="password"
                        required>
                </div>
                <div class="myform__field">
                    <label id="confirm-password" class="form__label" for="confirm-password">Confirmar contrase&ntilde;a</label>
                    <input class="form__input form__input-contain input--no-outline" type="password" name="confirm-password" id="confirm-password"
                        required>
                </div>
                <div class="myform__btns">
                    <button class="btn--submit btn--noBorder btn--noOutline" type="submit"
                        onclick="">Registrarse</button>
                    <button class="btn--google btn--noBorder btn--noOutline" type="button"><img class="img-google"
                            src="../../assets/img/google.svg" alt="SignUp-google" width="50px"></button>
                </div>
            </form>
        </div>
    </div>

</body>

</html>