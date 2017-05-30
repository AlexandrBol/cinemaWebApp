<%--
  Created by IntelliJ IDEA.
  User: alexandrbolshakov
  Date: 5/30/17
  Time: 00:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buy ticket</title>
    <jsp:include page="/pages/tmpl/headtag.jsp"/>
</head>
<body>
<jsp:include page="/pages/tmpl/head.jsp"/>
select sesision:
<form action="session">
    <select name="session">
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
    </select>
    <input type="submit" value="Submit">
</form>
    select row:
    <form action="row">
        <select name="row">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
        </select>
        <input type="submit" value="Submit">
    </form>
        select seat:
        <form action="seat">
            <select name="seat">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
            </select>
            <input type="submit" value="Submit">
</form>

</body>
</html>
