package lab.database;

import java.sql.*;

public class MainClass {

    public static void main(String[] args) {

        PersonRepository personRepo = new PersonRepositoryImpl();

        System.out.println(personRepo.findById(150));

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
