<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<%
    session.setAttribute("session", "session implicit object");
    application.setAttribute("application", "application implicit object");
    pageContext.setAttribute("pageScope", "page scope value", PageContext.PAGE_SCOPE);
    pageContext.setAttribute("requestScope", "request scope value", PageContext.REQUEST_SCOPE);
    pageContext.setAttribute("sessionScope", "session scope value", PageContext.SESSION_SCOPE);
    pageContext.setAttribute("applicationScope", "application scope value", PageContext.APPLICATION_SCOPE);
//    RequestDispatcher dispatcher = request.getRequestDispatcher("/demoJsp.jsp");
//    dispatcher.forward(request,response);

%>
<form action="demoJsp.jsp">
    <input type="text" name="name" />
    <input type="text" name="phone" />
    <input type="text" name="address" />
    <input type="submit" value="Submit" />
</form>
<a href="hello-servlet?name=T2203E">Hello Servlet</a>
</body>
<%--<jsp:include page="footer.jsp" >--%>
<%--    <jsp:param name="name" value="T2203E"/>--%>
<%--</jsp:include>--%>
<jsp:useBean id="customer" class="com.example.demo.entity.CustomerEntity" scope="request" />
<jsp:setProperty name="customer" property="id" value="1" />
<jsp:setProperty name="customer" property="name" value="T2203E" />
<jsp:setProperty name="customer" property="age" value="22" />
<jsp:setProperty name="customer" property="address" value="B6 Aptech" />

<%--<jsp:forward page="demoJsp.jsp"></jsp:forward>--%>
</html>