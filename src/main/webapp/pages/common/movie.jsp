<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title><c:out value="${movieDTO.title}" default="err"/></title>
</head>

<body>
<img src="${pageContext.servletContext.contextPath}/img/${movieDTO.id}.jpg" alt="">
<c:out value="${movieDTO.title}" default="err"/>
<c:out value="${movieDTO.description}" default="err"/>
<c:out value="${movieDTO.duration}" default="err"/>


</body>
</html>
