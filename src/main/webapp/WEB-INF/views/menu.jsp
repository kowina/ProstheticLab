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
<h1>${laboratory.name}</h1>
 <br>
<a href="/app/laboratories/get/${laboratory.id}">TWOJE LABORATORIUM</a>
<a href="/app/dentalOffices/list/${laboratory.id}">GABINETY</a>
<a href="/app/dentists/list/${laboratory.id}">LEKARZE</a>
<a href="/app/offers/list/${laboratory.id}">TWOJA OFERTA</a><br>

<a href="/app/dentalOffices/add/${laboratory.id}">DODAJ GABINET</a>
<a href="/app/dentists/add/${laboratory.id}">DODAJ LEKARZA</a>
<a href="/app/offers/add/${laboratory.id}">DODAJ DO OFERTY</a>


