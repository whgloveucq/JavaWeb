<%--
  Created by IntelliJ IDEA.
  User: whg
  Date: 19-8-2
  Time: 下午5:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Save Product</title>
    <style type="text/css">@import url("<c:url value="/css/main.css" /> ");</style>
</head>
<body>
<div id="global">
    <h4>The product has been saved </h4>
    <p>
        <h5>Details:</h5>
        Product Name:${product.name} <br/>
        Description:${product.description}<br/>
        Price:$${product.price}
    <p>Following files are uploaded successfully.</p>
    <ol>
        <c:forEach items="${product.images}" var="image">
            <li>${image.originalFilename} <br/>

            <img width="100" src= '<c:url value= '/images/' />${image.originalFilename}' />

        </c:forEach>
    </ol>

    </p>


</div>
</body>
</html>
