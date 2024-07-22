<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form edit laboratory</title>
</head>
<body>
<h1>EDYCJA LABORATORIUM</h1>

<form:form modelAttribute="laboratory" action="/laboratories/edit" method="post">
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
        REGON: <form:input path="regon"/>
        <form:errors path="regon"/>
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
