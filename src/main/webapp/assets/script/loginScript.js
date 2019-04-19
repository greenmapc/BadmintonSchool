document.addEventListener("DOMContentLoaded", function() {
    submitButton = document.getElementById("btn-login");


    submitButton.onclick = function() {

        reLogin = /[a-zA-Z0-9_]{3,25}/;
        rePassword = /[a-zA-Z_0-9]{6,30}/;
        customLogin = document.getElementById('customLogin').value;
        customPassword = document.getElementById('customPassword').value;

        validLogin = reLogin.test(customLogin);
        validPassword = rePassword.test(customPassword);

        element = document.getElementById('loginAlert');
        if (customLogin.length === 0 || customLogin.length === 0) {

            return emptyFields(element);

        } else {
            if (!validLogin || !validPassword) {
                return invalidPassOrLogin(element);

            } else {
                return true;
            }
        }
    }
});

function emptyFields(element) {
    element.innerText = "Все поля должны быть заполнены";
    element.style.display = "";
    return false;
}

function invalidPassOrLogin(element) {
    console.log(document.getElementById('loginAlert'));
    element.style.display = "";
    element.innerText = "Неверный логин или пароль";
    return false;
}