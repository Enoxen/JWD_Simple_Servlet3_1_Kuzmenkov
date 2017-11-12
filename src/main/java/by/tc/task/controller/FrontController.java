package by.tc.task.controller;

import by.tc.task.entity.User;
import by.tc.task.exceptions.ServiceException;
import by.tc.task.service.ServiceFactory;
import by.tc.task.service.UserService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Y50-70 on 09.11.2017.
 */

public class FrontController extends HttpServlet {


    private ServiceFactory factory = ServiceFactory.getInstance();
    private UserService userService = factory.getUserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        try {
            User user = userService.findUser(name, surname);
            request.setAttribute("user", user);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user.jsp");
            requestDispatcher.forward(request, response);
        }
        catch (ServiceException e){
            PrintWriter out = response.getWriter();
            out.println(e.getMessage());
        }
    }
}
