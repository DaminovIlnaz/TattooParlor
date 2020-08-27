package app.model.dao;

import app.entities.Tattoo;
import app.entities.User;
import app.model.connectDb.DataBaseHandler;
import app.model.dbInfo.ConstTattoos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TattooDAO extends ConstTattoos {
    private Connection connection = DataBaseHandler.getConnection();

    public ResultSet getAllTattoos(){
            String quant = "SELECT * FROM "+ TATTOOS_TABLE;
            PreparedStatement statement = null;
            ResultSet rs = null;
            try {
                statement = connection.prepareStatement(quant);
                rs = statement.executeQuery();
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return rs;
    }

    /*public ResultSet getQuantityTattoo(){
        String quant = "SELECT count(*) FROM " + TATTOOS_TABLE;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(quant);
            rs = statement.executeQuery();
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }*/

    public void delete(Tattoo tattoo){

        String create = "DELETE FROM " + TATTOOS_TABLE + " WHERE ("+TATTOO_NAME+" = ?)";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(create);
            statement.setString(1, tattoo.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(Tattoo newTattoo, String id){

       /* */

        String create = "UPDATE "+ TATTOOS_TABLE +" SET " + TATTOO_NAME +" = ?, " + TATTOO_LINK + " = ? WHERE (" +TATTOO_ID+" = ?);";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(create);
            statement.setString(1, newTattoo.getName());
            statement.setString(2, newTattoo.getLink());
            statement.setString(3, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void create(Tattoo tattoo){
        String create = "INSERT INTO "+TATTOOS_TABLE+"("+TATTOO_NAME+","+TATTOO_LINK+")"+" VALUES (?,?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(create);
            statement.setString(1, tattoo.getName());
            statement.setString(2, tattoo.getLink());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet read(String name){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + TATTOOS_TABLE + " WHERE " +
                TATTOO_NAME + "=?";

        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(select);
            statement.setString(1,name);
            resSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resSet;
    }


}
