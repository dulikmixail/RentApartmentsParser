package by.dulik.RentApartmentsParser.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Rent {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String innerId;

    @Column(nullable = false)
    private String photo;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private String priceByn;

    @Column(nullable = false)
    private String priceUsd;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String address;

    @Column
    private Date createTime;

    @Column
    private String parsingSite;

    public Rent() {
        this.createTime = new Date();
    }

    public Rent(String innerId, String photo, String url, String priceByn, String priceUsd, String title, String address, Date createTime, String parsingSite) {
        this.innerId = innerId;
        this.photo = photo;
        this.url = url;
        this.priceByn = priceByn;
        this.priceUsd = priceUsd;
        this.title = title;
        this.address = address;
        this.createTime = createTime;
        this.parsingSite = parsingSite;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInnerId() {
        return innerId;
    }

    public void setInnerId(String innerId) {
        this.innerId = innerId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPriceByn() {
        return priceByn;
    }

    public void setPriceByn(String priceByn) {
        this.priceByn = priceByn;
    }

    public String getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(String priceUsd) {
        this.priceUsd = priceUsd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getParsingSite() {
        return parsingSite;
    }

    public void setParsingSite(String parsingSite) {
        this.parsingSite = parsingSite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rent rent = (Rent) o;
        return Objects.equals(id, rent.id) &&
                Objects.equals(innerId, rent.innerId) &&
                Objects.equals(photo, rent.photo) &&
                Objects.equals(url, rent.url) &&
                Objects.equals(priceByn, rent.priceByn) &&
                Objects.equals(priceUsd, rent.priceUsd) &&
                Objects.equals(title, rent.title) &&
                Objects.equals(address, rent.address) &&
                Objects.equals(createTime, rent.createTime) &&
                Objects.equals(parsingSite, rent.parsingSite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, innerId, photo, url, priceByn, priceUsd, title, address, createTime, parsingSite);
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", innerId='" + innerId + '\'' +
                ", photo='" + photo + '\'' +
                ", url='" + url + '\'' +
                ", priceByn='" + priceByn + '\'' +
                ", priceUsd='" + priceUsd + '\'' +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", createTime=" + createTime +
                ", parsingSite=" + parsingSite +
                '}';
    }
}
