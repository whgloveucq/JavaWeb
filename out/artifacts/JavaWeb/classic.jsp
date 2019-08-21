<%--
  Created by IntelliJ IDEA.
  User: whg
  Date: 19-1-7
  Time: 下午5:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>综合测试页面</title>
</head>
<body>
<jsp:forward page="jspf/login.jsp">
    <jsp:param name="text" value="please login"/>

</jsp:forward>
</body>
</html>
