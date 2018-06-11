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

<table class="table" align="center">
    <tr>
        <td rowspan="1" class="first">Mass1,Mass2</td>
        <td> - массы первого и второго тела</td>
        <td rowspan="1" class="second">x1,y1,z1,x2,y2,z2,x3,y3,z3</td>
        <td> - где x3 длина троса</td>
    </tr>
    <tr>
        <td rowspan="1" class="first">S1,S3</td>
        <td> - площади первого и второго тела</td>
        <td rowspan="1" class="second">gamma1,gamma2,gamm3</td>
        <td> - угол крена плоскости угла атаки</td>
    </tr>
    <tr>
        <td rowspan="1" class="first">V</td>
        <td> - скорость центра масс связки двух тел</td>
        <td rowspan="1" class="second">alfa1,alfa2,alfa3</td>
        <td> - пространственный угол атаки</td>
    </tr>
    <tr>
        <td rowspan="1" class="first">Tetta</td>
        <td> - угол наклона траектории</td>
        <td rowspan="1" class="second">fi1,fi2,fi3</td>
        <td> - аэродинамический угол крена</td>
    </tr>
    <tr>
        <td rowspan="1" class="first">H</td>
        <td> - высота над уровнем моря</td>
        <td rowspan="1" class="second">w11-w33</td>
        <td> - вектор компонент угловых скоростей</td>
    </tr>
    <tr>
        <td rowspan="1" class="first">Ix1,Iy1,Iz1,Ix2,Iy2,Iz2</td>
        <td> - моменты инерции</td>
        <td rowspan="1" class="second">Cx1,Cy1,Cx2,Cy2</td>
        <td> - аэродинамические коэффициенты</td>
    </tr>
    <tr>
        <td rowspan="1" class="first">my1,mz1,my2,mz2</td>
        <td> - </td>
        <td rowspan="1" class="second"></td>
        <td></td>
    </tr>
</table>

