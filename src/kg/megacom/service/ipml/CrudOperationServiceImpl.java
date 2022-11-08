package kg.megacom.service.ipml;
import kg.megacom.models.*;
import kg.megacom.service.*;
import java.util.Random;
import java.util.Scanner;

public class CrudOperationServiceImpl implements CrudOperationService {
    Random random = new Random();
    Scanner sc = new Scanner(System.in);
    SellerService sellerService = new SellerServiceImpl();
    ShopService shopService = new ShopServiceImpl();
    ReceiptService receiptService = new ReceiptServiceImpl();

    @Override
    public void crudObjects() {

        System.out.println("Выберите объект с которым хотите совершить операции.\n1-магазин, 2-продавец, 3-чеки");
        int answer = sc.nextInt();
        if (answer == 1) {
            System.out.println("Выберите операцию.\n" +
                    "Создать магазин - 1 \n" + "Получить список магазинов - 2 \n" +
                    "Изменить название магазина - 3 \n" +
                    "Удалить магазин - 4 \n" +
                    "Вывести магазин по id - 5");
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
                    System.out.println(shopService.shopList());
                    System.out.println("\n Введите id магазина, которую хотите изменить");
                    shopService.updateShop(sc.nextInt());
                    System.out.println("Объект изменён");
                    break;
                case 4:
                    System.out.println(shopService.shopList());
                    System.out.println("Введите id магазина для удаления");
                    shopService.deleteShop(sc.nextInt());
                    System.out.println("Объект удален");
                    break;
                case 5:
                    System.out.println("Введите id магазина для вывода");
                    System.out.println(shopService.findShopById(sc.nextLong()));
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
                    System.out.println(sellerService.getAllSellers());
                    System.out.println("\nВведите id продавца, которого хотите изменить: ");
                    sellerService.updateSeller(sc.nextInt());
                    break;
                case 4:
                    System.out.println(sellerService.getAllSellers());
                    System.out.println("\nВведите id продавца, которого хотите удалить: ");
                    sellerService.deleteSeller(sc.nextInt());
                    System.out.println("Продавец успешно удален");
                    break;
            }
        } else if (answer == 3) {
            System.out.println("Выберите операцию.\n" +
                    "Создать чек - 1 \n" + "Получить список - 2 \n" +
                    "Вывести чек по id- 3 \n" +
                    "Удалить чек - 4");
            int chooseOperation2 = sc.nextInt();
            switch (chooseOperation2) {
                case 1:
                    int num = random.nextInt(10000 - 0 + 1) + 0;
                    System.out.println(sellerService.getAllSellers());
                    System.out.println("Введите id продавца.");
                    int sellerId = sc.nextInt();

                    System.out.println("Введите общую сумму");
                    double totalSum = sc.nextDouble();
                    System.out.println("Введите номер чека");
                    int numOfReceipt = sc.nextInt();
                    int fd = num;

                    Receipt receipt = new Receipt();
                    receipt.setTotalSum(totalSum);
                    receipt.setNumOfReceipt(numOfReceipt);
                    receipt.setFd(fd);

                    Seller seller = new Seller();
                    seller.setId(sellerId);
                    receipt.setSeller(seller);

                    receiptService.createReceipt(receipt);
                    System.out.println("Вы успешно создали чек");
                    break;
                case 2:
                    System.out.println("\n Список чеков");
                    System.out.println(receiptService.getAllReceipts());
                    break;
                case 3:
                    System.out.println("\nВведите id чека, который необходимо вывести: ");
                    System.out.println(receiptService.getReceiptById(sc.nextLong()));
                    break;
                case 4:
                    System.out.println(receiptService.getAllReceipts());
                    System.out.println("\nВведите id чека, который необходимо удалить: ");
                    receiptService.deleteReceipt(sc.nextInt());
                    System.out.println("Чек успешно удален");
                    break;
            }
        }
    }
}
