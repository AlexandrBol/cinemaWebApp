<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cinema</title>
    <jsp:include page="/pages/tmpl/headtag.jsp"/>
</head>

<body>
<jsp:include page="/pages/tmpl/head.jsp"/>
<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="carousel-item active">
            <img class="d-block img-fluid" src="https://cdn.allwallpaper.in/wallpapers/1920x1080/12418/movie-posters-the-avengers-movie-blurred-background-1920x1080-wallpaper.jpg" alt="First slide">
    </div>
        <div class="carousel-item">
            <img class="d-block img-fluid" src="http://www.wallpapermade.com/images/wallpapers/originals/guardians-of-the-galaxy-movie-poster-wallpaper-2080.jpg" alt="Second slide">
        </div>
        <div class="carousel-item">
            <img class="d-block img-fluid" src="https://cdn.allwallpaper.in/wallpapers/2048x1152/8934/batman-movies-posters-the-dark-knight-rises-2048x1152-wallpaper.jpg" alt="Third slide">
        </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
</body>
</html>