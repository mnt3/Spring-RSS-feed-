<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Feed List</title>
    <link href="webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://bootswatch.com/4/spacelab/bootstrap.min.css"/>
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
    <div>
    <h1>XML RSS feed</h1>
    <h2><i>Please find the list of all available feeds</i></h2>
    </div>
    <div>
        <c:forEach items="${feeds}" var="feed">

                <p class="panel-body">
                    <a href="feed?id=${feed.id}">${feed.url}</a><br/>

                </p>

        </c:forEach>
    </div>
</div>
</body>

</html>