
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>admin panel</title>
</head>
<body>
<h3>Panel administratora</h3>
<h3>Hej ${user.firstName}</h3>
<sec:authorize access="isAuthenticated()">
    <form  method="post" action="/logout">
        <input class="fa fa-id-badge" type="submit" value="Wyloguj">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
    <p>Zalogowany jako: <sec:authentication property="principal.username"/></p>
    <p>Posiada role: <sec:authentication property="authorities"/></p>
</sec:authorize>
</body>
</html>