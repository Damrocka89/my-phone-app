<%--
  Created by IntelliJ IDEA.
  User: ewkra
  Date: 28.07.2019
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Smart Shop</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="${pageContext.request.contextPath}/toBasket"><span class="glyphicon glyphicon-shopping-cart"></span> Koszyk</a></li>
            <c:choose>
                <c:when test="${isAuthenticated}">
                    <li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-out"></span> Wyloguj</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-log-in"></span> Zaloguj</a></li>
                </c:otherwise>
            </c:choose>

        </ul>
    </div>
</nav>
</body>
</html>
