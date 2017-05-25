<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <jsp:include page="/pages/tmpl/headtag.jsp"/>
</head>
<body>
<jsp:include page="/pages/tmpl/head.jsp"/>
<c:out value="${sessionScope.message}"/>
<form name="loginForm" method="post" action="${pageContext.servletContext.contextPath}/login">
    Username: <input type="text" name="login"/> <br/>
    Password: <input type="password" name="password"/> <br/>
    <input type="submit" value="Login" />
</form>
</body>
</html>
