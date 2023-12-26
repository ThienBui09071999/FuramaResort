package repository.repositories;

import model.person.Customer;
import repository.interfice_repository.IPromotionRepository;

import java.util.Set;
import java.util.TreeSet;

public class PromotionRepository  implements IPromotionRepository {
    @Override
    public Set<Customer> getListUseService(int year) {
        return null;
    }

    @Override
    public TreeSet<Customer> getListGetVoucher() {
        return null;
    }
}
