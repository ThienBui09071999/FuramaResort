package repository.interfice_repository;

import java.util.List;

public interface IRepository<T> {
    List<T> getAll();
    void add(T t);
//    void remove(int index);
//    int searchByID(String id);
//    void update(List<T> t);
}
