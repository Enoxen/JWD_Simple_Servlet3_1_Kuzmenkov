package by.tc.task.dao;

import by.tc.task.dao.impl.UserDaoImpl;

/**
 * Created by Y50-70 on 12.11.2017.
 */
public class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();
    private final UserDao userDao = new UserDaoImpl();

    private DaoFactory(){}

    public UserDao getUserDao(){
        return userDao;
    }
    public static DaoFactory getInstance(){
        return instance;
    }
}

