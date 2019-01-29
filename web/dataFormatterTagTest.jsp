<%--
  Created by IntelliJ IDEA.
  User: whg
  Date: 19-1-29
  Time: 下午5:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/WEB-INF/dataFormatter.tld" prefix="selfD"%>

<html>
<head>
    <title>Testing DataFormatterTag</title>
</head>
<body>
<selfD:dataFormatter header="States" items="Alabama,Alaska,Georgia,Folorida" />
<br/>
<selfD:dataFormatter header="Countries" >
    <jsp:attribute name="items">US,UK,Canada,Korea</jsp:attribute>

</selfD:dataFormatter>
</body>
</html>
