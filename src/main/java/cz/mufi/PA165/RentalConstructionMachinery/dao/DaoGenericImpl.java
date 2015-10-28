package cz.mufi.PA165.RentalConstructionMachinery.dao;

import org.springframework.core.GenericTypeResolver;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by jakac on 28.10.15.
 */
public abstract class DaoGenericImpl<T> implements Dao<T> {

    @PersistenceContext
    protected EntityManager em;

    protected Class<? extends T> daoType;

    public DaoGenericImpl()
    {
        daoType = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), DaoGenericImpl.class);
    }

    public void create(T entity)
    {
        em.persist(entity);
    }

    public void update(T entity)
    {
        em.merge(entity);
    }

    public void delete(T entity)
    {
        em.remove(entity);
    }

    public T findById(long id)
    {
        return em.find(daoType, id);
    }

    public List<T> findAll()
    {
        return em.createQuery("from " + daoType.getName()).getResultList();
    }
}
