<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Dentists</title>
</head>
<body>
<%@ include file="../menu.jsp" %>
TWOJ LABOR ${lanoratoryName}
<h1>LISTA DENTYSTÓW</h1>
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Imię</th>
                <th>Nazwisko</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${dentists}" var="dentist">
                <tr>
                    <td>${dentist.id}</td>
                    <td>${dentist.firstName}</td>
                    <td>${dentist.lastName}</td>
                    <td>
                        <a href="/app/dentists/edit/${dentist.id}">Edit</a>
<%--                        <a href="/authors/confirmDel/${author.id}">Delete</a>--%>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
