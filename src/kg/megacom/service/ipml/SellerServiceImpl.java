package kg.megacom.service.ipml;

import kg.megacom.db.DbHelper;
import kg.megacom.db.impl.DbHelperImpl;
import kg.megacom.models.Seller;
import kg.megacom.models.Shop;
import kg.megacom.service.SellerService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SellerServiceImpl implements SellerService {

    DbHelper dbHelper = new DbHelperImpl();

    @Override
    public void createSeller(Seller seller) {
        try {
            PreparedStatement ps = dbHelper.getConnection("insert into tb_seller(name,age,shops_id) values (?,?,?)");
            ps.setString(1, seller.getName());
            ps.setInt(2, seller.getAge());
            ps.setInt(3, seller.getShopId().getId());
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
            PreparedStatement ps = dbHelper.getConnection("select s.id,s.name,s.age,  sh.id as shop_id, sh.name as shop_name from tb_seller s INNER join tb_shop sh on sh.id=s.shop_id\n");
            ResultSet resultSet = ps.executeQuery();
            List<Seller> sellerList = new ArrayList<>();
            while (resultSet.next()) {
                Seller seller = new Seller();
                seller.setId(resultSet.getInt("id"));
                seller.setName(resultSet.getString("name"));
                seller.setAge(resultSet.getInt("age"));
                Shop shop = new Shop();
                shop.setId(resultSet.getInt("shop_id"));
                shop.setName(resultSet.getString("name"));
                seller.setShopId(shop);
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
                Shop shop = new Shop();
                shop.setId(resultSet.getInt("shop_id"));
                seller.setShopId(shop);
                seller.setActive(resultSet.getBoolean("active"));
            }
            return seller;
        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при выводе продавца!");
        }
    }

    @Override
    public void deleteSeller(int id) {
        try {
            PreparedStatement ps = dbHelper.getConnection("delete from tb_employees where id=?");
            ps.setInt(1, id);
            int result = ps.executeUpdate();
            if (result == 1) {
                System.out.println("Обьект успешно удалён");
            } else if (result == 0) {
                System.out.println("Запрос успешно выполнен. Заняло 0мс, 0 строк изменено");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateSeller(int id) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя...");
        String name = sc.next();
        try {
            PreparedStatement ps = dbHelper.getConnection("Update tb_seller set name=? where id=?");
            ps.setString(1, name);
            ps.setInt(2, id);
            int result = ps.executeUpdate();
            if (result == 1) {
                System.out.println("Обьект успешно изменён");
            } else if (result == 0) {
                System.out.println("Запрос успешно выполнен. Заняло 0мс, 0 строк изменено");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
