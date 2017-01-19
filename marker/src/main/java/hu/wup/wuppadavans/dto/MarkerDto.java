package hu.wup.wuppadavans.dto;

/**
 * Created by szvarga on 2017. 01. 19..
 */
public class MarkerDto {

    private Long id;
    private String type;
    private Double latitude;
    private Double longitude;
    private String name;
    private String description;
    private String address;
    private String phones;
    private String webUri;
    private String facebookUri;
    private String imageUri;
    private Boolean hasPharmacy;
    private Boolean isPharmacyOpen;
    private Boolean isOpen;
    private Boolean isDuty;
    

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

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
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
}
