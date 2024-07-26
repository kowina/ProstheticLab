<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Strona laboratorium</title>
</head>
<body>
<a href="/app/laboratories/choice/+<sec:authentication property="principal.user.id"/>">PRZEŁĄCZ LABORATORIUM</a>
<%@ include file="../menu.jsp" %>

<h3>HOMELAB</h3>
</body>
</html>
