package kg.megacom;

import kg.megacom.db.DbHelper;
import kg.megacom.db.impl.DbHelperImpl;
import kg.megacom.models.Product;
import kg.megacom.models.Seller;
import kg.megacom.models.Shop;
import kg.megacom.service.*;
import kg.megacom.service.ipml.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CrudOperationService crudOperationService = new CrudOperationServiceImpl();
        SellOperationService sellOperationService = new SellOperationServiceImpl();
        ReceiptService receiptService = new ReceiptServiceImpl();

        System.out.println("Перейти в управление справочником - 0");
        System.out.println("Перейти в управление продажами - 1");


        switch (scanner.nextInt()) {
            case 0:
                crudOperationService.crudObjects();
                break;
            case 1:
                sellOperationService.sell();
        }
    }
}
