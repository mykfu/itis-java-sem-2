import model.User;

public class UserResponse extends DefaultResponse<User> {
    protected User result;
    public UserResponse(boolean ok, User result) {
        super(ok, result);
    }
}
