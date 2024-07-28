<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>admin panel</title>
</head>
<body>
<h3>Panel administratora</h3>
<h3>Cześć <sec:authentication property="principal.user.firstName"/></h3>
<%--<p>Zalogowany jako: <sec:authentication property="principal.user.firstName"/></p>--%>
<sec:authorize access="isAuthenticated()">
    <form  method="post" action="/logout">
        <input class="fa fa-id-badge" type="submit" value="Wyloguj">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
    <%--    <p>Zalogowany jako: <sec:authentication property="principal.user.firstName"/></p>--%>
    <%--    <p>Posiada role: <sec:authentication property="authorities"/></p>--%>
</sec:authorize>
<a href="/app/laboratories/list">LABORATORIA</a>
<a href="/app/dentalOffices/list">GABINETY</a>
<a href="/app/dentists/list">LEKARZE</a>


<h1>LISTA LEKARZY</h1>
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
<%--                <a href="/app/dentists/edit/${dentist.id}">Edit</a>--%>
                    <%--                        <a href="/authors/confirmDel/${author.id}">Delete</a>--%>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>