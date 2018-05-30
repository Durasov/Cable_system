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
                            <a href="/Graphics.jsp" class="nav_link nav_link4"> Графики </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </section>
    </div>
</header>
<form action="editInputParameters" method="post" class="form1">
<table class="table" align="center">
    <thead>
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
    <tr>
        <td><input name="massFirst" required type="number" value="${parametersToEdit.massFirst}" class="editParam"></td>
        <td><input name="massSecond" required type="number" value="${parametersToEdit.massSecond}" class="editParam"></td>
        <td><input name="S1" required type="number" value="${parametersToEdit.s1}" class="editParam"></td>
        <td><input name="S2" required type="number" value="${parametersToEdit.s2}" class="editParam"></td>
        <td><input name="v" required type="number" value="${parametersToEdit.v}" class="editParam"></td>
        <td><input name="tetta" required type="number" value="${parametersToEdit.tetta}" class="editParam"></td>
        <td><input name="h" required type="number" value="${parametersToEdit.h}" class="editParam"></td>
        <td></td>
        <td></td>
    </tr>
    </tbody>
    <thead>
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
    <tr>
        <td><input name="x1" required type="number" value="${parametersToEdit.x1}" class="editParam"></td>
        <td><input name="y1" required type="number" value="${parametersToEdit.y1}" class="editParam"></td>
        <td><input name="z1" required type="number" value="${parametersToEdit.z1}" class="editParam"></td>
        <td><input name="x2" required type="number" value="${parametersToEdit.x2}" class="editParam"></td>
        <td><input name="y2" required type="number" value="${parametersToEdit.y2}" class="editParam"></td>
        <td><input name="z2" required type="number" value="${parametersToEdit.z2}" class="editParam"></td>
        <td><input name="x3" required type="number" value="${parametersToEdit.x3}" class="editParam"></td>
        <td><input name="y3" required type="number" value="${parametersToEdit.y3}" class="editParam"></td>
        <td><input name="z3" required type="number" value="${parametersToEdit.z3}" class="editParam"></td>
    </tr>
    </tbody>
    <thead>
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
    <tr>
        <td><input name="gamma1" required type="number" value="${parametersToEdit.gamma1}" class="editParam"></td>
        <td><input name="alfa1" required type="number" value="${parametersToEdit.alfa1}" class="editParam"></td>
        <td><input name="fi1" required type="number" value="${parametersToEdit.fi1}" class="editParam"></td>
        <td><input name="gamma2" required type="number" value="${parametersToEdit.gamma2}" class="editParam"></td>
        <td><input name="alfa2" required type="number" value="${parametersToEdit.alfa2}" class="editParam"></td>
        <td><input name="fi2" required type="number" value="${parametersToEdit.fi2}" class="editParam"></td>
        <td><input name="gamma3" required type="number" value="${parametersToEdit.gamma3}" class="editParam"></td>
        <td><input name="alfa3" required type="number" value="${parametersToEdit.alfa3}" class="editParam"></td>
        <td><input name="fi3" required type="number" value="${parametersToEdit.fi3}" class="editParam"></td>
    </tr>
    </tbody>
    <thead>
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
    <tr>
        <td><input name="w11" required type="number" value="${parametersToEdit.w11}" class="editParam"></td>
        <td><input name="w12" required type="number" value="${parametersToEdit.w12}" class="editParam"></td>
        <td><input name="w13" required type="number" value="${parametersToEdit.w13}" class="editParam"></td>
        <td><input name="w21" required type="number" value="${parametersToEdit.w21}" class="editParam"></td>
        <td><input name="w22" required type="number" value="${parametersToEdit.w22}" class="editParam"></td>
        <td><input name="w23" required type="number" value="${parametersToEdit.w23}" class="editParam"></td>
        <td><input name="w31" required type="number" value="${parametersToEdit.w31}" class="editParam"></td>
        <td><input name="w32" required type="number" value="${parametersToEdit.w32}" class="editParam"></td>
        <td><input name="w33" required type="number" value="${parametersToEdit.w33}" class="editParam"></td>
    </tr>
    </tbody>
    <thead>
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
    <tr>
        <td><input name="ix1" required type="number" value="${parametersToEdit.ix1}" class="editParam"></td>
        <td><input name="iy1" required type="number" value="${parametersToEdit.iy1}" class="editParam"></td>
        <td><input name="iz1" required type="number" value="${parametersToEdit.iz1}" class="editParam"></td>
        <td><input name="ix2" required type="number" value="${parametersToEdit.iy2}" class="editParam"></td>
        <td><input name="iy2" required type="number" value="${parametersToEdit.iy2}" class="editParam"></td>
        <td><input name="iz2" required type="number" value="${parametersToEdit.iz2}" class="editParam"></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    </tbody>
    <thead>
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
    <tr>
        <td><input name="cx1" required type="number" value="${parametersToEdit.cx1}" class="editParam"></td>
        <td><input name="cy1" required type="number" value="${parametersToEdit.cy1}" class="editParam"></td>
        <td><input name="cx2" required type="number" value="${parametersToEdit.cx2}" class="editParam"></td>
        <td><input name="cy2" required type="number" value="${parametersToEdit.cy2}" class="editParam"></td>
        <td><input name="my1" required type="number" value="${parametersToEdit.my1}" class="editParam"></td>
        <td><input name="mz1" required type="number" value="${parametersToEdit.mz1}" class="editParam"></td>
        <td><input name="my2" required type="number" value="${parametersToEdit.my2}" class="editParam"></td>
        <td><input name="mz2" required type="number" value="${parametersToEdit.mz2}" class="editParam"></td>
        <td></td>
    </tr>
    </tbody>
    <tbody>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td><input id="submitButton" type="submit" value="Изменить" class="button"/></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    </tbody>
</table>
</form>
<div class="description">
    <c:forEach items="${results}" var="result" begin="0" end="0">
        <a href="/addResult?resultId=${result.resultId}" class="add_button">Add result</a>
    </c:forEach>
</div>
</body>
</html>

