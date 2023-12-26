package repository.repositories;

import model.person.Customer;
import repository.interfice_repository.ICustomerRepository;
import utils.ReadAndWriteFileCSV;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CustomerRepository implements ICustomerRepository {
    private static final String CUSTOMER_DATA ="D:\\CodeGym\\FuramaResort\\src\\data\\person\\customer.csv";
    @Override
    public List<Customer> getAll() {
        List<String> stringList;
        stringList = ReadAndWriteFileCSV.readfileCSV(CUSTOMER_DATA);
        List<Customer> customerList = new ArrayList<>();
        String[] array;
        for (String line:stringList) {
            array = line.split(",");
            Customer customer = new Customer(array[0], array[1], array[2], array[3], array[4], array[5], array[6], array[7], array[8]);
            customerList.add(customer);
        }
        return customerList;
    }
    @Override
    public void add(Customer customer) {
        List<String> stringList = new ArrayList<>();
        stringList.add(customer.getInforToCSV());
        ReadAndWriteFileCSV.writeListStringToCSV(CUSTOMER_DATA,stringList,true);
    }
    @Override
    public void edit(List<Customer> customerList) {
        List<String> stringList = new ArrayList<>();
        for (Customer customer:customerList) {
            stringList.add(customer.getInforToCSV());
        }
        ReadAndWriteFileCSV.writeListStringToCSV(CUSTOMER_DATA,stringList,false);
    }
    public static boolean customerExist(String idCheck) {
        CustomerRepository customerRepository = new CustomerRepository();
        List<Customer> customerList = customerRepository.getAll();
        for (Customer customer : customerList) {
            if (customer.getId().equals(idCheck)) {
                return true;
            }
        }
        return false;
    }
}
