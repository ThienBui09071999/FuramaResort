package repository.interfice_repository;

import model.person.Customer;

import java.util.List;

public interface ICustomerRepository extends IRepository<Customer>{
    void edit(List<Customer> customerList);
}
