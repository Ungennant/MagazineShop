<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<body>--%>
<%--<form action="/registration" method="post">--%>
<%--    <h1>Реєстрація</h1>--%>
<%--    <p>Будь-ласка заповніть форму щоб зареєструватись на сайті</p>--%>
<%--    <hr>--%>
<%--    <label for="email"><b>Електронна пошта</b></label>--%>
<%--    <input type="text" placeholder="Введіть пошту" name="email" id="email" required>--%>
<%--    <br/>--%>
<%--    <label for="firstName"><b>Ім'я користувача</b></label>--%>
<%--    <input type="text" placeholder="Введіть ім'я" name="firstName" id="firstName">--%>
<%--    <br/>--%>
<%--    <label for="lastName"><b>Прізвище користувача</b></label>--%>
<%--    <input type="text" placeholder="Введіть прізвище" name="lastName" id="lastName">--%>
<%--    <br/>--%>
<%--    <label for="password"><b>Пароль</b></label>--%>
<%--    <input type="password" placeholder="Введіть пароль" name="password" id="password" required>--%>

<%--    <p>Реєструючись на сайті ви погоджуєтесь з нашими<a href="#"> Умовами та конфіденційністю</a>.</p>--%>
<%--    <button type="submit" class="registerbtn">Зареєструватись</button>--%>

<%--    <div class="container signin">--%>
<%--        <p>Вже зарєстровані? <a href="#">Увійти</a>.</p>--%>
<%--    </div>--%>
<%--</form>--%>

<%--</body>--%>
<%--</html>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link href="css/login.css" rel="stylesheet">
</head>
<body>
<div class="login-page">
    <div class="form">
        <form class="register-form">
            <input class="email" type="text" placeholder="Введіть пошту"/>
            <input class="firstName" type="text" placeholder="Введіть ім'я"/>
            <input class="lastName" type="text" placeholder="Введіть прізвище"/>
            <input class="password" type="password" placeholder="Введіть пароль"/>
            <input class="cpassword" type="password" placeholder="Повторіть пароль"/>
            <button class="register">Зареєструватись</button>
            <p class="message">Вже зареєстровані? <a href="#">Увійти</a></p>
        </form>
        <form class="login-form">
            <input class="email" type="text" placeholder="Введіть логін"/>
            <input class="password" type="password" placeholder="Введіть пароль"/>
            <button class="login">Увійти</button>
            <p class="message">Немає аккаунту? <a href="#">Зареєструватись</a></p>
        </form>
    </div>
    <div class="alert alert-success  alert-dismissible fade show" role="alert">
        <b>Реєстрація успішна!</b>  Ви можете зайти на сайт.
        <button type="button" class="close" data-dismiss="alert"
                aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="js/login.js"></script>
</body>
</html>




