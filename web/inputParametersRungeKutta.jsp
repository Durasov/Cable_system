<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 18.05.2018
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Тросовая система</title>
    <link rel="stylesheet" href="resources/style.css">
    <script type="text/javascript" src="resources/script/Chart.js"></script>
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
                            <a href="/#" class="nav_link nav_link3"> Результаты </a>
                        </li>
                        <li class="nav_li">
                            <a href="/Graphics.jsp" class="nav_link nav_link3"> Графики </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </section>
    </div>
</header>

<main class="main">
    <form action="inputParametersRungeKutta" method="post" class="form">
        <table class="table" align="center">
            <thead>
            <th>Количество интервалов</th>
            <th>Начальное время</th>
            <th>Размер шага</th>
            <th>Максимальный размер шага</th>
            </thead>
            <tbody>
                <tr>
                    <td><input name="n" type="number" required value="20" class="textbox"></td>
                    <td><input name="t0" type="number" required value="0" class="textbox"></td>
                    <td><input name="step" type="number" required value="0.05" step="0.01" class="textbox"> </td>
                    <td><input name="stepmax" type="number" required value="0.05" step="0.01" class="textbox"></td>
                </tr>
            </tbody>
            <thead>
            <th>n1</th>
            <th>nmax</th>
            <th>Интервал от,</th>
            <th>до</th>
            </thead>
            <tbody>
            <tr>
                <td><input name="n1" type="number" required value="1" class="textbox"> </td>
                <td><input name="nmax" type="number" required value="100" class="textbox"></td>
                <td><input name="a" type="number" required value="1" class="textbox"></td>
                <td><input name="b" type="number" required value="20" class="textbox"></td>
            </tr>
            </tbody>
            <tr>
                <td></td>
                <td><input type="submit" value="Расчитать" class="button"></td>
                <td><a href="/inputParameters" class="cancel">Назад</a></td>
                <td></td>
            </tr>
            </tbody>
        </table>
    </form>
</main>
</body>
</html>

