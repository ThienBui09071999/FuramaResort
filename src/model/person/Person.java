package model.person;

public abstract class Person {
    private String name, sex, email, id;
    private String dateOfBirth, phoneNumber, CMND;

    public Person() {
    }

    public Person(String id, String name, String sex, String email, String dateOfBirth, String phoneNumber, String CMND) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.CMND = CMND;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    @Override
    public String toString() {
        return name +
                ", id= " + id +
                ", CMND= " + CMND +
                ", phoneNumber= " + phoneNumber +
                ", sex= " + sex +
                ", email= " + email +
                ", dateOfBirth= " + dateOfBirth;
    }
    public String getInforToCSV(){
        return id+","+name+","+sex+","+email+","+dateOfBirth+","+phoneNumber+","+CMND;
    }
}
