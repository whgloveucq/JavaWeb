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
    <script type="text/javascript" src="/jscript/ztree/js/jquery.ztree.excheck.js" ></script>
    <script type="text/javascript" src="/jscript/ztree/js/jquery.ztree.exedit.js" ></script>

    <script type="text/javascript">

        var zTreeObj;

        var setting = {

            check:{
                enable:true ,
                chkboxType: {"Y":"s", "N":"ps"}
            } ,
            data: {

                simpleData: {
                    enable: true
                }
            }



        };


        var zNodes=${zTrees} ;


        $(function(){

            zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);

        });

        function chooseSubmit() {

            var zTree = $.fn.zTree.getZTreeObj("treeDemo");
            //获取勾选框上的节点
            var nodes = zTree.getCheckedNodes(true);
            if (nodes.length == 0) {
                //alert("请先选择一个节点")
                alertMsg.error("请选择机构！");
                return false;
            }


            var resultStr = "" ;
            for (var i = 0,l = nodes.length; i < l; i++) {
                if (nodes[i].isVirtual == "true") {
                    resultStr += nodes[i].name + "," ;
                }
            }
            resultStr = resultStr.substring(0, resultStr.length - 1) ;
            alert(resultStr) ;
            if (resultStr == "") {
                alert("请选择一个节点！");
                return false ;
            }
        }



    </script>


    <title>Ztree测试</title>
</head>
<body>
<h1>同步加在</h1>
<div>
    <input type="hidden" name="right" id="right"  value="${sessionScope.user.right}">
    <ul id="treeDemo" class="ztree"></ul>

</div>




</body>
</html>
