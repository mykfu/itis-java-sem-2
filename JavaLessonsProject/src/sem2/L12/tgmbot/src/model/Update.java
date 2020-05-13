package model;

import dao.CSVFileChatDAO;
import dao.CSVFileUserDAO;

public class Update implements Model {
    private long update_id;
    private boolean is_bot;
    private Message message;
    private Message edited_message;

    public Update() {
    }

    public long getUpdate_id() {
        return update_id;
    }

    public boolean isIs_bot() {
        return is_bot;
    }

    public Message getMessage() {
        return message;
    }

    public Message getEdited_message() {
        return edited_message;
    }

    @Override
    public String toString() {
        return "model.Update{" +
                "update_id=" + update_id +
                ", is_bot=" + is_bot +
                (message != null?  ", message=" + message : "" ) +
                (edited_message != null?  ", edited_message=" + edited_message : "" ) +
                '}';
    }
}
