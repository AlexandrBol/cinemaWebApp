<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All movies</title>
    <jsp:include page="/pages/tmpl/headtag.jsp"/>
</head>
<body>
<jsp:include page="/pages/tmpl/head.jsp"/>

<c:forEach items="${movieDTOList}" var="movies">
    <a href="${pageContext.servletContext.contextPath}/movie?id=${movies.id}">
    <img src="<c:out value="${movies.poster}"/>" border="0" style="width: 250px; height: 350px;">
    </a></c:forEach>

</body>

</html>
