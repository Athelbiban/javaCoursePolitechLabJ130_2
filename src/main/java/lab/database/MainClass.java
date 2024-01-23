package lab.database;

import java.sql.*;
import java.util.Arrays;

public class MainClass {

    public static void main(String[] args) {

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
        PersonRepositoryImpl pr = new PersonRepositoryImpl();

//        for (Product p : pr.getAll()) {
//            System.out.println(p);
//        }

        pr.printProductsFromOrder(5);

//        PersonRepository personRepo = new PersonRepositoryImpl();

//        System.out.println(personRepo.findById(150));

        //personRepo.getAll().forEach(System.out::println);
//        Person person = personRepo.findById(1);
//        System.out.println(person);
//        person.setEmail("Ethan_Newton8123@famism.biz");
//        person.setJobtitle("HRR Specialist");
//        person.setPhone("5-702-837-4314");
//        person.setFirstnamelastname("srgbsrgbsgrvfrvredf efv");
//        person = personRepo.update(person);
//        System.out.println(person);

//        Person newPerson = new Person();
//        newPerson.setJobtitle("Master");
//        newPerson.setFirstnamelastname("Boby");
//        newPerson.setPhone("79215658855");
//        newPerson.setEmail("df@dfg.df");
//        System.out.println("Записываем новый объект в бд");
//        newPerson = personRepo.create(newPerson);
//        System.out.println("Получаем новый объект из бд");
//        System.out.println(personRepo.findById(newPerson.getId()));
//        System.out.println("Удаляем новый объект из бд");
//        personRepo.remove(newPerson.getId());
//        System.out.println(personRepo.findById(newPerson.getId()));
//        System.out.println("Проверяем java-объект персоны");
//        System.out.println(newPerson);

    }
}
