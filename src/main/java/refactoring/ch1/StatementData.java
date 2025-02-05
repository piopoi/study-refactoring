package refactoring.ch1;

import java.util.List;

public class StatementData {

    private final String customer;
    private final List<Performance> performances;
    private int totalAmount;
    private int totalVolumeCredits;

    public StatementData(String customer, List<Performance> performances) {
        this.customer = customer;
        this.performances = performances;
    }

    public String getCustomer() {
        return customer;
    }

    public List<Performance> getPerformances() {
        return performances;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getTotalVolumeCredits() {
        return totalVolumeCredits;
    }

    public void setTotalVolumeCredits(int totalVolumeCredits) {
        this.totalVolumeCredits = totalVolumeCredits;
    }
}
