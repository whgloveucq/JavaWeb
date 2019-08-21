<%--
  Created by IntelliJ IDEA.
  User: whg
  Date: 19-7-12
  Time: 下午6:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title> Edit Book Form</title>
    <style type="text/css">@import url("<c:url value="/css/main.css" />");</style>
</head>
<body>
<div id="global" >
    <form:form modelAttribute="book"  action="/book_update"  method="post" >
<%--        commandNameu is old version and unuseful--%>

        <fieldset>
            <legend> Edit a book </legend>
        </fieldset>
        <form:hidden path="id" />
        <p>
            <label for="category">Category:</label>
            <form:select id="category" path="category.id" items="${categories}" itemLabel="name" itemValue="id" />
        </p>
        <p>
           <label for="title">Title:</label>
            <form:input id="title" path="title" />
        </p>
        <p>
           <label for="author">Author:</label>
            <form:input id="author" path="author" />
        </p>
        <p>
           <label for="isbn">Isbn:</label>
            <form:input id="isbn" path="isbn" />
        </p>
        <p>
           <label for="price">Price:</label>
            <form:input id="price" path="price" />
        </p>
        <p id="buttons">
            <input id="reset" type="reset" tabindex="4">
            <input id="submit" type="submit" tabindex="5">
        </p>
    </form:form>
</div>

</body>
</html>
