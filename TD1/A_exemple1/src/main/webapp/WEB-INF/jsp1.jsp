<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<html>
<head>
    <title>Votre première JSP</title>
</head>
<body>
<!-- dans cette JSP on a deux affichages possibles, suivant que "who_is_there" est défini (et de longueur >0) ou pas... -->
<c:if test="${empty who_is_there}">
    <form method="post">
        <label> nom
            <input type="text" name="nom">
        </label>
        <br/>
        <button type="submit">Envoyer</button>
    </form>
</c:if>




<c:if test="${not empty who_is_there}">
Bienvenu ${who_is_there}!
</c:if>
</body>
</html>
