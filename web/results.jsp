<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 05.06.2018
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 23.05.2018
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Тросовая система</title>
    <link rel="stylesheet" type="text/css" href="resources/style.css"/>
    <link rel="stylesheet" type="text/css" href="resources/style2.css"/>
</head>
<body>
<header>
    <div class="content-main">
        <section class="header">
            <div class="logo"><img src="resources/img/logo2.png"></div>
            <div class="header-menu">
                <nav class="nav_item">
                    <ul class="nav_ul">
                        <li class="nav_li">
                            <a href="/index" class="nav_link nav_link1"> Главная </a>
                        </li>
                        <li class="nav_li">
                            <a href="/inputParameters" class="nav_link nav_link2"> Выбор параметров </a>
                        </li>
                        <li class="nav_li">
                            <a href="/results" class="nav_link nav_link3"> Результаты </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </section>
    </div>
</header>
<form action="editInputParameters" method="post" class="">
<div class="container" align="center">
    <table class="results_table" align="center">
        <thead>
        <th>Id</th>
        <th>Gamma1</th>
        <th>Alfa1</th>
        <th>Fi1</th>
        <th>N</th>
        </thead>
        <tbody>
        <c:forEach items="${results}" var="results">
        <tr>
            <td>${results.parametrsId}</td>
            <td>${results.gamma1}</td>
            <td>${results.alfa1}</td>
            <td>${results.fi1}</td>
            <td>${results.n}</td>
        </tr>
        </tbody>
        </c:forEach>
    </table>
</div>
<img src="resources/img/ugolataki.png" alt="" class="">
<input id="submitButton" class="savebutton" value="Удалить" type="submit">
</form>
</body>
</html>

