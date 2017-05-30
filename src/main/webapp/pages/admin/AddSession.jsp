<%--
  Created by IntelliJ IDEA.
  User: alexandrbolshakov
  Date: 5/30/17
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Session</title>
    <jsp:include page="/pages/tmpl/headtag.jsp"/>
</head>
<body>
<jsp:include page="/pages/tmpl/head.jsp"/>
<c:out value="${sessionScope.message}"/>
<form name="SessionForm" method="post" action="${pageContext.servletContext.contextPath}/addSession">
    name: <input type="text" name="name"/> <br/>
    price: <input type="text" name="price"/> <br/>


    <input type="submit" value="AddSession" />
</form>
</body>
</html>
