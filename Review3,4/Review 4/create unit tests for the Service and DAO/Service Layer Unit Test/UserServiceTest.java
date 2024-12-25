import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    private UserService userService;
    private UserDAO mockUserDAO;

    @BeforeEach
    void setUp() {
        mockUserDAO = mock(UserDAO.class);
        userService = new UserService(mockUserDAO);
    }

    @Test
    void testRegisterUser() {
        User user = new User("John", "john@example.com", 25);

        // Mock DAO saveUser to return true
        when(mockUserDAO.saveUser(user)).thenReturn(true);

        boolean result = userService.registerUser(user);

        assertTrue(result);
        verify(mockUserDAO, times(1)).saveUser(user);
    }

    @Test
    void testGetUserProfile() {
        String email = "john@example.com";
        User user = new User("John", email, 25);

        // Mock DAO getUserByEmail to return the user object
        when(mockUserDAO.getUserByEmail(email)).thenReturn(user);

        User result = userService.getUserProfile(email);

        assertNotNull(result);
        assertEquals("John", result.getName());
        assertEquals(email, result.getEmail());
        assertEquals(25, result.getAge());
    }
}
