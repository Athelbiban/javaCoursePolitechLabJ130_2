package lab.database;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PersonRepositoryImpl implements PersonRepository{

    String url = "jdbc:mysql://localhost:3306/store";
    String user = "root";
    String password = "143";

    @Override
    public List<Person> getAll() {
        List<Person> persons = new LinkedList<>();
        try ( Connection connection = getConnection();
              Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("select * from person");
            while (rs.next()){
                Integer id = rs.getInt("id");
                String jobtitle = rs.getString("jobtitle");
                String firstnamelastname = rs.getString("firstnamelastname");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                persons.add(new Person(id, jobtitle, firstnamelastname, phone, email));
            }
        }catch (SQLException e){

        }
        return persons;
    }

    @Override
    public Person findById(int id) {
        Person person = null;
        try ( Connection connection = getConnection();
              Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("select * from person where id=" + id);
            if(rs.next()) {
                String jobtitle = rs.getString("jobtitle");
                String firstnamelastname = rs.getString("firstnamelastname");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                person = new Person(id, jobtitle, firstnamelastname, phone, email);
            }
        }catch (SQLException e){

        }
        return person;
    }

    @Override
    public Person findByJobtitleNamePhoneEmail(String jobtitle, String name, String phone, String email) {
        Person person = null;
        String sql = "select * from person where jobtitle=? and firstnamelastname=? and phone=? and email=?";
        try ( Connection connection = getConnection();
              PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, jobtitle);
            ps.setString(2, name);
            ps.setString(3, phone);
            ps.setString(4, email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Integer id = rs.getInt("id");
                String jobt = rs.getString("jobtitle");
                String firstnamelastname = rs.getString("firstnamelastname");
                String phonee = rs.getString("phone");
                String emaill = rs.getString("email");
                person = new Person(id, jobt, firstnamelastname, phonee, emaill);
            }
        }catch (SQLException e){

        }
        return person;
    }

    @Override
    public Person update(Person person) {
        String sql = "update person set jobtitle=?, phone=?, email=? where id=?";
        try ( Connection connection = getConnection();
              PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(4, person.getId());
            ps.setString(1, person.getJobtitle());
            ps.setString(2, person.getPhone());
            ps.setString(3, person.getEmail());
            ps.execute();
        }catch (SQLException e){

        }
        return findById(person.getId());
    }

    @Override
    public int remove(int id) {
        int count = 0;
        try ( Connection connection = getConnection();
              Statement statement = connection.createStatement()) {
            count = statement.executeUpdate("delete from person where id=" + id);
        }catch (SQLException e){

        }
        return count;
    }

    @Override
    public Person create(Person person) {
        String sql = "insert into person (jobtitle, firstnamelastname, phone, email) value (?, ?, ?, ?)";
        try ( Connection connection = getConnection();
              PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, person.getJobtitle());
            ps.setString(2, person.getFirstnamelastname());
            ps.setString(3, person.getPhone());
            ps.setString(4, person.getEmail());
            ps.execute();
        }catch (SQLException e){

        }
        return findByJobtitleNamePhoneEmail(person.getJobtitle(), person.getFirstnamelastname(), person.getPhone(), person.getEmail());
    }



    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
