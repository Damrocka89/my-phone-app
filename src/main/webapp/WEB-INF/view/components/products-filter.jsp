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
</head>
<body>
<div class="col-sm-2">
    <div class="container">
        <div class="filter-content">
            <div class="card-body">
                <form action="/produkty" method="get">

                    <c:forEach items="${brands}" var="brand">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" name="marka" value="${brand}"
                            ${checkedBrands.contains(brand) ? "checked" : ""}>
                            <label class="form-check-label" for="${brand}Check">
                                    ${brand}
                            </label>
                        </div>
                    </c:forEach>
                    <button type="submit" class="btn btn-default">Filtruj</button>
                </form>

            </div>
        </div>
    </div>
</div>
</body>
</html>
