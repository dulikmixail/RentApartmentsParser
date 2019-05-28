package by.dulik.RentApartmentsParser.entity.kufar;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class PaidServices {

    @JsonProperty("highlight")
    private boolean highlight;

    @JsonProperty("halva")
    private boolean halva;

    @JsonProperty("polepos")
    private boolean polepos;

    @JsonProperty("ribbons")
    private Object ribbons;

    public boolean isHighlight() {
        return highlight;
    }

    public void setHighlight(boolean highlight) {
        this.highlight = highlight;
    }

    public boolean isHalva() {
        return halva;
    }

    public void setHalva(boolean halva) {
        this.halva = halva;
    }

    public boolean isPolepos() {
        return polepos;
    }

    public void setPolepos(boolean polepos) {
        this.polepos = polepos;
    }

    public Object getRibbons() {
        return ribbons;
    }

    public void setRibbons(Object ribbons) {
        this.ribbons = ribbons;
    }

    @Override
    public String toString() {
        return
                "PaidServices{" +
                        "highlight = '" + highlight + '\'' +
                        ",halva = '" + halva + '\'' +
                        ",polepos = '" + polepos + '\'' +
                        ",ribbons = '" + ribbons + '\'' +
                        "}";
    }
}
