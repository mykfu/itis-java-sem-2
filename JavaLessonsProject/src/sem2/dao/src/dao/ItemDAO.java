package dao;

import model.Model;

import java.util.List;

public interface ItemDAO<T extends Model> {

    public List<T> getAll();

    public T getById(int id);

    public void add(T type);

    public void update(T type);

    public void remove(T type);

}
