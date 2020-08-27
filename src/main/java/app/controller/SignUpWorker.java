package app.controller;

import app.entities.User;
import app.model.dao.TattooDAO;
import app.model.dao.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/signUpWorker")
public class SignUpWorker extends HttpServlet {
    private UserDAO userDAO = new UserDAO();
    private TattooDAO tattooDAO= new TattooDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String login = req.getParameter("email");
        String password = req.getParameter("password");

        Pattern p = Pattern.compile("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");
        Matcher m = p.matcher(login);
        UserDAO userDAO = new UserDAO();
        if(!(login.equals("")||name.equals("")||password.equals(""))) {
            if (m.matches()) {
                try {
                    if (!userDAO.isField("login", login)) {
                        try {
                            if (!userDAO.isField("name", name)) {
                                User user = new User(name, login, password,"0");
                                userDAO.addUser(user);
                                RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/userAccountForm.jsp");
                                dispatcher.forward(req, resp);
                            } else {
                                req.setAttribute("info", "This name is use!");
                                RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/signUpInfoForm.jsp");
                                dispatcher.forward(req, resp);
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    } else {
                        req.setAttribute("info", "This email is use!");
                        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/signUpInfoForm.jsp");
                        dispatcher.forward(req, resp);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                req.setAttribute("info", "Email don't correct!");
                RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/signUpInfoForm.jsp");
                dispatcher.forward(req, resp);
            }
        }
        else{
            req.setAttribute("info", "Fill all fields!");
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/signUpInfoForm.jsp");
            dispatcher.forward(req, resp);
        }
    }
}

