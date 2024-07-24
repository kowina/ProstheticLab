
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>Potwierdzenie usunięcia</title>
    </head>
    <body>
    <h1>Potwierdzenie usuniecia</h1>
    <p>Czy jesteś pewny, że chcesz usunąć laboratorium o nazwie ${laboratory.name}</p>
    <a href="/app/laboratories/get/${laboratory.id}">Nie, wróć</a><br>
    <a href="/app/laboratories/delete/${laboratory.id}">Tak, usuń</a>
    </body>
    </html>
