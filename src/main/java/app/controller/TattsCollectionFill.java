package app.controller;

import app.entities.Tattoo;
import app.model.dao.TattooDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/fill")
public class TattsCollectionFill extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map map = new HashMap();
        String name = "";
        String link = "";

        TattooDAO td = new TattooDAO();
        ResultSet resSet = td.getAllTattoos();
        int columns = 0;



        try {
            columns = resSet.getMetaData().getColumnCount();
            int count = 0;
            while(resSet.next()){
                for (int i = 1; i <= columns; i++){
                    String str = resSet.getString(i);
                    Pattern p1 = Pattern.compile("^[0-9]+$");
                    Pattern p2 = Pattern.compile("^[a-z]+$");
                    Matcher m1 = p1.matcher(str);
                    Matcher m2 = p2.matcher(str);
                    if(!m1.matches()){
                        if(m2.matches()){
                            name = str;
                        }
                        else {
                            link = str;

                        }
                    }
                }
                Tattoo tattoo = new Tattoo(name,link);
                map.put(count, tattoo);
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("tatts",map);
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/tattsCollectionForm.jsp");
        dispatcher.forward(req, resp);


    }
}


/*
 ВЫВОД КОЛИЧЕСТВА ТАТУХ В ТАБЛЕ
 TattooDAO td = new TattooDAO();
        ResultSet resSet = td.getQuantityTattoo();
        int columns = 0;
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
