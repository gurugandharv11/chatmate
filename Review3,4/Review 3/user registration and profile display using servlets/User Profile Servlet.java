import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/profile")
public class UserProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        // Retrieve user data from session
        String name = (String) session.getAttribute("name");
        String email = (String) session.getAttribute("email");
        String age = (String) session.getAttribute("age");

        if (name == null || email == null || age == null) {
            response.getWriter().write(
                "<html>" +
                "<head><title>Profile</title></head>" +
                "<body>" +
                "<h1>No Profile Found</h1>" +
                "<p>Please <a href='/register'>register</a> first.</p>" +
                "</body>" +
                "</html>"
            );
        } else {
            response.getWriter().write(
                "<html>" +
                "<head><title>User Profile</title></head>" +
                "<body>" +
                "<h1>Your Profile</h1>" +
                "<p><strong>Name:</strong> " + name + "</p>" +
                "<p><strong>Email:</strong> " + email + "</p>" +
                "<p><strong>Age:</strong> " + age + "</p>" +
                "<a href='/register'>Edit Profile</a>" +
                "</body>" +
                "</html>"
            );
        }
    }
}
