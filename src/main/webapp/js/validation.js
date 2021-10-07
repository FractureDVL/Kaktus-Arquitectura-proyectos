function validate() {

    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirm-password").value;
    if (password != confirmPassword) {
        alert("Las contraseñas no son iguales, por favor verifique.");
        return false;
    }
    return true;

}