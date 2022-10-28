package kg.megacom.db;

import kg.megacom.models.Product;
import kg.megacom.models.Seller;
import kg.megacom.models.Shop;

import java.sql.PreparedStatement;
import java.util.List;

public interface DbHelper {
    public PreparedStatement getConnection(String sql);







}
