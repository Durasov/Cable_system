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
        </section>
    </div>
</header>

<main class="main">
    <form action="index" method="post" class="form">
        <p>Количество интервалов</p>
        <input name="n" type="number" required value="15" class="textbox"> </br>
        <p>Начальное время</p>
        <input name="t0" type="number" required value="0" class="textbox"> </br>
        <p>Размер шага</p>
        <input name="step" type="number" required value="0,05" step="0.01" class="textbox"> </br>
        <p>Максимальный размер шага</p>
        <input name="stepmax" type="number" required value="0,05" step="0.01" class="textbox"> </br>
        <p>n1</p>
        <input name="n1" type="number" required value="1" class="textbox"> </br>
        <p>nmax</p>
        <input name="nmax" type="number" required value="100" class="textbox"> </br>
        <p>Интервал, от</p>
        <input name="a" type="number" required value="1" class="textbox"> </br>
        <p>до</p>
        <input name="b" type="number" required value="20" class="textbox"> </br>
        <input type="submit" value="Расчитать" class="button">
    </form>
    <div><canvas id="line-chart" style="height:400px;width: content-box;"></canvas></div>
    <script>
        var a = <%=request.getAttribute("x")%>;
        var b = <%=request.getAttribute("y")%>;
        var ctx = document.getElementById("line-chart").getContext('2d');
        new Chart (ctx, {
            type: 'line',
            data: {
                labels: b,
                datasets: [{
                    data: a,
                    label: "Рунге кутты",
                    borderColor: "red",
                    fill: false
                }
                ]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                title: {
                    display: true,
                    text: 'Диплом'
                }
            }
        });
    </script>
</main>
</body>
</html>
