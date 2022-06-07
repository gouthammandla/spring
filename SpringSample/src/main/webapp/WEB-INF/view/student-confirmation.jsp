<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>

<h2>The student confirmed is: ${student.firstName} ${student.lastName}</h2>
<br><br>
<h2>Country:${student.country}</h2>
<br><br>
<h2>Favourite Language:${student.favouriteLanguage}</h2>
<br><br>
Operating Systems:
<ul>
<c:forEach var="temp" items="${student.operatingSystems}">
<li>${temp}</li>
</c:forEach>
</ul>
</body>
</html>