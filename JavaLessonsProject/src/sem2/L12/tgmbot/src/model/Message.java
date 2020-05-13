package model;

public class Message implements Model {
    private long message_id;
    private User from;
    private long date;
    private Chat chat;
    private String text;

    public Message() {
    }

    public Message(long message_id, User from, long date, Chat chat, String text) {
        this.message_id = message_id;
        this.from = from;
        this.date = date;
        this.chat = chat;
        this.text = text;
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
        return "model.Message{" +
                "message_id=" + message_id +
                ", from=" + from +
                ", date=" + date +
                ", chat=" + chat +
                ", text='" + text + '\'' +
                '}';
    }
}
