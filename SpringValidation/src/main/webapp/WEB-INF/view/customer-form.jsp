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

<div style="margin: auto;width: 60%;border: 5px solid black;padding: 10px;">
<h2>Customer Registration From</h2>
<form:form action="processForm" modelAttribute="customer">
First Name:<form:input path="firstName"/>
<br><br>
Last Name(*):<form:input path="lastName"/>
<form:errors path="lastName" cssClass="error"/>
<br><br>
Free Pass:<form:input path="freePass"/>
<form:errors path="freePass" cssClass="error"/>
<br><br>
Postal Code:<form:input path="postalCode"/>
<form:errors path="postalCode" cssClass="error"/>
<br><br>
CourseCode:<form:input path="courseCode"/>
<form:errors path="courseCode" cssClass="error"/>
<br><br>


<input type="submit" value ="submit"/>
</form:form>
</div>
</body>
</html>