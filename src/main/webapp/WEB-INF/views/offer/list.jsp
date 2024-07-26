<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>lIST OFFER</title>
</head>
<body>
<a href="/app/laboratories/choice/+<sec:authentication property="principal.user.id"/>">PRZEŁĄCZ LABORATORIUM</a>

<%@ include file="../menu.jsp" %>

<h1>TWOJA OFERTA</h1>
<div>
    <table>
        <thead>
            <tr>
                <th>NAZWA</th>
                <th>CENA JEDNOSTKOWA</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${offers}" var="offer">
                <tr>
                    <td>${offer.name}</td>
                    <td>${offer.unitPrice} zł</td>
                    <td>
                         <a href="/app/offers/edit/${offer.id}/${laboratory.id}">EDYTUJ</a>
                          <a href="/app/offers/confirmDelete/${offer.id}/${laboratory.id}">USUŃ</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>