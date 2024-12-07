<%--
Cette JSP accueillera un form avec les deux champs login et password
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>LOGIN</title>
</head>
<body>
    <form method="post">s
        <label for="login">Login</label>
        <input type="text" id="login" name="login" required>
        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>
        <button type="submit">Login</button>
    </form>
</body>
</html>