<table class="table" align="center">
    <thead>
    <th>Id</th>
    <th>Mass1</th>
    <th>Mass2</th>
    <th>S1</th>
    <th>S2</th>
    <th>V</th>
    <th>tetta</th>
    <th>H</th>
    <th></th>
    <th></th>
    </thead>
    <tbody>
    <c:forEach items="${inputParametres}" var="inputParametr">
    <tr>
        <td>${inputParametr.parametrsId}</td>
        <td>${inputParametr.massFirst}</td>
        <td>${inputParametr.massSecond}</td>
        <td>${inputParametr.s1}</td>
        <td>${inputParametr.s2}</td>
        <td>${inputParametr.v}</td>
        <td>${inputParametr.tetta}</td>
        <td>${inputParametr.h}</td>
        <td></td>
        <td></td>
    </tr>
    </tbody>
    </c:forEach>
    <c:set var="inputParametrList" value="${inputParametres}" scope="session"/>
    <thead>
    <th></th>
    <th>x1</th>
    <th>y1</th>
    <th>z1</th>
    <th>x2</th>
    <th>y2</th>
    <th>z2</th>
    <th>x3</th>
    <th>y3</th>
    <th>z3</th>
    </thead>
    <tbody>
    <c:forEach items="${inputParametres}" var="inputParametr">
    <tr>
        <td>${inputParametr.parametrsId}</td>
        <td>${inputParametr.x1}</td>
        <td>${inputParametr.y1}</td>
        <td>${inputParametr.z1}</td>
        <td>${inputParametr.x2}</td>
        <td>${inputParametr.y2}</td>
        <td>${inputParametr.z2}</td>
        <td>${inputParametr.x3}</td>
        <td>${inputParametr.y3}</td>
        <td>${inputParametr.z3}</td>
    </tr>
    </tbody>
    </c:forEach>
    <thead>
    <th></th>
    <th>gamma1</th>
    <th>alfa1</th>
    <th>fi1</th>
    <th>gamma2</th>
    <th>alfa2</th>
    <th>fi2</th>
    <th>gamma3</th>
    <th>alfa3</th>
    <th>fi3</th>
    </thead>
    <tbody>
    <c:forEach items="${inputParametres}" var="inputParametr">
    <tr>
        <td>${inputParametr.parametrsId}</td>
        <td>${inputParametr.gamma1}</td>
        <td>${inputParametr.alfa1}</td>
        <td>${inputParametr.fi1}</td>
        <td>${inputParametr.gamma2}</td>
        <td>${inputParametr.alfa2}</td>
        <td>${inputParametr.fi2}</td>
        <td>${inputParametr.gamma3}</td>
        <td>${inputParametr.alfa3}</td>
        <td>${inputParametr.fi3}</td>
    </tr>
    </tbody>
    </c:forEach>
    <thead>
    <th></th>
    <th>w11</th>
    <th>w12</th>
    <th>w13</th>
    <th>w21</th>
    <th>w22</th>
    <th>w23</th>
    <th>w31</th>
    <th>w32</th>
    <th>w33</th>
    </thead>
    <tbody>
    <c:forEach items="${inputParametres}" var="inputParametr">
    <tr>
        <td>${inputParametr.parametrsId}</td>
        <td>${inputParametr.w11}</td>
        <td>${inputParametr.w12}</td>
        <td>${inputParametr.w13}</td>
        <td>${inputParametr.w21}</td>
        <td>${inputParametr.w22}</td>
        <td>${inputParametr.w23}</td>
        <td>${inputParametr.w31}</td>
        <td>${inputParametr.w32}</td>
        <td>${inputParametr.w33}</td>
    </tr>
    </tbody>
    </c:forEach>
    <thead>
    <th></th>
    <th>Ix1</th>
    <th>Iy1</th>
    <th>Iz1</th>
    <th>Ix2</th>
    <th>Iy2</th>
    <th>Iz2</th>
    <th></th>
    <th></th>
    <th></th>
    </thead>
    <tbody>
    <c:forEach items="${inputParametres}" var="inputParametr">
    <tr>
        <td>${inputParametr.parametrsId}</td>
        <td>${inputParametr.ix1}</td>
        <td>${inputParametr.iy1}</td>
        <td>${inputParametr.iz1}</td>
        <td>${inputParametr.ix2}</td>
        <td>${inputParametr.iy2}</td>
        <td>${inputParametr.iz2}</td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    </tbody>
    </c:forEach>
    <thead>
    <th></th>
    <th>Cx1</th>
    <th>Cy1</th>
    <th>Cx2</th>
    <th>Cy2</th>
    <th>My1</th>
    <th>Mz1</th>
    <th>My2</th>
    <th>Mz2</th>
    <th></th>
    </thead>
    <tbody>
    <c:forEach items="${inputParametres}" var="inputParametr">
    <tr>
        <td>${inputParametr.parametrsId}</td>
        <td>${inputParametr.cx1}</td>
        <td>${inputParametr.cy1}</td>
        <td>${inputParametr.cx2}</td>
        <td>${inputParametr.cy2}</td>
        <td>${inputParametr.my1}</td>
        <td>${inputParametr.mz1}</td>
        <td>${inputParametr.my2}</td>
        <td>${inputParametr.mz2}</td>
        <td></td>
    </tr>
    </tbody>
    </c:forEach>
    <tbody>
    <c:forEach items="${inputParametres}" var="inputParametr">
    <tr>
        <td>${inputParametr.parametrsId}</td>
        <td></td>
        <td><a href="/useParameters?parametrsId=${inputParametr.parametrsId}" class="add_button">Выбрать</a></td>
        <td></td>
        <td><a href="/addInputParameters" class="add_button">Добавить</a></td>
        <td></td>
        <td><a href="/editInputParameters?parametrsId=${inputParametr.parametrsId}" class="add_button">Изменить</a></td>
        <td></td>
        <td><a href="/deleteInputParameters?parametrsId=${inputParametr.parametrsId}" class="add_button">Удалить</a></td>
        <td></td>
    </tr>
    </tbody>
    </c:forEach>
</table>
</body>
</html>
