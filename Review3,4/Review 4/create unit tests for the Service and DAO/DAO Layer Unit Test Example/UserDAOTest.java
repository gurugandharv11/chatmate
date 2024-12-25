import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.sql.*;

public class UserDAOTest {

    private UserDAO userDAO;
    private Connection mockConnection;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultSet;

    @BeforeEach
    void setUp() throws SQLException {
        mockConnection = mock(Connection.class);
        mockPreparedStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        userDAO = new UserDAO(mockConnection);
    }

    @Test
    void testSaveUser() throws SQLException {
        User user = new User("John", "john@example.com", 25);
        
        // Mocking the execution of update (1 row affected)
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        boolean result = userDAO.saveUser(user);

        assertTrue(result);
        verify(mockPreparedStatement, times(1)).setString(1, "John");
        verify(mockPreparedStatement, times(1)).setString(2, "john@example.com");
        verify(mockPreparedStatement, times(1)).setInt(3, 25);
        verify(mockPreparedStatement, times(1)).executeUpdate();
    }

    @Test
    void testGetUserByEmail() throws SQLException {
        // Mocking a result set
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getString("name")).thenReturn("John");
        when(mockResultSet.getString("email")).thenReturn("john@example.com");
        when(mockResultSet.getInt("age")).thenReturn(25);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        User user = userDAO.getUserByEmail("john@example.com");

        assertNotNull(user);
        assertEquals("John", user.getName());
        assertEquals("john@example.com", user.getEmail());
        assertEquals(25, user.getAge());
    }
}
