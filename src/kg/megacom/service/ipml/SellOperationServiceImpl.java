package kg.megacom.service.ipml;

import kg.megacom.service.ProductService;
import kg.megacom.service.SellOperationService;

public class SellOperationServiceImpl implements SellOperationService {

    ProductService productService = new ProductServiceImpl();

    @Override
    public void sell() {
        System.out.println("Выберите продукты для покупки");


        /*
        Вывести продукты для продажи
        Выбрать продукты (составить список продуктов для корзины и определить их количество) отдельный лист
        Создать чек
               крад чека
               Подсчёт стоимости всех продуктов с учётом количества
               Вывлд чека со стоимостью, список продуктов,




         */

    }
}
