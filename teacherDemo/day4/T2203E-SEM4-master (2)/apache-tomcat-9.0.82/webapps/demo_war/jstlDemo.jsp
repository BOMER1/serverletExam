<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/19/2023
  Time: 7:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSTL</title>
</head>
<body>

<c:set var="name" value="T2203E"/>
<h1>Name :<c:out value="${name}" default="Hello T2203E" /></h1>
<c:remove var="name" />
<h1>Name after remove :<c:out value="${name}" default="Hello T2203E" /></h1>

<c:if test="${ 4 > 3}" >
    <h1> 4 gt 3 is true</h1>
</c:if>

<c:if test="${ 4 < 3}" >
    <h1> 4 gt 3 is true</h1>
</c:if>

<c:choose>
    <c:when test="${ 4 > 3}">
        <h1> 4 gt 3 is true</h1>
    </c:when>
    <c:otherwise>
        <h1>hello</h1>
    </c:otherwise>
</c:choose>


<c:forEach var="i" begin="0" end="10" step="2" >
    <h1>${i}</h1>
</c:forEach>

<c:forTokens items="A2,A3,A4,A6" delims="," var="name">
    <h1>${name}</h1>
</c:forTokens>


</body>
</html>
