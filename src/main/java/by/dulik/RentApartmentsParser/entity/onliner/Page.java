package by.dulik.RentApartmentsParser.entity.onliner;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Page {

    @JsonProperty("current")
    private int current;

    @JsonProperty("last")
    private int last;

    @JsonProperty("limit")
    private int limit;

    @JsonProperty("items")
    private int items;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return
                "Page{" +
                        "current = '" + current + '\'' +
                        ",last = '" + last + '\'' +
                        ",limit = '" + limit + '\'' +
                        ",items = '" + items + '\'' +
                        "}";
    }
}
