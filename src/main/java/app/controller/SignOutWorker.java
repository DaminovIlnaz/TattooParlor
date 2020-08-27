package app.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/signOut")
public class SignOutWorker extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cookie myCok = null;
        Cookie[] cok = req.getCookies();
        for (Cookie cookie : cok) {
            if (cookie.getName().equals("key")) {
                myCok = cookie;
            }
        }
        session.setAttribute(myCok.getValue(), null);
        Cookie cookie = new Cookie("key", null);
        resp.addCookie(cookie);

        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/signInForm.jsp");
        dispatcher.forward(req, resp);
    }
}
