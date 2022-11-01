package kg.megacom.models;

public class ProductReceipt {
    private long id;
    private Product product;
    private Receipt receipt;
    private double count;
    private double cost;

    public ProductReceipt(long id, Product product, Receipt receipt, double count, double cost) {
        this.id = id;
        this.product = product;
        this.receipt = receipt;
        this.count = count;
        this.cost = cost;
    }

    public ProductReceipt() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }


    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

}
