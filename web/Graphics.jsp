<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 29.05.2018
  Time: 17:23
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
<main>
    <form action="saveParameters" method="post" class="">
    <div><canvas id="line-chart" style="height:400px;width: content-box;"></canvas></div>
    <script>
        var a = <%=request.getAttribute("y")%>;
        var b = <%=request.getAttribute("x")%>;
        var ctx = document.getElementById("line-chart").getContext('2d');
        new Chart (ctx, {
            type: 'line',
            data: {
                labels: b,
                datasets: [{
                    data: a,
                    label: "Угол атаки",
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
                    text: ''
                }
            }
        });
    </script>
        <div><canvas id="line-chart2" style="height:400px;width: content-box;"></canvas></div>
        <script>
            var a = <%=request.getAttribute("N")%>;
            var b = <%=request.getAttribute("x1")%>;
            var ctx = document.getElementById("line-chart2").getContext('2d');
            new Chart (ctx, {
                type: 'line',
                data: {
                    labels: b,
                    datasets: [{
                        data: a,
                        label: "Сила натяжения троса",
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
                        text: ''
                    }
                }
            });
        </script>
        <input id="submitButton" type="submit" value="Сохранить" class="savebutton"/>
    </form>
</main>
</body>
</html>
