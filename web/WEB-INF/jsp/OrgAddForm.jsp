<%--
  Created by IntelliJ IDEA.
  User: whg
  Date: 19-8-21
  Time: 下午6:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <c:set var="path" value="${pageContext.request.contextPath}}" />
    <meta http-equiv="Content-Type" content="text/html" ;charset="UTF8">
    <title>添加机构</title>
    <script type="text/javascript" src="${path}/jscript/jquery-3.4.1.min.js"></script>
</head>
<body>
<table>
    <tr>
        <th>机构ID</th>
        <th>机构类型</th>
        <th>机构名称</th>
        <th>上级机构ID</th>
        <th>机构状态</th>
        <th>描述</th>
        <th>操作【 <a href="${path}/OrgManage/insertOrg" >新增</a>】</th>
    </tr>
    <c:forEach items="${org}" var="org">
        <tr id="org-${org.orgid}">
            <td>${org.orgid}</td>
            <td>${org.orgtype}</td>
            <td>${org.name}</td>
            <td>${org.pid}</td>
            <td>${org.state}</td>
            <td>${org.description}</td>
            <td>[<a href="${path}/OrgManage/update?orgid=${org.orgid}">编辑</a> ]

            </td>

        </tr>
    </c:forEach>


</table>
</body>
</html>
