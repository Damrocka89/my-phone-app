<%--
  Created by IntelliJ IDEA.
  User: ewkra
  Date: 27.07.2019
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="webjars/bootstrap/3.4.0/css/bootstrap.min-jsf.css" rel="stylesheet">

    <title>Produkt</title>
</head>
<body>

<%@ include file="components/navbar.jsp" %>


<div class="container">

    <div class="row">
        <div class="col-sm-4">
            <img src="${product.imagePath}" alt="${product.brand} ${product.model} picture" width="134"
                 height="192">
        </div>
        <div class="col-sm-4">
            <h1>${product.brand} ${product.model}</h1>
            <h6>System operacyjny: ${product.operatingSystem}</h6>
            <h6>Przednia kamera: ${product.primaryCameraMp}</h6>
            <h6>Tylna kamera: ${product.secondaryCameraMp}</h6>
        </div>
        <div class="col-sm-4">
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
</div>


<script src="webjars/jquery/3.4.1/jquery.min.js"/>
<script src="webjars/bootstrap/3.4.0/js/bootstrap.min.js"/>
</body>
</html>
