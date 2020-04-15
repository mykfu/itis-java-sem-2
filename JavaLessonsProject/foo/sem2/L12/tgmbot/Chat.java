package sem2.L12.tgmbot;

public class Chat {
    private long id;
    private String type;
    private String username;

    public Chat() {
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
        return "Chat{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
