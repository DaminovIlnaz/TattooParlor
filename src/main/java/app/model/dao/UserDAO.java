package app.model.dao;

import app.entities.User;
import app.model.connectDb.DataBaseHandler;
import app.model.dbInfo.ConstUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends ConstUser {
    private Connection connection = DataBaseHandler.getConnection();

    public void addUser(User user){
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO "+USER_TABLE+"("+USER_NAME+","+USER_LOGIN+","+USER_PASSWORD+","+USER_ISADMIN+")"+" VALUES (?,?,?,?)");
            statement.setString(1,user.getName());
            statement.setString(2,user.getEmail());
            statement.setString(3,user.getPassword());
            statement.setString(4,user.getStatus());
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isFields(String fieldName1, String value1, String fieldName2, String value2){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + USER_TABLE + " WHERE " +
                fieldName1 + "=? AND " + fieldName2 + "=?";

        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(select);
            statement.setString(1,value1);
            statement.setString(2,value2);
            resSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if(resSet.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isField(String fieldName, String value) throws SQLException {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + USER_TABLE + " WHERE " +
                fieldName + "=?";

        PreparedStatement statement = null;


            statement = connection.prepareStatement(select);
            statement.setString(1,value);
            resSet = statement.executeQuery();


        try {
            if(resSet.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }




}//вся работа с пользователем должна быть тут!!!