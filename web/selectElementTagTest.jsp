<%--
  Created by IntelliJ IDEA.
  User: whg
  Date: 19-1-30
  Time: 下午4:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/WEB-INF/SelectElementTag.tld" prefix="selfD"%>
<html>
<head>
    <title>Testing SelectElementFormatterTag</title>
</head>
<body>
<selfD:select>
<option value="${value}">${text}</option>
</selfD:select>
</body>
</html>
