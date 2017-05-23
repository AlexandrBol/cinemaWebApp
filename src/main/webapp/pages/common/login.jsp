<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <jsp:include page="/pages/tmpl/headtag.jsp"/>
</head>

<body>
<jsp:include page="/pages/tmpl/head.jsp"/>
<div class="form-inline">
<c:out value="${sessionScope.message}"/>
<form name="loginForm" method="post" action="z${pageContext.servletContext.contextPath}/login">
    <h1>Login</h1>
                    <input type="text" placeholder="Login"  class="form-control" name="login"/> <br/>
                    <input type="password"  placeholder="Password" class="form-control" name="password"/> <br/>
<div class="form-inline">
    <input class=" btn btn-md btn-success" type="submit" value="Login" />
    <a class="btn btn-danger btn-md" href="register" role="button">Register</a>
</div>
</form>

</div>
<% session.removeAttribute("error"); %>
</body>
</html>
