package repository.interfice_repository;

import model.person.Customer;

import java.util.Set;
import java.util.TreeSet;

public interface IPromotionRepository {
    Set<Customer> getListUseService(int year);
    TreeSet<Customer> getListGetVoucher();
}
