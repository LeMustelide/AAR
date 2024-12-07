<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>URL</title>
</head>
<body>
<H2>Invocation d'un contrôleur SpringMVC avec méthode incluse dans l'URL</H2>
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
    <a href="${pageContext.request.contextPath}/UrlControleur/bonjour">bonjour</a>
    <br>
    <a href="${pageContext.request.contextPath}/UrlControleur/beau">il fait beau</a>
    <br>
    <a href="${pageContext.request.contextPath}/UrlControleur">sans passer de TODO</a>
</div>

<div>
    <h3>Puis avec un formulaire (POST)</h3>
    <form method="post" action="${pageContext.request.contextPath}/UrlControleur/bonjour">
        <button type="submit">bonjour</button>
    </form>
    <form method="post" action="${pageContext.request.contextPath}/UrlControleur/beau">
        <button type="submit">il fait beau</button>
    </form>
    <form method="post" action="${pageContext.request.contextPath}/UrlControleur">
        <button type="submit">Sans passer de TODO</button>
    </form>
</div>

<div>
    <script>
        function setaction(action="") {
            document.form_multi_boutons.action="${pageContext.request.contextPath}/UrlControleur/"+action;
        }
    </script>
    <h3>Et une approche plus compacte avec un formulaire (POST)</h3>
    <h4>(un seul formulaire avec un peu de javascript pour adapter l'action...)</h4>
    <form method="post" name="form_multi_boutons" id="form_multi_boutons">
        <button type="submit" onclick="setaction('bonjour');">bonjour</button>
        <button type="submit" onclick="setaction('beau');">il fait beau</button>
        <button type="submit" onclick="setaction();">Sans passer de TODO</button>
    </form>
</div>

</body>
</html>

