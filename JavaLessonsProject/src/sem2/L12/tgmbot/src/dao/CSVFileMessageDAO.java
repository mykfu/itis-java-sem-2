package dao;

import model.Message;
import model.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CSVFileMessageDAO implements MessageDAO {

    private final static String DEFAULT_FILENAME = "message.csv";
    private String filename;
    private List<Message> messages;

    public CSVFileMessageDAO() {
        this(DEFAULT_FILENAME);
    }

    public CSVFileMessageDAO(String filename) {
        this.filename = filename;
        messages = new ArrayList<>();
        if (Paths.get(filename).isAbsolute()) {
            try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename))) {
                CSVFileUserDAO userDAO = new CSVFileUserDAO();
                CSVFileChatDAO chatDAO = new CSVFileChatDAO();
                this.messages = reader.lines().map(line -> {
                    String[] lineSplitted = line.split(",");
                    return new Message(
                            Long.parseLong(lineSplitted[0]), // message_id
                            userDAO.getById(Long.parseLong(lineSplitted[1])), // user
                            Long.parseLong(lineSplitted[2]), // date
                            chatDAO.getById(Long.parseLong(lineSplitted[3])), // chat
                            lineSplitted[4] // text
                    );
                }).collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public boolean add(Message element) {
        DAO userDAO = CSVFileDAOManager.getDAO(element.getFrom().getClass());
        DAO chatDAO = CSVFileDAOManager.getDAO(element.getChat().getClass());

        if (!userDAO.add(element.getFrom()) & !chatDAO.add(element.getChat())) return false;

        userDAO.close();
        chatDAO.close();

        return messages.add(element);
    }

    @Override
    public List<Message> getAll() {
        return null;
    }

    @Override
    public Message getById(long id) {
        return null;
    }

    @Override
    public boolean set(Message element) {
        return false;
    }

    @Override
    public boolean remove(Message element) {
        return false;
    }


    public void close() {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename), StandardOpenOption.APPEND);
            for (Message message : messages) {
                writer.append(
                        String.format(
                                "%d,%d,%d,%d,%s%n",
                                message.getMessage_id(),
                                message.getFrom().getId(),
                                message.getDate(),
                                message.getChat().getId(),
                                message.getText()
                        )
                );
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
