package app.controller;

import app.entities.Tattoo;
import app.model.dao.TattooDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/adminka")
public class AdminWorker extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String comand = req.getParameter("submit");
        TattooDAO tattooDao = new TattooDAO();
        String tattooName = req.getParameter("tattooName");
        String tattooLink = req.getParameter("tattooLink");
        String newTattooName = req.getParameter("newTattooName");
        String newTattooLink = req.getParameter("newTattooLink");
        String tattooId = req.getParameter("tattooId");

        Tattoo tattoo = new Tattoo(tattooName,tattooLink);
        Tattoo newTattoo = new Tattoo(newTattooName,newTattooLink);
        if(comand.equals("delete")){
            tattooDao.delete(tattoo);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/adminForm.jsp");
            dispatcher.forward(req, resp);
        }
        if(comand.equals("create")){
            tattooDao.create(tattoo);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/adminForm.jsp");
            dispatcher.forward(req, resp);
        }
        if(comand.equals("update")){
            tattooDao.update(newTattoo,tattooId);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/adminForm.jsp");
            dispatcher.forward(req, resp);
        }
        if(comand.equals("read")){
            ResultSet resSet = tattooDao.read(tattooName);
            /*int columns = 0;
            try {
                columns = resSet.getMetaData().getColumnCount();
                while(resSet.next()){
                    for (int i = 1; i <= columns; i++){
                        System.out.print(resSet.getString(i) + "\t");
                    }
                    System.out.println();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }*/
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/adminForm.jsp");
            dispatcher.forward(req, resp);

        }

    }
}
