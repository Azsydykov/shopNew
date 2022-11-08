package kg.megacom;
import kg.megacom.service.*;
import kg.megacom.service.ipml.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CrudOperationService crudOperationService = new CrudOperationServiceImpl();
        SellOperationService sellOperationService = new SellOperationServiceImpl();
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
