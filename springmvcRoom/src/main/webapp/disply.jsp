<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Disply</title>
</head>
<body>
<h1 style="text-align: center; text-decoration: underline;">Result</h1>
<table border=" 4px solid red", style=" background-color:white; padding: 10px ;text-align: center;margin: 0 auto">
<tr style="background-color:gray ; color: white; width: 20px">
<th style="padding: 10px ; ">Id</th>
<th>Name</th>
<th>Age</th>
<th>Phone No</th>
<th>Delete</th>
<th>edit</th>

</tr>
<c:forEach var="list" items="${list }">
<tr>
<td style="padding: 10px ">${list.id}</td>
<td>${list.name}</td>
<td>${list.age}</td>
<td>${list.phoneno}</td>
<td style="background-color:#ff7f7f ; border: none"><a href="delete?id=${list.id}" style="color:black;padding: 10px;">Delete</a> </td>
<td style="background-color: #5890ff ; border: none; "><a href="edit?id=${list.id}" style="color:black;padding: 10px;">Edit</a> </td>


</tr>

</c:forEach>

</table>

</body>
</html>