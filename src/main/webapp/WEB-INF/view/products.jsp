<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: ewkra
  Date: 27.07.2019
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link href="webjars/bootstrap/3.4.0/css/bootstrap.min-jsf.css" rel="stylesheet">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
    <title>Produkty</title>
</head>
<body>

<div class="jumbotron">
    <h1>Smart Shop</h1>
    <ul class="nav navbar-nav navbar-right">
        <li><a style="color:#989a9c" href="${pageContext.request.contextPath}/toBasket"><span class="glyphicon glyphicon-shopping-cart"></span> Koszyk</a></li>
        <li><a style="color:#989a9c" href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
    <p>Be smarter.</p>
</div>


<div class="container">
    <div class="col-sm-2">
        <p>tu bedzie filtr</p>
    </div>

    <div class="col-sm-10">
        <div class="container">

            <c:forEach items="${products}" var="product">
                <div class="row">
                    <div class="col-sm-3">
                        <img src="${product.imagePath}" alt="${product.brand} ${product.model} picture" width="134"
                             height="192">
                    </div>
                    <div class="col-sm-4">
                        <h1>
                            <a style="color:#989a9c" href="<c:url value="${pageContext.request.contextPath}/produkt?id=${product.id}"/>">${product.brand} ${product.model}</a>
                        </h1>
                        <h6>System operacyjny: ${product.operatingSystem}</h6>
                        <h6>Przednia kamera: ${product.primaryCameraMp}</h6>
                        <h6>Tylna kamera: ${product.secondaryCameraMp}</h6>
                    </div>
                    <div class="col-sm-3">
                        <fmt:setLocale value="pl_PL"/>
                        <h5><fmt:formatNumber value="${product.price}" type="currency" minFractionDigits="2"/></h5>
                        <form action="${pageContext.request.contextPath}/addToBasket?id=${product.id}" method="post">
                            <input type="submit" value="Do koszyka" class="btn btn-default outline"/>
                        </form>
                        <form action="${pageContext.request.contextPath}/buyNow?id=${product.id}" method="post">
                            <input type="submit" value="Kup teraz" class="btn btn-default outline"/>
                        </form>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>
</div>

<script src="webjars/jquery/3.4.1/jquery.min.js"/>
<script src="webjars/bootstrap/3.4.0/js/bootstrap.min.js"/>
</body>
</html>
