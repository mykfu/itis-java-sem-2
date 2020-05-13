package model;

public class Chat implements Model {
    private long id;
    private String type;
    private String username;

    public Chat() {
    }

    public Chat(long id, String type, String username) {
        this.id = id;
        this.type = type;
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "model.Chat{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
