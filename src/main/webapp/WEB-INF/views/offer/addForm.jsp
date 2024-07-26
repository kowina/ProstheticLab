<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form add offer</title>
</head>
<body>
<a href="/app/laboratories/choice/+<sec:authentication property="principal.user.id"/>">PRZEŁĄCZ LABORATORIUM</a>

<%@ include file="../menu.jsp" %>

<h1>DODAWANIE DO OFERTY</h1>

<div>
    <form:form modelAttribute="offer" action="/app/offers/add/${laboratory.id}" method="post">
    <form:hidden path="id"/>
    <label>
       Nazwa: <form:select path="name">
                <form:option value="-" label="--Proszę wybrać--"/>
                <form:options items="${sampleOffers}" itemLabel="name" itemValue="name"/>
            </form:select>
    </label>
    <form:errors path="name"/>

    <label>
        Cena jednostkowa: <form:input path="unitPrice"/> zł
        <form:errors path="unitPrice"/>
    </label><br>
    <form:button>DODAJ</form:button>
</form:form>
</div>




</body>
</html>
