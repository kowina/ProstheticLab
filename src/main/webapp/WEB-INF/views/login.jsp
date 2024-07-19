<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="post">
    <c:if test="${param.logout != null}">
        <div>
            <p style="color: green; font-weight: bold;" >Wylogowałeś się pomyślnie.</p>
        </div>
    </c:if>
    <c:if test="${param.error != null}">
        <div>
            <p style="color: red; font-weight: bold;" >Błędna nazwa użytkownika lub hasło. Spróbuj ponownie.</p>
        </div>
    </c:if>
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <div><input type="submit" value="Sign In"/></div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>


</form>

</body>
</html>
