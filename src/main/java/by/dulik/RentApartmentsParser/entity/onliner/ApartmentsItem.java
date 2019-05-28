package by.dulik.RentApartmentsParser.entity.onliner;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import java.util.Date;

@Generated("com.robohorse.robopojogenerator")
public class ApartmentsItem {

    @JsonProperty("rent_type")
    private String rentType;

    @JsonProperty("price")
    private Price price;

    @JsonProperty("contact")
    private Contact contact;

    @JsonProperty("photo")
    private String photo;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("up_available_in")
    private int upAvailableIn;

    @JsonProperty("location")
    private Location location;

    @JsonProperty("id")
    private int id;

    @JsonProperty("last_time_up")
    private Date lastTimeUp;

    @JsonProperty("url")
    private String url;

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getUpAvailableIn() {
        return upAvailableIn;
    }

    public void setUpAvailableIn(int upAvailableIn) {
        this.upAvailableIn = upAvailableIn;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getLastTimeUp() {
        return lastTimeUp;
    }

    public void setLastTimeUp(Date lastTimeUp) {
        this.lastTimeUp = lastTimeUp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return
                "ApartmentsItem{" +
                        "rent_type = '" + rentType + '\'' +
                        ",price = '" + price + '\'' +
                        ",contact = '" + contact + '\'' +
                        ",photo = '" + photo + '\'' +
                        ",created_at = '" + createdAt + '\'' +
                        ",up_available_in = '" + upAvailableIn + '\'' +
                        ",location = '" + location + '\'' +
                        ",id = '" + id + '\'' +
                        ",last_time_up = '" + lastTimeUp + '\'' +
                        ",url = '" + url + '\'' +
                        "}";
    }
}
