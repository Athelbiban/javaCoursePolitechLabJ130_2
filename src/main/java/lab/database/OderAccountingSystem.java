package lab.database;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class OderAccountingSystem {

    private static final String URL = "jdbc:mysql://localhost:3306/store";
    private static final String USER = "root";
    private static final String PASSWORD = "143";

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

    public void toOrder(Order order) {

        int rows1, rows2 = 0;
        String sqlQuery = "INSERT orders (order_create, customer_name, customer_phone, " +
                "customer_email, customer_address, order_status, order_shipment) " +
                "VALUES (CURDATE(), ?, ?, ?, ?, \"P\", NULL)";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             PreparedStatement prepared = connection.prepareStatement(sqlQuery)) {

            prepared.setString(1, order.getPerson().getName());
            prepared.setString(2, order.getPerson().getPhone());
            prepared.setString(3, order.getPerson().getEmail());
            prepared.setString(4, order.getPerson().getAddress());

            rows1 = prepared.executeUpdate();

            for (String k : order.getProductMap().keySet()) {

                rows2 += statement.executeUpdate(
                        "INSERT position VALUES (" +
                                "(SELECT MAX(order_id) FROM orders), " +
                                "\"" + k + "\", " +
                                "(SELECT price FROM products WHERE article = \"" + k + "\"), " +
                                order.getProductMap().get(k) +
                                ");"
                );
            }

        System.out.println("В таблицу 'orders' добавлено строк: " + rows1);
        System.out.println("В таблицу 'position' добавлено строк: " + rows2);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
