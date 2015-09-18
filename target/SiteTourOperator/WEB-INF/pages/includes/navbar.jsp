<%--
  Created by IntelliJ IDEA.
  User: Vasyl
  Date: 02.06.2015
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <!--button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button-->
            <a class="navbar-brand" href="#">Світ мандрів</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/">Домівка</a></li>
                <li><a href="/tours">Тури</a></li>
                <li><a href="/tours">Країни</a></li>
                <!--li><a href="/tours">Заявки користувачів</a></li-->
                <!--li><a href="/tours/create-tour">Створити тур</a></li-->
                <li><a href="/tours">Про компанію</a></li>
                <li><a href="/tours">Контакти</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <sec:authorize access="isAnonymous()">
                    <li><a href="/login">Увійти</a></li>
                </sec:authorize>

                <sec:authorize access="isAuthenticated()">
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">vasyl <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="/users/view">Мій профіль</a></li>
                            <li><a href="/users/edit">Редагувати профіль</a></li>
                            <li><a href="/logout">Вийти</a></li>
                        </ul>
                    </li>
                </sec:authorize>
            </ul>
        </div><!--/.nav-collapse -->
    </div><!--/.container-fluid -->
</nav>
</html>
