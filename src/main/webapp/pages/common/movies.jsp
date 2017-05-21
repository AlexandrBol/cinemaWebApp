<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../tmpl/headtag.jspx" />
</head>
<body>
<jsp:include page="../tmpl/head.jspx" />
<center>
<c:forEach items="${movieDTOList}" var="movies">
<a href="${pageContext.servletContext.contextPath}/movie?id=${movies.id}">${movies.title}</a><br/>
</c:forEach>
</center>
</body>
</html>
