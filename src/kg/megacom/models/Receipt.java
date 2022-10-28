package kg.megacom.models;

import java.util.Date;
import java.util.Random;

public class Receipt {

    private double id;
    private Date addDate;
    private int totalSum;
    private int numOfReceipt;

    public Receipt( Date addDate, int totalSum, int numOfReceipt) {
        this.id = Math.random();
        this.addDate = addDate;
        this.totalSum = totalSum;
        this.numOfReceipt = numOfReceipt;
    }

    public Receipt() {
    }

    public double getId() {
        return id;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public int getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(int totalSum) {
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
        return "Receipt{" +
                "id=" + id +
                ", addDate=" + addDate +
                ", totalSum=" + totalSum +
                ", numOfReceipt=" + numOfReceipt +
                '}';
    }
}
