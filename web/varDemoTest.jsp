<%--
  Created by IntelliJ IDEA.
  User: whg
  Date: 19-2-2
  Time: 上午11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>

Today's date
<br/>
<tags:varDemo>
    In long format:${longDate}
    <br/>
    In short format :${shortDate}


</tags:varDemo>