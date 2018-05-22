<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 22.05.2018
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Graphics</title>
    <script type="text/javascript" src="resources/script/Chart.js"></script>
</head>
<body>
    <main>
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
