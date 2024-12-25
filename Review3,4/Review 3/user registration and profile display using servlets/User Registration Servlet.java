import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/register")
public class UserRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().write(
            "<html>" +
            "<head><title>User Registration</title></head>" +
            "<body>" +
            "<h1>Register</h1>" +
            "<form action='/register' method='post'>" +
            "    <label for='name'>Name:</label><br>" +
            "    <input type='text' id='name' name='name' required><br><br>" +
            "    <label for='email'>Email:</label><br>" +
            "    <input type='email' id='email' name='email' required><br><br>" +
            "    <label for='age'>Age:</label><br>" +
            "    <input type='number' id='age' name='age' required><br><br>" +
            "    <button type='submit'>Register</button>" +
            "</form>" +
            "</body>" +
            "</html>"
        );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Extract user data from the request
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String age = request.getParameter("age");

        // Store data in session for simplicity (this can be replaced by database storage)
        HttpSession session = request.getSession();
        session.setAttribute("name", name);
        session.setAttribute("email", email);
        session.setAttribute("age", age);

        // Redirect to the profile page
        response.sendRedirect("profile");
    }
}
