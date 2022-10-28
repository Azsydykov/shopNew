package kg.megacom.db.impl;

import kg.megacom.db.DbHelper;
import kg.megacom.models.Product;
import kg.megacom.models.Seller;
import kg.megacom.models.Shop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
