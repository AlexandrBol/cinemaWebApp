<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title><c:out value="${movieDTO.title}" default="err"/></title>
    <jsp:include page="/pages/tmpl/headtag.jsp"/>
    <style>
        .container2 {
            margin: auto;
            width: 60%;
            padding: 10px;
        }
    </style>
</head>

<body>
<jsp:include page="/pages/tmpl/head.jsp"/>
<div class="col-xs-12">
    <div class="row">
        <div class="hidden-xs col-sm-3">
            <div class="logo_redirect">
                <img src="<c:out value="${movieDTO.poster}"/>" style="width: 250px; height: 350px;">
            </div>
        </div>
        <div class="col-xs-12 col-sm-9">
            <h2><c:out value="${movieDTO.title}" default="err"/></h2>
            <p>Genre:<c:out value="${movieDTO.genre}" default="err"/></p>
            <p>Duration:<c:out value="${movieDTO.duration}" default="err"/></p>
            <p>Rent starts  at <c:out value="${movieDTO.rent_start}" default="err"/> and end <c:out value="${movieDTO.rent_end}" default="--.--.----"/></p>
            <p>Rate:<c:out value="${movieDTO.rate}" default="err"/></p>
            <p>description:<c:out value="${movieDTO.description}" default="err"/></p>
        </div>
    </div>
</div>
<div class="container2">
<iframe width="560" height="315" src="<c:out value="${movieDTO.video}"/>" frameborder="0" allowfullscreen></iframe>
</div>

</body>
</html>
