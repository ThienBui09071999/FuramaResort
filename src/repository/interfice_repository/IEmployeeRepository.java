package repository.interfice_repository;

import model.person.Employee;

import java.util.List;

public interface IEmployeeRepository<T> extends IRepository<T>{
    void edit(List<Employee> employeeList);
}
