<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista lekarzy</title>
</head>
<body>
<a href="/app/laboratories/choice/+<sec:authentication property="principal.user.id"/>">PRZEŁĄCZ LABORATORIUM</a>

<%@ include file="../menu.jsp" %>
<br>
<h1>LISTA LEKARZY</h1>
    <table>
        <thead>
            <tr>
                <th>Imię</th>
                <th>Nazwisko</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${dentists}" var="dentist">
                <tr>
                    <td>${dentist.firstName}</td>
                    <td>${dentist.lastName}</td>
                    <td>
                         <a href="/app/dentists/get/${dentist.id}/${laboratory.id}">SZCZEGÓŁY</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
