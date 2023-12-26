package repository.repositories;

import model.person.Employee;
import repository.interfice_repository.IEmployeeRepository;
import utils.ReadAndWriteFileCSV;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository<Employee> {
    private static final String EMPLOYEE_DATA="D:\\CodeGym\\FuramaResort\\src\\data\\person\\employee.csv";
    @Override
    public List<Employee> getAll() {
        List<String> stringList;
        stringList = ReadAndWriteFileCSV.readfileCSV(EMPLOYEE_DATA);
        List<Employee> employeeList = new ArrayList<>();
        String[] array;
        for(String line:stringList){
            array =line.split(",");
            Employee employee = new Employee(array[0],array[1],array[2],array[3],array[4],array[5],array[6],array[7],array[8],Double.parseDouble(array[9]));
            employeeList.add(employee);
        }
        return  employeeList;
    }

    @Override
    public void add(Employee employee) {
        List<String> stringList = new ArrayList<>();
        stringList.add(employee.getInforToCSV());
        ReadAndWriteFileCSV.writeListStringToCSV(EMPLOYEE_DATA,stringList,true);
    }

    @Override
    public void edit(List<Employee> employeeList) {
        List<String> stringList = new ArrayList<>();
        for (Employee employee: employeeList) {
            stringList.add(employee.getInforToCSV());
        }
        ReadAndWriteFileCSV.writeListStringToCSV(EMPLOYEE_DATA,stringList,false);
    }
}
