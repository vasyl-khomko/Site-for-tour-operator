<%--
  Created by IntelliJ IDEA.
  User: Vasyl
  Date: 10.06.2015
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Вхід</title>
    <%@ include file="includes/links.jsp"%>
    <%@ include file="includes/scripts.jsp"%>
</head>
<body>
    <div class="container">
        <%@ include file="includes/navbar.jsp"%>
        <div class="row">
            <div class="col-md-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Вхід</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" action="/loginProcess" method="post">

                                <div class="form-group">
                                    <input class="form-control" placeholder="Логін" name="username" type="text" autofocus="">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Пароль" name="password" type="password" value="">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Запам'ятати мене
                                    </label>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-sm btn-success">Увійти</button>
                                    <a href="users/registration" class="btn btn-sm btn-default">Створити акаунт</a>
                                </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
