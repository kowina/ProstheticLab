<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form edit dentaloffice</title>
</head>
<body>
<a href="/app/laboratories/choice/+<sec:authentication property="principal.user.id"/>">PRZEŁĄCZ LABORATORIUM</a>

<%@ include file="../menu.jsp" %>

<h1>EDYCJA GABINETU</h1>

<form:form modelAttribute="dentalOffice" action="/app/dentalOffices/edit/${laboratory.id}" method="post">
    <form:hidden path="id"/>
    <label>
        Nazwa: <form:input path="name"/>
    </label>
    <form:errors path="name"/>
    <br>
    <label>
        NIP: <form:input path="nip"/>
        <form:errors path="nip"/>
    </label><br>
    <label>
        Email: <form:input path="email"/>
        <form:errors path="email"/>
    </label><br>
    <label>
        Telefon: <form:input path="phone"/>
        <form:errors path="phone"/>
    </label><br>
    <label>
        Ulica: <form:input path="street"/>
        <form:errors path="street"/>
    </label><br>
    <label>
        Nr: <form:input path="streetNumber"/>
        <form:errors path="streetNumber"/>
    </label><br>
    <label>
        Nr lokalu: <form:input path="localeNumber"/>
        <form:errors path="localeNumber"/>
    </label><br>
    <label>
        Miasto: <form:input path="city"/>
        <form:errors path="city"/>
    </label><br>
    <label>
        Kod pocztowy: <form:input path="postalCode"/>
        <form:errors path="postalCode"/>
    </label><br>

    <form:button>Zapisz</form:button>
</form:form>

</body>
</html>

