<jsp:useBean id="login" scope="request" type="java.lang.String"/>
<%--
Cette JSP sera appelée une fois que l'utilisateur est loggué
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Bonjour ${login}</h1>
    <a href="logout">Logout</a>
</body>
</html>
