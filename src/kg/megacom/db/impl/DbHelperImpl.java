package kg.megacom.db.impl;

import kg.megacom.db.DbHelper;
import kg.megacom.models.Product;
import kg.megacom.models.Seller;
import kg.megacom.models.Shop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbHelperImpl implements DbHelper {

    private PreparedStatement getConnection(String sql) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:d:\\users\\asydykov\\Desktop\\SHOP\\SHOPnew.db");
            PreparedStatement ps = connection.prepareStatement(sql);
            return ps;
        } catch (SQLException throwables) {
            throw new RuntimeException("Ошибка при подключении к базе данных");
        }
    }

    @Override
    public void createShop(Shop shop) {
        try {
            PreparedStatement ps = getConnection("insert into tb_shop(name) values (?)");
            ps.setString(1, shop.getName());
            int result = ps.executeUpdate();
            if (result == 1) {
                System.out.println("Обьект успешно добавлен");
            } else if (result == 0) {
                System.out.println("Запрос успешно выполнен. Заняло 0мс, 0 строк изменено");
            }
        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при сохранении магазина");
        }
    }

    @Override
    public void createSeller(Seller seller) {
        try {
            PreparedStatement ps = getConnection("insert into tb_seller(name,age,shops_id) values (?,?,?)");
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
            PreparedStatement ps = getConnection("select * from tb_seller");
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
            PreparedStatement ps = getConnection("select * from tb_seller where id= ?");
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
            PreparedStatement ps = getConnection("delete from tb_seller where id=?");
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

    @Override
    public void createProduct(Product product) {
        try {
            PreparedStatement ps = getConnection("insert into tb_product (name, price) values (?,?)");
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());

            int result = ps.executeUpdate();
            if (result == 1) {
                System.out.println("Обьект успешно добавлен");
            } else if (result == 0) {
                System.out.println("Запрос успешно выполнен. Заняло 0мс, 0 строк изменено");
            }
        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при добавлении продукта");
        }
    }

    @Override
    public List<Product> getAllProducts() {
        try {
            PreparedStatement ps = getConnection("select * from tb_product");
            ResultSet resultSet = ps.executeQuery();
            List<Product> productList = new ArrayList<>();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getLong("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                productList.add(product);
            }
            return productList;

        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при выводе списка продуктов");
        }
    }

    @Override
    public Product getProductById(Long id) {
        try {
            PreparedStatement ps = getConnection("select * from tb_product where id= ?");
            ps.setInt(1, Math.toIntExact(id));
            ResultSet resultSet = ps.executeQuery();
            Product product = new Product();
            while (resultSet.next()) {
                product.setId(resultSet.getLong("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getLong("price"));
            }
            return product;
        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при выводе продукта!");
        }
    }


}
