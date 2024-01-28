package lab.database;

import java.sql.SQLException;
import java.util.List;

public interface PersonRepository {

    List<Product> getAll();

    void printProductsFromOrder(int id);
    void orderRegistration(Order order);

//    Person findByJobtitleNamePhoneEmail(String jobtitle, String name, String phone, String email);

//    Person update(Person person);

//    int remove(int id);

//    Person create(Person person);
}
