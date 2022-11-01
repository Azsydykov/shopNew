package kg.megacom.service.ipml;

import kg.megacom.db.DbHelper;
import kg.megacom.db.impl.DbHelperImpl;
import kg.megacom.models.ProductReceipt;
import kg.megacom.service.ProductReceiptService;

import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        return null;
    }

    @Override
    public ProductReceipt findById(Long id) {
        return null;
    }
}
