package by.tc.task.dao.impl;

import by.tc.task.dao.UserDAO;
import static by.tc.task.dao.constants.ConnectionConstant.*;// не надо статического импорта, это не есть гуд
import static by.tc.task.dao.constants.PreparedStatement.*;

import static  by.tc.task.dao.constants.ResponseFromDb.*;
import by.tc.task.entity.User;
import by.tc.task.exception.DAOException;
import by.tc.task.exception.RequestToDbException;

import java.sql.*;// не импортируйте классы через *, пожалейте тех, кто это потом читать будет

/**
 * Created by Y50-70 on 12.11.2017.
 */
public class UserDAOImpl implements UserDAO {


    @Override
    public User findUser(String name, String surname) throws DAOException {
        User user;
        try{
            Class.forName("com.mysql.jdbc.Driver");// неименованная константная строка - это раз
            // а два - ты учел, сколько раз этот оператор будет выполняться
            // т.к. выполняться он должен только один раз за всю жизнь приложения
        }
        catch (ClassNotFoundException e){
            throw new DAOException("problems with db", e);
        }
        // два try - уже перебор
        // всю твою логику можно было запилить в одном и не перегружать метод
        try(Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD)){
            user = executeRequest(name, surname, connection);
        }
        catch (SQLException e){
            throw new DAOException("no connection to db", e);
        }
        catch (RequestToDbException e){
            throw new DAOException(e.getMessage(),e);// ну зачем ты повторно сетишь сообщение, которое уже есть в объекте е, ведь двумя строчками выше все же правильно написал, а тут что - лень было подумать на причиной эксепшена
            
        }
        return user;
    }
    private User executeRequest(String name, String surname, Connection connection) throws RequestToDbException,
                                                                                            SQLException
    {
        ResultSet result = null;
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement(GET_STATEMENT);
            statement.setString(1, name);
            statement.setString(2, surname);
            result = statement.executeQuery();
            if(result.next()){
                result.previous();
                user = createUserFromDbResponse(result);
            }
            return user;
        }
        catch (SQLException e) {
            throw new RequestToDbException("problems with request", e);
        }
        finally {
            if(result != null){
                result.close();
            }
        }
    }
    private User createUserFromDbResponse(ResultSet result) throws SQLException{
        User user = new User();
        try {
            while(result.next()) {

                user.setName(result.getString(NAME));

                user.setSurname(result.getString(SURNAME));

                user.setPhoneNumber(result.getString(PHONE_NUMBER));

                user.setEmail(result.getString(EMAIL));
            }
        }
        catch (SQLException e){// ты перехватил SQLException, чтобы выбросить снова SQLException 
            // да еще в private методе
            // что пили, когда это писали, я тоже такого хочу
            throw new SQLException("creating entity problems", e);
        }
        return user;
    }
}
