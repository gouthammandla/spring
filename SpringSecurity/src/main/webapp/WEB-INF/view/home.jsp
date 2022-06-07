<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
    <head>
        <title>
            Home Page
        </title>

    </head>
    <body>
        <h2>Home Page</h2>
        <hr>
        <p>User: <security:authentication property="principal.username"/></p
        <br><br>
        <p>Role(s): <security:authentication property="principal.authorities"/></p>
        <hr>

        <security:authorize access="hasRole('MANAGER')">
        <p><a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>(Only for Manager peeps)</p>
        </security:authorize>
        <security:authorize access="hasRole('ADMIN')">
        <p><a href="${pageContext.request.contextPath}/systems">IT systems Meeting</a>(Only for Admin peeps)</p>
        </security:authorize>
        <hr>
        <form:form action="${pageContext.request.contextPath}/logout" method="POST">
        <input type="submit" value="Logout"/>
        </form:form>

    </body>
</html>