
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: whg
  Date: 19-8-25
  Time: 下午6:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <c:set var="path" value="${pageContext.request.contextPath}" />
    <meta http-equiv="Content-Type" content="text/html" ;charset="UTF8">
    <title>机构维护</title>
</head>
<body>

<%--<c:if test="${errors} !=null">--%>
<%--    <label>deee</label>--%>
<%--    <c:forEach items="${errors}"  var="error">--%>
<%--        <li>${error.getDefaultMessage}</li>--%>
<%--    </c:forEach>--%>
<%--</c:if>--%>
<form:form modelAttribute="org"  name="org" action="/OrgManage/insertOrg" >
    <input type="hidden" name="id" value="${org.orgid}">


    <table>



        <c:if test="${msg !=null}" >
            <tr>
                <th colspan="2" style="color: red;max-width: 500px;">${msg}</th>
            </tr>
            <tr>
                <th colspan="2">机构维护</th>
            </tr>
            <tr>
                <th>机构ID</th>
                <td>
<%--                   <input type="text" name="orgid" value="${org.orgid}">--%>
<%--                    <form:input path="orgid" />--%>
                    <form:input path="orgid" />

                    </td>
                <td>
                    <form:errors path="orgid"></form:errors>

                </td>
            </tr>
            <tr>
                <th>机构类型</th>
                <td><input type="text" name="orgtype" value="${org.orgtype}">

                </td>
                <td>
                    <form:errors path="orgtype"></form:errors>
                </td>
            </tr>
            <tr>
                <th>机构名称</th>
                <td><input type="text" name="name" value="${org.name}">

                </td>
                <td>
                    <form:errors path="name"></form:errors>
                </td>
            </tr>
            <tr>
                <th>上级机构</th>
                <td><input type="text" name="pid" value="${org.pid}">

                </td>
                <td>
                    <form:errors path="pid"></form:errors>
                </td>
            </tr>
            <tr>
                <th>机构状态</th>
 <td>

<%--<input type="text" name="state" value="${org.state}">--%>

                <select name="state" >
                    <option value="0">未生效</option>
                    <option value="1">生效</option>
                </select>
                </td>
                <td>
                    <form:errors path="state"></form:errors>
                </td>


            </tr>
            <tr>
                <th>机构描述</th>
                <td><input type="text" name="description" value="${org.description}"></td>
                <td></td>
            </tr>
            <tr>
                <th colspan="2">
                    <input type="submit" value="保存">
                    <input type="button" onclick="backToList()" value="取消">
                </th>

            </tr>

        </c:if>


    </table>




</form:form>
<script>
    function backToList() {
        location.href='/OrgManage/orglist' ;
    }
</script>


</body>
</html>
