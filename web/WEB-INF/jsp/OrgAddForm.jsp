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
    <c:set var="path" value="${pageContext.request.contextPath}" />
    <meta http-equiv="Content-Type" content="text/html" ;charset="UTF8">
    <title>添加机构</title>
    <script type="text/javascript" src="/jscript/jquery-3.4.1.min.js"></script>
</head>
<body>
<%--${path}  <br/>--%>
<%--${pageContext.request.contextPath}  1 <br/>--%>
<%--<%=request.getContextPath()%> 2 <br/>--%>
<div>

    <form modelAttribue="org" action="/OrgManage/orgListSelective" method="post">
        <tr>
            <th>机构ID</th>
            <td><input type="text" name="orgid"  ></td>
        </tr>
        <tr>
            <th>机构类型</th>
            <td><input type="text" name="orgtype" ></td>
        </tr>
        <tr>
            <th>机构名称</th>
            <td><input type="text" name="name" ></td>
        </tr>
        <tr>
            <th>上级机构</th>
            <td><input type="text" name="pid" ></td>
        </tr>
        <tr>
            <th>机构状态</th>
            <td><input type="text" name="state" ></td>
        </tr>
        <tr>
            <th colspan="2">
                <input type="submit" value="提交">
                <input type="reset"  value="重置">
            </th>

        </tr>
    </form>

</div>

<div>
<table>
    <tr>
        <th>机构ID</th>
        <th>机构类型</th>
        <th>机构名称</th>
        <th>上级机构ID</th>
        <th>机构状态</th>
        <th>描述</th>
        <th colspan="2">操作【 <a href="/OrgManage/insertOrg" >新增</a>】</th>
    </tr>
    <c:forEach items="${org}" var="org">
        <tr id="org-${org.orgid}">
            <td>${org.orgid}</td>
            <td>${org.orgtype}</td>
            <td>${org.name}</td>
            <td>${org.pid}</td>
            <td>${org.state}</td>
            <td>${org.description}</td>
            <td>[<a href="/OrgManage/updateOrg?orgid=${org.orgid}">编辑</a> ]</td>
            <td><a href="javascript:;" onclick="deleteById(${org.orgid},'${org.name}')"> 删除</a></td>
        </tr>
    </c:forEach>

    <tr>
        [<a href="/OrgManage/orglist?currentPage=1">首页</a>]&nbsp
        [<a href="/OrgManage/orglist?currentPage=${page.prePage}">上一页</a>]&nbsp
        [<a href="/OrgManage/orglist?currentPage=${page.nextPage}">下一页</a>]&nbsp
        [<a href="/OrgManage/orglist?currentPage=${page.navigateLastPage}">末页</a>]&nbsp
        [转到页]
        [第 ${page.pageNum}页 &nbsp:[共${page.pages} 页] ]
    </tr>
</table>
</div>

<script>
    function deleteById(id,label) {

        var r= confirm('确定要删除"'+label+'"吗?');
        if(r){
            $.ajax(
                {url:"/OrgManage/deleteOrg" ,
                    data:{
                    'id':id
                    },
                    dataType: "JSON",
                    type:"POST",
                    success:function (data) {
                    if(data.success){
                        $('#org-' + id).remove();
                        // alert('删除成功' + label);
                        alert(data.msg);
                    }
                    else
                    {
                        alert(data.msg);
                    }

                    }


                }


            )
        }


    }




</script>




</body>
</html>
