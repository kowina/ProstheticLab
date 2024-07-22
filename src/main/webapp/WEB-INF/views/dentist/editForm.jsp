<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form edit dentist</title>
</head>
<body>
<h1>EDytowanie DENTYSTY</h1>

<form:form modelAttribute="dentist" action="/dentists/edit" method="post">
    <form:hidden path="id"/>
    <label>
        Imię: <form:input path="firstName"/>
    </label>
    <form:errors path="firstName"/>
    <br>
    <label>
        Nazwisko: <form:input path="lastName"/>
        <form:errors path="lastName"/>
    </label><br>
    <form:button>Zapisz</form:button>
</form:form>

</body>
</html>

