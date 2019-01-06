<%@ page import="java.text.DateFormat" %><%--
  Created by IntelliJ IDEA.
  User: whglo
  Date: 2019/1/6
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    public  String GetTodaysDate()
    {
        DateFormat dateFormat=DateFormat.getDateInstance(DateFormat.LONG);
        return  dateFormat.format(new java.util.Date()).toString();
    }
%>
<html>
<head>
    <title>Declarations</title>
</head>
<body>
Today is <%=GetTodaysDate() %>
</body>
</html>
