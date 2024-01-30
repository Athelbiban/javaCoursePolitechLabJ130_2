package lab.database;

import java.util.LinkedHashMap;

public class Order {

    private Person person;
    private LinkedHashMap<String, Integer> productMap;

    public Order(Person person, LinkedHashMap<String, Integer> productMap) {
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

    @Override
    public String toString() {
        return "Order{" +
                "person=" + person +
                ", productMap=" + productMap +
                '}';
    }
}
