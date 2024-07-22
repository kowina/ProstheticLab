<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista Laboratoriów</title>
</head>
<body>

<h1>LISTA LABORATORIÓW</h1>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Nazwa</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${laboratories}" var="laboratory">
        <tr>
            <td>${laboratory.id}</td>
            <td>${laboratory.name}</td>
            <td>
                                            <a href="/laboratories/edit/${laboratory.id}">Edit</a>
                    <%--                        <a href="/authors/confirmDel/${author.id}">Delete</a>--%>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

