import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/chat")
public class ChatMateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Handles GET requests.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set the response content type
        response.setContentType("text/html");

        // Write a simple HTML page as the response
        response.getWriter().write(
            "<html>" +
            "<head><title>ChatMate</title></head>" +
            "<body>" +
            "<h1>Welcome to ChatMate!</h1>" +
            "<p>Use the form below to send a message:</p>" +
            "<form action='/chat' method='post'>" +
            "    <input type='text' name='message' placeholder='Type a message...' required>" +
            "    <button type='submit'>Send</button>" +
            "</form>" +
            "</body>" +
            "</html>"
        );
    }

    /**
     * Handles POST requests.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the user's message from the request parameters
        String userMessage = request.getParameter("message");

        // Generate a simple response
        String botResponse = "You said: \"" + userMessage + "\". How can I help you further?";

        // Set the response content type to JSON
        response.setContentType("application/json");

        // Write the response in JSON format
        response.getWriter().write("{\"response\": \"" + botResponse + "\"}");
    }
}
