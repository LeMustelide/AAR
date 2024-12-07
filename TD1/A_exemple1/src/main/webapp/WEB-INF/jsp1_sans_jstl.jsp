<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Votre première JSP</title>
</head>
<body>
<!-- dans cette JSP on a deux affichages possibles, suivant que "who_is_there" est défini (et de longueur >0) ou pas... -->
<% String who_is_there=(String)request.getAttribute("who_is_there"); %>

<%   if (who_is_there==null) { %>
    <form method="post">
        <label> nom
            <input type="text" name="nom">
        </label>
        <br/>
        <button type="submit">Envoyer</button>
    </form>
<% } else { %>
    Bienvenu <%= who_is_there %>!
<% } %>
</body>
</html>
