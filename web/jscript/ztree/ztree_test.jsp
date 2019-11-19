<%--
  Created by IntelliJ IDEA.
  User: whg
  Date: 19-10-2
  Time: 下午12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<html>
<head>
    <link rel="stylesheet" href="/jscript/ztree/css/demo.css" type="text/css">
    <link rel="stylesheet" href="/jscript/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <script type="text/javascript" src="/jscript/ztree/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="/jscript/ztree/js/jquery.ztree.core.js" ></script>

    <script type="text/javascript">

        var zTreeObj;

        var setting = {};

        var zNodes = [

            {name:"test1",children:[

                    {name:"test1_1"}, {name:"test1_2"}]},

            {name:"test2",children:[

                    {name:"test2_1"}, {name:"test2_2"}]}

        ];

        $(function(){

            zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);

        });

    </script>
    <title>Ztree测试</title>
</head>
<body>
<div>

    <ul id="treeDemo" class="ztree"></ul>

</div>




</body>
</html>
