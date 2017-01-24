package hu.wup.wuppadavans.model;

import java.util.Objects;

public class Marker {

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

    /**
     **/
    public Marker id(Long id) {
        this.id = id;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     **/
    public Marker type(String type) {
        this.type = type;
        return this;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     **/
    public Marker latitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }


    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     **/
    public Marker longitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }


    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     **/
    public Marker name(String name) {
        this.name = name;
        return this;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     **/
    public Marker description(String description) {
        this.description = description;
        return this;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     **/
    public Marker address(String address) {
        this.address = address;
        return this;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     **/
    public Marker phones(String phones) {
        this.phones = phones;
        return this;
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }

    /**
     **/
    public Marker webUri(String webUri) {
        this.webUri = webUri;
        return this;
    }


    public String getWebUri() {
        return webUri;
    }

    public void setWebUri(String webUri) {
        this.webUri = webUri;
    }

    /**
     **/
    public Marker facebookUri(String facebookUri) {
        this.facebookUri = facebookUri;
        return this;
    }


    public String getFacebookUri() {
        return facebookUri;
    }

    public void setFacebookUri(String facebookUri) {
        this.facebookUri = facebookUri;
    }

    /**
     **/
    public Marker imageUri(String imageUri) {
        this.imageUri = imageUri;
        return this;
    }


    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    /**
     **/

    public Marker hasPharmacy(Boolean hasPharmacy) {
        this.hasPharmacy = hasPharmacy;
        return this;
    }


    public Boolean getHasPharmacy() {
        return hasPharmacy;
    }

    public void setHasPharmacy(Boolean hasPharmacy) {
        this.hasPharmacy = hasPharmacy;
    }

    /**
     **/
    public Marker isPharmacyOpen(Boolean isPharmacyOpen) {
        this.isPharmacyOpen = isPharmacyOpen;
        return this;
    }


    public Boolean getIsPharmacyOpen() {
        return isPharmacyOpen;
    }

    public void setIsPharmacyOpen(Boolean isPharmacyOpen) {
        this.isPharmacyOpen = isPharmacyOpen;
    }

    /**
     **/
    public Marker isOpen(Boolean isOpen) {
        this.isOpen = isOpen;
        return this;
    }


    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    /**
     **/
    public Marker isDuty(Boolean isDuty) {
        this.isDuty = isDuty;
        return this;
    }


    public Boolean getIsDuty() {
        return isDuty;
    }

    public void setIsDuty(Boolean isDuty) {
        this.isDuty = isDuty;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Marker marker = (Marker) o;
        return Objects.equals(id, marker.id) &&
                Objects.equals(type, marker.type) &&
                Objects.equals(latitude, marker.latitude) &&
                Objects.equals(longitude, marker.longitude) &&
                Objects.equals(name, marker.name) &&
                Objects.equals(description, marker.description) &&
                Objects.equals(address, marker.address) &&
                Objects.equals(phones, marker.phones) &&
                Objects.equals(webUri, marker.webUri) &&
                Objects.equals(facebookUri, marker.facebookUri) &&
                Objects.equals(imageUri, marker.imageUri) &&
                Objects.equals(hasPharmacy, marker.hasPharmacy) &&
                Objects.equals(isPharmacyOpen, marker.isPharmacyOpen) &&
                Objects.equals(isOpen, marker.isOpen) &&
                Objects.equals(isDuty, marker.isDuty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, latitude, longitude, name, description, address, phones, webUri, facebookUri, imageUri, hasPharmacy, isPharmacyOpen, isOpen, isDuty);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Marker {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
        sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    address: ").append(toIndentedString(address)).append("\n");
        sb.append("    phones: ").append(toIndentedString(phones)).append("\n");
        sb.append("    webUri: ").append(toIndentedString(webUri)).append("\n");
        sb.append("    facebookUri: ").append(toIndentedString(facebookUri)).append("\n");
        sb.append("    imageUri: ").append(toIndentedString(imageUri)).append("\n");
        sb.append("    hasPharmacy: ").append(toIndentedString(hasPharmacy)).append("\n");
        sb.append("    isPharmacyOpen: ").append(toIndentedString(isPharmacyOpen)).append("\n");
        sb.append("    isOpen: ").append(toIndentedString(isOpen)).append("\n");
        sb.append("    isDuty: ").append(toIndentedString(isDuty)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

