package training.qa.jmx;

import java.io.Serializable;

/**
 * as bean
 */
public class Stock implements Serializable {

    private String company;
    private int amount;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
