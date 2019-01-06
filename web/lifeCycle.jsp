<%--
  Created by IntelliJ IDEA.
  User: whglo
  Date: 2019/1/6
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    public void jspInit(){
System.out.println("jspInit ...." ) ;
    }
    public void jspDestroy(){
        System.out.println("jspDestroy...");
    }
%>
<html>
<head>
    <title>jspInit and jspDestroy</title>
</head>
<body>
Overriding jspInit and jspDestroy

</body>
</html>
