package model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
public class Booking implements Comparable<Booking>{
    private String idBooking, idCustomer, idService;
    private String startDate, endDate, bookingDate;
    private boolean isCreaseContract;
    public Booking() {
    }

    public Booking(String idBooking, String idCustomer, String idService, String startDate, String endDate, String bookingDate,boolean isCreaseContract) {
        this.idBooking = idBooking;
        this.idCustomer = idCustomer;
        this.idService = idService;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bookingDate = bookingDate;
        this.isCreaseContract = isCreaseContract;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public boolean isCreaseContract() {
        return isCreaseContract;
    }

    public void setCreaseContract(boolean creaseContract) {
        isCreaseContract = creaseContract;
    }

    @Override
    public String toString() {
        return "idBooking= " + idBooking +
                ", idCustomer= " + idCustomer +
                ", idService= " + idService +
                ", dateStart= " + startDate +
                ", dateEnd= " + endDate +
                ", bookingDate= " + bookingDate +
                ", isCreaseContract= " + isCreaseContract;
    }
    public String getInforToCSV(){
        return idBooking+","+idCustomer+","+idService+","+startDate+","+endDate+","+bookingDate+","+isCreaseContract;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdBooking(),getIdCustomer(),getIdService(),getStartDate(),getEndDate(),getBookingDate());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Booking booking = (Booking) obj;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate start1 = LocalDate.parse(this.getStartDate(),formatter);
        LocalDate end1 = LocalDate.parse(this.getEndDate(),formatter);
        LocalDate start2 = LocalDate.parse(this.getStartDate(),formatter);
        LocalDate end2 = LocalDate.parse(this.getEndDate(),formatter);

        return Objects.equals(this.getIdService(), booking.getIdService()) && !start2.isAfter(end1) && !end2.isBefore(start1);
    }

    @Override
    public int compareTo(Booking o) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate thisdate = LocalDate.parse(this.getBookingDate(), formatter);
        LocalDate thatDate = LocalDate.parse(o.getBookingDate(), formatter);
        if (thisdate.compareTo(thatDate) == 0) {
            LocalDate date1 = LocalDate.parse(this.getEndDate(), formatter);
            LocalDate date2 = LocalDate.parse(o.getEndDate(), formatter);
            return date1.compareTo(date2);
        } else {
            return thisdate.compareTo(thatDate);
        }
    }
}
