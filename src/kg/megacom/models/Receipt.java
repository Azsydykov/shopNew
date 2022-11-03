package kg.megacom.models;

public class Receipt {

    private long id;
    private String addDate;
    private Seller seller;
    private double totalSum;
    private int numOfReceipt;
    private int fd;


    public int getFd() {
        return fd;
    }

    public void setFd(int fd) {
        this.fd = fd;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Receipt() {
    }

    public long getId() {
        return id;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    public int getNumOfReceipt() {
        return numOfReceipt;
    }

    public void setNumOfReceipt(int numOfReceipt) {
        this.numOfReceipt = numOfReceipt;
    }

    @Override
    public String toString() {
        return " * ЧЕК * {" +
                "Id КАССИРА = " + seller.getId() +
                ", ИТОГ: " + " = " + totalSum +
                ", ДАТА: " + addDate +
                ", ЧЕК № = " + numOfReceipt +
                ", FD = " + fd +
                '}' + "\n";
    }
}
