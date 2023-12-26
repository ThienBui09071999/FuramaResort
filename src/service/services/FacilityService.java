package service.services;

import model.facility.Facility;
import model.facility.House;
import model.facility.Room;
import model.facility.Villa;
import repository.repositories.FacilityRepository;
import service.interface_services.IFaclitityService;
import utils.GetInput;

import java.util.Map;

public class FacilityService extends GetInput implements IFaclitityService {
    FacilityRepository facilityRepository = new FacilityRepository();
    @Override
    public void displayListMaintenance() {
        Map<Facility,Integer> facilityIntegerMap = facilityRepository.getAll();
        for (Map.Entry<Facility,Integer> entry: facilityIntegerMap.entrySet()) {
            int value = entry.getValue();
            if (value >= 5) {
                if (entry.getKey() instanceof Villa) {
                    Villa villa = (Villa) entry.getKey();
                    System.out.println("Used: " + value + ", " + villa);
                } else if (entry.getKey() instanceof House) {
                    House house = (House) entry.getKey();
                    System.out.println("Used: " + value + ", " + house);
                } else {
                    Room room = (Room) entry.getKey();
                    System.out.println("Used: " + value + ", " + room);
                }
            }
        }
    }

    @Override
    public void displayAll() {
        Map<Facility,Integer> facilityIntegerMap = facilityRepository.getAll();
        for (Map.Entry<Facility,Integer> entry: facilityIntegerMap.entrySet()){
            Facility facility = entry.getKey();
            int value = entry.getValue();
            if (facility instanceof Villa) {
                Villa villa = (Villa) facility;
                System.out.println("Used: " + value +", "+villa);
            } else if (facility instanceof House) {
                House house = (House) facility;
                System.out.println("Used: " + value +", "+house);
            } else {
                Room room = (Room) facility;
                System.out.println("Used: " + value +", "+room);
            }
        }
    }

    @Override
    public void add() {
        System.out.println("1. Add new villa: \n2. Add new house: \n3. Add new room: \n4. Back to menu: \nEnter your choice: ");
        int choice = getUserChoice(1,4);
        String idServices, roomStandard;
        int quantityFloor;
        String nameServices;
        double usingArea;
        double price;
        int maxNumPeople;
        String rentalType;
        switch (choice) {
            case 1:
                System.out.println("Enter id service: ");
                idServices = getIdService("VL");
                System.out.println("Enter name service: ");
                nameServices = getText();
                System.out.println("Enter usable area: ");
                usingArea = getAcreage();
                System.out.println("Enter price service: ");
                price = getExpense();
                System.out.println("Enter number of person: ");
                maxNumPeople = getNumberPerson();
                System.out.println("Enter rental type: Year, Month, Date, Hour");
                rentalType = getText();
                System.out.println("Enter room standard: ");
                roomStandard = getText();
                System.out.println("Enter pool acreage: ");
                double poolArea = getAcreage();
                System.out.println("Enter quantity of floor: ");
                quantityFloor = getNumber();
                Villa villa = new Villa(idServices,nameServices,usingArea,price,maxNumPeople,rentalType,roomStandard,poolArea,quantityFloor);
                facilityRepository.add(villa);
                break;
            case 2:
                System.out.println("Enter id service: ");
                idServices = getIdService("HO");
                System.out.println("Enter name service: ");
                nameServices = getText();
                System.out.println("Enter usable area: ");
                usingArea = getAcreage();
                System.out.println("Enter price service: ");
                price = getExpense();
                System.out.println("Enter number of person: ");
                maxNumPeople = getNumberPerson();
                System.out.println("Enter rental type: Year, Month, Date, Hour");
                rentalType = getText();
                System.out.println("Enter room standard: ");
                roomStandard = getText();
                System.out.println("Enter quantity of floor: ");
                quantityFloor = getNumber();
                House house =new House(idServices,nameServices,usingArea,price,maxNumPeople,rentalType,roomStandard,quantityFloor);
                facilityRepository.add(house);
                break;
            case 3:
                System.out.println("Enter id service: ");
                idServices = getIdService("RO");
                System.out.println("Enter name service: ");
                nameServices = getText();
                System.out.println("Enter usable area: ");
                usingArea = getAcreage();
                System.out.println("Enter price service: ");
                price = getExpense();
                System.out.println("Enter number of person: ");
                maxNumPeople = getNumberPerson();
                System.out.println("Enter rental type: Year, Month, Date, Hour");
                rentalType = getText();
                System.out.println("Enter incentives: ");
                String freeService = getText();
                Room room = new Room(idServices,nameServices,usingArea,price,maxNumPeople,rentalType,freeService);
                facilityRepository.add(room);
                break;
            default:
                break;
        }
    }
}
