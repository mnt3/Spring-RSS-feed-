<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>RSS feed</title>
    <link href="webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://bootswatch.com/4/cerulean/bootstrap.min.css" />
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">

    <div class="collapse navbar-collapse" id="navbarColor01">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/index">Add RSS <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/feedList">All Feeds</a>
            </li>

        </ul>
    </div>
</nav>

<div class="container">
    <h1>Feed  ${feed.feed_name}</h1>
   <p>URL address:<a href="${feed.url}">${feed.url}</a></p>
    <p>Update time and date: ${feed.last_update}</p>
    <p>Article count: ${item_count}</p>
    <p>Most recent articles title and URL: </p>

    <table class="table table-hover">
        <tr>
            <th>Title</th>
            <th>URL</th>
        </tr>
        <c:forEach  items="${itemTopFive}" var ="item">
            <tr>
                <td>${item.title}</td>
                <td><a href="${item.link}">${item.link}</a></td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>

</html>