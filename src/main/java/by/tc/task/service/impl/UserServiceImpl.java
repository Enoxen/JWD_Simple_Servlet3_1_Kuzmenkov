package by.tc.task.service.impl;

import by.tc.task.dao.DaoFactory;
import by.tc.task.dao.UserDao;
import by.tc.task.entity.User;
import by.tc.task.exception.DAOException;
import by.tc.task.exception.ServiceException;
import by.tc.task.service.UserService;

/**
 * Created by Y50-70 on 12.11.2017.
 */
public class UserServiceImpl implements UserService {
    public UserServiceImpl(){}
    @Override
    public User findUser(String name, String surname) throws ServiceException{

        DaoFactory factory = DaoFactory.getInstance();
        UserDao userDao = factory.getUserDao();
        try {
            return userDao.findUser(name, surname);
        }
        catch (DAOException e){
            throw new ServiceException(e.getMessage(),e);
        }


    }
}
