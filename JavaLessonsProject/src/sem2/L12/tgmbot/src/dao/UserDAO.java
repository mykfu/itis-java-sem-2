package dao;

import model.User;

import java.util.List;

public interface UserDAO extends DAO <User> {
    public List<User> findByUsername(String username);
}
