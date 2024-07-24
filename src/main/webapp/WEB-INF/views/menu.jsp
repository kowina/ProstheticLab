<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
<a href="/app/laboratories/list/<sec:authentication property="principal.user.id"/>">TWOJE LABORATORIUM</a>
<a href="">GABINETY</a>
<a href="/app/dentists/list">LEKARZE</a>
<a href="">TWOJA OFERTA</a>