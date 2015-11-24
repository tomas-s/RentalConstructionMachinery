package cz.mufi.PA165.RentalConstructionMachinery.dao;

import java.util.List;

/**
 * @Author Matej Jakimov
 */
public interface Dao<T> {

    /**
     * Insert {@code T} to the DB.
     * 
     * @param entity
     */
    T create(T entity);

    /**
     * Update {@code T} from DB.
     * 
     * @param entity
     */
    void update(T entity);

    /**
     * Delete {@code T} from DB.
     * 
     * @param entity
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
