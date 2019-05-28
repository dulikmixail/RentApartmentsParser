package by.dulik.RentApartmentsParser.entity.onliner;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class USD {

    @JsonProperty("amount")
    private String amount;

    @JsonProperty("currency")
    private String currency;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return
                "USD{" +
                        "amount = '" + amount + '\'' +
                        ",currency = '" + currency + '\'' +
                        "}";
    }
}
