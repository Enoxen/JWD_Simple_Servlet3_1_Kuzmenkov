package by.tc.task.service.impl;

import by.tc.task.dao.DAOFactory;
import by.tc.task.dao.UserDAO;
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
// куда, куда ты поделавась.... валидация из сервисов слежала
        DAOFactory factory = DAOFactory.getInstance();
        UserDAO userDAO = factory.getUserDAO();
        try {
            return userDAO.findUser(name, surname);
        }
        catch (DAOException e){
            throw new ServiceException(e.getMessage(),e);// см аналогичную ошибку в дао
        }


    }
}
