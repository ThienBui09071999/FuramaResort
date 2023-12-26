package utils;

import model.Booking;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class BooKingCompator implements Comparator<Booking>{
    @Override
    public int compare(Booking o1, Booking o2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1 = LocalDate.parse(o1.getBookingDate(), formatter);
        LocalDate date2 = LocalDate.parse(o2.getBookingDate(), formatter);
        if (date1.compareTo(date2) == 0) {
            LocalDate dateEnd1 = LocalDate.parse(o1.getEndDate(), formatter);
            LocalDate dateEnd2 = LocalDate.parse(o2.getEndDate(), formatter);
            return dateEnd1.compareTo(dateEnd2);
        } else {
            return date1.compareTo(date2);
        }
    }
}
