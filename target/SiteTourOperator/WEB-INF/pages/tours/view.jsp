<%--
  Created by IntelliJ IDEA.
  User: Vasyl
  Date: 21.05.2015
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>${tour.name}</title>
    <%@ include file="../includes/links.jsp"%>
    <%@ include file="../includes/scripts.jsp"%>
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="http://fontawesome.io/assets/font-awesome/css/font-awesome.css" rel="stylesheet">
    <script type="text/javascript">
        $(function(){
            var hash = window.location.hash;
            hash && $('#tour-view-nav a[href="' + hash + '"]').tab('show');

            $('.nav-tabs a').click(function (e) {
                $(this).tab('show');
                var scrollmem = $('body').scrollTop();
                window.location.hash = this.hash;
                $('html,body').scrollTop(scrollmem);
            });
        });
    </script>
</head>
<body>
<div class="container">
    <%@ include file="../includes/navbar.jsp"%>
    <div class="panel-heading">
        <h3 class="panel-title">${tour.name}</h3>
    </div>
    <div class="row">
        <div class="col-md-8">
            <div class="thumbnail">
                <img src="http://feerie.com.ua/sites/default/files/styles/portfolio_grid/public/zamok_somjur_pejzazh_2.jpg?itok=edUS9g2N">
            </div>
            <h3>
                <span class="label label-info">${tour.duration} днів</span>
                <span class="label label-success">${tour.price} грн.</span>
            </h3>
            <hr>
            <p><strong>Країни: </strong>
                <c:forEach items="${tour.countries}" var="country">
                <span>${country.name}; </span>
                </c:forEach>
            </p>
            <p><strong>Тип туру: </strong>
                <c:forEach items="${tour.categories}" var="category">
                <span>${category.name}; </span>
                </c:forEach>
            </p>
            <p><strong>Дати: </strong>
                <c:forEach items="${tour.dates}" var="date">
                    <span>${date}, </span>
                </c:forEach>
            </p>
            <p>${tour.description}</p>
            <ul id="tour-view-nav" class="nav nav-tabs">
                <li class="active"><a href="#tourdays" data-toggle="tab">Маршрут туру</a></li>
                <li><a href="#reviews" data-toggle="tab">Відгуки і коментарі</a></li>
                <li><a href="#services" data-toggle="tab">Список послуг</a></li>
            </ul>
            <div class="tab-content" id="tour-tab-content">
                <div id="tourdays" class="tab-pane active">
                    <c:forEach items="${tour.tourdays}" var="tourday">
                        <h3><span class="label label-primary">День ${tourday.dayNumber}</span></h3>
                        <p>${tourday.description}</p>
                    </c:forEach>
                </div>
                <div id="reviews" class="tab-pane">
                    <h2 class="page-header">Відгуки і коментарі</h2>
                    <section class="comment-list">
                        <!-- First Comment -->
                        <c:forEach items="${reviews}" var="reviewItem">
                            <article class="row">
                                <div class="col-md-2 col-sm-2 hidden-xs">
                                    <figure class="thumbnail">
                                        <img class="img-responsive" src="http://www.keita-gaming.com/assets/profile/default-avatar-c5d8ec086224cb6fc4e395f4ba3018c2.jpg" />
                                        <figcaption class="text-center">${reviewItem.user.username}</figcaption>
                                    </figure>
                                </div>
                                <div class="col-md-10 col-sm-10">
                                    <div class="panel panel-default arrow left">
                                        <div class="panel-body">
                                            <header class="text-left">
                                                <div class="comment-user"><i class="fa fa-user"></i> ${reviewItem.user.username}</div>
                                                <time class="comment-date" datetime="16-12-2014 01:05"><i class="fa fa-clock-o"></i> ${reviewItem.createTime}</time>
                                            </header>
                                            <div class="comment-post">
                                                <p>
                                                   ${reviewItem.text}
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </article>
                        </c:forEach>
                        <article class="row">
                            <div class="col-md-2 col-sm-2 hidden-xs">
                                <figure class="thumbnail">
                                    <img class="img-responsive" src="http://www.keita-gaming.com/assets/profile/default-avatar-c5d8ec086224cb6fc4e395f4ba3018c2.jpg" />
                                    <figcaption class="text-center">username</figcaption>
                                </figure>
                            </div>
                            <div class="col-md-10 col-sm-10">
                                <div class="panel panel-default arrow left bg-darkgrey">
                                    <div class="panel-body">
                                        <header class="text-left">
                                            <div class="comment-user"><i class="fa fa-user"></i> That Guy</div>
                                        </header>
                                        <form:form action="/tours/view/add-review?tour_id=${tour.tourId}" method="post" commandName="review">
                                            <div class="comment-post">
                                                <form:textarea class="form-control resize-vertical" path="text"></form:textarea>
                                            </div>
                                            <p class="text-right"><button type="submit" class="btn btn-success btn-sm">Submit</button></p>
                                        </form:form>
                                    </div>
                                </div>
                            </div>
                        </article>
                    </section>

                </div>
                <div id="services" class="tab-pane">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>Послуга</th>
                            <th>Вартість</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${tour.services}" var="service">
                            <tr>
                                <td>${service.description}</td>
                                <td>${service.price}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div><!-- /.tab-content -->
        </div>
        <div class="col-md-4">
            <div class="well">
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sed diam eget risus varius blandit sit amet non magna. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Cras mattis consectetur purus sit amet fermentum. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Aenean lacinia bibendum nulla sed consectetur.</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
