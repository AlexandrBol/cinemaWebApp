<%@ page pageEncoding="UTF-8"%>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="pages/tmpl/headtag.jspx" />
    <title>Login</title>
</head>

<body>
<jsp:include page="pages/tmpl/head.jspx" />

<h2>LOL</h2>
<br>
<%=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))%>
</body>
</html>