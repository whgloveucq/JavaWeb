<%--
  Created by IntelliJ IDEA.
  User: whglo
  Date: 2019/1/6
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>getProperty and setProperty</title>
</head>
<body>
<jsp:useBean id="employee" class="com.whg.session.Employee" />
<jsp:setProperty name="employee" property="firstName" value="Abigail"/>
<jsp:setProperty name="employee" property="lastName" value="Wu"/>
<jsp:getProperty name="employee" property="firstName" />
<jsp:getProperty name="employee" property="lastName" />
</body>
</html>
