package app.controller;

import app.model.dao.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.HttpCookie;
import java.sql.SQLException;


@WebServlet("/signInWorker")
public class SignInWorker extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

                String login = req.getParameter("login");
                String password = req.getParameter("password");
                String remember = req.getParameter("remember");
                UserDAO userDao = new UserDAO();

                if (userDao.isFields("login", login, "password", password)) {
                    if (userDao.isFields("isadmin", "1", "login", login)) {
                        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/adminForm.jsp");
                        dispatcher.forward(req, resp);
                    } else {
                        if (remember != null) {
                            Cookie cookie = new Cookie("key", login);
                            resp.addCookie(cookie);
                            session.setAttribute(login, password);
                        }

                        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/userAccountForm.jsp");
                        dispatcher.forward(req, resp);
                    }
                } else {
                    req.setAttribute("info", "Don't correct login or password!");
                    RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/signInInfoForm.jsp");
                    dispatcher.forward(req, resp);
                }
            }
}
