package model.facility;

public abstract class Facility {
    private  String idServices;
    private String nameServices;
    private  double usingArea;
    private double price;
    private int maxNumPeople;
    private String rentalType;

    public Facility() {
    }

    public Facility(String idServices, String nameServices, double usingArea, double price, int maxNumPeople, String rentalType) {
        this.idServices = idServices;
        this.nameServices = nameServices;
        this.usingArea = usingArea;
        this.price = price;
        this.maxNumPeople = maxNumPeople;
        this.rentalType = rentalType;
    }

    public String getIdServices() {
        return idServices;
    }

    public void setIdServices(String idServices) {
        this.idServices = idServices;
    }

    public String getNameServices() {
        return nameServices;
    }

    public void setNameServices(String nameServices) {
        this.nameServices = nameServices;
    }

    public double getUsingArea() {
        return usingArea;
    }

    public void setUsingArea(double usingArea) {
        this.usingArea = usingArea;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaxNumPeople() {
        return maxNumPeople;
    }

    public void setMaxNumPeople(int maxNumPeople) {
        this.maxNumPeople = maxNumPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return nameServices +
                ": id=" + idServices +
                ", usingArea=" + usingArea +
                ", price=" + price +" VND"+
                ", maxNumPeople=" + maxNumPeople +
                ", rentalType=" + rentalType ;
    }
    public String getInforToCSV() {
        return idServices + "," + nameServices + "," + usingArea + "," + price + "," + maxNumPeople + "," + rentalType;
    }
}
