package entity;


import model.Marker;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mark")
public class MarkerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    private String type = null;
    private Double latitude = null;
    private Double longitude = null;
    private String name = null;
    private String description = null;
    private String address = null;
    private List<String> phones = new ArrayList<String>();
    private String webUri = null;
    private String facebookUri = null;
    private String imageUri = null;
    private List<String> openingTime = new ArrayList<String>();
    private List<String> pharmacyOpeningTime = new ArrayList<String>();
    private Boolean hasPharmacy = null;
    private Boolean isPharmacyOpen = null;
    private Boolean isOpen = null;
    private Boolean isDuty = null;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mark")
    private List<MarkerEntity> userEntityList;

    public MarkerEntity(String type, Double latitude, Double longitude, String name, String description, String address, List<String> phones, String webUri, String facebookUri, String imageUri, List<String> openingTime, List<String> pharmacyOpeningTime, Boolean hasPharmacy, Boolean isPharmacyOpen, Boolean isOpen, Boolean isDuty, List<MarkerEntity> userEntityList) {
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.description = description;
        this.address = address;
        this.phones = phones;
        this.webUri = webUri;
        this.facebookUri = facebookUri;
        this.imageUri = imageUri;
        this.openingTime = openingTime;
        this.pharmacyOpeningTime = pharmacyOpeningTime;
        this.hasPharmacy = hasPharmacy;
        this.isPharmacyOpen = isPharmacyOpen;
        this.isOpen = isOpen;
        this.isDuty = isDuty;
        this.userEntityList = userEntityList;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public String getWebUri() {
        return webUri;
    }

    public void setWebUri(String webUri) {
        this.webUri = webUri;
    }

    public String getFacebookUri() {
        return facebookUri;
    }

    public void setFacebookUri(String facebookUri) {
        this.facebookUri = facebookUri;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public List<String> getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(List<String> openingTime) {
        this.openingTime = openingTime;
    }

    public List<String> getPharmacyOpeningTime() {
        return pharmacyOpeningTime;
    }

    public void setPharmacyOpeningTime(List<String> pharmacyOpeningTime) {
        this.pharmacyOpeningTime = pharmacyOpeningTime;
    }

    public Boolean getHasPharmacy() {
        return hasPharmacy;
    }

    public void setHasPharmacy(Boolean hasPharmacy) {
        this.hasPharmacy = hasPharmacy;
    }

    public Boolean getPharmacyOpen() {
        return isPharmacyOpen;
    }

    public void setPharmacyOpen(Boolean pharmacyOpen) {
        isPharmacyOpen = pharmacyOpen;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }

    public Boolean getDuty() {
        return isDuty;
    }

    public void setDuty(Boolean duty) {
        isDuty = duty;
    }

    public List<MarkerEntity> getUserEntityList() {
        return userEntityList;
    }

    public void setUserEntityList(List<MarkerEntity> userEntityList) {
        this.userEntityList = userEntityList;
    }
}
