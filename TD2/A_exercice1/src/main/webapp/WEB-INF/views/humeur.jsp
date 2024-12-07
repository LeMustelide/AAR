<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--
  Created by IntelliJ IDEA.
  User: marc
  Date: 16/09/2024
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Humeur</title>
</head>
<body>
<h1>Quel est votre humeur ?</h1>
<form method="post" action="${pageContext.request.contextPath}/humeur">
    <select name="humeur">
        <c:forEach var="humeur" items="${humeurs}">
            <option value="${humeur}">${humeur}</option>
        </c:forEach>
    </select>
    <p><button type="submit">Envoyer</button></p>
</form>
</body>
</html>
