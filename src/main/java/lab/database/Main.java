package lab.database;

import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args) {

        OderAccountingSystem pr = new OderAccountingSystem();

//        Product[] products = new Product[5];
//        products[0] = new Product("3251615", "Стол кухонный", "белый", 8000, 12);
//        products[1] = new Product("3251616", "Стол кухонный", null, 8000, 15);
//        products[2] = new Product("3251617", "Стул столовый \"гусарский\"", "орех", 4000, 0);
//        products[3] = new Product("3251619", "Стул столовый с высокой спинкой", "белый", 3500, 37);
//        products[4] = new Product("3251620", "Стул столовый с высокой спинкой", "коричневый", 3500, 52);
//
//        for (Product p : products) {
//            System.out.println(p);
//        }

        // загрузить список продуктов и вывести его на экран
//        for (Product p : pr.getAll()) {
//            System.out.println(p);
//        }

        // загрузка и печать товаров из заказа с заданным id
//        pr.printProductsFromOrder(1);

        // зарегистрировать заказ, задать атрибуты параметрами метода
        Person person = new Person("Стас Востров", "(981)987-65-43", "vostrov@gmail.com", "ул. Книпович, 4-1");
        LinkedHashMap<String, Integer> productMap = new LinkedHashMap<>();
        productMap.put("3251616", 1);
        productMap.put("3251620", 1);
        productMap.put("3251619", 2);
        Order order = new Order(person, productMap);
        pr.toOrder(order);

    }
}
