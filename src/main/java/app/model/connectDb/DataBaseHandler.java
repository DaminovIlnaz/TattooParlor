package app.model.connectDb;

import app.model.dbInfo.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseHandler extends Config {
    private static Connection connection;

    public static Connection getConnection(){
        if(connection == null){

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName+"?useLegacyDatetimeCode=false&amp&serverTimezone=UTC", dbUser, dbPass);
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
            return connection;
    }
}
