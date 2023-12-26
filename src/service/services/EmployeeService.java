package service.services;

import model.person.Employee;
import repository.interfice_repository.IEmployeeRepository;
import repository.repositories.EmployeeRepository;
import service.interface_services.IEmployeeService;
import utils.GetInput;

import java.util.List;
import java.util.Scanner;
public class EmployeeService extends GetInput implements IEmployeeService {
    private static IEmployeeRepository employeeRepository = new EmployeeRepository();
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void edit() {
        List<Employee> employeeList = employeeRepository.getAll();
        showAllId();
        System.out.println("Enter the ID of the employee you want to update: ");
        String idUpdate = getIdUser("NV");;
        boolean flag = true;
        int value;
        for (Employee employee : employeeList) {
            if (employee.getId().equals(idUpdate)) {
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
                    System.out.println("8. edit level ");
                    System.out.println("9. edit position ");
                    System.out.println("10. edit salary ");
                    System.out.println("Other. Quit edit employee ");
                    value = inputValueInt();
                    switch (value) {
                        case 1:
                            System.out.println("Enter new ID employee: ");
                            employee.setId(getIdUser("NV"));
                            System.out.println("------successful edit------");
                            break;
                        case 2:
                            System.out.println("Enter new name employee: ");
                            employee.setName(getNameUser());
                            System.out.println("------successful edit------");
                            break;
                        case 3:
                            System.out.println("Enter new date of birth employee: ");
                            employee.setDateOfBirth(getDate(true));
                            System.out.println("------successful edit------");
                            break;
                        case 4:
                            System.out.println("Enter new sex employee: ");
                            employee.setSex(getText());
                            System.out.println("------successful edit------");
                            break;
                        case 5:
                            System.out.println("Enter new idCard employee: ");
                            employee.setCMND(getCMND());
                            System.out.println("------successful edit------");
                            break;
                        case 6:
                            System.out.println("Enter new phone number employee: ");
                            employee.setPhoneNumber(getPhoneNumber());
                            System.out.println("------successful edit------");
                            break;
                        case 7:
                            System.out.println("Enter new email employee: ");
                            employee.setEmail(scanner.nextLine());
                            System.out.println("------successful edit------");
                            break;
                        case 8:
                            System.out.println("Enter new level employee: Trung cấp, Cao đẳng, Đại học and Sau đại học");
                            employee.setLevel(getText());
                            System.out.println("------successful edit------");
                            break;
                        case 9:
                            System.out.println("Enter new position employee: lễ tân, phục vụ, chuyên viên, giám sát, quản lý, giám đốc");
                            employee.setPosition(getText());
                            System.out.println("------successful edit------");
                            break;
                        case 10:
                            System.out.println("Enter new salary employee: ");
                            employee.setSalary(getExpense());
                            System.out.println("------successful edit------");
                        default:
                            flag = false;
                    }
                } while (flag);
                employeeRepository.edit(employeeList);
                return;
            }
        }
        System.out.println("ID not found!!!");
    }

    @Override
    public void displayAll() {
        List<Employee> employeeList = employeeRepository.getAll();
        for (Employee employee: employeeList) {
            System.out.println(employee);
        }
    }

    @Override
    public void add() {
        String id;
        do {
            System.out.println("Enter id employee: ");
            id = getIdUser("NV");
        } while (checkExistId(id));
//        System.out.println("Enter id employee: ");
//        String id = getIdUser("NV");
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
        System.out.println("Enter level employee: Trung cấp, Cao đẳng, Đại học and Sau đại học");
        String level = getText();
        System.out.println("Enter position employee: lễ tân, phục vụ, chuyên viên, giám sát, quản lý, giám đốc");
        String position = getText();
        System.out.println("Enter salary employee: ");
        double salary = getExpense();
        Employee employee = new Employee(id, name, sex, email, dateOfBirth, phoneNumber, CMND, level, position, salary);
        employeeRepository.add(employee);
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
    private void showAllId() {
        List<Employee> employeeArrayList = employeeRepository.getAll();
        System.out.println("----------All Employee's Id-----------");
        for (Employee e : employeeArrayList) {
            System.out.println(e.getName() + ": " + e.getId());
        }
    }
    private boolean checkExistId(String id) {
        List<Employee> employeeList = employeeRepository.getAll();
        for (Employee employee : employeeList) {
            if (employee.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
