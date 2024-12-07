
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>

L'application a l'air de se lancer...

<form action="${pageContext.request.contextPath}/peupler">
    <button type="submit">peupler</button>
</form>

</body>
</html>
