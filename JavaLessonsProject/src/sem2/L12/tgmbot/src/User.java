public class User {
    private long id;
    private boolean is_bot;
    private String username;

    public User() {
    }

    public long getId() {
        return id;
    }

    public boolean isIs_bot() {
        return is_bot;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", is_bot=" + is_bot +
                ", username='" + username + '\'' +
                '}';
    }
}
