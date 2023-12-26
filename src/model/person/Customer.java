package model.person;

public class Customer extends Person{
    private String address;
    private String typeCustomer;

    public Customer() {
    }

    public Customer(String address, String typeCustomer) {
        this.address = address;
        this.typeCustomer = typeCustomer;
    }

    public Customer(String id,String name, String sex, String email, String dateOfBirth, String phoneNumber, String CMND, String address, String typeCustomer) {
        super( id, name, sex, email, dateOfBirth, phoneNumber, CMND);
        this.address = address;
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", address=" + address+
                ", typeCustomer=" + typeCustomer;
    }

    @Override
    public String getInforToCSV() {
        return super.getInforToCSV()+","+address+","+typeCustomer;
    }
}
