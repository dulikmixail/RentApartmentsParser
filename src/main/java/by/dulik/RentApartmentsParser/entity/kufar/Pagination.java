package by.dulik.RentApartmentsParser.entity.kufar;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import java.util.List;

@Generated("com.robohorse.robopojogenerator")
public class Pagination {

    @JsonProperty("pages")
    private List<PagesItem> pages;

    public List<PagesItem> getPages() {
        return pages;
    }

    public void setPages(List<PagesItem> pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return
                "Pagination{" +
                        "pages = '" + pages + '\'' +
                        "}";
    }
}
