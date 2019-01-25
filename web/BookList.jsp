<%--
  Created by IntelliJ IDEA.
  User: whg
  Date: 19-1-15
  Time: 下午2:51
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Book List</title>
    <style>
table,tr,td {border: 1px solid brown ;}
    </style>
</head>
<body>
Books in Simple Table
<table>
    <tr>
        <td>ISBN</td>
        <td>Title</td>
    </tr>
    <c:forEach items="${requestScope.books}" var="book" varStatus="status">
        <tr>
            <td>${book.isbn}</td>
            <td>${book.title}</td>

        </tr>
    </c:forEach>
</table>
<br/>
Books in Styled Table
<table>
    <tr style="background:#ababff">
        <td>ISBN</td>
        <td>Title</td>
    </tr>
    <c:forEach items="${requestScope.books}" var="book" varStatus="status">
        <c:if test="${status.count%2 ==0}" >
            <tr style="background:#eeeeff">
        </c:if>
   <c:if test="${status.count%2!=0}" >
    <tr style="background:#dedeff">
            </c:if>
                <td>${book.isbn}</td>
                <td>${book.title}</td>
        </tr>
    </c:forEach>
</table>
<br/>
ISBNs only:
<c:forEach items="${requestScope.books}" var="book" varStatus="status">
${book.isbn}<c:if test="${!status.last}">,</c:if>
</c:forEach>

</body>
</html>
