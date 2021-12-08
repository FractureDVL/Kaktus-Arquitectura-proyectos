$(document).ready(function () {
    
    $('#password').keyup(function () {
        var pass1 = $('#password').val();
        var pass2 = $('#confirm-password').val();
        if (pass1 == pass2) {
            $('#alerta-contrasenas').text("Las contraseñas coinciden").css("color", "green");
        } else {
            $('#alerta-contrasenas').text("Las contraseñas no coinciden").css("color", "red");
        }
    });
    
    $('#confirm-password').keyup(function () {
        var pass1 = $('#password').val();
        var pass2 = $('#confirm-password').val();
        if (pass1 == pass2) {
            $('#alerta-contrasenas').text("Las contraseñas coinciden").css("color", "green");
        } else {
            $('#alerta-contrasenas').text("Las contraseñas no coinciden").css("color", "red");
        }
    });

    $('#form').submit(function (event) {
        var pass1 = $('#password').val();
        var pass2 = $('#confirm-password').val();
        if (pass1 != pass2)
            event.preventDefault();
    });

});
////
////<%
//                        String rta = "1";
//                        if(rta=="0"){//
////                    %>
////                    <div id="alerta-login"></div>
////                    <script>
//                        $(document).ready(function () {//
////                            $('#login').submit(function (event) {
////                                $('#alerta-login').text("Datos ingresados erroneos").css("color", "red");
////                                event.preventDefault();
////                            });
////                        });
//                    </script>//
////                    <%
//                        }
//                    %>
//                    