<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: whg
  Date: 19-8-14
  Time: 下午5:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <style type="text/css">@import url("<c:url value="/css/mian.css" />") ;</style>
</head>
<body>
<div id="global">
    <form:form modelAttribute="login" action="login" method="post">
    <fieldset>
        <legend>Login</legend>
        <p>
            <label for="userName"> User Name:</label>
            <form:input id="userName" path="userName" cssErrorClass="error" />
        </p>
        <p>
            <label for="password"> Password:</label>
            <form:password id="password" path="passWord" cssErrorClass="error" />
        </p>
        <p id="buttons">
            <input id="reset" type="reset" tabindex="4">
            <input id="submit" type="submit" tabindex="5" value="Login">
        </p>

    </fieldset>

    </form:form>



</div>





</body>
</html>

