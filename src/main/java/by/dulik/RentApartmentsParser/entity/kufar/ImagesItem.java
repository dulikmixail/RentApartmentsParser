package by.dulik.RentApartmentsParser.entity.kufar;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ImagesItem {

    @JsonProperty("id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return
                "ImagesItem{" +
                        "id = '" + id + '\'' +
                        "}";
    }
}
