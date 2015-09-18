<%--
  Created by IntelliJ IDEA.
  User: Vasyl
  Date: 11.06.2015
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Користувачі</title>
    <%@ include file="../includes/links.jsp"%>
    <%@ include file="../includes/scripts.jsp"%>
</head>
<body>
<div class="container">
    <%@ include file="../includes/navbar.jsp"%>
    <div class="page-header">
        <h2>Заявки користувачів</h2>
    </div>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Прізвище</th>
                    <th>Імія</th>
                    <th>Логін</th>
                    <th>Емейл</th>
                    <th>Телефон</th>
                    <th>Час створення</th>
                    <th>Роль</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.lastName}</td>
                        <td>${user.firstName}</td>
                        <td>${user.username}</td>
                        <td>${user.email}</td>
                        <td>${user.phone}</td>
                        <td>${user.createTime}</td>
                        <td>${user.role.name}</td>
                        <td><a href="/users/confirm">Підтвердити</a></td>
                        <td><a href="/users/reject">Відхилити</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
