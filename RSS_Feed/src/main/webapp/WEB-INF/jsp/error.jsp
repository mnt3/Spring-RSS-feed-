<%--
  Created by IntelliJ IDEA.
  User: Mantas
  Date: 8/1/2018
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Error </title>
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
<h1>Sorry, but you got an error, try to check your url</h1>

<button type="button" class="btn btn-primary btn-lg">Go to main page</button>
</div>
</body>
</html>
