<%--
  Created by IntelliJ IDEA.
  User: whg
  Date: 19-8-1
  Time: 下午6:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title> Add Product Form </title>
    <style type="text/css">@import url("<c:url value="/css/main.css"/> ");</style>
</head>
<body>
<div id="global">

    <form:form  modelAttribute="product" action="product_save2" method="post" enctype="multipart/form-data">
        <fieldset>
            <legend>Add a product</legend>

        <p>
            <label for="name">ProductName:</label>
            <form:input id="name" path="name" cssErrorClass="error" />
            <form:errors path="name"  cssClass="error" />
        </p>
        <p>
            <label for="description"> Description: </label>
            <form:input id="description" path="description" />
        </p>
        <p>
            <label for="price">Price:</label>
            <form:input id="price" path="price" cssErrorClass="error" />
        </p>
        <p>

            <label for="image">Product Image:</label>
            <input type="file" name="images[0]">
        </p>
        <p id="buttons">
            <input id="reset" type="reset" tabindex="4">
            <input id="submit" type="submit" tabindex="5" value="Add Product">
        </p>
        </fieldset>
    </form:form>


</div>


</body>
</html>
