<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Check Triangle</title>
    <style type="text/css">
        .sideLenght {
            width: 50px;
        }
    </style>
    <link href="<c:url value='css/output.css'/>" rel="stylesheet" type="text/css" />
</head>

<body>
<p align="right">${role}: ${userName}<br/>
<align="right"><a href="./logout">Log out</a></p>

<form id="form1" name="form1" method="post" action="checkTriangle">
    <p>Input the lenght of 3 sides
    </p>
    <p>The length should not more than 200</p>
    <p>
        <label for="a">Side 1 </label>
        <input name="a" type="text" class="sideLenght" id="a"  value="${a}" />
        Side 2
        <input name="b" type="text" class="sideLenght" id="b" value="${b}"/>
        Side 3
        <input name="c" type="text" class="sideLenght" id="c" value="${c}" />
        <input type="submit" name="check" id="check" value="Is Triangle?" />
    </p>
    <c:if test="${not empty inputError}">
        <p class="error">Stupid put the value in all boxes</p>
    </c:if>
</form>
<c:if test="${not empty triType}">
    <div class="output" id="output">
        <c:choose>
            <c:when test="${triType eq 'equilateral'}" >
                <p><img src="<c:url value='/pic/equilateral.jpg'/>" alt="equilateral" width="304" height="130" /></p>
            </c:when>
            <c:when test="${triType eq 'isoscelene'}" >
                <p><img src="<c:url value='/pic/isosceles.jpg'/>" alt="Isosceles" width="303" height="138" /></p>
            </c:when>
            <c:when test="${triType eq 'scalene'}" >
                <p><img src="<c:url value='/pic/scalene.jpg'/>" alt="Scalene" width="303" height="127" /></p>
            </c:when>
            <c:otherwise>
                <p><img src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTzQOWMA3iRR_JGY1Bgtqkn6L6_NMdcXgJwQpzcRLijPaXyRlBdPQ" alt="" name="mX3KtElp-MrjaM:" id="mX3KtElp-MrjaM:" data-src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTzQOWMA3iRR_JGY1Bgtqkn6L6_NMdcXgJwQpzcRLijPaXyRlBdPQ" data-sz="f" onload="google.stb.csi.onTbn(1, this)" /></p>
                <p class="error">This is not Triangle</p>
            </c:otherwise>
        </c:choose>
    </div>
</c:if>
<p>&nbsp;</p>
</body>
</html>