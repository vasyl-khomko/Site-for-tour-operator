<%--
  Created by IntelliJ IDEA.
  User: Vasyl
  Date: 10.06.2015
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Реєстрація</title>
    <%@ include file="includes/links.jsp"%>
    <%@ include file="includes/scripts.jsp"%>
</head>
<body>
<div class="container">
    <%@ include file="includes/navbar.jsp"%>
    <div class="row">
        <div class="col-md-8">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Реєстрація</h3>
                </div>
                <div class="panel-body">
                    <form role="form" class="form-horizontal" action="/register" method="post">
                        <fieldset>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="email">Username:</label>
                                <div class="col-sm-10">
                                    <input type="email" class="form-control" id="username" name="username" placeholder="Enter email">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="email">Email:</label>
                                <div class="col-sm-10">
                                    <input type="email" class="form-control" id="email" name="email" placeholder="Enter email">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="pwd">Password:</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="pwd" placeholder="Enter password">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <input type="submit" class="btn btn-sm btn-success" value="Register">
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
