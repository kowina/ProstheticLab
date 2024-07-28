<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Szczegóły Laboratorium</title>
</head>
<body>
<a href="/app/laboratories/choice/+<sec:authentication property="principal.user.id"/>">PRZEŁĄCZ LABORATORIUM</a>

<%@ include file="../menu.jsp" %>
<br>

<h1>SZCZEGÓŁY LABORATORIUM</h1>
<a href="/app/laboratories/add">DODAJ LABORATORIUM</a>

<table>
    <thead>
    <tr>
        <th>NAZWA</th>
        <th>NIP</th>
        <th>REGON</th>
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
            <td>${laboratory.name}</td>
            <td>${laboratory.nip}</td>
            <td>${laboratory.regon}</td>
            <td>${laboratory.email}</td>
            <td>${laboratory.phone}</td>
            <td>${laboratory.street}</td>
            <td>${laboratory.streetNumber}</td>
            <td>${laboratory.localeNumber}</td>
            <td>${laboratory.city}</td>
            <td>${laboratory.postalCode}</td>
            <td>
                <a href="/app/laboratories/edit/${laboratory.id}">EDYTUJ</a>
                <a href="/app/laboratories/confirmDelete/${laboratory.id}">USUŃ</a>
<%--                                           <a href="/app/laboratories/get/${laboratory.id}">SZCZEGÓŁY</a>--%>
            </td>
        </tr>
    </tbody>
</table>
<h2>Liczba wykonanych prac:${numberOfWorks}</h2><br>
<h2>Ostatnio oddane 3 prace:</h2>
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
            <c:forEach items="${lastThree}" var="work">
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
