<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>TODO</title>
</head>
<body>
<H2>Invocation d'un contrôleur Spring MV avec un paramètre TODO...</H2>
<br/>
<div class="block">
    A l'appel précédent, la valeur de TODO était : ${previoustodo}
    <br>
    Je répond donc : ${msg}
</div>

<div class="block">
    <h3>Historique des actions</h3>
    <ul>
    <c:forEach items="${compteur}" var="pair">
        <li>${pair.key} : ${pair.value}</li>
    </c:forEach>
    </ul>
</div>


<br/>
<div class="block">
    <h3>Tout d'abord via une url (hyperlien -> GET)</h3>
    <a href="TodoControleur?TODO=bonjour">bonjour</a>
    <br>
    <a href="TodoControleur?TODO=beau">il fait beau</a>
    <br>
    <a href="TodoControleur">sans passer de TODO</a>
</div>

<div>
    <h3>Puis avec un formulaire (POST)</h3>
    <form method="post" action="TodoControleur">
        <button type="submit" name="TODO" value="bonjour">bonjour</button>
        <button type="submit" name="TODO" value="beau">il fait beau</button>
        <button type="submit" name="BIDON" value="bidon">Sans passer de TODO</button>
    </form>
</div>
</body>
</html>
