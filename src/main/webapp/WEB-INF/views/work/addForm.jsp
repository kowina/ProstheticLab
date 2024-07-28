<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form add WORK</title>
</head>
<body>
<a href="/app/laboratories/choice/+<sec:authentication property="principal.user.id"/>">PRZEŁĄCZ LABORATORIUM</a>

<%@ include file="../menu.jsp" %>

<h1>DODAWANIE PRACY</h1>

<div>
    <form:form modelAttribute="work" action="/app/works/add/${laboratory.id}" method="post">
    <form:hidden path="id"/>

        <label>
            Data przyjęcia<input type="date" <form:input  path="created"/>
        </label><br>
                 <form:errors path="created"/>
        <label>
            Data oddania:<input type="date" <form:input  path="finished"/>
        </label><br>
         <form:errors path="finished"/>
       <label>
           Gabinet:  <form:select path="dentalOffice" items="${dentalOffices}" itemLabel="name" itemValue="id"/>
       </label><br>
       <label>
           Lekarz:  <form:select path="dentist" items="${dentists}" itemLabel="lastName" itemValue="id"/>
       </label><br>
       <label>
            Pacjent: <form:input path="patient"/>
       </label><br>
         <form:errors path="patient"/>
         <label>
         Rodzaj pracy:<form:select path="offer" items="${offers}" itemLabel="name" itemValue="id"/>
         </label><br>
         <label>
         Ilość:<form:input path="quantity"/>
</label><br>
    <label>
        Opis:<form:textarea path="description"/>
    </label><br>
             <form:errors path="description"/>

    <form:button>DODAJ</form:button>
</form:form>
</div>
</body>
</html>
