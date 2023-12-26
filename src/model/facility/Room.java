package model.facility;

public class Room extends Facility{
    private String freeService;

    public Room() {
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String idServices, String nameServices, double usingArea, double price, int maxNumPeople, String rentalType, String freeService) {
        super(idServices, nameServices, usingArea, price, maxNumPeople, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return super.toString() + "freeService= " + freeService;
    }

    @Override
    public String getInforToCSV() {
        return super.getInforToCSV() + "," + freeService;
    }
}
