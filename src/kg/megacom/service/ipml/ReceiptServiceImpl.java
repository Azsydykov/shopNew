package kg.megacom.service.ipml;

import kg.megacom.db.DbHelper;
import kg.megacom.db.impl.DbHelperImpl;
import kg.megacom.models.Receipt;
import kg.megacom.models.Seller;
import kg.megacom.service.ReceiptService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReceiptServiceImpl implements ReceiptService {
    DbHelper dbHelper = new DbHelperImpl();
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    @Override
    public void createReceipt(Receipt receipt) {
        try {
            PreparedStatement ps = dbHelper.getConnection("insert into tb_receipt (add_date, seller_id, totalSum, num_of_receipt,fd) VALUES (?,?,?,?,?)");
            ps.setString(1, (sdf.format(new Date())));
            ps.setLong(2, receipt.getSeller().getId());
            ps.setDouble(3, receipt.getTotalSum());
            ps.setInt(4, receipt.getNumOfReceipt());
            ps.setLong(5, receipt.getFd());
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при создании чека");
        }
    }

    @Override
    public List<Receipt> getAllReceipts() {

        try {
            PreparedStatement ps = dbHelper.getConnection("select c.id, c.num_of_receipt, c.fd, c.totalSum, " +
                    "e.id as seller_id, e.name  from tb_receipt c inner join tb_seller e on e.id=c.seller_id ;");
            ResultSet resultSet = ps.executeQuery();
            List<Receipt> receiptList = new ArrayList<>();
            while (resultSet.next()) {
                Receipt receipt = new Receipt();
                receipt.setId(resultSet.getLong("id"));
                //  receipt.setAddDate(resultSet.getString("add_date"));

                Seller seller = new Seller();
                seller.setName(resultSet.getString("name"));
                seller.setId(resultSet.getInt("seller_id"));
                receipt.setTotalSum(resultSet.getDouble("totalSum"));
                receipt.setNumOfReceipt(resultSet.getInt("num_of_receipt"));
                receipt.setFd(resultSet.getInt("fd"));
                receiptList.add(receipt);
                receipt.setSeller(seller);
            }
            return receiptList;
        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при выводе списка чеков");
        }
    }

    @Override
    public Receipt getReceiptById(Long id) {
        try {
            PreparedStatement ps = dbHelper.getConnection("select c.id, c.num_of_receipt, c.fd, c.totalSum, e.id as seller_id, e.name  " +
                    "from tb_receipt c inner join tb_seller e on e.id=c.seller_id where c.id=(?)");
            ps.setLong(1, id);
            ResultSet resultSet = ps.executeQuery();
            Receipt receipt = new Receipt();
            while (resultSet.next()) {

                Seller seller = new Seller();
                seller.setName(resultSet.getString("name"));
                seller.setId(resultSet.getInt("seller_id"));

                receipt.setId(resultSet.getLong("id"));
                receipt.setTotalSum(resultSet.getDouble("totalSum"));
                receipt.setNumOfReceipt(resultSet.getInt("num_of_receipt"));
                receipt.setFd(resultSet.getInt("fd"));
                receipt.setSeller(seller);
            }
            return receipt;
        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при выводе списка чеков");
        }
    }

    @Override
    public void deleteReceipt(int id) {
        try {
            PreparedStatement ps = dbHelper.getConnection("delete from tb_receipt where id=?");
            ps.setInt(1, id);
            int result = ps.executeUpdate();
            if (result == 1) {
                System.out.println("Обьект успешно удалён");
            } else if (result == 0) {
                System.out.println("Запрос успешно выполнен. Заняло 0мс, 0 строк изменено");
            }
        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при удалении продавца!");
        }
    }

    @Override
    public void updateReceipt(int id) {

    }
}
