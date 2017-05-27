<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <jsp:include page="/pages/tmpl/headtag.jsp"/>
</head>
<body>
<jsp:include page="/pages/tmpl/head.jsp"/>
<c:out value="${sessionScope.message}"/>
<form name="registerForm" method="post" action="${pageContext.servletContext.contextPath}/register">
    Username: <input type="text" name="login"/> <br/>
    Password: <input type="text" name="password"/> <br/>
    First Name: <input type="text" name="firstName"/> <br/>
    Last Name: <input type="text" name="lastName"/> <br/>
    email: <input type="text" name="email"/> <br/>
    sex: <input type="text" name="sex"/> <br/>
    birthday:<input type="text" name="birthday"/> <br/>
    <input type="submit" value="Register" />
</form>
</body>
</html>
