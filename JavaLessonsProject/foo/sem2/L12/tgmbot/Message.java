package sem2.L12.tgmbot;

public class Message {
    private long message_id;
    private User from;
    private long date;
    private Chat chat;
    private String text;

    public Message() {
    }

    public long getMessage_id() {
        return message_id;
    }

    public User getFrom() {
        return from;
    }

    public long getDate() {
        return date;
    }

    public Chat getChat() {
        return chat;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message_id=" + message_id +
                ", from=" + from +
                ", date=" + date +
                ", chat=" + chat +
                ", text='" + text + '\'' +
                '}';
    }
}
