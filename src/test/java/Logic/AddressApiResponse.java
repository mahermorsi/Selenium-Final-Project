package Logic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressApiResponse {
    private boolean success;
    private Data data;
    private String message;

    @JsonCreator
    public AddressApiResponse(
            @JsonProperty("success") boolean success,
            @JsonProperty("data") Data data,
            @JsonProperty("message") String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public Data getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "success=" + success +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }

    public static class Data {
        private Map<String, AddressDetails> allAddresses;
        private NewAddress newAddress;

        @JsonCreator
        public Data(
                @JsonProperty("allAddresses") Map<String, AddressDetails> allAddresses,
                @JsonProperty("newAddress") NewAddress newAddress) {
            this.allAddresses = allAddresses;
            this.newAddress = newAddress;
        }

        public Map<String, AddressDetails> getAllAddresses() {
            return allAddresses;
        }

        public NewAddress getNewAddress() {
            return newAddress;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "allAddresses=" + allAddresses +
                    ", newAddress=" + newAddress +
                    '}';
        }
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AddressDetails {
        private int id;
        private String apartment;
        private String area;
        private Integer area_id;
        private String city;
        private int city_id;
        private int defaultVal;
        private String entrance;
        private String floor;
        private String name;
        private Integer store_id;
        private String street;
        private Integer street_id;
        private String street_number;
        private String zip;

        public AddressDetails() {
            // Needed for Jackson deserialization
        }

        @JsonCreator
        public AddressDetails(
                @JsonProperty("id") int id,
                @JsonProperty("apartment") String apartment,
                @JsonProperty("area") String area,
                @JsonProperty("area_id") Integer area_id,
                @JsonProperty("city") String city,
                @JsonProperty("city_id") int city_id,
                @JsonProperty("default") int defaultVal,
                @JsonProperty("entrance") String entrance,
                @JsonProperty("floor") String floor,
                @JsonProperty("name") String name,
                @JsonProperty("store_id") Integer store_id,
                @JsonProperty("street") String street,
                @JsonProperty("street_id") Integer street_id,
                @JsonProperty("street_number") String street_number,
                @JsonProperty("zip") String zip) {
            this.id = id;
            this.apartment = apartment;
            this.area = area;
            this.area_id = area_id;
            this.city = city;
            this.city_id = city_id;
            this.defaultVal = defaultVal;
            this.entrance = entrance;
            this.floor = floor;
            this.name = name;
            this.store_id = store_id;
            this.street = street;
            this.street_id = street_id;
            this.street_number = street_number;
            this.zip = zip;
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getApartment() {
            return apartment;
        }

        public void setApartment(String apartment) {
            this.apartment = apartment;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public Integer getArea_id() {
            return area_id;
        }

        public void setArea_id(Integer area_id) {
            this.area_id = area_id;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public int getCity_id() {
            return city_id;
        }

        public void setCity_id(int city_id) {
            this.city_id = city_id;
        }

        public int getDefaultVal() {
            return defaultVal;
        }

        public void setDefaultVal(int defaultVal) {
            this.defaultVal = defaultVal;
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getStore_id() {
            return store_id;
        }

        public void setStore_id(Integer store_id) {
            this.store_id = store_id;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public Integer getStreet_id() {
            return street_id;
        }

        public void setStreet_id(Integer street_id) {
            this.street_id = street_id;
        }

        public String getStreet_number() {
            return street_number;
        }

        public void setStreet_number(String street_number) {
            this.street_number = street_number;
        }

        public String getZip() {
            return zip;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }

        @Override
        public String toString() {
            return "AddressDetails{" +
                    "id=" + id +
                    ", apartment='" + apartment + '\'' +
                    ", area='" + area + '\'' +
                    ", area_id=" + area_id +
                    ", city='" + city + '\'' +
                    ", city_id=" + city_id +
                    ", defaultVal=" + defaultVal +
                    ", entrance='" + entrance + '\'' +
                    ", floor='" + floor + '\'' +
                    ", name='" + name + '\'' +
                    ", store_id=" + store_id +
                    ", street='" + street + '\'' +
                    ", street_id=" + street_id +
                    ", street_number='" + street_number + '\'' +
                    ", zip='" + zip + '\'' +
                    '}';
        }
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class NewAddress {
        private String name;
        private int city_id;
        private String city;
        private String street;
        private String street_number;
        private String zip;
        private String apartment;
        private String entrance;
        private String floor;
        private String user_id;
        private int customer_id;
        private String updated_at;
        private String created_at;
        private int id;

        @JsonCreator
        public NewAddress(
                @JsonProperty("name") String name,
                @JsonProperty("city_id") int city_id,
                @JsonProperty("city") String city,
                @JsonProperty("street") String street,
                @JsonProperty("street_number") String street_number,
                @JsonProperty("zip") String zip,
                @JsonProperty("apartment") String apartment,
                @JsonProperty("entrance") String entrance,
                @JsonProperty("floor") String floor,
                @JsonProperty("user_id") String user_id,
                @JsonProperty("customer_id") int customer_id,
                @JsonProperty("updated_at") String updated_at,
                @JsonProperty("created_at") String created_at,
                @JsonProperty("id") int id) {
            this.name = name;
            this.city_id = city_id;
            this.city = city;
            this.street = street;
            this.street_number = street_number;
            this.zip = zip;
            this.apartment = apartment;
            this.entrance = entrance;
            this.floor = floor;
            this.user_id = user_id;
            this.customer_id = customer_id;
            this.updated_at = updated_at;
            this.created_at = created_at;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCity_id() {
            return city_id;
        }

        public void setCity_id(int city_id) {
            this.city_id = city_id;
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

        public String getStreet_number() {
            return street_number;
        }

        public void setStreet_number(String street_number) {
            this.street_number = street_number;
        }

        public String getZip() {
            return zip;
        }

        public void setZip(String zip) {
            this.zip = zip;
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

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public int getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(int customer_id) {
            this.customer_id = customer_id;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
