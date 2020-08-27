package app.model.dao;

import app.entities.Tattoo;
import app.entities.User;
import app.model.connectDb.DataBaseHandler;
import app.model.dbInfo.ConstOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAO extends ConstOrder {
    private Connection connection = DataBaseHandler.getConnection();
    public void create(String login) throws SQLException {
        String create = "INSERT INTO "+ORDER_TABLE+"("+ORDER_LOGIN+")"+" VALUES (?)";
        PreparedStatement statement = null;
            statement = connection.prepareStatement(create);
            statement.setString(1, login);
            statement.executeUpdate();
    }

    public ResultSet getAllOrder(){
        String quant = "SELECT count(*) FROM " + ORDER_TABLE;
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
}
