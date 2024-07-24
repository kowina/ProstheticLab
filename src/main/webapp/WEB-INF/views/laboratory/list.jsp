<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista Laboratoriów</title>
</head>
<body>
<%@ include file="../menu.jsp" %>
<br>

<h1>LISTA LABORATORIÓW</h1>
<a href="/app/laboratories/add">DODAJ LABORATORIUM</a>

<table>
    <thead>
    <tr>
        <th>Nazwa</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${laboratories}" var="laboratory">
        <tr>
            <td>${laboratory.name}</td>
            <td>
<%--                                            <a href="/app/laboratories/edit/${laboratory.id}">EDYTUJ</a>--%>
<%--                                            <a href="/app/laboratories/delete/${laboratory.id}">USUŃ</a>--%>
                                            <a href="/app/laboratories/get/${laboratory.id}">SZCZEGÓŁY</a>


            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

