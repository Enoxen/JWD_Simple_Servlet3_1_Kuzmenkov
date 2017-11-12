<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html" charset="utf-8">
    <title>User output</title>
</head>
<body>
    <c:if test = "${requestScope.user.name != null}">
        <table border="1">
            <tr>
                <td>Name</td>
                <td>Surname</td>
                <td>Phone Number</td>
                <td>email</td>
            </tr>
            <tr>
                <td><c:out value="${requestScope.user.name}" /></td>
                <td><c:out value="${requestScope.user.surname}" /></td>
                <td><c:out value="${requestScope.user.phoneNumber}" /></td>
                <td><c:out value="${requestScope.user.email}" /></td>
            </tr>
        </table>
    </c:if>

    <c:if test="${requestScope.user.name == null}">
        <c:out value="User not found" />
    </c:if>
</body>
</html>
