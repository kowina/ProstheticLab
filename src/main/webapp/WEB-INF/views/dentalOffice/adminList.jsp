<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<a href="">TWOJA OFERTA</a>

<h1>LISTA GABINETÓW</h1>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Nazwa</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${dentalOffices}" var="dentalOffice">
        <tr>
            <td>${dentalOffice.id}</td>
            <td>${dentalOffice.name}</td>
            <td>
                <a href="/app/dentalOffices/get/${dentalOffice.id}">Szczegóły</a>
                    <%--                        <a href="/authors/confirmDel/${author.id}">Delete</a>--%>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>