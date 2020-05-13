package dao;

import model.Chat;
import model.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CSVFileChatDAO implements ChatDAO {

    private final static String DEFAULT_FILENAME = "chat.csv";
    private String filename;
    private List<Chat> chats;

    public CSVFileChatDAO() {
        this(DEFAULT_FILENAME);
    }

    public CSVFileChatDAO(String filename) {
        this.filename = filename;
        chats = new ArrayList<>();
        if (Paths.get(filename).isAbsolute()) {
            try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename))) {
                this.chats = reader.lines().map(line -> {
                    String[] lineSplitted = line.split(",");
                    return new Chat(Long.parseLong(lineSplitted[0]), lineSplitted[1], lineSplitted[2]);
                }).collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean add(Chat element) {
        return chats.add(element);
    }

    @Override
    public List<Chat> getAll() {
        return null;
    }

    @Override
    public Chat getById(long id) {
        return chats.stream().filter(user -> user.getId() == id).collect(Collectors.collectingAndThen(
                Collectors.toList(),
                list -> {
                    if (list.size() != 1) {
                        throw new IllegalStateException();
                    }
                    return list.get(0);
                }
        ));
    }

    @Override
    public boolean set(Chat element) {
        return false;
    }

    @Override
    public boolean remove(Chat element) {
        return false;
    }


    public void close() {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename), StandardOpenOption.APPEND);
            for (Chat chat : chats) {
                writer.append(String.format("%d,%s,%s%n", chat.getId(), chat.getType(), chat.getUsername()));
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
