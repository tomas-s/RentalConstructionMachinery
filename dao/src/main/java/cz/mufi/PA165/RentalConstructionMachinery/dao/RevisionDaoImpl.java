package cz.mufi.PA165.RentalConstructionMachinery.dao;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Customer;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Revision;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import static org.hibernate.criterion.Projections.id;
import org.springframework.stereotype.Repository;


@Repository
public class RevisionDaoImpl extends DaoGenericImpl<Revision> implements RevisionDao {

}

