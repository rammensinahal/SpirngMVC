<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<form:form action="save" modelAttribute="std">
Id:<form:input path="id"/>
Name:<form:input path="name"/>
Email:<form:input path="email"/>
Password:<form:input path="password"/>
Age:<form:input path="age"/>
Address:<form:input path="address"/>
<input type="submit">

</form:form>
</body>
</html>