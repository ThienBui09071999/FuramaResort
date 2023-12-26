package repository.interfice_repository;

import model.Booking;
import model.Contract;

import java.util.List;
import java.util.Set;

public interface IBookingRepository {
    void add(Booking booking);

    Set<Booking> getListBooking();

    void createNewContract(Contract contract);

    void editContract(String idContract);

    List<Contract> getListContract();
}