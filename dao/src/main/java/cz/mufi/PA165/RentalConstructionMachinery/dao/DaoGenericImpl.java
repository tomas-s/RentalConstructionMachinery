package cz.mufi.PA165.RentalConstructionMachinery.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.core.GenericTypeResolver;
import cz.mufi.PA165.RentalConstructionMachinery.exception.ProjectDataAccesException;
/**
 * Created by jakac on 28.10.15.
 */
public abstract class DaoGenericImpl<T> implements Dao<T> {

    @PersistenceContext
    protected EntityManager em;

    protected Class<? extends T> daoType;

    public DaoGenericImpl() {
        daoType = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), DaoGenericImpl.class);
    }

    public T create(T entity)  {
        if(entity==null)
            throw new IllegalArgumentException("Obiekt ma hodnotu null.");
            em.persist(entity);
        
            
        
        return entity;
    }

    public void update(T entity) {
        if(entity==null)
            throw new IllegalArgumentException("Obiekt ma hodnotu null.");
        em.merge(entity);
    }

    public void delete(T entity) {
    if(entity==null)
            throw new IllegalArgumentException("Obiekt ma hodnotu null.");
        em.remove(em.merge(entity));
    }

    public T findById(long id) {
        return em.find(daoType, id);
    }

    public List<T> findAll() {
        return em.createQuery("SELECT t FROM " + daoType.getName() + " t ").getResultList();
    }
}
