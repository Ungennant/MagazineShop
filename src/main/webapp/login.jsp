<%--
  Created by IntelliJ IDEA.
  User: Akira
  Date: 21.02.2023
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form action="/login" method="post">
    <h1>Вхід</h1>
    <p>Будь-ласка заповніть форму щоб увійти до кабінету</p>
    <hr>
    <label for="login"><b>Електронна пошта</b></label>
    <input type="text" placeholder="Введіть пошту" name="login" id="login" required>
    <br/>
    <label for="password"><b>Пароль</b></label>
    <input type="password" placeholder="Введіть пароль" name="password" id="password" required>

    <button type="submit" class="loginbtn">Увійти</button>

    <div class="container signin">
        <p>Ще не зареєстровані? <a href="#">Зареєструватись</a>.</p>
    </div>
</form>

</body>
</html>
