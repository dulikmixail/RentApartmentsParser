package by.dulik.RentApartmentsParser.entity.kufar;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import java.util.List;

@Generated("com.robohorse.robopojogenerator")
public class KufarRent {

    @JsonProperty("ads")
    private List<AdsItem> ads;

    @JsonProperty("total")
    private int total;

    @JsonProperty("pagination")
    private Pagination pagination;

    public List<AdsItem> getAds() {
        return ads;
    }

    public void setAds(List<AdsItem> ads) {
        this.ads = ads;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    @Override
    public String toString() {
        return
                "KufarRent{" +
                        "ads = '" + ads + '\'' +
                        ",total = '" + total + '\'' +
                        ",pagination = '" + pagination + '\'' +
                        "}";
    }
}
