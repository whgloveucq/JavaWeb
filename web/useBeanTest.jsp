<%--
  Created by IntelliJ IDEA.
  User: whglo
  Date: 2019/1/6
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--useBean将创建一个关联Java对象的脚本变量。这是早期分离的表示层和业务逻辑的手段
    。随着其他技术的发展，如自定义标签和表达语言，现在很少使用useBean方式。
    --%>
    <title>use Bean</title>
</head>
<body>
<jsp:useBean id="today" class="java.util.Date"/>
应用jsp 的useBean 标签，今天是 <%=today.toString()
%>
</body>
</html>
