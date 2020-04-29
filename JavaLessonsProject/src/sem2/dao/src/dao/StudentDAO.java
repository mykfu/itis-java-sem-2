package dao;

import model.Role;
import model.Student;

import java.util.List;

public interface StudentDAO extends ItemDAO<Student>{

    // CRUD Create Read Update Delete
    // DAO Data Access Object

    Role getRole();
}
