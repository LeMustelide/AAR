
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Essai</title>
</head>
<body>
<p>Il est temps de deviner...</p>
Quel caractère proposez-vous ?
<form method="post">
    <input type="text" name="caractere" autofocus>
    <button type="submit">Envoyer</button> <!-- TODO compléter le bouton -->
</form>

Pour l'instant vous avez trouvé : ${devine}


<p>Nombre d'erreurs : ${nbErreurs}/6</p>
</body>
</html>
