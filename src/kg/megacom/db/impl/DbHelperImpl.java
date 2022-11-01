package kg.megacom.db.impl;
import kg.megacom.db.DbHelper;
import java.sql.*;


public class DbHelperImpl implements DbHelper {

    public PreparedStatement getConnection(String sql) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:d:\\users\\asydykov\\Desktop\\SHOP\\SHOPnew.db");
            PreparedStatement ps = connection.prepareStatement(sql);
            return ps;
        } catch (SQLException throwables) {
            throw new RuntimeException("Ошибка при подключении к базе данных");
        }
    }

}
