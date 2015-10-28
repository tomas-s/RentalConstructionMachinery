package cz.mufi.PA165.RentalConstructionMachinery.dao;

import java.util.List;

/**
 * @Author Matej Jakimov
 */
public interface Dao<T> {

    /**
     * Insert {@code T} to the DB.
     * 
     * @param customer
     */
    void create(T entity);

    /**
     * Update {@code T} from DB.
     * 
     * @param customer
     */
    void update(T entity);

    /**
     * Delete {@code T} from DB.
     * 
     * @param customer
     */
    void delete(T entity);

    /**
     * Find {@code T} by {@code id}.
     * 
     * @param id
     * @return
     */
    T findById(long id);

    /**
     * Find all {@code T}.
     * 
     * @return
     */
    List<T> findAll();
}
