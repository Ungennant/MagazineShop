<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>
<form action="/registration" method="post">
    <h1>Реєстрація</h1>
    <p>Будь-ласка заповніть форму щоб зареєструватись на сайті</p>
    <hr>
    <label for="email"><b>Електронна пошта</b></label>
    <input type="text" placeholder="Введіть пошту" name="email" id="email" required>
    <br/>
    <label for="firstName"><b>Ім'я користувача</b></label>
    <input type="text" placeholder="Введіть ім'я" name="firstName" id="firstName">
    <br/>
    <label for="lastName"><b>Прізвище користувача</b></label>
    <input type="text" placeholder="Введіть прізвище" name="lastName" id="lastName">
    <br/>
    <label for="password"><b>Пароль</b></label>
    <input type="password" placeholder="Введіть пароль" name="password" id="password" required>

    <p>Реєструючись на сайті ви погоджуєтесь з нашими<a href="#"> Умовами та конфіденційністю</a>.</p>
    <button type="submit" class="registerbtn">Зареєструватись</button>

    <div class="container signin">
        <p>Вже зарєстровані? <a href="#">Увійти</a>.</p>
    </div>
</form>

</body>
</html>
