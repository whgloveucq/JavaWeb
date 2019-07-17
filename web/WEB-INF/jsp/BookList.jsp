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
    <h1>Book List</h1>
    <a href="<c:url value="/book_input"/> ">Add Book</a>
    <table>
        <tr>
            <th>Category</th>
            <th>Title</th>
            <th>ISBN</th>
            <th>Author</th>
            <th>Price</th>
            <th>&nbsp;</th>
    </tr>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.category.name}</td>
                <td>${book.title}</td>
                <td>${book.isbn}</td>
                <td>${book.author}</td>
                <td>${book.price}</td>
                <td><a href="/book_edit/${book.id}">Edit</a></td>
                <td></td>
            </tr>


        </c:forEach>

    </table>
</div>

</body>
</html>
