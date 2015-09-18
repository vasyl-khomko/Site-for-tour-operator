<%--
  Created by IntelliJ IDEA.
  User: Vasyl
  Date: 02.06.2015
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Список послуг</title>
    <%@ include file="../includes/links.jsp"%>
    <%@ include file="../includes/scripts.jsp"%>
</head>
<body>
<div class="container">
    <%@ include file="../includes/navbar.jsp"%>
    <div class="page-header">
        <h2>Послуги, що надаюсться</h2>
    </div>
    <div class="row">
        <div class="col-md-8">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Назва послуги</th>
                    <th>Вартість (грн.)</th>
                    <th>Дія</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${services}" var="service">
                    <tr>
                        <td>${service.description}</td>
                        <td>${service.price}</td>
                        <td><a href="/tours/delete?service_id="${service.serviceId}>Видалити</a></td>
                    </tr>
                </c:forEach>
                <c:forEach begin="1" end="${4 - services.size()}">
                <tr>
                    <td>(назва)</td>
                    <td>(ціна)</td>
                    <td></td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
            <form class="form-horizontal" action="/tours/add-service" method="post">
                <div class="form-group">
                    <div class="col-md-8">
                        <label>Назва послуги</label>
                        <input name="description" class="form-control" placeholder="Назва послуги" type="text">
                    </div>
                    <div class="col-md-2">
                        <label>Вартість (грн)</label>
                        <input name="price" class="form-control" placeholder="Ціна" type="text" value="0">
                    </div>
                    <div class="col-md-2">
                        <label>Додати</label>
                        <button type="submit" class="btn btn-default form-control">Додати</button>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <a href="/tours/tour-review" class="btn btn-success">Завершити</a>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-4">
            <div class="list-group">
                <a href="/tours/edit-current-tour" class="list-group-item">Інформація про тур</a>
                <a href="/tours/create-or-edit-tourdays" class="list-group-item">Маршрут туру</a>
                <a href="/tours/create-or-edit-services" class="list-group-item active">Список послуг</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
