package kg.megacom;

import kg.megacom.db.DbHelper;
import kg.megacom.db.impl.DbHelperImpl;
import kg.megacom.models.Product;
import kg.megacom.models.Seller;
import kg.megacom.models.Shop;
import kg.megacom.service.CrudOperationService;
import kg.megacom.service.SellOperationService;
import kg.megacom.service.ipml.CrudOperationServiceImpl;
import kg.megacom.service.ipml.SellOperationServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CrudOperationService crudOperationService = new CrudOperationServiceImpl();

        SellOperationService sellOperationService = new SellOperationServiceImpl();

        System.out.println("Перейти в управление справочником ");


        //  System.out.println("Введите название магазина: ");
        //  dbHelper.createShop(new Shop(scanner.next()));

        //  System.out.println("Введите данные продавца (имя, возраст, id_магазина): ");
        //  dbHelper.createSeller(new Seller(scanner.next(),scanner.nextInt(),scanner.nextInt()));

        //   System.out.println("Введите id продукта, для вывода");
        //    System.out.println(dbHelper.getProductById(scanner.nextLong()));

        //   System.out.println("Введите продукт (название, цена): ");
        //   dbHelper.createProduct(new Product(scanner.next(), scanner.nextDouble()));

        //    System.out.println(dbHelper.getAllProducts());
        //    System.out.println(dbHelper.getAllSellers());

        //    System.out.println("Введите id продавца, для вывода: ");
        //    System.out.println(dbHelper.getSellerById(scanner.nextLong()));

        //     System.out.println("Введите id продавца для удаления: ");
        //    dbHelper.deleteSeller(scanner.nextLong());


    }
}
