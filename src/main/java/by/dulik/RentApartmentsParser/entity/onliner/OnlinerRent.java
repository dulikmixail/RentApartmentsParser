package by.dulik.RentApartmentsParser.entity.onliner;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import java.util.List;

@Generated("com.robohorse.robopojogenerator")
public class OnlinerRent {

    @JsonProperty("total")
    private int total;

    @JsonProperty("page")
    private Page page;

    @JsonProperty("apartments")
    private List<ApartmentsItem> apartments;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<ApartmentsItem> getApartments() {
        return apartments;
    }

    public void setApartments(List<ApartmentsItem> apartments) {
        this.apartments = apartments;
    }

    @Override
    public String toString() {
        return
                "OnlinerRent{" +
                        "total = '" + total + '\'' +
                        ",page = '" + page + '\'' +
                        ",apartments = '" + apartments + '\'' +
                        "}";
    }
}
