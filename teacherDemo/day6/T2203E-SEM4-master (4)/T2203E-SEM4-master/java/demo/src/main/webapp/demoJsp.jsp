<%@ page import="java.io.Writer" %>
<%@ page import="com.example.demo.entity.CustomerEntity" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/12/2023
  Time: 8:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="errorPage.jsp" %>
<html>
<head>
    <title>Demo</title>
</head>
<body>
<h1>Demo jsp page</h1>
<h1>Expression</h1>
<%
    int c = 300;
    int d = c + 10;
    String name = request.getParameter("name");
    String phone = request.getParameter("phone");
    String address = request.getParameter("address");
    // scope
    String sessionValue = (String)session.getAttribute("session");
    String applicationValue = (String)application.getAttribute("application");
    String pageScope =  (String)pageContext.getAttribute("pageScope", PageContext.PAGE_SCOPE);
    String requestScope =  (String)pageContext.getAttribute("requestScope", PageContext.REQUEST_SCOPE);
    String sessionScope =  (String)pageContext.getAttribute("sessionScope", PageContext.SESSION_SCOPE);
    String applicationScope =  (String)pageContext.getAttribute("applicationScope", PageContext.APPLICATION_SCOPE);

%>
<jsp:useBean id="customer" scope="request" class="com.example.demo.entity.CustomerEntity" />

<%! int a = 200; String b = "T2203E"; %>
<h3><%= 10 + 40 + 50 %></h3>
<h3><%= a %></h3>
<h3><%= b %></h3>
<h3><%= d %></h3>
<h1>Data from index form</h1>
<h3>name : <%= name %></h3>
<h3>phone : <%= phone %></h3>
<h3>address : <%= address %></h3>
<h1> Scope </h1>
<h3>sessionValue : <%= sessionValue %></h3>
<h3>applicationValue : <%= applicationValue %></h3>
<h3>pageScope : <%= pageScope %></h3>
<h3>requestScope : <%= requestScope %></h3>
<h3>sessionScope : <%= sessionScope %></h3>
<h3>applicationScope : <%= applicationScope %></h3>
<%--<%@ include file="footer.jsp"%>--%>

<h1> customer information</h1>
<h3>name : <jsp:getProperty name="customer" property="name"/> </h3>
<h3>age : <jsp:getProperty name="customer" property="age"/> </h3>
<h3>address : <jsp:getProperty name="customer" property="address"/> </h3>

<h1> Name: ${customer.name}</h1>
<h1> Age: ${customer.age}</h1>
<h1> Address: ${customer.address}</h1>
<h1> Tong : ${ 4 + "6"}</h1>
<h1> Tong : ${ 4 >= "4"}</h1>
<h1> value param name: ${param.name}</h1>
<h1> value param address: ${param.address}</h1>

<jsp:useBean id="customers" scope="request" type="java.util.List"/>

<%
    List<CustomerEntity> customerEntityList = (List<CustomerEntity>) customers;
    for (CustomerEntity cust : customerEntityList) {

%>
<h1> Name : <%= cust.getName() %>, Age: <%= cust.getAge() %>, Address: <%= cust.getAddress()%></h1>
<%
    }
%>

</body>
</html>
