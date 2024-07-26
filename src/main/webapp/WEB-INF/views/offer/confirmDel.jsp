
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
    <title>Potwierdzenie usunięcia</title>
</head>
<body>
<h1>Potwierdzenie usuniecia</h1>
<p>Czy jesteś pewny, że chcesz usunąć oferte o nazwie ${offer.name}</p>
<a href="/app/offers/list/${laboratory.id}">Nie, wróć</a><br>
<a href="/app/offers/delete/${offer.id}/${laboratory.id}">Tak, usuń</a>
</body>
</html>
