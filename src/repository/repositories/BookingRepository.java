package repository.repositories;

import model.Booking;
import model.Contract;
import repository.interfice_repository.IBookingRepository;
import utils.GetInput;
import utils.ReadAndWriteFileCSV;

import java.util.List;
import java.util.Set;
import java.util.*;
public class BookingRepository extends GetInput implements IBookingRepository {
    private static final String BOOKING_DATA = "D:\\CodeGym\\FuramaResort\\src\\data\\booking.csv";
    private static final String CONTRACT_DATA = "D:\\CodeGym\\FuramaResort\\src\\data\\contract.csv";

    private static final Set<Booking> bookingSet = new TreeSet<>();
    private static final List<Contract> contractList = new ArrayList<>();
    static {
        List<String> stringList = ReadAndWriteFileCSV.readfileCSV(BOOKING_DATA);
        for (String string: stringList) {
            if (string.length()>0) {
                String[] array = string.split(",");
                Booking booking = new Booking(array[0], array[1], array[2], array[3], array[4], array[5], Boolean.parseBoolean(array[6]));
                bookingSet.add(booking);
            }
        }
        List<String> stringList1 = ReadAndWriteFileCSV.readfileCSV(CONTRACT_DATA);
        for (String string: stringList1) {
            if (string.length()>0) {
                String[] array = string.split(",");
                Contract contract = new Contract(array[0], array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]));
                contractList.add(contract);
            }
        }
    }

    @Override
    public void add(Booking booking) {
        bookingSet.add(booking);
        update(true);
    }
    public void update(boolean append) {
        List<String> stringList = new ArrayList<>();
        for (Booking bk :bookingSet) {
            stringList.add(bk.getInforToCSV());
        }
        ReadAndWriteFileCSV.writeListStringToCSV(BOOKING_DATA, stringList, append);
    }

    @Override
    public Set<Booking> getListBooking() {
        return bookingSet;
    }

    @Override
    public void createNewContract(Contract contract) {
        contractList.add(contract);
        updateContract(true);
    }

    @Override
    public void editContract(String idContract) {
        for (Contract contract  : contractList) {
            if (contract.getIdContract().equals(idContract)){
                System.out.println("Enter new ID contract: ");
                contract.setIdContract(getIdUser("FM"));
                System.out.println("Enter new ID booking: ");
                contract.setIdBooking(getIdUser("BK"));
                System.out.println("Enter new deposit: ");
                contract.setDepositMoney(getExpense());
                System.out.println("Enter new total money: ");
                contract.setTotalMoney(getExpense());
                updateContract(false);
                return;
            }
        }
        System.out.println("The Contract code not found!!!");
    }

    @Override
    public List<Contract> getListContract() {
        return contractList;
    }
    private void updateContract(boolean append) {
        List<String> stringList = new ArrayList<>();
        for (Contract contract : contractList) {
            stringList.add(contract.getInforToCSV());
        }
        ReadAndWriteFileCSV.writeListStringToCSV(CONTRACT_DATA, stringList, append);
    }
}
