<%--
  Created by IntelliJ IDEA.
  User: Vasyl
  Date: 02.06.2015
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Маршрут туру</title>
    <meta charset="UTF-8">
    <%@ include file="../includes/links.jsp"%>
    <%@ include file="../includes/scripts.jsp"%>
</head>
<body>
<div class="container">
    <%@ include file="../includes/navbar.jsp"%>
    <div class="page-header">
        <h2>Маршрут туру</h2>
    </div>
    <div class="row">
        <div class="col-md-8">
            <form class="form-horizontal" action="${pageContext.request.contextPath}/tours/save-or-update-tourdays" method="post">
                <c:forEach items="${tourdays}" var="tourday" varStatus="i">
                    <div class="form-group">
                        <div class="col-md-12">
                            <label>День ${i.count}</label>
                            <textarea class="form-control resize-vertical" name="descriptions">${tourday.description}</textarea>
                        </div>
                    </div>
                </c:forEach>
                <div class="form-group">
                    <div class="col-md-12">
                    <button type="submit" class="btn btn-sm btn-success">Продовжити</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-4">
            <div class="list-group">
                <a href="/tours/edit-current-tour" class="list-group-item">Інформація про тур</a>
                <a href="/tours/create-or-edit-tourdays" class="list-group-item active">Маршрут туру</a>
                <a href="/tours/create-or-edit-services" class="list-group-item">Список послуг</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
