<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form edit WORK</title>
</head>
<body>
<a href="/app/laboratories/choice/+<sec:authentication property="principal.user.id"/>">PRZEŁĄCZ LABORATORIUM</a>

<%@ include file="../menu.jsp" %>

<h1>EDYCJA PRACY</h1>

<div>
    <form:form modelAttribute="work" action="/app/works/edit/${laboratory.id}" method="post">
    <form:hidden path="id"/>
    <form:hidden path="laboratory"/>
    <form:hidden path="workNumber"/>
    <form:hidden path="totalPrice"/>

        <label>
            Data przyjęcia<input type="date" value="${work.created}" <form:input  path="created" />
        </label><br>
                 <form:errors path="created"/>
        <label>
            Data oddania:<input type="date" value="${work.finished}" <form:input  path="finished"/>
        </label><br>
         <form:errors path="finished"/>
        <label>
           Gabinet:     <form:select path="dentalOffice">
                            <form:option value="${work.dentalOffice.id}" label="${work.dentalOffice.name}"/>
                            <form:options items="${dentalOffices}" itemLabel="name" itemValue="id"/>
                        </form:select>
       </label><br>
       <label>
           Lekarz:     <form:select path="dentist">
                            <form:option value="${work.dentist.id}" label="${work.dentist.lastName}"/>
                            <form:options items="${dentists}" itemLabel="lastName" itemValue="id"/>
                        </form:select>
       </label><br>
       <label>
            Pacjent: <form:input path="patient"/>
       </label><br>
         <form:errors path="patient"/>
         <label>
            Gabinet:    <form:select path="offer">
                            <form:option value="${work.offer.id}" label="${work.offer.name}"/>
                            <form:options items="${offers}" itemLabel="name" itemValue="id"/>
                        </form:select>
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
