package cz.mufi.PA165.RentalConstructionMachinery.dao;

import java.util.List;

/**
 * @Author Matej Jakimov
 */
public interface Dao<T> {

    /**
     * Create entity in database
     * @param entity
     */
    void create(T entity);

    /**
     * Update entity in database
     * @param entity
     */
    void update(T entity);

    /**
     * Delete entity from database
     * @param entity
     */
    void delete(T entity);

    /**
     * Return entity with provided id if exists
     * @param id
     */
    T findById(long id);

    /**
     * Return list of all entities from database
     */
    List<T> findAll();
}
