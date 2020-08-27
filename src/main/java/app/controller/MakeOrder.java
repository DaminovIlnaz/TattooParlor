package app.controller;

import app.model.dao.OrderDAO;
import app.model.dao.OrderHasTattoosDAO;
import app.model.dao.TattooDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/order")
public class MakeOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Cookie myCok = null;
        Cookie[] cok = req.getCookies();
        for (Cookie cookie : cok) {
            if (cookie.getName().equals("key")) {
                myCok = cookie;
            }
        }

        if ((!myCok.getValue().equals(""))&&(!(myCok.getValue() == null))) {

            OrderDAO od = new OrderDAO();
            ResultSet resSet = od.getAllOrder();
            int columns = 0;

            int num = 0;
            try {
                while(resSet.next()){
                    num++;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            String strNum = String.valueOf(num);


            TattooDAO tattooDAO = new TattooDAO();
            resSet = tattooDAO.read(name);
            String myString = "";
            try {
                columns = resSet.getMetaData().getColumnCount();
                while(resSet.next()){
                    for (int i = 1; i <= columns; i++){
                        myString += resSet.getString(i) + " ";
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            String arr[] = myString.split(" ");


            OrderDAO orderDAO = new OrderDAO();
            OrderHasTattoosDAO orderHasTattoosDAO = new OrderHasTattoosDAO();
            try {
                orderDAO.create(myCok.getValue());
                orderHasTattoosDAO.create(strNum,arr[0]);
                RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/goodOrderForm.jsp");
                dispatcher.forward(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }




        }
        else{
            req.setAttribute("info", "To order you need to authorization!");
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/signInInfoForm.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
