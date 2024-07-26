<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Szczegóły Lekarza</title>
</head>
<body>
<a href="/app/laboratories/choice/+<sec:authentication property="principal.user.id"/>">PRZEŁĄCZ LABORATORIUM</a>

<%@ include file="../menu.jsp" %>
<br>

<h1>SZCZEGÓŁY LEKARZA</h1>

 <table>
        <thead>
            <tr>
                <th>Imię</th>
                <th>Nazwisko</th>
            </tr>
        </thead>
        <tbody>
                <tr>
                    <td>${dentist.firstName}</td>
                    <td>${dentist.lastName}</td>
                    <td>
                          <a href="/app/dentists/edit/${dentist.id}/${laboratory.id}">EDYTUJ</a>
                          <a href="/app/dentists/confirmDelete/${dentist.id}/${laboratory.id}">USUŃ</a>
                    </td>
                </tr>
        </tbody>
    </table>
</body>
</html>
