package kg.megacom.models;

public class Product {

    private long id;
    private String name;
    private int amount;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public Product(String name) {
        this.name = name;
    }
    public Product (String name, int amount){
        this.name = name;
        this.amount = amount;
    }
    public Product(double price) {

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

}

