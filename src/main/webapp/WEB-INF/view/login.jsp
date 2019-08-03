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

    <title>login</title>
</head>
<body>

<%@ include file="components/navbar.jsp" %>

<c:if test="${invalidCredentials}">
    <h5 style="color:red">Nieprawidłowy login i/lub hasło</h5>
</c:if>

<form method="post" action="/authentication">
    Login: <input type="text" name="login"/>
    Hasło: <input type="password" name="password"/>
    <button type="submit" class="btn btn-primary">Zaloguj</button>
</form>

<form method="get" action="${pageContext.request.contextPath}/register" >
    <input type="submit" value="Zarejestruj" class="btn btn-primary outline"/>
</form>



<script src="webjars/jquery/3.4.1/jquery.min.js"/>
<script src="webjars/bootstrap/3.4.0/js/bootstrap.min.js"/>
</body>
</html>
