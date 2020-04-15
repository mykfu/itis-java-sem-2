package sem2.L12.tgmbot;

public class UserResponse implements Response {
    private boolean ok;
    private User result;

    public UserResponse() {
    }

    public boolean isOk() {
        return ok;
    }

    public User getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Response{" +
                "result=" + result +
                '}';
    }
}
