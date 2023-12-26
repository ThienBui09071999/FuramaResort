package service.services;

import model.person.Customer;
import model.person.Employee;
import repository.interfice_repository.ICustomerRepository;
import repository.repositories.CustomerRepository;
import service.interface_services.ICustomerService;
import utils.GetInput;

import javax.swing.*;
import java.util.List;
import java.util.Scanner;

public class CustomerService extends GetInput implements ICustomerService {
    private static ICustomerRepository customerRepository = new CustomerRepository();
    static Scanner scanner = new Scanner(System.in);
    @Override
    public void edit() {
        List<Customer> customerList = customerRepository.getAll();
        showAllId();
        System.out.println("Enter the ID of the customer you want to update: ");
        String idUpdate = getIdUser("KH");
        boolean flag = true;
        int value;
        for (Customer customer: customerList) {
            if (customer.getId().equals(idUpdate)) {
                do {
                    System.out.println("------edit employee------");
                    System.out.println("please Choose");
                    System.out.println("1. edit ID ");
                    System.out.println("2. edit Name ");
                    System.out.println("3. edit date of birth ");
                    System.out.println("4. edit Sex ");
                    System.out.println("5. edit CMND ");
                    System.out.println("6. edit phone number ");
                    System.out.println("7. edit email ");
                    System.out.println("8. edit customer type ");
                    System.out.println("9. edit address ");
                    System.out.println("Other. Quit edit employee ");
                    value = inputValueInt();
                    switch (value) {
                        case 1:
                            System.out.println("Enter new ID employee: ");
                            customer.setId(getIdUser("KH"));
                            System.out.println("------successful edit------");
                            break;
                        case 2:
                            System.out.println("Enter new name employee: ");
                            customer.setName(getNameUser());
                            System.out.println("------successful edit------");

                            break;
                        case 3:
                            System.out.println("Enter new date of birth employee: ");
                            customer.setDateOfBirth(getDate(true));
                            System.out.println("------successful edit------");

                            break;
                        case 4:
                            System.out.println("Enter new sex employee: ");
                            customer.setSex(getText());
                            System.out.println("------successful edit------");
                            break;
                        case 5:
                            System.out.println("Enter new CMND employee: ");
                            customer.setCMND(getCMND());
                            System.out.println("------successful edit------");
                            break;
                        case 6:
                            System.out.println("Enter new phone number employee: ");
                            customer.setPhoneNumber(getPhoneNumber());
                            System.out.println("------successful edit------");
                            break;
                        case 7:
                            System.out.println("Enter new email employee: ");
                            customer.setEmail(scanner.nextLine());
                            System.out.println("------successful edit------");

                            break;
                        case 8:
                            System.out.println("Enter new customer type: (Diamond, Platinum, Gold, Silver, Member).");
                            customer.setTypeCustomer(getText());
                            System.out.println("------successful edit------");
                            break;
                        case 9:
                            System.out.println("Enter new address customer: ");
                            customer.setAddress(getNameUser());
                            System.out.println("------successful edit------");
                            break;
                        default:
                            flag = false;
                    }
                } while (flag);
                customerRepository.edit(customerList);
                return;
            }
        }
        System.out.println("ID not found!!!");
    }
    @Override
    public void displayAll() {
        List<Customer> customerList = customerRepository.getAll();
        for (Customer customer: customerList) {
            System.out.println(customer);
        }
    }

    @Override
    public void add() {
        String id;
        do {
            System.out.println("Enter id employee: ");
            id = getIdUser("KH");
        } while (checkExistId(id));
        System.out.println("Enter name employee: ");
        String name = getNameUser();
        System.out.println("Enter date of birth employee: ");
        String dateOfBirth = getDate(true);
        System.out.println("Enter sex employee: ");
        String sex = getText();
        System.out.println("Enter CMND employee: ");
        String CMND = getCMND();
        System.out.println("Enter phone number employee: ");
        String phoneNumber = getPhoneNumber();
        System.out.println("Enter email employee: ");
        String email = scanner.nextLine();
        System.out.println("Enter customer type customer: (Diamond, Platinum, Gold, Silver, Member).");
        String typeCustomer = getText();
        System.out.println("Enter address customer: ");
        String address = getText();
        Customer customer = new Customer(id,name,sex,email,dateOfBirth,phoneNumber,CMND,address,typeCustomer);
        customerRepository.add(customer);
    }
    private void showAllId(){
        List<Customer> customerList = customerRepository.getAll();
        System.out.println("----------All Customer's Id-----------");
        for (Customer c:customerList) {
            System.out.println(c.getName()+": "+c.getId());
        }
    }
    private boolean checkExistId(String id) {
        List<Customer> customerList = customerRepository.getAll();
        for (Customer customer: customerList) {
            if (customer.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
    private int inputValueInt() {
        int value = 0;
        boolean flag;
        do {
            flag = false;
            try {
                value = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException nfe) {
                System.out.println("please input Number, try again");
                flag = true;
            }
        } while (flag);

        return value;
    }
}
