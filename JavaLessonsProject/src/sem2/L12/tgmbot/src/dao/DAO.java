package dao;

import model.Model;

import java.util.List;

public interface DAO <E extends Model>{
    // create
    public boolean add(E element);

    // read
    public List<E> getAll();

    public E getById(long id);

    // update
    public boolean set(E element);

    // delete
    public boolean remove(E element);

    public void close();

}
