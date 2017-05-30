<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Hall</title>
    <jsp:include page="/pages/tmpl/headtag.jsp"/>
</head>
<body>
<jsp:include page="/pages/tmpl/head.jsp"/>
<c:out value="${sessionScope.message}"/>
<form name="HallForm" method="post" action="${pageContext.servletContext.contextPath}/addHall">
    name: <input type="text" name="name"/> <br/>
    price: <input type="text" name="price"/> <br/>
    <input type="submit" value="AddHall" />
</form>
</body>
</html>
