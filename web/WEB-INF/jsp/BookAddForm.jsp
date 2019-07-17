<%--
  Created by IntelliJ IDEA.
  User: whg
  Date: 19-7-12
  Time: 下午6:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title> Book List </title>
    <style type="text/css" >@import url("<c:url value="/css/main.css"/> ") ;</style>
</head>
<body>
<div id="global">
   <form:form modelAttribute="book" action="/book_save" method="post">
       <fieldset>
           <legend>Add a book</legend>
       </fieldset>
       <p>
           <label for="category"> Category: </label>

       </p>
       <form:select path="category.id" id="category" items="${categories}" itemLabel="name" itemValue="id" />
       <p>
           <label for="title">Title:</label>
           <form:input path="title" />
       </p>
       <p>
           <label for="author">Author:</label>
           <form:input path="author" />
       </p>
       <p>
           <label for="isbn">ISBN:</label>
           <form:input path="isbn" />
       </p>
       <p>
           <label for="price">Price:</label>
           <form:input path="price" />
       </p>
       <p id="buttons">
           <input id="reset" type="reset"  tabindex="4" />
           <input id="submit" type="submit"  tabindex="5" value="Add Book" />

       </p>

   </form:form>


</div>
</body>
</html>
