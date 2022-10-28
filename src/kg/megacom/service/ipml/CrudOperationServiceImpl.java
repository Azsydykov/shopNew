package kg.megacom.service.ipml;

import kg.megacom.models.Seller;
import kg.megacom.models.Shop;
import kg.megacom.service.CrudOperationService;
import kg.megacom.service.SellerService;
import kg.megacom.service.ShopService;

import java.util.Scanner;

public class CrudOperationServiceImpl implements CrudOperationService {

    SellerService sellerService = new SellerServiceImpl();
    ShopService shopService = new ShopServiceImpl();

    @Override
    public void crudObjects() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите объект с которым хотите совершить операции.\n1-магазин ,2-продавец");
        int answer = sc.nextInt();
        if (answer == 1) {
            System.out.println("Выберите операцию.\n" +
                    "Создать магазин - 1 \n" + "Получить список магазинов - 2 \n" +
                    "Изменить название магазина - 3 \n" +
                    "Удалить магазин - 4");
            int chooseOperation = sc.nextInt();
            switch (chooseOperation) {
                case 1:
                    System.out.println("Введите название магазина.");
                    String shopName = sc.next();
                    Shop shop = new Shop(shopName);
                    shopService.createShop(shop);
                    System.out.println("Вы успешно создали магазин с названием " + shopName);
                    break;
                case 2:
                    System.out.println("\n Список магазинов");
                    System.out.println(shopService.shopList());
                    break;
                case 3:
                    System.out.println("\n Введите id магазина, которую хотите изменить");
                    shopService.updateShop(sc.nextInt());
                    System.out.println("Объект изменён");
                    break;
                case 4:
                    System.out.println("Введите id магазина для удаления");
                    shopService.deleteShop(sc.nextInt());
                    System.out.println("Объект удален");
                    break;

            }
        } else if (answer == 2) {
            System.out.println("Выберите операцию.\n" +
                    "Создать продавца - 1 \n" + "Получить список продавцов - 2 \n" +
                    "Изменить имя прдодавца- 3 \n" +
                    "Удалить продавца - 4");
            int chooseOperation1 = sc.nextInt();
            switch (chooseOperation1) {
                case 1:
                    System.out.println("Введите имя продавца.");
                    String sellerName = sc.next();
                    System.out.println("Введите возраст продавца.");
                    int age = sc.nextInt();
                    System.out.println("Введите id Магазина");

                    System.out.println(shopService.shopList());

                    int shopId = sc.nextInt();

                    Seller seller = new Seller();
                    seller.setName(sellerName);
                    seller.setAge(age);
                    Shop shop = new Shop();
                    shop.setId(shopId);
                    seller.setShopId(shop);
                    sellerService.createSeller(seller);
                    System.out.println("Вы успешно создали продавца с именем " + sellerName);
                    break;
                case 2:
                    System.out.println("\n Список продавцов");
                    System.out.println(sellerService.getAllSellers());
                    break;
                case 3:
                    System.out.println("\n Введите имя");
                    sellerService.updateSeller(1);
                    break;
                case 4:
                    sellerService.deleteSeller(1);
                    System.out.println("Продавец 1 удален");
                    break;

            }
        }
    }
}
