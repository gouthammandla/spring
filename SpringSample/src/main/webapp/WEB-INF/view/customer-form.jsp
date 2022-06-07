<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<style>
.error{
color:red
}
</style>
</head>
<body>


<h2>Customer Registration From</h2>
<form:form action="processForm" modelAttribute="customer">
First Name:<form:input path="firstName"/>
<br><br>
Last Name(*):<form:input path="lastName"/>
<form:errors path="lastName" cssClass="error"/>
<br><br>


<input type="submit" value ="submit"/>
</form:form>

</body>
</html>