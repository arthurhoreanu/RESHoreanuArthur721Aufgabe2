package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Character {

    private int id;
    private String name;
    private String region;
    private List<Product> products = new ArrayList<Product>();

    public Character(int id, String name, String region) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", products=" + products +
                '}';
    }
}
