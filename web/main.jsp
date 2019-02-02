<%--
  Created by IntelliJ IDEA.
  User: whg
  Date: 19-2-2
  Time: 下午4:04
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>

Your referer header: ${header.referer}
<br/>${header.values()}
<br/>
<tags:doBodyDemo>
    ${header.referer}
</tags:doBodyDemo>
<a href="viewReferer.jsp">
    View
</a> the referer as a Session a attribute.

