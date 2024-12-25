public class UserService {

    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean registerUser(User user) {
        return userDAO.saveUser(user);
    }

    public User getUserProfile(String email) {
        return userDAO.getUserByEmail(email);
    }
}
