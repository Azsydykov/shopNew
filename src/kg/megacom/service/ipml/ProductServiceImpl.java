package kg.megacom.service.ipml;
import kg.megacom.db.DbHelper;
import kg.megacom.db.impl.DbHelperImpl;
import kg.megacom.exeption.ProductNotFoundExc;
import kg.megacom.models.Product;
import kg.megacom.service.ProductService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProductServiceImpl implements ProductService {
    DbHelper dbHelper = new DbHelperImpl();
    List<Product> productList = new ArrayList<>();


    @Override
    public void createProduct(Product product) {
        try {
            PreparedStatement ps = dbHelper.getConnection("insert into tb_product (name, price) values (?,?)");
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
            PreparedStatement ps = dbHelper.getConnection("select * from tb_product");
            ResultSet resultSet = ps.executeQuery();

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
            PreparedStatement ps = dbHelper.getConnection("select * from tb_product where id= ?");
            ps.setInt(1, Math.toIntExact(id));
            ResultSet resultSet = ps.executeQuery();
            Product product = new Product();
            while (resultSet.next()) {
                product.setId(resultSet.getLong("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getLong("price"));
            }
            if (product.getId() == 0) {
                throw new ProductNotFoundExc("Продукт с id=" + id + " не найден!");

            }
            return product;
        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при выводе продукта!");
        }
    }

    @Override
    public void increasePrice() {
      //  productList.stream().map(n->n.getPrice()+n.getPrice()*10/100).collect(Collectors.toList()).forEach(System.out::println);

        productList.stream().map(n -> {
            double m = n.getPrice() + (n.getPrice() * 10 / 100);
            return m;
        }).forEach(System.out::println);
    }
}
