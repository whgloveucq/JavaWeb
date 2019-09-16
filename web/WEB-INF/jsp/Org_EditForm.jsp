<%--
  Created by IntelliJ IDEA.
  User: whg
  Date: 19-9-7
  Time: 下午3:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新机构</title>
</head>
<body>
<div>
    <form   modelAttribute="org"  action="/OrgManage/updateOrgF" method="post">
    <table>
        <tr>
            <th>机构ID</th>
            <th>机构类型</th>
            <th>机构名称</th>
            <th>上级机构ID</th>
            <th>机构状态</th>
            <th>描述</th>
            <th>     </th>

        </tr>

            <tr id="org-${org.orgid}">
                <td><input name="orgid" value=" ${org.orgid}"/></td>
                <td><input name="orgtype" value="${org.orgtype}"/></td>
                <td><input name="name" value=" ${org.name}"/></td>
                <td><input name="pid" value="${org.pid}"/> </td>
                <td><input name="state" value=" ${org.state}"/></td>
                <td><input name="description" value=" ${org.description}" />  </td>
                <td><input type="submit" value="更新" > </td>
            </tr>



    </table>
    </form>
</div>

</body>
</html>
