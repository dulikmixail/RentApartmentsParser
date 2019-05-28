package by.dulik.RentApartmentsParser.entity.kufar;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class PagesItem {

    @JsonProperty("num")
    private int num;

    @JsonProperty("label")
    private String label;

    @JsonProperty("token")
    private Object token;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Object getToken() {
        return token;
    }

    public void setToken(Object token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return
                "PagesItem{" +
                        "num = '" + num + '\'' +
                        ",label = '" + label + '\'' +
                        ",token = '" + token + '\'' +
                        "}";
    }
}
