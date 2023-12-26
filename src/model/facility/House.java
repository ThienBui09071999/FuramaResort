package model.facility;

public class House extends Facility{
    private String roomStandard;
    private  int quantityFloor;

    public House() {
    }

    public House(String roomStandard, int quantityFloor) {
        this.roomStandard = roomStandard;
        this.quantityFloor = quantityFloor;
    }

    public House(String idServices, String nameServices, double usingArea, double price, int maxNumPeople, String rentalType, String roomStandard, int quantityFloor) {
        super(idServices, nameServices, usingArea, price, maxNumPeople, rentalType);
        this.roomStandard = roomStandard;
        this.quantityFloor = quantityFloor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
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
                ", quantityFloor= " + quantityFloor ;
    }

    @Override
    public String getInforToCSV() {
        return super.getInforToCSV() + "," + roomStandard + "," + quantityFloor;
    }
}
