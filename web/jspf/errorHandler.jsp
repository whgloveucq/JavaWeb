<%--
  Created by IntelliJ IDEA.
  User: whg
  Date: 19-1-7
  Time: 下午5:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.io.IOException" %>
<%@page import="javax.servlet.ServletException" %>
<html>
<head>
    <title>错误处理页面</title>
</head>
<body>
An error has occurred.<br/>
Error message:<% out.println(Exception.class.toString());%>
</body>
</html>
