package kg.megacom.service.ipml;

import kg.megacom.db.DbHelper;
import kg.megacom.db.impl.DbHelperImpl;
import kg.megacom.models.Shop;
import kg.megacom.service.ShopService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopServiceImpl implements ShopService {

    DbHelper dbHelper = new DbHelperImpl();

    @Override
    public void createShop(Shop shop) {
        try {
            PreparedStatement ps = dbHelper.getConnection("insert into tb_shop(name) values (?)");
            ps.setString(1, shop.getName());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при сохранении магазина");
        }
    }

    @Override
    public List<Shop> shopList() {
        try {
            PreparedStatement ps = dbHelper.getConnection("select * from tb_shop");
            ResultSet resultSet = ps.executeQuery();
            List<Shop> shopList = new ArrayList<>();
            while (resultSet.next()) {
                Shop shop = new Shop();
                shop.setId(resultSet.getInt("id"));
                shop.setName(resultSet.getString("name"));
                shopList.add(shop);
            }
            return shopList;
        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при выводе списка магазинов");
        }
    }

    @Override
    public void updateShop(int id) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите новое название: ");
        String name = scanner.next();
        try {
            PreparedStatement preparedStatement = dbHelper.getConnection("Update tb_shop set name= ? where id=?");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при изменении названия магазина");
        }
    }

    @Override
    public void deleteShop(int id) {
        try {
            PreparedStatement ps = dbHelper.getConnection("delete from tb_shop where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при удалении магазина");
        }
    }
}

