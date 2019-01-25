<%--
  Created by IntelliJ IDEA.
  User: whg
  Date: 19-1-25
  Time: 下午12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>BigCities</title>
    <style>
        table,tr,td{border: 1px solid #aaee77;
        padding:1px
        }

    </style>
</head>
<body>
Capitals
<table>
    <tr style="background:#448755";color:white;front-weight:bold">
<td>Country</td>
<td>Capital</td>
    </tr>
<c:forEach items="${requestScope.capitals}" var="mapItem" >
    <tr>
        <td>${mapItem.key}</td>
        <td>${mapItem.value}</td>
    </tr>

</c:forEach>


</table>
<br/>
Big Cities
<table>
<tr style="background: #448755 ;color:white;font-weight:bold">

    <td>Country</td>
    <td>BigCities</td>
</tr>
    <c:forEach var="mapItem" items="${requestScope.bigCities}">
<tr>
<td>${mapItem.key}</td>
<td>
    <c:forEach items="${mapItem.value}" var="city" varStatus="status">
        ${city}<c:if test="${!status.last}">,</c:if>
    </c:forEach>

</td>

</tr>


    </c:forEach>


</table>
</body>
</html>
