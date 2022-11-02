package kg.megacom.models;

public class Product implements Comparable<Product>{

    private long id;
    private String name;

    private double price;

    public Product(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return
                "id=" + id +", "+ name  +
                ", price=" + price+"\n";

    }

    @Override
    public int compareTo(Product o) {
        return o.name.compareTo(o.getName());
    }
}

