package kg.megacom.service.ipml;

import kg.megacom.db.DbHelper;
import kg.megacom.db.impl.DbHelperImpl;
import kg.megacom.models.Shop;
import kg.megacom.service.ShopService;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ShopServiceImpl implements ShopService {

    DbHelper dbHelper = new DbHelperImpl();

    @Override
    public void createShop(Shop shop) {
        try {
            PreparedStatement ps = dbHelper.getConnection("insert into tb_shop(name) values (?)");
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
}
