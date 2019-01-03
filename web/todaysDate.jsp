<%--
  Created by IntelliJ IDEA.
  User: whg
  Date: 19-1-3
  Time: 下午5:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Today's date</title>
</head>
<body>
<%
DateFormat dateFormat=DateFormat.getDateInstance(DateFormat.SHORT);
String s=dateFormat.format(new Date());
out.println("Today is " +s) ;
///**/
%>
<%----%>
<%----%>

</body>
</html>
