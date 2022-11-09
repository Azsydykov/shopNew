package kg.megacom.service;

import kg.megacom.models.ProductReceipt;

import java.util.List;

public interface ProductReceiptService {

     void createProductReceipt(ProductReceipt receipt);
     List<ProductReceipt> getAllProductReceipts();
     ProductReceipt findById(Long id);


    long getLastId();
}
