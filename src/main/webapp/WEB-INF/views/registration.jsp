<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Registration form</title>
</head>
<body>
<h1>REJESTRACJA</h1>

<form:form modelAttribute="user" action="/registration" method="post">
    <form:hidden path="id"/>
    <label>
        First name: <form:input path="firstName"/>
    </label>
    <form:errors path="firstName"/>
    <br>
    <label>
        Last name: <form:input path="lastName"/>
        <form:errors path="lastName"/>
    </label><br>
    <label>
        Email: <form:input path="email"/>
    </label>
    <form:errors path="email"/>
    <br>
    <label>
        Password:
        <form:password path="password" />
    </label>
    <form:errors path="password"/>
    <form:button>Zapisz</form:button>
</form:form>
</body>
</html>
