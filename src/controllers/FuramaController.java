package controllers;
import service.interface_services.ICustomerService;
import service.interface_services.IEmployeeService;
import service.services.BookingService;
import service.services.CustomerService;
import service.services.EmployeeService;
import service.services.FacilityService;

import java.util.Scanner;
public class FuramaController {
    static final int EMPLOYEE = 1;
    static final int CUSTOMER = 2;
    static final int FACILITY = 3;
    static final int BOOKING = 4;
    static final int PROMOTION = 5;
    static Scanner scanner = new Scanner(System.in);
    static private IEmployeeService employeeService = new EmployeeService();
    static private ICustomerService customerService = new CustomerService();
    static private FacilityService facilityService = new FacilityService();
    static private BookingService bookingService = new BookingService();
    public void displayMainMenu() {
        int valueChoose;
        boolean flag = true;
        do {
            System.out.println("---------------MENU--------------");
            System.out.println("-1. Employee Management         -");
            System.out.println("-2. Customer Management         -");
            System.out.println("-3. Facility Management         -");
            System.out.println("-4. Booking Management          -");
            System.out.println("-5. Promotion Management        -");
            System.out.println("-Other. Exit                    -");
            System.out.println("---------------------------------");
            valueChoose = checkInputValue();
            switch (valueChoose) {
                case EMPLOYEE:
                    displayEmployeeManagement();
                    break;
                case CUSTOMER:
                    displayCustomerManagement();
                    break;
                case FACILITY:
                    displayFacilityManagement();
                    break;
                case BOOKING:
                    displayBookingManagement();
                    break;
                case PROMOTION:
                    displayPromotionManagement();
                    break;
                default:
                    flag = false;
            }

        }
        while (flag);

    }
    private void displayEmployeeManagement() {
        int value;
        boolean flag = true;

        do {
            System.out.println("---------------Employee Management--------------");
            System.out.println("-1. Display list employees                     -");
            System.out.println("-2. Add new employee                           -");
            System.out.println("-3. Edit employee                              -");
            System.out.println("-Other.Return main menu                        -");
            System.out.println("-------------------------------------------------");
            value = checkInputValue();
            switch (value) {
                case 1:
                    System.out.println("--------- Display list employees-------");
                    employeeService.displayAll();
                    break;
                case 2:
                    System.out.println("--------- Add new employee-------");
                    employeeService.add();
                    break;
                case 3:
                    System.out.println("--------- Edit employee-------");
                    employeeService.edit();
                    break;
                default:
                    flag = false;
            }
        } while (flag);

    }

    private void displayCustomerManagement() {
        int value;
        boolean flag = true;

        do {
            System.out.println("---------------Customer Management--------------");
            System.out.println("-1. Display list customers                     -");
            System.out.println("-2. Add new customer                           -");
            System.out.println("-3. Edit customer                              -");
            System.out.println("-Other.Return main menu                        -");
            System.out.println("------------------------------------------------");

            value = checkInputValue();
            switch (value) {
                case 1:
                    System.out.println("--------- Display list customers-------");
                    customerService.displayAll();
                    break;
                case 2:
                    System.out.println("--------- Add new customer-------");
                    customerService.add();
                    break;
                case 3:
                    System.out.println("--------- Edit customer-------");
                    customerService.edit();
                    break;
                default:
                    flag = false;
            }
        } while (flag);

    }

    private void displayFacilityManagement() {
        int value;
        boolean flag = true;

        do {
            System.out.println("---------------Facility Management -------------");
            System.out.println("-1. Display list facility                      -");
            System.out.println("-2. Add new facility                           -");
            System.out.println("-3. Display list facility maintenance          -");
            System.out.println("-Other. Return main menu                       -");
            System.out.println("------------------------------------------------");
            value = checkInputValue();
            switch (value) {
                case 1:
                    System.out.println("--------- Display list facility -------");
                    facilityService.displayAll();
                    break;
                case 2:
                    System.out.println("--------- Add new facility  -------");
                    facilityService.add();
                    break;
                case 3:
                    facilityService.displayListMaintenance();
                    break;
                default:
                    flag = false;
            }
        } while (flag);

    }

    private void displayBookingManagement() {
        int value;
        boolean flag = true;

        do {
            System.out.println("---------------Booking Management --------------");
            System.out.println("-1. Add new booking                            -");
            System.out.println("-2. Display list booking                       -");
            System.out.println("-3. Create new contracts                       -");
            System.out.println("-4. Display list contracts                     -");
            System.out.println("-5. Edit contracts                             -");
            System.out.println("-Other. Return main menu                       -");
            System.out.println("------------------------------------------------");
            value = checkInputValue();
            switch (value) {
                case 1:
                    System.out.println("-----------Add new booking------------");
                    bookingService.add();
                    break;
                case 2:
                    System.out.println("-----------Display list booking ------------");
                    bookingService.displayAll();
                    break;
                case 3:
                    System.out.println("-----------Create new contracts ------------");
                    bookingService.createNewContract();
                    break;
                case 4:
                    System.out.println("-----------Display list contracts ------------");
                    bookingService.displayListContract();
                    break;
                case 5:
                    System.out.println("-----------Edit contracts ------------");
                    bookingService.editContract();
                    break;
                default:
                    flag = false;
            }
        } while (flag);
    }

    private void displayPromotionManagement() {
        int value;
        boolean flag = true;
        do {
            System.out.println("---------------Promotion Management --------------");
            System.out.println("-1. Display list customers use service           -");
            System.out.println("-2. Display list customers get voucher           -");
            System.out.println("-Other. Return main menu                         -");
            System.out.println("--------------------------------------------------");
            value = checkInputValue();
            switch (value) {
                case 1:
                    break;
                case 2:
                    break;
                default:
                    flag = false;
            }
        } while (flag);
    }
    private int checkInputValue() {
        int value = 0;
        boolean flag;
        do {
            flag = false;
            try {
                value = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException nfe) {
                System.out.println("please input number");
                flag = true;
            }
        } while (flag);

        return value;
    }
}
