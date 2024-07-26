
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
    <title>Potwierdzenie usunięcia</title>
</head>
<body>
<h1>Potwierdzenie usuniecia</h1>
<p>Czy jesteś pewny, że chcesz usunąć lekarza o nazwisku ${dentist.lastName}</p>
<a href="/app/dentists/get/${dentist.id}/${laboratory.id}">Nie, wróć</a><br>
<a href="/app/dentists/delete/${dentist.id}/${laboratory.id}">Tak, usuń</a>
</body>
</html>
