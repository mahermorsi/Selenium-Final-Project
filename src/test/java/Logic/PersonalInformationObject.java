package Logic;

public class PersonalInformationObject {
    private String first_name;
    private String last_name;
    private String phone;
    private String additional_phone;
    private int sex_id;
    private String birth_date;

    public PersonalInformationObject(String first_name, String last_name, String phone, String additional_phone, int sex_id, String birth_date) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.additional_phone = additional_phone;
        this.sex_id = sex_id;
        this.birth_date = birth_date;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdditional_phone() {
        return additional_phone;
    }

    public void setAdditional_phone(String additional_phone) {
        this.additional_phone = additional_phone;
    }

    public int getSex_id() {
        return sex_id;
    }

    public void setSex_id(int sex_id) {
        this.sex_id = sex_id;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }
    @Override
    public String toString() {
        return "{\n" +
                "    \"first_name\": \"" + first_name + "\",\n" +
                "    \"last_name\": \"" + last_name + "\",\n" +
                "    \"phone\": \"" + phone + "\",\n" +
                "    \"additional_phone\": " + (additional_phone != null ? "\"" + additional_phone + "\"" : "null") + ",\n" +
                "    \"sex_id\": " + sex_id + ",\n" +
                "    \"birth_date\": \"" + birth_date + "\"\n" +
                "}";
    }
}
