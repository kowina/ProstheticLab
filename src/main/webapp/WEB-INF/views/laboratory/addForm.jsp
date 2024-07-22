<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form add dentist</title>
</head>
<body>
<h1>DODAWANIE LABORATORIUM</h1>

<form:form modelAttribute="laboratory" action="/laboratories/add" method="post">
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
        Nr: <form:input path="street_number"/>
        <form:errors path="street_number"/>
    </label><br>
    <label>
        Nr lokalu: <form:input path="locale_number"/>
        <form:errors path="locale_number"/>
    </label><br>
    <label>
        Miasto: <form:input path="city"/>
        <form:errors path="city"/>
    </label><br>
    <label>
        Kod pocztowy: <form:input path="postal_code"/>
        <form:errors path="postal_code"/>
    </label><br>

    <form:button>Zapisz</form:button>
</form:form>

</body>
</html>
