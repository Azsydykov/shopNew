package kg.megacom.models;

public class Seller {
    private long id;
    private String name;
    private int age;
    private int shopId;
    private boolean active;


    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public Seller(long id, String name, int age, int shopId, boolean active) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.shopId= shopId;
        this.active = active;
    }
    public Seller(String name, int age, int shopId) {

        this.name = name;
        this.age = age;
        this.shopId= shopId;

    }
    public Seller() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name=" + name +
                ", age=" + age +
                ", shopId=" + shopId +
                ", active=" + active +
                '}';
    }
}
