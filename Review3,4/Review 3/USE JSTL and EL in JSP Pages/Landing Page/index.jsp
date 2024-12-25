<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
</head>
<body>
    <h1>Welcome to User Management</h1>
    <p><a href="registration.jsp">Register</a></p>
    <p><a href="profile.jsp">View Profile</a></p>

    <!-- Example of using EL -->
    <p>${sessionScope.userName}</p>
</body>
</html>
