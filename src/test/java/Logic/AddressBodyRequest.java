package Logic;

public class AddressBodyRequest {

    private String name;
    private int cityId;
    private String city;
    private String street;
    private String streetNumber;
    private String zipCode;
    private String apartment;
    private String entrance;
    private String floor;

    public AddressBodyRequest(String name, int cityId, String city, String street, String streetNumber, String zipCode, String apartment, String entrance, String floor) {
        this.name = name;
        this.cityId = cityId;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
        this.zipCode = zipCode;
        this.apartment = apartment;
        this.entrance = entrance;
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getEntrance() {
        return entrance;
    }

    public void setEntrance(String entrance) {
        this.entrance = entrance;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }
    @Override
    public String toString() {
        return "{" +
                "\"name\": " + (name != null ? "\"" + name + "\"" : "null") + "," +
                "\"city_id\": " + cityId + "," +
                "\"city\": \"" + city + "\"," +
                "\"street\": \"" + street + "\"," +
                "\"street_number\": \"" + streetNumber + "\"," +
                "\"zip\": \"" + zipCode + "\"," +
                "\"apartment\": \"" + apartment + "\"," +
                "\"entrance\": " + (entrance != null ? "\"" + entrance + "\"" : "null") + "," +
                "\"floor\": \"" + floor + "\"" +
                "}";
    }
}

