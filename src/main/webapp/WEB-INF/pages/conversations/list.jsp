<%--
  Created by IntelliJ IDEA.
  User: Vasyl
  Date: 14.10.2015
  Time: 13:07
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
                <tbody>
                <c:forEach items="${conversations}" var="conversation">
                    <tr>
                        <td>${conversation}</td>
                        <td>${conversation.firstName}</td>
                        <td><a href="/users/confirm">Підтвердити</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
