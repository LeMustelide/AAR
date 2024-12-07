
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>METEO</title>
</head>
<body>

<!-- implanter ici le nombre de fois où chaque option de météo a été validée -->

<form method="post">
    <select name="meteo">
        <c:forEach items="${options}" var="opt">
        <option value="${opt}" ${opt == param.meteo ? 'selected' : ''} >${opt}</option>
        </c:forEach>
    </select>
    <button type="submit">Valider</button>
</form>

Nombre de fois où chaque option a été validée :
<ul>
    <jsp:useBean id="counters" scope="request" type="java.util.HashMap"/>
    <c:forEach items="${counters}" var="entry">
        <li>${entry.key} : ${entry.value}</li>
    </c:forEach>
</ul>

</body>
</html>
