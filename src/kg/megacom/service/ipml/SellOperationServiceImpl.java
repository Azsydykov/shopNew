package kg.megacom.service.ipml;

import javafx.scene.chart.AxisBuilder;
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
    ProductReceiptService productReceiptService = new ProductReceiptServiceImpl();
    ArrayList<Receipt> receiptList = new ArrayList<>();
    //  TreeSet<ProductReceipt> selectedProduct = new TreeSet<>();
    List<ProductReceipt> selectedProduct = new ArrayList<>();


    Product product = null;

    @Override
    public void sell() {
        System.out.println("Выберите продукты для продажи: ");
        List<Product> productList = productService.getAllProducts();
        // productService.increasePrice();

        System.out.println(productList);

        //save ProductReceipt
        //save Receipt

        byte answer = 0;
        while (answer != 1) {
            ProductReceipt productReceipt = new ProductReceipt();
            System.out.println("Введите id продукта");
            try {
                long productId = scanner.nextLong();
                product = productService.getProductById(productId);
            } catch (ProductNotFoundExc e) {
                System.out.println(e.getMessage());
                continue;
            }
            productReceipt.setProduct(product);
            System.out.println("Введите количество: ");
            double setCount = scanner.nextDouble();
            Receipt receipt = new Receipt();
            receipt.setId(receipt.getId());
            productReceipt.setReceipt(receipt);

            productReceipt.setCount(setCount);
            productReceipt.setCost(product.getPrice() * setCount);

            selectedProduct.add(productReceipt);

            productReceiptService.createProductReceipt(productReceipt);


            System.out.println("Продолжаете покупку? 1 нет, 0 да");
            answer = scanner.nextByte();
        }

        System.out.println(selectedProduct);

        double Sum = 0;
        for (ProductReceipt item : selectedProduct) {
            Sum += item.getCost();
        }

        int num = random.nextInt(10000 - 0 + 1) + 0;
        System.out.println(sellerService.getAllSellers());
        System.out.println("Введите id продавца.");
        int sellerId = scanner.nextInt();

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

        receiptList.add(receipt);

        System.out.println("Список продуктов:");
        System.out.println(selectedProduct);

        System.out.println("Ваш чек:");
        System.out.println(receiptList);

        receiptService.createReceipt(receipt);

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





