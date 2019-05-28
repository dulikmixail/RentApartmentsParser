package by.dulik.RentApartmentsParser.entity.onliner;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Price {

    @JsonProperty("amount")
    private String amount;

    @JsonProperty("converted")
    private Converted converted;

    @JsonProperty("currency")
    private String currency;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Converted getConverted() {
        return converted;
    }

    public void setConverted(Converted converted) {
        this.converted = converted;
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
                "Price{" +
                        "amount = '" + amount + '\'' +
                        ",converted = '" + converted + '\'' +
                        ",currency = '" + currency + '\'' +
                        "}";
    }
}
