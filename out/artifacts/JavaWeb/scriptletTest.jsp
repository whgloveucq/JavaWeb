<%--
  Created by IntelliJ IDEA.
  User: whglo
  Date: 2019/1/6
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Scriptlet example</title>
</head>
<body>
<b>Httpp headers:</b><br/>
<%--first scriptlet--%>
<%
for(Enumeration<String> e=request.getHeaderNames();e.hasMoreElements();){

String header=e.nextElement();
out.println(header+":"+request.getHeader(header)+"<br/>");
}
String message="Thank you ";
%>
<%--表达式--%>
Today is <%=java.util.Calendar.getInstance().getTime()%>
<hr/>
<%--second scriptlet --%>
<%
    out.println(message);
    out.println("<br/> 今天是 "+java.util.Calendar.getInstance().getTime());
%>
<%--声明--%>

</body>
</html>
