package by.dulik.RentApartmentsParser.entity.kufar;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import java.util.Date;
import java.util.List;

@Generated("com.robohorse.robopojogenerator")
public class AdsItem {

    @JsonProperty("price_usd")
    private String priceUsd;

    @JsonProperty("images")
    private List<ImagesItem> images;

    @JsonProperty("rooms")
    private int rooms;

    @JsonProperty("tmp_blocket_url")
    private String tmpBlocketUrl;

    @JsonProperty("address")
    private String address;

    @JsonProperty("list_id")
    private int listId;

    @JsonProperty("list_time")
    private Date listTime;

    @JsonProperty("remuneration_type")
    private int remunerationType;

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("coordinates")
    private List<Double> coordinates;

    @JsonProperty("paid_services")
    private PaidServices paidServices;

    @JsonProperty("type")
    private String type;

    @JsonProperty("price_byn")
    private String priceByn;

    @JsonProperty("ad_id")
    private int adId;

    @JsonProperty("size")
    private int size;

    @JsonProperty("size_area")
    private int sizeArea;

    @JsonProperty("property_type")
    private int propertyType;

    @JsonProperty("category")
    private int category;

    @JsonProperty("region")
    private int region;

    public String getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(String priceUsd) {
        this.priceUsd = priceUsd;
    }

    public List<ImagesItem> getImages() {
        return images;
    }

    public void setImages(List<ImagesItem> images) {
        this.images = images;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public String getTmpBlocketUrl() {
        return tmpBlocketUrl;
    }

    public void setTmpBlocketUrl(String tmpBlocketUrl) {
        this.tmpBlocketUrl = tmpBlocketUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public Date getListTime() {
        return listTime;
    }

    public void setListTime(Date listTime) {
        this.listTime = listTime;
    }

    public int getRemunerationType() {
        return remunerationType;
    }

    public void setRemunerationType(int remunerationType) {
        this.remunerationType = remunerationType;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<Double> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }

    public PaidServices getPaidServices() {
        return paidServices;
    }

    public void setPaidServices(PaidServices paidServices) {
        this.paidServices = paidServices;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPriceByn() {
        return priceByn;
    }

    public void setPriceByn(String priceByn) {
        this.priceByn = priceByn;
    }

    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSizeArea() {
        return sizeArea;
    }

    public void setSizeArea(int sizeArea) {
        this.sizeArea = sizeArea;
    }

    public int getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(int propertyType) {
        this.propertyType = propertyType;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return
                "AdsItem{" +
                        "price_usd = '" + priceUsd + '\'' +
                        ",images = '" + images + '\'' +
                        ",rooms = '" + rooms + '\'' +
                        ",tmp_blocket_url = '" + tmpBlocketUrl + '\'' +
                        ",address = '" + address + '\'' +
                        ",list_id = '" + listId + '\'' +
                        ",list_time = '" + listTime + '\'' +
                        ",remuneration_type = '" + remunerationType + '\'' +
                        ",subject = '" + subject + '\'' +
                        ",coordinates = '" + coordinates + '\'' +
                        ",paid_services = '" + paidServices + '\'' +
                        ",type = '" + type + '\'' +
                        ",price_byn = '" + priceByn + '\'' +
                        ",ad_id = '" + adId + '\'' +
                        ",size = '" + size + '\'' +
                        ",size_area = '" + sizeArea + '\'' +
                        ",property_type = '" + propertyType + '\'' +
                        ",category = '" + category + '\'' +
                        ",region = '" + region + '\'' +
                        "}";
    }
}
