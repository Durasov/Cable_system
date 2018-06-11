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
                            <a href="/results" class="nav_link nav_link3"> Результаты </a>
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
            <th>Размер шага</th>
            <th>Начальное время</th>
            <th>Количество иттераций</th>
            </thead>
            <tbody>
                <tr>
                    <td><input name="step" type="number" required value="0.1" step="0.01" class="textbox"> </td>
                    <td><input name="t0" type="number" required value="0.0" step="0.01" class="textbox"></td>
                    <td><input name="nmax" type="number" required value="350" class="textbox"></td>
                </tr>
            </tbody>
            <tr>
                <td><input type="submit" value="Расчитать" class="add_button"></td>
                <td></td>
                <td><a href="/inputParameters" class="add_button">Назад</a></td>
            </tr>
            </tbody>
        </table>
    </form>
</main>
</body>
</html>

