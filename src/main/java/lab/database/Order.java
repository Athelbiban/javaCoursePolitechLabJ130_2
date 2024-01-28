package lab.database;

import java.util.LinkedList;
import java.util.Objects;

public class Order {

    private int id;
    private int amount;
    private int price;
    private Person person;
    private LinkedList<Product> productList;

    public Order(int id, int amount, int price, Person person, LinkedList<Product> productList) {
        this.id = id;
        this.amount = amount;
        this.price = price;
        this.person = person;
        this.productList = productList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public LinkedList<Product> getProductList() {
        return productList;
    }

    public void setProductList(LinkedList<Product> productList) {
        this.productList = productList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", amount=" + amount +
                ", price=" + price +
                ", person=" + person +
                ", productList=" + productList +
                '}';
    }
}
