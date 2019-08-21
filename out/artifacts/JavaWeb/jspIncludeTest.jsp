<%--
  Created by IntelliJ IDEA.
  User: whglo
  Date: 2019/1/6
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Include action</title>
</head>
<body>
<jsp:include page="jspf/menu.jsp">
    <jsp:param name="text" value="How are you ?" />
</jsp:include>
</body>
</html>
