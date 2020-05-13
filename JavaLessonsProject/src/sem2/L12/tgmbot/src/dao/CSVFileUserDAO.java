package dao;

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

public class CSVFileUserDAO implements UserDAO {
    private final static String DEFAULT_FILENAME = "users.csv";
    private String filename;
    private List<User> users;

    public CSVFileUserDAO() {
        this(DEFAULT_FILENAME);
    }

    public CSVFileUserDAO(String filename) {
        this.filename = filename;
        users = new ArrayList<>();
        if (Paths.get(filename).isAbsolute()) {
            try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename))) {
                this.users = reader.lines().map(line -> {
                    String[] lineSplitted = line.split(",");
                    return new User(Long.parseLong(lineSplitted[0]), Boolean.parseBoolean(lineSplitted[1]), lineSplitted[2]);
                }).collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public List<User> findByUsername(String username) {
        return users.stream().filter(user -> user.getUsername().equals(username)).collect(Collectors.toList());
    }

    @Override
    public boolean add(User element) {
        return users.add(element);
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User getById(long id) {
        return users.stream().filter(user -> user.getId() == id).collect(Collectors.collectingAndThen(
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
    public boolean set(User element) {
        return false;
    }

    @Override
    public boolean remove(User element) {
        return false;
    }

    public void close() {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename), StandardOpenOption.APPEND);
            for (User user : users) {
                writer.append(String.format("%d,%s,%s%n", user.getId(), user.isBot(), user.getUsername()));
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
