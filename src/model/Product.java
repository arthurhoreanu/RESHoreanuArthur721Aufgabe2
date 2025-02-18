package model;

public class Product {

    private String name;
    private int price;
    private String universe;

    public Product(String name, int price, String universe) {
        this.name = name;
        this.price = price;
        this.universe = universe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUniverse() {
        return universe;
    }

    public void setUniverse(String universe) {
        this.universe = universe;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", universe='" + universe + '\'' +
                '}';
    }
}
