function validate() {

    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirm-password").value;

    if (password != confirmPassword) {

        var passId = document.getElementById("pass-id");
        var confirmId = document.getElementById("confirm-id");

        passId.classList.add("input--no-validate");
        confirmId.classList.add("input--no-validate");

        return false;
    }
    else { return true; }



}