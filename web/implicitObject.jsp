<%--
  Created by IntelliJ IDEA.
  User: whg
  Date: 19-1-4
  Time: 下午3:27
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Implicit Objects</title>
</head>
<body>
<b>Http headers:</b><br/>
<%
for (Enumeration<String> e=request.getHeaderNames();e.hasMoreElements();){

String header=e.nextElement();
out.println(header +":" +request.getHeader(header));
}
%>
<hr/>

<%
    response.setContentType("text/json");
out.println("Buffer size:" + response.getBufferSize()+"<br/>");
out.println("Session id:"  + session.getId()+"</br>");
out.println("Servlet name:" + config.getServletName()+ " --" +config.getServletContext()+ "--" +config.getInitParameterNames()+"<br/>");
out.println("appliation info :" + application.getServerInfo()+ " --" +application.getContextPath());
out.println("Server info:" +application.getServerInfo());

%>


</body>
</html>
