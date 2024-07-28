
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>find patient</title>
</head>
<body>
<a href="/app/laboratories/choice/+<sec:authentication property="principal.user.id"/>">PRZEŁĄCZ LABORATORIUM</a>

<%@ include file="../menu.jsp" %>
<h2>Prace szukanego pacjenta:</h2>
<div>
    <table>
        <thead>
            <tr>
                <th>Numer pracy</th>
                <th>Gabinet</th>
                <th>Lekarz</th>
                <th>Pacjent</th>
                <th>Data przyjęcia</th>
                <th>Data oddania</th>
                <th>Rodzaj</th>
                <th>Opis</th>
                <th>Cena całkowita</th>

            </tr>
        </thead>
        <tbody>
            <c:forEach items="${patientFound}" var="work">
                <tr>
                    <td>${work.workNumber}</td>
                    <td>${work.dentalOffice.name}</td>
                    <td>${work.dentist.lastName}</td>
                    <td>${work.patient}</td>
                    <td>${work.created}</td>
                    <td>${work.finished}</td>
                    <td>${work.offer.name}</td>
                    <td>${work.description}</td>
                    <td>${work.totalPrice} zł</td>
                    <td>
<%--                         <a href="/app/works/edit/${work.id}/${laboratory.id}">EDYTUJ</a>--%>
<%--                          <a href="/app/works/confirmDelete/${work.id}/${laboratory.id}">USUŃ</a>--%>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

