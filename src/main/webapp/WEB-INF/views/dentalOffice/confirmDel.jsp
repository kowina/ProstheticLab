
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Potwierdzenie usunięcia</title>
</head>
<body>
<h1>Potwierdzenie usuniecia</h1>
<p>Czy jesteś pewny, że chcesz usunąć gabinet o nazwie ${dentalOffice.name}</p>
<a href="/app/dentalOffices/get/${dentalOffice.id}/${laboratory.id}">Nie, wróć</a><br>
<a href="/app/dentalOffices/delete/${dentalOffice.id}/${laboratory.id}">Tak, usuń</a>
</body>
</html>