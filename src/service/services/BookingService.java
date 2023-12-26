package service.services;

import model.Booking;
import model.Contract;
import repository.repositories.BookingRepository;
import service.interface_services.IBookingService;
import utils.GetInput;
import repository.repositories.CustomerRepository;
import repository.repositories.FacilityRepository;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BookingService extends GetInput implements IBookingService {
    static BookingRepository bookingRepository = new BookingRepository();
    @Override
    public void displayAll() {
        Set<Booking> bookingSet = bookingRepository.getListBooking();
        for (Booking booking : bookingSet) {
            System.out.println(booking);
        }
    }
    @Override
    public void add() {
        CustomerService customerService = new CustomerService();
        FacilityService facilityService = new FacilityService();
        customerService.displayAll();
        facilityService.displayAll();

        System.out.println("Enter ID booking:");
        String idBooking = getIdUser("BK");
        System.out.println("Enter ID customer:");
        String idCustomer = getIdUser("KH");
        if (!CustomerRepository.customerExist(idCustomer)) {
            System.out.println("The ID customer not exist!!!");
            return;
        }
        System.out.println("Enter ID service:");
        String idService = getIdService();
        if (!FacilityRepository.increaseValue(idService)) {
            System.out.println("The ID you entered does not exist!!!");
            return;
        }
        System.out.println("Enter date booking:");
        String bookingDate = getDate(false);
        System.out.println("Enter date start:");
        String startDate = getDate(false);
        System.out.println("Enter date end:");
        String endDate = getDate(false);


        Booking booking = new Booking(idBooking,idCustomer,idService,startDate,endDate,bookingDate,false);
        bookingRepository.add(booking);
    }
    @Override
    public void createNewContract() {
        Set<Booking> bookingSet = bookingRepository.getListBooking();
        Queue<Booking> bookingQueue = new ArrayDeque<>();
        for (Booking booking: bookingSet) {
            if ((!booking.isCreaseContract()) && (!booking.getIdService().contains("RO"))) {
                bookingQueue.add(booking);
            }
        }
        Booking booking = bookingQueue.poll();
        if (booking == null) {
            System.out.println("All bookings have been contracted!!!");
            return;
        }
        String nextId = booking.getIdBooking();
        String idBooking;
        do {
            System.out.println("Enter ID booking: ");
            idBooking = getIdUser("BK");
            if (!idBooking.equals(nextId)) {
                System.out.println("Next booking is : " + nextId);
            }
        } while (!idBooking.equals(nextId));

        System.out.println("Enter ID contract: ");
        String idContract = getIdUser("FM");
        System.out.println("Enter deposit: ");
        double depositMoney = getExpense();
        System.out.println("Enter total money: ");
        double totalMoney = getExpense();

        Contract contract = new Contract(idContract,idBooking,depositMoney,totalMoney);
        bookingRepository.createNewContract(contract);

        for (Booking booking1: bookingSet) {
            if (booking1.getIdBooking().equals(idBooking)) {
                booking1.setCreaseContract(true);
                break;
            }
        }
        bookingRepository.update(false);
    }

    @Override
    public void editContract() {
        System.out.println("Enter ID contract: ");
        String idContract = getIdUser("FM");
        bookingRepository.editContract(idContract);
    }

    @Override
    public void displayListContract() {
        List<Contract> contractList = bookingRepository.getListContract();
        for (int i = 0; i < contractList.size(); i++) {
            System.out.println((i + 1) + ". " + contractList.get(i));
        }
    }

    public static boolean checkBooking(Booking booking) {
        List<Contract> contractList = bookingRepository.getListContract();
        for (Contract contract : contractList) {
            if (booking.getIdBooking().equals(contract.getIdBooking())) {
                return true;
            }
        }
        return false;
    }
}
