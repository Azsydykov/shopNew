package kg.megacom.db;

import kg.megacom.models.Product;
import kg.megacom.models.Seller;
import kg.megacom.models.Shop;

import java.util.List;

public interface DbHelper {

    void createShop(Shop shop);

    void createSeller(Seller seller);
    public List<Seller> getAllSellers();
    Seller getSellerById(Long id);
    public void deleteSeller(long id);
    void createProduct(Product product);
    public List<Product> getAllProducts();
    Product getProductById(Long id);



}
