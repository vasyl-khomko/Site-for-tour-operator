<%--
  Created by IntelliJ IDEA.
  User: Vasyl
  Date: 13.06.2015
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <title>Мій профіль ${user.username}</title>
    <%@ include file="../includes/links.jsp"%>
    <%@ include file="../includes/scripts.jsp"%>
</head>
<body>
    <div class="container">
        <%@ include file="../includes/navbar.jsp"%>
        <div class="row">
            <div class="col-md-12">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Мій профіль</h3>
                    </div>
                    <div class="panel-body">
                        <div class="col-md-4">
                            <div class="thumbnail">
                                <img src="${user.image.fileName}">
                            </div>
                        </div>
                        <div class="col-md-8">
                            <table class="table table-hover">
                                <tbody>
                                <tr>
                                    <td>Прізвище</td>
                                    <td>${user.lastName}</td>
                                </tr>
                                <tr>
                                    <td>Ім'я</td>
                                    <td>${user.firstName}</td>
                                </tr>
                                <tr>
                                    <td>Дата народження</td>
                                    <td>${user.birthDate}</td>
                                </tr>
                                <tr>
                                    <td>Логін</td>
                                    <td>${user.username}</td>
                                </tr>
                                <tr>
                                    <td>Роль</td>
                                    <td>${user.role.name}</td>
                                </tr>
                                <tr>
                                    <td>Електронна пошта</td>
                                    <td>${user.email}</td>
                                </tr>
                                <tr>
                                    <td>Телефон</td>
                                    <td>${user.phone}</td>
                                </tr>
                                <tr>
                                <tr>
                                    <td>Адреса</td>
                                    <td>${user.address}</td>
                                </tr>
                                <tr>
                                    <td>Дата створення</td>
                                    <td>${user.createTime}</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
