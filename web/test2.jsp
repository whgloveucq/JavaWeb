<%--
  Created by IntelliJ IDEA.
  User: whg
  Date: 19-3-8
  Time: 下午4:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>Form Values</title>
</head>
<body>
<table>
    <tr>
        <td>Name:</td>
        <td>${param.name}(length:${fn:length(param.name)})</td>
    </tr>
    <tr>
        <td>Address:</td>
        <td>${param.address}(length:${fn:length(param.address)})</td>

    </tr>


</table>

</body>
</html>
