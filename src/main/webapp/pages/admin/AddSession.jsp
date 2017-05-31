<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Session</title>
    <jsp:include page="/pages/tmpl/headtag.jsp"/>
</head>
<body>
<jsp:include page="/pages/tmpl/head.jsp"/>



<form name="SessionForm" method="post" action="${pageContext.servletContext.contextPath}/AddSession">
    <select id="value" name="value">
        <c:forEach items="${movieDTOList}" var="movies">
            <option value="${movies.id}">${movies.title}</option>
        </c:forEach>
    </select>

    <select id="value1" name="value1">
        <c:forEach items="${hallDTOList}" var="hall">
            <option value="${hall.id}">${hall.name}</option>
        </c:forEach>
    </select>

    dateSession: <input type="dateSession" name="dateSession"/> <br/>
    <input type="submit" value="AddSession" />
</form>

</body>
</html>
