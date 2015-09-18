<%--
  Created by IntelliJ IDEA.
  User: Vasyl
  Date: 21.05.2015
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Тури</title>
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/favicon.ico" />
    <%@ include file="../includes/links.jsp"%>
    <%@ include file="../includes/scripts.jsp"%>
</head>
<body>
    <div class="container">
        <%@ include file="../includes/navbar.jsp"%>
        <div class="row">
            <c:forEach items="${tours}" var="tour" varStatus="i">
            <div class="col-md-4">
                <div class="thumbnail">
                    <img src="/images/${tour.image.fileName}">
                    <!--img src="http://feerie.com.ua/sites/default/files/styles/portfolio_grid/public/zamok_somjur_pejzazh_2.jpg?itok=edUS9g2N"-->
                    <div class="caption">
                        <h3><a href="/tours/view?tour_id=${tour.tourId}">${tour.name}</a></h3>
                        <!--p><strong>Країни: </strong> Польща, Словачина, Чехія, Угорщина</p-->
                        <p class="description">${tour.description}</p>
                        <p>
                            <span class="label label-info">${tour.duration} днів</span>
                            <span class="label label-success">${tour.price} грн.</span>

                            <sec:authorize access="hasAnyRole('USER_ROLE')">
                                <a class="btn btn-primary btn-xs pull-right" href="/tours/edit-tour?tour_id=${tour.tourId}">Змінити</a>
                            </sec:authorize>
                        </p>
                    </div>
                </div>
            </div>
            <c:if test="${i.count % 3 == 0}">
        </div>
        <div class="row">
            </c:if>
            </c:forEach>
        </div>
        <div class="row text-center">
            <h1>${pagesCount}</h1>
            <h1>Count: ${count}</h1>
            <div class="col-lg-12">
                <ul class="pagination">
                    <c:choose>
                        <c:when test="${i == page}">
                            <li class="active"><a href="/?page=${i}">${i}</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="">«</a></li>
                        </c:otherwise>
                    </c:choose>
                    <li>
                        <a href="">«</a>
                    </li>
                    <c:forEach begin="1" end="${pagesCount}" var="i">
                        <c:choose>
                            <c:when test="${i == page}">
                                <li class="active"><a href="/?page=${i}">${i}</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="/?page=${i}">${i}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <li>
                        <a href="#">»</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>
