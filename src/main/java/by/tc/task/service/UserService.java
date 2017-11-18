package by.tc.task.service;

import by.tc.task.entity.User;
import by.tc.task.exception.ServiceException;

/**
 * Created by Y50-70 on 12.11.2017.
 */
public interface UserService {
    User findUser(String name, String surname) throws ServiceException;
}
