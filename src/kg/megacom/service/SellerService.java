package kg.megacom.service;

import kg.megacom.models.Seller;

import java.util.List;

public interface SellerService {
    public void createSeller(Seller seller);
    public List<Seller> getAllSellers();
    Seller getSellerById(Long id);
    public void deleteSeller(int id);
    void updateSeller(int id);
}
