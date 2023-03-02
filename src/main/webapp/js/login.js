function loginRegisterSwitch() {
    $('form').animate({
        height : "toggle",
        opacity : "toggle"
    }, "slow");
}

function showAlertAfterRegistration() {
    $('div.alert.alert-success').show();
}

$('.message a').click(function() {
    loginRegisterSwitch();
});

$("button.register")
    .click(
        function() {
            let email = $("form.register-form input.email").val();
            let firstName = $("form.register-form input.firstName").val();
            let lastName = $("form.register-form input.lastName").val();
            let password = $("form.register-form input.password").val();
            let cpassword = $("form.register-form input.cpassword").val();

            if (email == '' || firstName == '' || lastName == ''
                || password == '' || cpassword == '') {
                alert("Будь-ласка заповніть всі поля!");
            } else if ((password.length) < 8) {
                alert("Пароль повинен містити не менше восьми символів!");
            } else if (!(password).match(cpassword)) {
                alert("Введені паролі не збігаються. Спробуйте ще раз?");
            } else {
                let userRegistration = {
                    email : email,
                    firstName : firstName,
                    lastName : lastName,
                    password : password
                };

                $.post("registration", userRegistration,
                    function(data) {
                        if (data == 'Success') {
                            $("form")[0].reset();
                            $("form")[1].reset();
                            loginRegisterSwitch();
                            showAlertAfterRegistration();
                        }
                    });
            }
        });

$("button.login").click(function() {
    let email = $("form.login-form input.email").val();
    let password = $("form.login-form input.password").val();

    if (email == '' || password == '') {
        alert("Будь-ласка заповніть форму для входу");
    } else {
        let userLogin = {
            email : email,
            password : password
        };

        $.post("login", userLogin, function(data) {
            if(data !== ''){

                let customUrl = '';
                let urlContent = window.location.href.split('/');
                for (let i = 0; i < urlContent.length-1; i++) {
                    customUrl+=urlContent[i]+'/'
                }
                customUrl += data.destinationUrl;
                window.location = "cabinet.jsp";
            }
            $("form")[1].reset();
        });
    }
});