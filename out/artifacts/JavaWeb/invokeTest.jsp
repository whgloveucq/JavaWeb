<%--
  Created by IntelliJ IDEA.
  User: whg
  Date: 19-2-8
  Time: 上午11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="selfD" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Product Details</title>
</head>
<body>
<selfD:invokeDemo><jsp:attribute name="productDetails">
<table width="220" border="1">
    <tr>
<td><b>Product Name</b></td>
<td>${productName}</td>
    </tr>
<tr>
<td><b>Description</b></td>
<td>${description}</td>
</tr>
    <tr>
<td><b>Price</b></td>
<td>${price}</td>
    </tr>


</table>



</jsp:attribute></selfD:invokeDemo>


</body>
</html>
