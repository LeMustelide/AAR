<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>La valeur en session est...</title>
</head>
<body>
    La valeur stockée en session est :
    <br/>
    ${memoattribute} (valeur récupérée par le servlet et transmise sous forme d'attribut)
    <br/>
    ${memosession} (accès direct à la session par la JSP)
</body>
</html>
