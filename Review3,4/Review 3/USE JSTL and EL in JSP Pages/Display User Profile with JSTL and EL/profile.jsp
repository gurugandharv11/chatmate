<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
</head>
<body>
    <h1>Your Profile</h1>
    <c:choose>
        <!-- Check if the session has the required user data -->
        <c:when test="${not empty sessionScope.name and not empty sessionScope.email and not empty sessionScope.age}">
            <p><strong>Name:</strong> ${sessionScope.name}</p>
            <p><strong>Email:</strong> ${sessionScope.email}</p>
            <p><strong>Age:</strong> ${sessionScope.age}</p>
            <p><a href="registration.jsp">Edit Profile</a></p>
        </c:when>
        <c:otherwise>
            <p>No profile data found. Please <a href="registration.jsp">register</a>.</p>
        </c:otherwise>
    </c:choose>
</body>
</html>
