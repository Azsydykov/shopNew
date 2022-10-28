package kg.megacom.service.ipml;

import kg.megacom.db.DbHelper;
import kg.megacom.db.impl.DbHelperImpl;
import kg.megacom.models.Seller;
import kg.megacom.service.SellerService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SellerServiceImpl implements SellerService {

    DbHelper dbHelper = new DbHelperImpl();

    @Override
    public void createSeller(Seller seller) {
        try {
            PreparedStatement ps = dbHelper.getConnection("insert into tb_seller(name,age,shops_id) values (?,?,?)");
            ps.setString(1, seller.getName());
            ps.setInt(2, seller.getAge());
            ps.setInt(3, seller.getShopId());
            int result = ps.executeUpdate();
            if (result == 1) {
                System.out.println("Обьект успешно добавлен");
            } else if (result == 0) {
                System.out.println("Запрос успешно выполнен. Заняло 0мс, 0 строк изменено");
            }
        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при сохранении продавца");
        }
    }

    @Override
    public List<Seller> getAllSellers() {
        try {
            PreparedStatement ps = dbHelper.getConnection("select * from tb_seller");
            ResultSet resultSet = ps.executeQuery();
            List<Seller> sellerList = new ArrayList<>();
            while (resultSet.next()) {
                Seller seller = new Seller();
                seller.setId(resultSet.getInt("id"));
                seller.setName(resultSet.getString("name"));
                seller.setAge(resultSet.getInt("age"));
                seller.setShopId(resultSet.getInt("shop_id"));
                seller.setActive(resultSet.getBoolean("active"));
                sellerList.add(seller);
            }
            return sellerList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Seller getSellerById(Long id) {
        try {
            PreparedStatement ps = dbHelper.getConnection("select * from tb_seller where id= ?");
            ps.setInt(1, Math.toIntExact(id));
            ResultSet resultSet = ps.executeQuery();
            Seller seller = new Seller();
            while (resultSet.next()) {
                seller.setId(resultSet.getInt("id"));
                seller.setName(resultSet.getString("name"));
                seller.setAge(resultSet.getInt("age"));
                seller.setShopId(resultSet.getInt("shop_id"));
                seller.setActive(resultSet.getBoolean("active"));
            }
            return seller;

        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при выводе продавца!");
        }
    }

    @Override
    public void deleteSeller(long id) {
        try {
            PreparedStatement ps = dbHelper.getConnection("delete from tb_seller where id=?");
            ps.setLong(1, Math.toIntExact(id));
            int result = ps.executeUpdate();
            System.out.println(result);
            if (result == 1) {
                System.out.println("Обьект успешно удален");
            } else if (result == 0) {
                System.out.println("Запрос успешно выполнен. Заняло 0мс, 0 строк изменено");
            }
        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при удалении продавца ");
        }
    }
}
