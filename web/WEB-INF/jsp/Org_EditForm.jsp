<%@ taglib prefix="form" uri="http://mycompany.com" %>
<%--
  Created by IntelliJ IDEA.
  User: whg
  Date: 19-9-7
  Time: 下午3:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fc" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>更新机构</title>
</head>
<body>

<c:if test="${msg !=null}" >
    <th colspan="2" style="color: red;max-width: 500px;">${msg}</th>
</c:if>
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
                <td>
<%--                    <input name="state" value=" ${org.state}"/> --%>
<%--                    <select name="state" >--%>
<%--                    <option value=" ${org.state}">生效</option>--%>
<%--                    <option value="1">未生效</option>--%>

<%--                    </select>--%>

                       <fc:select  id="orgstate" path="state"  name="state" >
<%--                           <fc:option value="-1" label="请选择"/>--%>
                           <fc:options items="${state.utilMap}"

                           />
                       </fc:select>


                </td>
                <td><input name="description" value=" ${org.description}" />  </td>
                <td><input type="submit" value="更新" > </td>
                <td><input type="button" onclick="backToList()" value="返回"></td>
            </tr>



    </table>
    </form>
</div>
<script>
    selectedobj = document.getElementById("orgstate");
    for(i=0;i<selectedobj.length;i++){
        // alert(selectedobj[i].key);
        // alert(selectedobj[i].value);
        if(selectedobj[i].value== "${org.state}")
            selectedobj[i].selected = true;
    }

    function backToList() {
        location.href='/OrgManage/orglist' ;
    }

</script>

</body>
</html>
