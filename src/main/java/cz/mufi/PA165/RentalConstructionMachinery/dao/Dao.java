package cz.mufi.PA165.RentalConstructionMachinery.dao;

import java.util.List;

/**
 * @Author Matej Jakimov
 */
public interface Dao<T> {

    void create(T entity);

    void update(T entity);

    void delete(T entity);

    T findById(long id);

    List<T> findAll();
}
