package by.tc.task.service.impl;

import by.tc.task.dao.DAOFactory;
import by.tc.task.dao.UserDAO;
import by.tc.task.entity.User;
import by.tc.task.exceptions.DAOException;
import by.tc.task.exceptions.ServiceException;
import by.tc.task.service.UserService;

/**
 * Created by Y50-70 on 12.11.2017.
 */
public class UserServiceImpl implements UserService {
    public UserServiceImpl(){}
    @Override
    public User findUser(String name, String surname) throws ServiceException{

        DAOFactory factory = DAOFactory.getInstance();
        UserDAO userDAO = factory.getUserDao();
        try {
            return userDAO.findUser(name, surname);
        }
        catch (DAOException e){
            throw new ServiceException(e.getMessage(),e);
        }


    }
}
