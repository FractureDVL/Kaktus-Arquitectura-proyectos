function validate() {

    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirm-password").value;

    if (password != confirmPassword) {

        var passId = document.getElementById("password");
        var confirmId = document.getElementById("confirm-password");

        passId.classList.add("input--no-validate");
        confirmId.classList.add("input--no-validate");

        return false;
    }
    else { 
        return true; 
    }



}