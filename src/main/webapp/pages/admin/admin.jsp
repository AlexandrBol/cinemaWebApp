
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page</title>
</head>
<body>

<h3>Admin page</h3>
<li><a href="addMovie.jsp">Add Movie</a></li>
<li><a href="addHall.jsp">Add Hall</a></li>

<form name="SessionForm" method="post" action="${pageContext.servletContext.contextPath}/AddSession">
    <input type="submit" value="AddSession" />
</form>
</body>
</html>
