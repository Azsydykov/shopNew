package kg.megacom.service;

import kg.megacom.models.Product;

import java.util.List;

public interface ProductService {
    void createProduct(Product product);
    public List<Product> getAllProducts();
    Product getProductById(Long id);

      void increasePrice();


}
