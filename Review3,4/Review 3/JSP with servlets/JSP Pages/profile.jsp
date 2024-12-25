<%@ page session="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
</head>
<body>
    <h1>Your Profile</h1>
    <%
        String name = (String) session.getAttribute("name");
        String email = (String) session.getAttribute("email");
        String age = (String) session.getAttribute("age");

        if (name == null || email == null || age == null) {
    %>
        <p>No profile found. Please <a href="registration.jsp">register</a>.</p>
    <%
        } else {
    %>
        <p><strong>Name:</strong> <%= name %></p>
        <p><strong>Email:</strong> <%= email %></p>
        <p><strong>Age:</strong> <%= age %></p>
        <a href="registration.jsp">Edit Profile</a>
    <%
        }
    %>
</body>
</html>
