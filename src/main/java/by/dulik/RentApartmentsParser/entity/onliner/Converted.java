package by.dulik.RentApartmentsParser.entity.onliner;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Converted {

    @JsonProperty("BYN")
    private BYN bYN;

    @JsonProperty("USD")
    private USD uSD;

    public BYN getBYN() {
        return bYN;
    }

    public void setBYN(BYN bYN) {
        this.bYN = bYN;
    }

    public USD getUSD() {
        return uSD;
    }

    public void setUSD(USD uSD) {
        this.uSD = uSD;
    }

    @Override
    public String toString() {
        return
                "Converted{" +
                        "bYN = '" + bYN + '\'' +
                        ",uSD = '" + uSD + '\'' +
                        "}";
    }
}
