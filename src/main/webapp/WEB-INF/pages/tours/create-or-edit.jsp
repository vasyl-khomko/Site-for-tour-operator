<%--
  Created by IntelliJ IDEA.
  User: Vasyl
  Date: 21.05.2015
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Створення туру</title>
    <!--%@ include file="../includes/links.jsp"%-->
    <!--%@ include file="../includes/scripts.jsp"%-->
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/bootstrap-datepicker/css/bootstrap-datepicker.css" rel="stylesheet">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap-datepicker/locales/bootstrap-datepicker.uk.min.js"></script>


    <script type="text/javascript">
        $(document).ready(function() {
            $('#dates').datepicker({
                language: "uk",
                multidate: true
            });
        });
    </script>
</head>
<body>
<div class="container">
    <%@ include file="../includes/navbar.jsp"%>
    <div class="page-header">
        <h2>Заповнення інформації про тур</h2>
    </div>
    <div class="row">
        <div class="col-md-8">
            <form class="form-horizontal" action="/tours/save-or-update-tour" method="post">
                <div class="form-group">
                    <div class="col-md-12">
                        <label>Назва</label>
                        <input id="name" type="text" name="name" class="form-control" value="${tour.name}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-4">
                        <label>Тривалість (днів)</label>
                        <input name="duration" class="form-control" placeholder="Тривалість" type="text" value="${tour.duration}">
                    </div>
                    <div class="col-md-4">
                        <label>Ціна (грн)</label>
                        <input name="price" class="form-control" placeholder="Ціна" type="text" value="${tour.price}">
                    </div>
                    <div class="col-md-4">
                        <label>Дати</label>
                        <div class="input-group input-append date" id="datePicker">
                            <input id="dates" type="text" class="form-control" name="dates" value="${joinedDates}"/>
                            <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">Країни</div>
                    <div class="panel-body">
                        <c:forEach items="${countries}" var="country">
                            <input type="checkbox" name="countries" value="${country.countryId}" <c:if test="${tour.countries.indexOf(country) >= 0}">checked</c:if>> ${country.name}
                        </c:forEach>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">Тип туру</div>
                    <div class="panel-body">
                        <c:forEach items="${categories}" var="category">
                            <input type="checkbox" name="categories" value="${category.categoryId}" <c:if test="${tour.categories.indexOf(category) >= 0}">checked</c:if>> ${category.name}
                        </c:forEach>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <label>Опис</label>
                        <textarea class="form-control resize-vertical" name="description">${tour.description}</textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-sm btn-success">Продовжити</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-4">
            <div class="list-group">
                <c:if test="${tour.tourId != 0}">
                    <a href="/tours/edit-current-tour" class="list-group-item active">Інформація про тур</a>
                    <a href="/tours/create-or-edit-tourdays" class="list-group-item">Маршрут туру</a>
                    <a href="/tours/create-or-edit-services" class="list-group-item">Список послуг</a>
                </c:if>
                <c:if test="${tour.tourId == 0}">
                    <a href="" class="list-group-item active">Інформація про тур</a>
                    <a href="" class="list-group-item">Маршрут туру</a>
                    <a href="" class="list-group-item">Список послуг</a>
                </c:if>
            </div>
            <div class="thumbnail">
                <img src="/images/${tour.image.fileName}">
            </div>
            <input type="file" name="file" class="btn btn-defaul">
        </div>
    </div>
</div>
</body>
</html>
