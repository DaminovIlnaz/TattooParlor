package app.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/signIn")
public class SignInRedirect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie myCok = null;
        Cookie[] cok = req.getCookies();
        HttpSession session = req.getSession();
        for (Cookie cookie : cok) {
            if (cookie.getName().equals("key")) {
                myCok = cookie;
            }
        }

        if (myCok != null) {
            String user = (String) session.getAttribute(myCok.getValue());
            if (user != null) {
                RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/userAccountForm.jsp");
                dispatcher.forward(req, resp);
            }

            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/signInForm.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
