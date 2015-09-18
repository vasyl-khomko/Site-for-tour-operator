<%--
  Created by IntelliJ IDEA.
  User: Vasyl
  Date: 13.06.2015
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Редагування профілю ${user.username}</title>
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
                    <h3 class="panel-title">Редагування рофілю</h3>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" enctype="multipart/form-data" action="/users/update" method="post">
                    <div class="col-md-4">
                        <div class="thumbnail">
                            <img src="/images/${user.image.fileName}">
                        </div>
                        <input type="file" name="file" class="btn btn-defaul">
                    </div>
                    <div class="col-md-8">
                        <div class="form-group">
                            <label class="col-md-3 control-label">Прізвище</label>
                            <div class="col-md-9">
                                <input type="text" name="last_name" class="form-control" value="${user.lastName}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">Ім'я</label>
                            <div class="col-md-9">
                                <input type="text" name="first_name" class="form-control" value="${user.firstName}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">Логін</label>
                            <div class="col-md-9">
                                <input type="text" name="username" class="form-control" value="${user.username}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">Електронна пошта</label>
                            <div class="col-md-9">
                                <input type="text" name="email" class="form-control" value="${user.email}">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3"></div>
                            <div class="col-md-6">
                                <label>Роль</label>
                                <select class="selectpicker form-control">
                                    <option>Користувач</option>
                                    <option>Тур менеджер</option>
                                    <option>Менеджер по роботі з клієнтами</option>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <label>Дата народження</label>
                                <input type="text" name="birth_date" class="form-control" value="${user.birthDate}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">Телефон</label>
                            <div class="col-md-9">
                                <input type="text" name="phone" class="form-control" value="${user.phone}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">Адреса</label>
                            <div class="col-md-9">
                                <input type="text" name="address" class="form-control" value="${user.address}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">Пароль</label>
                            <div class="col-md-9">
                                <input type="password" name="password1" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">Підтвердіть пароль</label>
                            <div class="col-md-9">
                                <input type="password" name="password2" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-3col-md-3 control-label"></div>
                            <div class="col-md-9">
                                <input type="submit" class="btn btn-info" value="Підтвердити зміни">
                                <a href="/users/view" class="btn btn-default">Скасувати</a>
                            </div>
                        </div>
                    </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
