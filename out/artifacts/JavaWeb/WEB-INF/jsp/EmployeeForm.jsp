<%--
  Created by IntelliJ IDEA.
  User: whg
  Date: 19-7-20
  Time: 下午2:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Employee Form</title>
    <style type="text/css">@import url("<c:url value="/css/main.css" />");</style>
</head>
<body>
<div id="global">

    <form:form modelAttribute="employee" action="employee_save" method="post">
        <fieldset>
            <legend>Add an employee</legend>

        <p>
            <label for="name"> Name:</label>
            <form:input path="name" tabindex="1" />
        </p>
        <p>
            <label for="birthDate">Date of Birth</label>
            <form:input path="birthDate" tabindex="2"/>

        </p>
        <p id="buttons" >
            <input id="reset" type="reset" tabindex="3">
            <input id="submit" type="submit" tabindex="4" value="Add Employee" >
        </p>
        </fieldset>
    </form:form>

</div>
</body>
</html>
