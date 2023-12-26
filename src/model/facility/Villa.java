package model.facility;

public class Villa extends Facility{
    private String roomStandard;
    private double poolArea;
    private  int quantityFloor;

    public Villa() {
    }

    public Villa(String roomStandard, double poolArea, int quantityFloor) {
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.quantityFloor = quantityFloor;
    }

    public Villa(String idServices, String nameServices, double usingArea, double price, int maxNumPeople, String rentalType, String roomStandard, double poolArea, int quantityFloor) {
        super(idServices, nameServices, usingArea, price, maxNumPeople, rentalType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.quantityFloor = quantityFloor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getQuantityFloor() {
        return quantityFloor;
    }

    public void setQuantityFloor(int quantityFloor) {
        this.quantityFloor = quantityFloor;
    }

    @Override
    public String toString() {
        return super.toString() +
                " roomStandard= " + roomStandard  +
                ", poolArea= " + poolArea +
                ", quantityFloor= " + quantityFloor ;
    }

    @Override
    public String getInforToCSV() {
        return super.getInforToCSV() + "," + roomStandard + "," + poolArea + "," + quantityFloor;
    }
}
