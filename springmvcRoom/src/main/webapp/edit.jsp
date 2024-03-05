<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>edit</title>
</head>
<body>
<table>
<form:form action="update" modelAttribute="r">
<tr>
<th>
Id:<form:input path="id" readonly="true"/>
</th>
</tr>
<tr>
<th>
Name:<form:input path="name" />
</th>
</tr>
<tr>
<th>
Age:<form:input path="age" />
</th>
</tr>
<tr>
<th>
Phone No:<form:input path="phoneno" />
</th>
</tr>
<tr>
<th>
<input type="submit">
</th>
</tr>
</form:form>
</table>

</body>
</html>