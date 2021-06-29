<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
 
<!DOCTYPE html>
<html>
<head>
<%@include file="./base.jsp" %> 
<meta charset="ISO-8859-1">
<title>Insert title here</title>    
</head>
<body>
<%@include file="navbar.jsp" %> 

<div class="container mt-3">
<div class="row">

<div class="col-md-12">

<h1 class="text-center mb-3">WELCOME</h1>
<table class="table">
  <thead class="table-dark">
    <tr>
    <th scope="col">S.NO.</th>
    <th scope="col">User Name</th>
    <th scope="col">Email Address</th>
    <th scope="col">Gender</th>
    <th scope="col">Description</th>
    <th scope="col">Action</th>
    </tr>
    
  </thead>
  <tbody>
    <c:forEach items="${customer }" var="cu">
    <tr>
    <th scope="row">${cu.id }</th>
    <th scope="row">${cu.name}</th>
    <th scope="row">${cu.email}</th>
    <th scope="row">${cu.gender}</th>
    <th scope="row">${cu.description}</th>
    <td>
    <a href="update/${cu.id }"><i class="fas fa-pen-nib" style="font-size:20px;"></i></a>
    <a href="delete/${cu.id }"><i class="fas fa-trash text-danger" style="font-size:20px;"></i></a>
    
    </td>
    </tr>
    </c:forEach>
  </tbody>
</table>
<div class="container text-center">
<a href="register" class="btn btn-outline-success">Add New Customers</a>
</div>
</div>
</div>
</div>
</body>
</html>