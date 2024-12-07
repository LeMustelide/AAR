<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>La valeur a été mémorisée</title>
</head>
<body>
    Elle est maintenant en session.
    Pour la retrouver,
<form method="get" action="SecondServlet">
    <button type="submit">cliquer ici</button>
</form>
</body>
</html>
