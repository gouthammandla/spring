<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>

<div style="margin: auto;width: 60%;border: 5px solid black;padding: 10px;">
<h2>Student Registration From</h2>
<form:form action="processForm" modelAttribute="student">
First Name:<form:input path="firstName"/>
<br><br>
Last Name:<form:input path="lastName"/>
<form:errors path="lastName" cssClass="error"/>
<br><br>
<form:select path="country">
<form:options items="${student.countryOptions}"/>

</form:select>
<br><br>

Favourite Language:
Java <form:radiobutton path="favouriteLanguage" value="Java"/>
C#<form:radiobutton path="favouriteLanguage" value="C#"/>
PHP<form:radiobutton path="favouriteLanguage" value="PHP"/>
Ruby<form:radiobutton path="favouriteLanguage" value="Ruby"/>
<br><br>
Operating Systems:
 Linux <form:checkbox path="operatingSystems" value="Linux"/>
 Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
 MS Window  <form:checkbox path="operatingSystems" value="MS Window"/>
<br><br>
<input type="submit" value ="submit"/>
</form:form>
</div>
</body>
</html>