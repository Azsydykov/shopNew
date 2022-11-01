package kg.megacom.service.ipml;

import kg.megacom.models.Product;
import kg.megacom.models.ProductReceipt;
import kg.megacom.service.ProductService;
import kg.megacom.service.SellOperationService;

import java.util.*;

public class SellOperationServiceImpl implements SellOperationService {
    ProductService productService = new ProductServiceImpl();
    TreeSet<Product> selectedProduct = new TreeSet<>();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void sell() {
        System.out.println("Выберите продукты для продажи: ");
        List<Product> productList = productService.getAllProducts();
        System.out.println(productList);
        ProductReceipt productReceipt = new ProductReceipt();

        //save ProductReceipt
        //save Receipt

        double countOfProduct;
        while (true) {
         //   Long productId = scanner.nextLong();
            System.out.println("Введите id продукта");
            Product product = productService.getProductById(scanner.nextLong());
            productReceipt.setProduct(product);
            System.out.println("Введите количество: ");
            productReceipt.setCount(scanner.nextDouble());
            productReceipt.setCost(product.getPrice());

        }


//
//        byte answer = 0;
//        int count = 0;
//        while (answer != 1) {
//            System.out.println("Выберите продукт для покупки: ");
//
//            String selectedProduct = scanner.next();
//            Product product =productService.getProductByName(selectedProduct);
//            System.out.println("Выберите количество: ");
//            int amount = scanner.nextInt();
//            ProductDetails productBasket = new ProductDetails(product, amount);
//
//            shoppingList.add(productBasket);
//
//            System.out.println("Продолжаете покупку? 1 нет, 0 да");
//            answer = scanner.nextByte();
//            count++;
//        }
//        System.out.println("Ваша корзина продуктов:");
//        for (ProductDetails item : shoppingList) {
//            if (item != null)
//                System.out.println(item);





        /*
        Вывести продукты для продажи
        Выбрать продукты (составить список продуктов для корзины и определить их количество) отдельный лист
        Создать чек
               CRUD чека
               Подсчёт стоимости всех продуктов с учётом количества
               Вывод чека со стоимостью, список продуктов,

         */

    }


}

