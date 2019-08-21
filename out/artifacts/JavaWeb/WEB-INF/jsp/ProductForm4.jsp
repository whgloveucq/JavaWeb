<%--
  Created by IntelliJ IDEA.
  User: whg
  Date: 19-6-10
  Time: 下午3:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><spring:message code="page.productform.title" /></title>
    <style type="text/css">@import url(/css/main.css);</style>
</head>
<body>
<%--<c:if test="${requestScope.errors != null }">--%>
<%--    <p id="errors">--%>
<%--        Error(s)!--%>
<%--        <ul>--%>
<%--      <c:forEach var="error" items="${requestScope.errors}">--%>
<%--          <li> ${error} </li>--%>
<%--      </c:forEach>--%>

<%--        </ul>--%>
<%--    </p>--%>
<%--</c:if>--%>
${errors.bindingFailure}
<br/>
<div id="global">
    Current Locale:${pageContext.response.locale }
    <br/>
    accept-language header:${header["accept-language"]}
    <form  modelAttribute="product" action="/product_save" method="post" >
        <fieldset>
            <legend><spring:message code="form.name"/></legend>
            <p>
                <label for="name"><spring:message code="label.productName" text="default text"/> </label>
                <input type="text" id="name" name="name" tabindex="1">
            </p>
            <p>
                <label for="description">Description:</label>
                <input type="text" id="description" name="description" tabindex="2">
            </p>


            <p>
                <label for="price">Price:</label>
                <input type="text" id="price" name="price" tabindex="3"> ${errors.codes}  ${errors.field} ${errors.rejectedValue} ${errors.defaultMessage}
            </p>
            <p>
                <label for="productionDate">productionDate:</label>
                <input type="text" id="productionDate" name="productionDate" tabindex="4">
            </p>


            <p id="buttons">
                <input id="reset" type="reset" tabindex="5">
                <input id="submit" type="submit" tabindex="6" value="Add Product" >


            </p>
        </fieldset>


    </form>

</div>
</body>
</html>