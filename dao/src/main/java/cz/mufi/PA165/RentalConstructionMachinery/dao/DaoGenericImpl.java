package cz.mufi.PA165.RentalConstructionMachinery.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.core.GenericTypeResolver;
import cz.mufi.PA165.RentalConstructionMachinery.exception.ProjectDataAccesException;
import static org.apache.derby.impl.sql.compile.SQLParserConstants.T;
/**
 * Created by Matej Jakimov on 28.10.15.
 */
public abstract class DaoGenericImpl<T> implements Dao<T> {

    @PersistenceContext
    protected EntityManager em;

    protected Class<? extends T> daoType;

    public DaoGenericImpl() {
        daoType = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), DaoGenericImpl.class);
    }

    public T create(T entity)  {
        em.persist(entity);
        return entity;
    }

    public void update(T entity) {
        em.merge(entity);
    }

    public void delete(T entity) {
        em.remove(em.merge(entity));
    }

    public T findById(long id) {
        T obj = null;
        obj =  em.find(daoType, id);
        return obj;
    }

    public List<T> findAll() {
        List<T> list = em.createQuery("SELECT t FROM " + daoType.getName() + " t ").getResultList();
        return list;
    }
}
