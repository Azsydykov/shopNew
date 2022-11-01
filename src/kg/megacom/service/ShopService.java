package kg.megacom.service;

import kg.megacom.models.Shop;

import java.util.List;

public interface ShopService {
    void createShop(Shop shop);
    List<Shop> shopList();
    void updateShop(int id);
    void deleteShop(int id);
    Shop findShopById(Long id);
}
