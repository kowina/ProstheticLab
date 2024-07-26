<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form add dentaloffice</title>
</head>
<body>
<a href="/app/laboratories/choice/+<sec:authentication property="principal.user.id"/>">PRZEŁĄCZ LABORATORIUM</a>

<%@ include file="../menu.jsp" %>

<h1>DODAWANIE DENTYSTY</h1>

<form:form modelAttribute="dentist" action="/app/dentists/add/${laboratory.id}" method="post">
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
