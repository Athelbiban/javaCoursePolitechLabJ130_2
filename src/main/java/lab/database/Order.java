package lab.database;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Objects;

public class Order {

//    private int id;
//    private int amount;
//    private int price;
    private Person person;
    private LinkedHashMap<String, Integer> productMap;

    public Order(Person person, LinkedHashMap<String, Integer> productMap) {
//        this.id = id;
//        this.amount = amount;
        this.person = person;
        this.productMap = productMap;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public LinkedHashMap<String, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(LinkedHashMap<String, Integer> productMap) {
        this.productMap = productMap;
    }
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Order order)) return false;
//        return id == order.id;
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }

    @Override
    public String toString() {
        return "Order{" +
//                "id=" + id +
//                ", amount=" + amount +
                "person=" + person +
                ", productMap=" + productMap +
                '}';
    }
}
