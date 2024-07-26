<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista Gabinetów</title>
</head>
<body>
<a href="/app/laboratories/choice/+<sec:authentication property="principal.user.id"/>">PRZEŁĄCZ LABORATORIUM</a>

<%@ include file="../menu.jsp" %>
<br>

<h1>LISTA GABINETÓW</h1>
<%--<a href="/app/dentalOffices/add/${laboratory.id}">DODAJ GABINET</a>--%>

<table>
    <thead>
    <tr>
        <th>Nazwa</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${dentalOffices}" var="dentalOffice">
        <tr>
            <td>${dentalOffice.name}</td>
            <td>
                <a href="/app/dentalOffices/get/${dentalOffice.id}/${laboratory.id}">SZCZEGÓŁY</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>