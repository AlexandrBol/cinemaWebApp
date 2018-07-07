<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Shedule</title>
    <jsp:include page="/pages/tmpl/headtag.jsp"/>
</head>
<body>

<jsp:include page="/pages/tmpl/head.jsp"/>

<p></p>

<c:forEach items="${sessionDTOList}" var="session">
    <p>${session.dateSession}</p>
    <c:forEach items="${movieDTOList}" var="movies">
    <a href="${pageContext.servletContext.contextPath}/session?id=${session.id}">
        <c:if test ="${session.movieID==movies.id}">
            <img src="<c:out value="${movies.poster}"/>" border="0" style="width: 250px; height: 350px;">
        </c:if>
    </a></c:forEach>
</c:forEach>

}
</body>

</html>
