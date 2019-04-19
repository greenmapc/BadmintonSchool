document.addEventListener("DOMContentLoaded", function () {

    var submitButton = document.getElementById("buttonRegistration");
    submitButton.onclick = function(e) {
        reLogin = /[a-zA-Z0-9_]{3,30}/;
        reNumber = /^9[0-9]{9}/;
        reEmail = /^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$/;

        customLogin = document.getElementById("regLogin").value;
        customNumber = document.getElementById("regNumber").value;
        customEmail = document.getElementById("regMail").value;
        // добавить radio

        validLogin = reLogin.test(customLogin);
        validNumber = reNumber.test(customNumber);
        validEmail = reEmail.test(customEmail);

        error = false;

        if(customNumber.length == 0 ||
            customLogin.length == 0 || customEmail.length == 0) {
            error = emptyFields();
        }

        if(!validLogin) {
            error = invalidLogin();
        }

        if(!validNumber) {
            error = invalidNumber();
        }
        if(!validEmail) {
            error = invalidEmail();
        }

        if(error) {
            return false;
        }
    };

    password = document.getElementById('regPassword');
    password.onkeyup = function() {
        rePassword = /^[a-zA-Z_0-9]+$/;

        shortPassword(password);

        if(password.value.length > 0) {
            if(!rePassword.test(password.value)) {
                invalidPassword();
            } else {
                warningMessage = document.getElementById('warning-password');
                warningMessage.innerText = "";
            }
        }
    };

    repeatPassword = document.getElementById('regRepeatPassword');
    repeatPassword.onkeyup = function () {
        if(password.value !== repeatPassword.value) {
            checkingPassMatch(false);
        } else {
            checkingPassMatch(true);
        }
    }

});

function emptyFields() {
    warningDiv = document.getElementById('empty-field');
    warningDiv.innerText = "Все поля должны быть заполнены";
    warningDiv.style.display = "";
    return true;
}

function invalidLogin() {
    warningMessage = document.getElementById('login-warning');
    warningMessage.style.setProperty('color', 'red');
    return true;
}

function invalidNumber() {
    warningMessage = document.getElementById('number-warning');
    warningMessage.style.setProperty('color', 'red');
    return true;
}

function invalidEmail() {
    warningMessage = document.getElementById('email-warning');
    warningMessage.innerText = "Несуществующий Email";
    warningMessage.style.setProperty('color', 'red');
    return true;
}

function shortPassword(password) {
    warningMessage = document.getElementById('short-password');
    if(password.value.length < 6) {
        warningMessage.style.setProperty('color', 'red');
        return false;
    } else {
        warningMessage.style.setProperty('color', '');
        return true;
    }
}

function invalidPassword() {
    warningMessage = document.getElementById('warning-password');
    warningMessage.innerText = "Пароль может состоять только из латинских букв, цифр и нижнего подчеркивания";
    warningMessage.style.setProperty('color', 'red');
}

function checkingPassMatch(ok) {
    warningRepeatPassword = document.getElementById('mismatch-form');
    if (!ok) {
        warningRepeatPassword.innerText = 'Пароли не совпадают';
        warningRepeatPassword.style.setProperty('color', 'red');
    } else {
        warningRepeatPassword.style.display = 'none';
        warningRepeatPassword.style.setProperty('color', '');
    }
}