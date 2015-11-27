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
        try{
        em.persist(entity);
        }
        catch(ProjectDataAccesException pe){
            pe.getMessage();
        }
        return entity;
    }

    public void update(T entity) {
        try{
        em.merge(entity);
        }
        catch(ProjectDataAccesException pe){
            pe.getMessage();
        }
    }

    public void delete(T entity) {
    try{
        em.remove(em.merge(entity));
        }
        catch(ProjectDataAccesException pe){
            pe.getMessage();
        }
    }

    public T findById(long id) {
        
        return em.find(daoType, id);
    }

    public List<T> findAll() {
        return em.createQuery("SELECT t FROM " + daoType.getName() + " t ").getResultList();
    }
}
