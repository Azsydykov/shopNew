package kg.megacom.service.ipml;

import kg.megacom.db.DbHelper;
import kg.megacom.db.impl.DbHelperImpl;
import kg.megacom.models.Product;
import kg.megacom.models.ProductReceipt;
import kg.megacom.models.Receipt;
import kg.megacom.service.ProductReceiptService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductReceiptServiceImpl implements ProductReceiptService {
    DbHelper dbHelper = new DbHelperImpl();

    @Override
    public void createProductReceipt(ProductReceipt receipt) {
        try {
            PreparedStatement ps = dbHelper.getConnection("insert into tb_product_receipt (product_id, " +
                    "receipt_id, count_of_product,cost) values (?,?,?,?);");
            ps.setLong(1, receipt.getProduct().getId());
            ps.setLong(2, receipt.getReceipt().getId());
            ps.setDouble(3,receipt.getCount());
            ps.setDouble(4,receipt.getCost());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка при сохранении чека");
        }
    }

    @Override
    public List<ProductReceipt> getAllProductReceipts() {
        try {
            PreparedStatement ps = dbHelper.getConnection("SELECT * from tb_product_receipt");
            ResultSet resultSet = ps.executeQuery();
            List<ProductReceipt> productReceiptList = new ArrayList<>();
            while (resultSet.next()) {
                ProductReceipt productReceipt = new ProductReceipt();
                productReceipt.setId(resultSet.getLong("id"));
                productReceipt.setCount(resultSet.getDouble("count_of_product"));
                productReceipt.setCost(resultSet.getDouble("cost"));

                Product product = new Product();
                product.setId(resultSet.getLong("product_id"));
                Receipt receipt = new Receipt();
                receipt.setId(resultSet.getLong("receipt_id"));

                productReceipt.setProduct(product);
                productReceipt.setReceipt(receipt);
                productReceiptList.add(productReceipt);
            }
            return productReceiptList;
        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при выводе списка чеков");
        }
    }

    @Override
    public ProductReceipt findById(Long id) {
        return null;
    }
}
