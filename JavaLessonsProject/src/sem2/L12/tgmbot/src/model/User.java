package model;

public class User implements Model {
    private long id;
    private boolean is_bot;
    private String username;

    public User() {
    }

    public User(long id, boolean is_bot, String username) {
        this.id = id;
        this.is_bot = is_bot;
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public boolean isBot() {
        return is_bot;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "model.User{" +
                "id=" + id +
                ", is_bot=" + is_bot +
                ", username='" + username + '\'' +
                '}';
    }
}
