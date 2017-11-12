package by.tc.task.dao;

import by.tc.task.entity.User;
import by.tc.task.exceptions.DAOException;

/**
 * Created by Y50-70 on 12.11.2017.
 */
public interface UserDAO {
    User findUser(String name, String surname)throws DAOException;
}
