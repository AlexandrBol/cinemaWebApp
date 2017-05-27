<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Movie</title>
    <jsp:include page="/pages/tmpl/headtag.jsp"/>
</head>
<body>
<jsp:include page="/pages/tmpl/head.jsp"/>
<c:out value="${sessionScope.message}"/>
<form name="MovieForm" method="post" action="${pageContext.servletContext.contextPath}/addmovie">
    title: <input type="text" name="title"/> <br/>
    description: <input type="text" name="description"/> <br/>
    duration: <input type="text" name="duration"/> <br/>
    rent_start: <input type="text" name="rent_start"/> <br/>
    rent_end: <input type="text" name="rent_end"/> <br/>
    genre: <input type="text" name="genre"/> <br/>
    rate: <input type="text" name="rate"/> <br/>
    poster: <input type="text" name="poster"/> <br/>
    video: <input type="text" name="video"/> <br/>
    <input type="submit" value="AddMovie" />
</form>
</body>
</html>
