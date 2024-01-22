package lab.database;

import java.sql.SQLException;
import java.util.List;

public interface PersonRepository {

    List<Person> getAll();

    Person findById(int id);

    Person findByJobtitleNamePhoneEmail(String jobtitle, String name, String phone, String email);

    Person update(Person person);

    int remove(int id);

    Person create(Person person);
}
