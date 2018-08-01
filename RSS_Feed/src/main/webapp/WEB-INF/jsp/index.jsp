<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Add RSS feed, main page</title>
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

<div class="container" >

    <h1>Add XML RSS Feed</h1>
    <h2><i>${message}</i></h2>
    <div class="jumbotron">
        <form:form method="POST" action="add" modelAttribute="feed">
            <div>

                <form:label path="url">XML RSS Feed url: </form:label>
            </div>
            <div>
                <form:input path="url" placeholder="https://www.15min.lt/rss" type="url" maxlength="255"
                            pattern="https://.*"/>
            </div>

            <div>
                <form:label path="feed_name">XML RSS Feed name: </form:label>
            </div>
            <div>
                <form:input path="feed_name" placeholder="Feed name 4-20 length" minlength="4" maxlength="20"/>
            </div>
            <br/>
            <div>
                <div>
                    <input type="submit" value="Add Feed" class="btn btn-primary"/>
                </div>
            </div>
        </form:form>
    </div>

</div>
</body>

</html>