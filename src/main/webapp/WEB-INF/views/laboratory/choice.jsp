<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wybór laboratorium</title>
</head>
<body>
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

<h1>WYBIERZ LABORATORIUM</h1>
<table>
    <thead>
    <tr>
        <th>Laboratorium</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${laboratories}" var="laboratory">
        <tr>
            <td><a href="/app/laboratories/home/${laboratory.id}">${laboratory.name}</a> </td>
            <td>
                    <%--                                            <a href="/app/laboratories/edit/${laboratory.id}">EDYTUJ</a>--%>
                    <%--                                            <a href="/app/laboratories/delete/${laboratory.id}">USUŃ</a>--%>
<%--                <a href="/app/laboratories/get/${laboratory.id}">SZCZEGÓŁY</a>--%>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
