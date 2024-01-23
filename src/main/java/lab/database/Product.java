package lab.database;

import java.util.Objects;

public class Product {

    private String article;
    private String name;
    private String color;
    private int price;
    private int stockBalance;

    public Product() {}

    public Product(String article, String name, String color, int price, int stockBalance) {
        this.article = article;
        this.name = name;
        this.color = color;
        this.price = price;
        this.stockBalance = stockBalance;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockBalance() {
        return stockBalance;
    }

    public void setStockBalance(int stockBalance) {
        this.stockBalance = stockBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(article, product.article);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article);
    }

    @Override
    public String toString() {
        return "Product{" +
                ", article='" + article + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", stockBalance=" + stockBalance +
                '}';
    }

}
