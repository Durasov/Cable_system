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
    <title>CableSystem</title>
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
                            <a href="/cyclists" class="nav_link nav_link3"> Результаты </a>
                        </li>
                        <li class="nav_li">
                            <a href="/cyclists" class="nav_link nav_link4"> Графики </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </section>
    </div>
</header>

<table class="table" align="center">
    <thead>
    <th>Id параметров</th>
    <th>Масса 1 тела</th>
    <th>Масса 2 тела</th>
    <th>Площадь первого тела</th>
    <th>Площадь второго тела</th>
    <th>r1</th>
    <th>первого</th>
    <th>тела</th>
    <th></th>
    <th></th>
    </thead>
    <tbody>
    <c:forEach items="${inputParametres}" var="inputParametr">
    <tr>
        <td>${inputParametr.parametrsId}
        </td>
        <td>${inputParametr.massFirst}
        </td>
        <td>${inputParametr.massSecond}
        </td>
        <td>${inputParametr.s1}
        </td>
        <td>${inputParametr.s2}
        </td>
        <td>${inputParametr.x1}
        </td>
        <td>${inputParametr.y1}
        </td>
        <td>${inputParametr.z1}
        </td>
        <td><a href="/useParameters?parametrsId=${inputParametr.parametrsId}">Выбрать</a></td>
        <td><a href="/deleteResult?resultId=${result.resultId}">Delete</a></td>
    </tr>
    </tbody>
    </c:forEach>
    <c:set var="inputParametrList" value="${inputParametres}" scope="session"/>
    <thead>
    <th></th>
    <th>r2</th>
    <th>второго</th>
    <th>тела</th>
    <th>|</th>
    <th>Силы</th>
    <th>аэродинамич.</th>
    <th>сопротивления</th>
    <th></th>
    <th>|</th>
    </thead>
    <tbody>
    <c:forEach items="${inputParametres}" var="inputParametr">
    <tr>
        <td>${inputParametr.parametrsId}
        </td>
        <td>${inputParametr.x2}
        </td>
        <td>${inputParametr.y2}
        </td>
        <td>${inputParametr.z2}
        </td>
        <td>${inputParametr.RA11}
        </td>
        <td>${inputParametr.RA12}
        </td>
        <td>${inputParametr.RA13}
        </td>
        <td>${inputParametr.RA21}
        </td>
        <td>${inputParametr.RA22}
        </td>
        <td>${inputParametr.RA23}
        </td>
    </tr>
    </tbody>
    </c:forEach>
    <thead>
    <th></th>
    <th>|</th>
    <th></th>
    <th>Моменты</th>
    <th>инерции</th>
    <th></th>
    <th></th>
    <th>|</th>
    <th></th>
    <th></th>
    </thead>
    <tbody>
    <c:forEach items="${inputParametres}" var="inputParametr">
    <tr>
        <td>${inputParametr.parametrsId}
        </td>
        <td>${inputParametr.ix1}
        </td>
        <td>${inputParametr.iy1}
        </td>
        <td>${inputParametr.iz1}
        </td>
        <td>${inputParametr.ix2}
        </td>
        <td>${inputParametr.iy2}
        </td>
        <td>${inputParametr.iz2}
        </td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    </tbody>
    </c:forEach>

    <thead>
    <th>Id параметров</th>
    <th>Начальные </th>
    <th>значения </th>
    <th>компонент вектора </th>
    <th>обобщенных</th>
    <th>угловых</th>
    <th>скоростей</th>
    <th>Gamma1</th>
    <th>Alfa1</th>
    <th>Fi1</th>
    </thead>
    <tbody>
    <c:forEach items="${inputParameters2}" var="inputParameters2">
    <tr>
        <td>${inputParameters2.parametrsId}
        </td>
        <td>${inputParameters2.w1}
        </td>
        <td>${inputParameters2.w2}
        </td>
        <td>${inputParameters2.w3}
        </td>
        <td>${inputParameters2.w4}
        </td>
        <td>${inputParameters2.w5}
        </td>
        <td>${inputParameters2.w6}
        </td>
        <td>${inputParameters2.gamma1}
        </td>
        <td>${inputParameters2.alfa1}
        </td>
        <td>${inputParameters2.fi1}
        </td>
    </tr>
    </tbody>
    </c:forEach>
    <thead>
    <th>Gamma2</th>
    <th>Alfa2</th>
    <th>Fi2</th>
    <th>V</th>
    <th>Tetta </th>
    <th>H</th>
    <th>Cx0 1 тела</th>
    <th>Cy0 1 тела</th>
    <th>Cx0 2 тела</th>
    <th>Cy0 2 тела</th>
    </thead>
    <tbody>
    <c:forEach items="${inputParameters2}" var="inputParameters2">
    <tr>
        <td>${inputParameters2.gamma2}
        </td>
        <td>${inputParameters2.alfa2}
        </td>
        <td>${inputParameters2.fi2}
        </td>
        <td>${inputParameters2.v}
        </td>
        <td>${inputParameters2.tetta}
        </td>
        <td>${inputParameters2.h}
        </td>
        <td>${inputParameters2.cx01}
        </td>
        <td>${inputParameters2.cx02}
        </td>
        <td>${inputParameters2.cy01}
        </td>
        <td>${inputParameters2.cy02}
        </td>
    </tr>
    </tbody>
    </c:forEach>
</table>
<div class="description">
    <c:forEach items="${results}" var="result" begin="0" end="0">
        <a href="/addResult?resultId=${result.resultId}" class="add_button">Add result</a>
    </c:forEach>
</div>
</form>
</body>
</html>
