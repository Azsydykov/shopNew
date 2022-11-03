package kg.megacom.service.ipml;

import kg.megacom.exeption.ProductNotFoundExc;
import kg.megacom.models.Product;
import kg.megacom.models.ProductReceipt;
import kg.megacom.models.Receipt;
import kg.megacom.models.Seller;
import kg.megacom.service.*;

import java.util.*;

public class SellOperationServiceImpl implements SellOperationService {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    ProductService productService = new ProductServiceImpl();
    SellerService sellerService = new SellerServiceImpl();
    ReceiptService receiptService = new ReceiptServiceImpl();

    ArrayList<Receipt> receiptList = new ArrayList<>();
    TreeSet<ProductReceipt> selectedProduct = new TreeSet<>();

    Product product = null;

    @Override
    public void sell() {
        System.out.println("Выберите продукты для продажи: ");
        List<Product> productList = productService.getAllProducts();
        System.out.println(productList);

        //save ProductReceipt
        //save Receipt
        byte answer = 0;
        while (answer != 1) {
            ProductReceipt productReceipt = new ProductReceipt();
            try {
                System.out.println("Введите id продукта");
                long productId = scanner.nextLong();
                product = productService.getProductById(productId);


                productReceipt.setProduct(product);
                System.out.println("Введите количество: ");
                double setCount = scanner.nextDouble();

                productReceipt.setCount(setCount);
                productReceipt.setCost(product.getPrice() * setCount);

                for (ProductReceipt item : selectedProduct) {
                    if (this.product.getId() == productId) {
                        System.out.println("Есть совпадение");
                        item.getCount();

                    }
                }
                selectedProduct.add(productReceipt);


            } catch (ProductNotFoundExc e) {
                System.out.println(e.getMessage());
                continue;
            }
            //productReceiptService.createProductReceipt(productReceipt);

            System.out.println("Продолжаете покупку? 1 нет, 0 да");
            answer = scanner.nextByte();
        }
        System.out.println("Ваша корзина продуктов:");
        System.out.println(selectedProduct);

        double Sum = 0;
        for (ProductReceipt item : selectedProduct) {
            Sum += item.getCost();
        }

        int num = random.nextInt(10000 - 0 + 1) + 0;

        System.out.println(sellerService.getAllSellers());
        System.out.println("Введите id продавца.");
        int sellerId = scanner.nextInt();

        System.out.println("Введите общую сумму");
        double totalSum = Sum;
        System.out.println("Введите номер чека");
        int numOfReceipt = scanner.nextInt();
        int fd = num;

        Receipt receipt = new Receipt();
        receipt.setAddDate(String.valueOf(new Date()));
        receipt.setTotalSum(totalSum);
        receipt.setNumOfReceipt(numOfReceipt);
        receipt.setFd(fd);

        Seller seller = new Seller();
        seller.setId(sellerId);
        receipt.setSeller(seller);

        receiptService.createReceipt(receipt);
        receiptList.add(receipt);
        System.out.println("Вы успешно создали чек");
        System.out.println(receipt);

    }
}



        /*
        Вывести продукты для продажи
        Выбрать продукты (составить список продуктов для корзины и определить их количество) отдельный лист
        Создать чек
               CRUD чека
               Подсчёт стоимости всех продуктов с учётом количества
               Вывод чека со стоимостью, список продуктов,
         */





