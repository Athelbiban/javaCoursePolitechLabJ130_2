package lab.database;

import org.w3c.dom.ls.LSOutput;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PersonRepositoryImpl implements PersonRepository{

    private static final String URL = "jdbc:mysql://localhost:3306/store";
    private static final String USER = "root";
    private static final String PASSWORD = "143";
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    @Override
    public List<Product> getAll() {

        List<Product> products = new LinkedList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery(
                    "SELECT article, product_name, color, pr.price, stock_balance " +
                        "FROM products pr " +
                            "LEFT JOIN position p USING(article) " +
                            "LEFT JOIN orders o USING(order_id) " +
                        "GROUP BY article " +
                        "ORDER BY article;"
            );

            while (rs.next()){
                String article = rs.getString("article");
                String name = rs.getString("product_name");
                String color = rs.getString("color");
                int price = rs.getInt("price");
                int stockBalance = rs.getInt("stock_balance");
                products.add(new Product(article, name, color, price, stockBalance));
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return products;
    }

    @Override
    public void printProductsFromOrder(int id) {

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery(
                    "SELECT product_name, color " +
                        "FROM position LEFT JOIN products USING(article) " +
                        "WHERE order_id = " + id + " " +
                        "GROUP BY article;"
            );

            while (rs.next()) {
                String name = rs.getString("product_name");
                String color = rs.getString("color");
                System.out.println(color != null ? name + " " + color : name);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void toOrder(Order order) {

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

             int result = statement.executeUpdate(
                     "INSERT orders (order_create, customer_name, customer_phone, customer_email, customer_address, order_status, order_shipment) VALUES " +
                             "(" +
                             "CURDATE(), " +
                             "\"" + order.getPerson().getName() + "\"" + ", " +
                             "\"" + order.getPerson().getPhone() + "\"" + ", " +
                             "\"" + order.getPerson().getEmail() + "\"" + ", " +
                             "\"" + order.getPerson().getAddress() + "\"" + ", " +
                             "'P', " +
                             "NULL" +
                             ");"
             );

            System.out.println("Добавлено строк: " + result);

            int result2 = statement.executeUpdate(
                    "INSERT position VALUES " +
                            "(" +
                            order.getPerson().getId() + ", " +
                            "\"" + order.getProductMap() + "\"" + ", " +
                            ");"
            );

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
