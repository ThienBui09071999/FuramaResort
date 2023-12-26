package repository.repositories;

import model.facility.Facility;
import model.facility.House;
import model.facility.Room;
import model.facility.Villa;
import repository.interfice_repository.IFacilityRepository;
import utils.ReadAndWriteFileCSV;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FacilityRepository implements IFacilityRepository {
    public static final String FACILITY_DATA ="D:\\CodeGym\\FuramaResort\\src\\data\\facility\\facility.csv";
    @Override
    public void add(Facility facility) {
        Map<Facility,Integer> facilityIntegerMap = new LinkedHashMap<>();
        if (facility == null) {
            System.out.println("You have not filled in all the information for the facility!!! ");
            return;
        }
        facilityIntegerMap.put(facility,0);
        update(facilityIntegerMap,true);
    }

    @Override
    public Map<Facility, Integer> getAll() {
        List<String> stringList = ReadAndWriteFileCSV.readfileCSV(FACILITY_DATA);
        Map<Facility,Integer> facilityIntegerMap = new LinkedHashMap<>();
        String[] array;
        for (String string : stringList) {
            array = string.split(",");
            if (string.startsWith("SVVL")) {
                Villa villa = new Villa(array[0], array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]), Integer.parseInt(array[4]), array[5],array[6], Double.parseDouble(array[7]), Integer.parseInt(array[8]));
                facilityIntegerMap.put(villa,Integer.parseInt(array[9]));
            } else if (string.startsWith("SVHO")) {
                House house = new House(array[0], array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]), Integer.parseInt(array[4]), array[5], array[6], Integer.parseInt(array[7]));
                facilityIntegerMap.put(house,Integer.parseInt(array[8]));
            } else {
                Room room = new Room(array[0], array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]), Integer.parseInt(array[4]), array[5], array[6]);
                facilityIntegerMap.put(room,Integer.parseInt(array[7]));
            }
        }
        return facilityIntegerMap;
    }
    public static boolean increaseValue(String idService) {
        FacilityRepository facilityRepository = new FacilityRepository();
        Map<Facility,Integer> facilityIntegerMap = facilityRepository.getAll();
        for (Map.Entry<Facility,Integer> entry: facilityIntegerMap.entrySet()) {
            if (entry.getKey().getIdServices().equals(idService)){
                int value = entry.getValue();
                Facility facility = entry.getKey();
                facilityIntegerMap.put(facility,value+1);
                update(facilityIntegerMap,false);
                return true;
            }
        }
        return false;
    }
    public static void  update(Map<Facility,Integer> facilityIntegerMap,boolean check) {
        List<String> stringList = new ArrayList<>();
        for (Map.Entry<Facility,Integer> entry: facilityIntegerMap.entrySet()) {
            if (entry.getKey() instanceof Villa) {
                Villa villa = (Villa) entry.getKey();
                stringList.add(villa.getInforToCSV()+","+entry.getValue());
            } else if (entry.getKey() instanceof House) {
                House house = (House) entry.getKey();
                stringList.add(house.getInforToCSV()+","+entry.getValue());
            } else {
                Room room = (Room) entry.getKey();
                stringList.add(room.getInforToCSV()+","+entry.getValue());
            }
        }
        ReadAndWriteFileCSV.writeListStringToCSV(FACILITY_DATA,stringList,check);
    }
}
