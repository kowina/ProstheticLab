<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Szczegóły Gabinetu</title>
</head>
<body>
<a href="/app/laboratories/choice/+<sec:authentication property="principal.user.id"/>">PRZEŁĄCZ LABORATORIUM</a>

<%@ include file="../menu.jsp" %>
<br>

<h1>SZCZEGÓŁY GABINETU</h1>
<a href="/app/dentalOffices/add/${laboratory.id}">DODAJ GABINET</a>

<table>
    <thead>
    <tr>
        <th>NAZWA</th>
        <th>NIP</th>
        <th>EMAIL</th>
        <th>TELEFON</th>
        <th>ULICA</th>
        <th>NR</th>
        <th>NR LOKALU</th>
        <th>MIASTO</th>
        <th>KOD POCZTOWY</th>

    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${dentalOffice.name}</td>
        <td>${dentalOffice.nip}</td>
        <td>${laboratory.email}</td>
        <td>${dentalOffice.phone}</td>
        <td>${dentalOffice.street}</td>
        <td>${dentalOffice.streetNumber}</td>
        <td>${dentalOffice.localeNumber}</td>
        <td>${dentalOffice.city}</td>
        <td>${dentalOffice.postalCode}</td>

        <td>
            <a href="/app/dentalOffices/edit/${dentalOffice.id}/${laboratory.id}">EDYTUJ</a>
            <a href="/app/dentalOffices/confirmDelete/${dentalOffice.id}/${laboratory.id}">USUŃ</a>
        </td>
    </tr>
    </tbody>
</table>

</body>
</html>
