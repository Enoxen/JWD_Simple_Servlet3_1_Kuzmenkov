package by.tc.task.main;

import by.tc.task.dao.DAOFactory;
import by.tc.task.dao.UserDAO;
import by.tc.task.exceptions.DAOException;


/**
 * Created by Y50-70 on 12.11.2017.
 */
public class Main {
    public static void main(String[] args){
        DAOFactory factory = DAOFactory.getInstance();
        UserDAO userDAO = factory.getUserDao();
        try {
            System.out.println(userDAO.findUser("ivan", "zalupin"));
        }
        catch (DAOException e){
            System.out.println(e.getMessage());
        }

    }
}
