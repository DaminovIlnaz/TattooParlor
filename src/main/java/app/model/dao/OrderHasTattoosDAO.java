package app.model.dao;

import app.entities.Tattoo;
import app.model.connectDb.DataBaseHandler;
import app.model.dbInfo.ConstOrdersHasTattoos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderHasTattoosDAO extends ConstOrdersHasTattoos {
    private Connection connection = DataBaseHandler.getConnection();

    public void create(String num, String name) throws SQLException {
        String create = "INSERT INTO "+O_HAS_T_TABLE+"("+O_HAS_T_IDORDERS+","+O_HAS_T_IDTATTOOS+")"+" VALUES (?,?)";
        PreparedStatement statement = null;
            statement = connection.prepareStatement(create);
            statement.setString(1, num);
            statement.setString(2, name);
            statement.executeUpdate();

    }
}
